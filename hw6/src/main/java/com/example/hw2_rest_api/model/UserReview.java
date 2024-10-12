package com.example.hw2_rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user_review")
public class UserReview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sentiment")
    private String sentiment;

    @Column(name = "sentiment_polarity")
    private Double sentimentPolarity;

    @Column(name = "sentiment_subjectivity")
    private Double sentimentSubjectivity;

    @Column(name = "review", length = 1000)
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_id", nullable = false)
    @JsonIgnore
    private DataModel dataModel;

    // Getters and Setters

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

    public Double getSentimentPolarity() {
        return sentimentPolarity;
    }

    public void setSentimentPolarity(Double sentimentPolarity) {
        this.sentimentPolarity = sentimentPolarity;
    }

    public Double getSentimentSubjectivity() {
        return sentimentSubjectivity;
    }

    public void setSentimentSubjectivity(Double sentimentSubjectivity) {
        this.sentimentSubjectivity = sentimentSubjectivity;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }
}
