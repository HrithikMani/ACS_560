package com.example.hw2_rest_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_review")
public class UserReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sentiment;
    private Float sentimentPolarity;
    private Float sentimentSubjectivity;
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_model_id")
    private DataModel dataModel;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSentiment() { return sentiment; }
    public void setSentiment(String sentiment) { this.sentiment = sentiment; }

    public Float getSentimentPolarity() { return sentimentPolarity; }
    public void setSentimentPolarity(Float sentimentPolarity) { this.sentimentPolarity = sentimentPolarity; }

    public Float getSentimentSubjectivity() { return sentimentSubjectivity; }
    public void setSentimentSubjectivity(Float sentimentSubjectivity) { this.sentimentSubjectivity = sentimentSubjectivity; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public DataModel getDataModel() { return dataModel; }
    public void setDataModel(DataModel dataModel) { this.dataModel = dataModel; }
}