package com.example.hw2_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hw2_rest_api.model.UserReview;
import com.example.hw2_rest_api.services.UserReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class UserReviewController {

    @Autowired
    private UserReviewService userReviewService;

    // Endpoint to save a review for a specific app
    @PostMapping("/app/{appId}")
    public ResponseEntity<UserReview> saveReview(@PathVariable Long appId, @RequestBody UserReview review) {
        try {
            UserReview savedReview = userReviewService.saveReview(appId, review);
            return ResponseEntity.ok(savedReview);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint to get all reviews for a specific app
    @GetMapping("/app/{appId}")
    public ResponseEntity<List<UserReview>> getReviewsByAppId(@PathVariable Long appId) {
        List<UserReview> reviews = userReviewService.getReviewsByAppId(appId);
        return ResponseEntity.ok(reviews);
    }

    // Endpoint to delete a review by its ID
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        userReviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}
