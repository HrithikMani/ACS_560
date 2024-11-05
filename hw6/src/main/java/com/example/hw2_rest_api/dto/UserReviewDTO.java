package com.example.hw2_rest_api.dto;

public class UserReviewDTO {
    private Long id;
    private String sentiment;
    private Float sentimentPolarity;
    private Float sentimentSubjectivity;
    private String review;

    public UserReviewDTO(Long id, String sentiment, Float sentimentPolarity, Float sentimentSubjectivity, String review) {
        this.id = id;
        this.sentiment = sentiment;
        this.sentimentPolarity = sentimentPolarity;
        this.sentimentSubjectivity = sentimentSubjectivity;
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public Float getSentimentPolarity() {
        return sentimentPolarity;
    }

    public void setSentimentPolarity(Float sentimentPolarity) {
        this.sentimentPolarity = sentimentPolarity;
    }

    public Float getSentimentSubjectivity() {
        return sentimentSubjectivity;
    }

    public void setSentimentSubjectivity(Float sentimentSubjectivity) {
        this.sentimentSubjectivity = sentimentSubjectivity;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
