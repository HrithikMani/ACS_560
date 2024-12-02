package com.example.hw2_rest_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hw2_rest_api.model.UserReview;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
    // Additional query methods can be defined here if needed
}
