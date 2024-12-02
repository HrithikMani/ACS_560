package com.example.hw2_rest_api.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_review")
public class UserReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "data_model_id", nullable = false)
    @JsonBackReference
    private DataModel dataModel;

    private String sentiment;
    private BigDecimal sentimentPolarity;
    private BigDecimal sentimentSubjectivity;

    @Column(columnDefinition = "TEXT")
    private String review;

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    // Constructors
    public UserReview() {
    }

    public UserReview(DataModel dataModel, String sentiment, String review) {
        this.dataModel = dataModel;
        this.sentiment = sentiment;
        this.review = review;
        this.sentimentPolarity = BigDecimal.ZERO; // Default value
        this.sentimentSubjectivity = BigDecimal.ZERO; // Default value
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public BigDecimal getSentimentPolarity() {
        return sentimentPolarity;
    }

    public void setSentimentPolarity(BigDecimal sentimentPolarity) {
        this.sentimentPolarity = sentimentPolarity;
    }

    public BigDecimal getSentimentSubjectivity() {
        return sentimentSubjectivity;
    }

    public void setSentimentSubjectivity(BigDecimal sentimentSubjectivity) {
        this.sentimentSubjectivity = sentimentSubjectivity;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
