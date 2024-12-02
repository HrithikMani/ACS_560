package com.example.hw2_vaadin.views;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.model.UserReview;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Route("data-models")
public class DataModelView extends VerticalLayout {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "http://localhost:3000/api/data-models";

    private final Grid<DataModel> grid = new Grid<>(DataModel.class);

    public DataModelView() {
        setupGrid();
        add(new Button("Add Data Model", e -> openAddDataModelDialog()));
    }

    private void setupGrid() {
        grid.setColumns("id", "name", "category", "rating");
        grid.addComponentColumn(this::createViewReviewsButton).setHeader("View Reviews");
        grid.addComponentColumn(this::createEditButton).setHeader("Edit");
        grid.addComponentColumn(this::createDeleteButton).setHeader("Delete");
        grid.setItems(fetchDataModels());
        add(grid);
    }

    private List<DataModel> fetchDataModels() {
        DataModel[] dataModels = restTemplate.getForObject(apiUrl, DataModel[].class);
        return Arrays.asList(dataModels);
    }

    private Button createViewReviewsButton(DataModel dataModel) {
        return new Button("View Reviews", e -> {
            List<UserReview> userReviews = new ArrayList<>(dataModel.getUserReviews()); // Convert Set to List
            openViewReviewsDialog(userReviews);
        });
    }

    private Button createEditButton(DataModel dataModel) {
        return new Button("Edit", e -> openEditDataModelDialog(dataModel));
    }

    private Button createDeleteButton(DataModel dataModel) {
        return new Button("Delete", e -> {
            restTemplate.delete(apiUrl + "/" + dataModel.getId());
            grid.setItems(fetchDataModels());
        });
    }

    private void openAddDataModelDialog() {
        Dialog dialog = new Dialog();
        TextField nameField = new TextField("Name");
        TextField categoryField = new TextField("Category");
        TextField ratingField = new TextField("Rating");

        Button saveButton = new Button("Save", e -> {
            try {
                String name = nameField.getValue();
                String category = categoryField.getValue();
                String ratingInput = ratingField.getValue();

                if (name.isEmpty() || category.isEmpty() || ratingInput.isEmpty()) {
                    Notification.show("All fields are required!", 3000, Notification.Position.MIDDLE);
                    return;
                }

                BigDecimal rating;
                try {
                    rating = new BigDecimal(ratingInput);
                } catch (NumberFormatException ex) {
                    Notification.show("Invalid rating value. Please enter a valid number.", 3000, Notification.Position.MIDDLE);
                    return;
                }

                DataModel dataModel = new DataModel();
                dataModel.setName(name);
                dataModel.setCategory(category);
                dataModel.setRating(rating);

                restTemplate.postForObject(apiUrl, dataModel, DataModel.class);
                grid.setItems(fetchDataModels());
                dialog.close();
            } catch (Exception ex) {
                Notification.show("Error saving data: " + ex.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        dialog.add(new VerticalLayout(nameField, categoryField, ratingField, saveButton));
        dialog.open();
    }

    private void openEditDataModelDialog(DataModel dataModel) {
        Dialog dialog = new Dialog();
        TextField nameField = new TextField("Name", dataModel.getName());
        TextField categoryField = new TextField("Category", dataModel.getCategory());
        TextField ratingField = new TextField("Rating", dataModel.getRating() != null ? dataModel.getRating().toString() : "");

        Button saveButton = new Button("Save", e -> {
            try {
                String name = nameField.getValue();
                String category = categoryField.getValue();
                String ratingInput = ratingField.getValue();

                if (name.isEmpty() || category.isEmpty() || ratingInput.isEmpty()) {
                    Notification.show("All fields are required!", 3000, Notification.Position.MIDDLE);
                    return;
                }

                BigDecimal rating;
                try {
                    rating = new BigDecimal(ratingInput);
                } catch (NumberFormatException ex) {
                    Notification.show("Invalid rating value. Please enter a valid number.", 3000, Notification.Position.MIDDLE);
                    return;
                }

                dataModel.setName(name);
                dataModel.setCategory(category);
                dataModel.setRating(rating);

                restTemplate.put(apiUrl + "/" + dataModel.getId(), dataModel);
                grid.setItems(fetchDataModels());
                dialog.close();
            } catch (Exception ex) {
                Notification.show("Error updating data: " + ex.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        dialog.add(new VerticalLayout(nameField, categoryField, ratingField, saveButton));
        dialog.open();
    }

    private void openViewReviewsDialog(List<UserReview> userReviews) {
        Dialog dialog = new Dialog();
        dialog.setWidth("80%");
        dialog.setHeight("70%");

        Grid<UserReview> reviewGrid = new Grid<>(UserReview.class);
        reviewGrid.setItems(userReviews);
        reviewGrid.removeAllColumns(); // Remove autogenerated columns

        reviewGrid.addColumn(UserReview::getId).setHeader("ID").setAutoWidth(true);
        reviewGrid.addColumn(UserReview::getSentiment).setHeader("Sentiment").setAutoWidth(true);
        reviewGrid.addColumn(UserReview::getSentimentPolarity).setHeader("Polarity").setAutoWidth(true);
        reviewGrid.addColumn(UserReview::getSentimentSubjectivity).setHeader("Subjectivity").setAutoWidth(true);

        // Make the review column flexible and not truncated
        reviewGrid.addColumn(UserReview::getReview)
            .setHeader("Review")
            .setFlexGrow(1) // Allow the column to expand dynamically
            .setAutoWidth(false); // Disable fixed width to prevent truncation

        // Add a delete button column
        reviewGrid.addComponentColumn(review -> {
            Button deleteButton = new Button("Delete", click -> {
                try {
                    // Remove review locally and refresh the grid
                    userReviews.remove(review);
                    reviewGrid.setItems(userReviews);
                    Notification.show("Review removed from the list.", 3000, Notification.Position.MIDDLE);
                } catch (Exception ex) {
                    Notification.show("Error removing review: " + ex.getMessage(), 3000, Notification.Position.MIDDLE);
                }
            });
            deleteButton.addThemeName("error");
            return deleteButton;
        }).setHeader("Actions");

        VerticalLayout layout = new VerticalLayout(reviewGrid, new Button("Close", e -> dialog.close()));
        layout.setPadding(true);
        layout.setSpacing(true);
        layout.setSizeFull();

        dialog.add(layout);
        dialog.open();
    }


}
