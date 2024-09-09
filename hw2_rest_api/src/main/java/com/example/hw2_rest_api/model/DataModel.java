package com.example.hw2_rest_api.model;

/**
 * Model class representing the data for each app in the dataset.
 */
public class DataModel {

    private String name;
    private String category;
    private double rating;
    private int reviews;
    private String size;
    private String installs;
    private String type;
    private double price;
    private String contentRating;
    private String genres;

    // Getters and Setters for all fields

    /**
     * Gets the name of the app.
     * 
     * @return The name of the app.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the app.
     * 
     * @param name The name of the app.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the category of the app.
     * 
     * @return The category of the app.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the app.
     * 
     * @param category The category of the app.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the rating of the app.
     * 
     * @return The rating of the app.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the rating of the app.
     * 
     * @param rating The rating of the app.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Gets the number of reviews for the app.
     * 
     * @return The number of reviews.
     */
    public int getReviews() {
        return reviews;
    }

    /**
     * Sets the number of reviews for the app.
     * 
     * @param reviews The number of reviews.
     */
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    /**
     * Gets the size of the app.
     * 
     * @return The size of the app.
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of the app.
     * 
     * @param size The size of the app.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets the number of installs for the app.
     * 
     * @return The number of installs.
     */
    public String getInstalls() {
        return installs;
    }

    /**
     * Sets the number of installs for the app.
     * 
     * @param installs The number of installs.
     */
    public void setInstalls(String installs) {
        this.installs = installs;
    }

    /**
     * Gets the type of the app.
     * 
     * @return The type of the app.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the app.
     * 
     * @param type The type of the app.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the price of the app.
     * 
     * @return The price of the app.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the app.
     * 
     * @param price The price of the app.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the content rating of the app.
     * 
     * @return The content rating.
     */
    public String getContentRating() {
        return contentRating;
    }

    /**
     * Sets the content rating of the app.
     * 
     * @param contentRating The content rating.
     */
    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    /**
     * Gets the genres of the app.
     * 
     * @return The genres.
     */
    public String getGenres() {
        return genres;
    }

    /**
     * Sets the genres of the app.
     * 
     * @param genres The genres.
     */
    public void setGenres(String genres) {
        this.genres = genres;
    }
}
