package com.example.hw2_rest_api.dto;

import java.util.List;

public class DataModelDTO {
    private Long id;
    private String name;
    private String category;
    private Double rating;
    private Integer reviews;
    private String size;
    private String installs;
    private String type;
    private String price;
    private String contentRating;
    private String genres;
    private List<UserReviewDTO> userReviews;

    public DataModelDTO(Long id, String name, String category, Double rating, Integer reviews, String size, String installs,
                        String type, String price, String contentRating, String genres, List<UserReviewDTO> userReviews) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.reviews = reviews;
        this.size = size;
        this.installs = installs;
        this.type = type;
        this.price = price;
        this.contentRating = contentRating;
        this.genres = genres;
        this.userReviews = userReviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public List<UserReviewDTO> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(List<UserReviewDTO> userReviews) {
        this.userReviews = userReviews;
    }
}
