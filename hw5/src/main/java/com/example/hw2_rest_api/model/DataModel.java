package com.example.hw2_rest_api.model;

import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Model class representing the data for each app in the dataset.
 */
@Entity
public class DataModel {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInstalls() {
        return installs;
    }

    public void setInstalls(String installs) {
        this.installs = installs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    /**
     * Converts the data model into a CSV-formatted string.
     * 
     * @return A string representing the data in CSV format.
     */
    public String toCSVString() {
        return String.join(",",
                name,
                category,
                String.valueOf(rating),
                String.valueOf(reviews),
                size,
                installs,
                type,
                String.valueOf(price),
                contentRating,
                genres
        );
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", reviews=" + reviews +
                ", size='" + size + '\'' +
                ", installs='" + installs + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", contentRating='" + contentRating + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
    // Override equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataModel dataModel = (DataModel) o;
        return Double.compare(dataModel.rating, rating) == 0 &&
                reviews == dataModel.reviews &&
                Double.compare(dataModel.price, price) == 0 &&
                Objects.equals(name, dataModel.name) &&
                Objects.equals(category, dataModel.category) &&
                Objects.equals(size, dataModel.size) &&
                Objects.equals(installs, dataModel.installs) &&
                Objects.equals(type, dataModel.type) &&
                Objects.equals(contentRating, dataModel.contentRating) &&
                Objects.equals(genres, dataModel.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, rating, reviews, size, installs, type, price, contentRating, genres);
    }

	public Long getId() {
		// TODO Auto-generated method stub
	
		return id;
	}

    
}
