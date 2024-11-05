package com.example.hw2_rest_api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "data_model")
public class DataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Double rating;
    private Integer reviews;
    private String size;
    private String installs;
    private String type;
    private Double price;
    private String contentRating;
    private String genres;

    @OneToMany(mappedBy = "dataModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserReview> userReviews;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Integer getReviews() { return reviews; }
    public void setReviews(Integer reviews) { this.reviews = reviews; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getInstalls() { return installs; }
    public void setInstalls(String installs) { this.installs = installs; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getContentRating() { return contentRating; }
    public void setContentRating(String contentRating) { this.contentRating = contentRating; }

    public String getGenres() { return genres; }
    public void setGenres(String genres) { this.genres = genres; }

    public List<UserReview> getUserReviews() { return userReviews; }
    public void setUserReviews(List<UserReview> userReviews) { this.userReviews = userReviews; }
}
