package com.example.hw2_rest_api.repositories;

import com.example.hw2_rest_api.model.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
    List<UserReview> findByDataModelId(Long appId);
}
