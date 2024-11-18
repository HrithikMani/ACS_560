package com.example.hw2_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hw2_rest_api.model.UserReview;
import com.example.hw2_rest_api.services.UserReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-reviews")
public class UserReviewController {

    @Autowired
    private UserReviewService userReviewService;

    @GetMapping
    public List<UserReview> getAllUserReviews() {
        return userReviewService.getAllUserReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReview> getUserReviewById(@PathVariable Long id) {
        Optional<UserReview> userReview = userReviewService.getUserReviewById(id);
        return userReview.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserReview> createUserReview(@RequestBody UserReview userReview) {
        UserReview createdUserReview = userReviewService.saveUserReview(userReview);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReview> updateUserReview(@PathVariable Long id, @RequestBody UserReview userReview) {
        if (!userReviewService.getUserReviewById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        UserReview updatedUserReview = userReviewService.updateUserReview(id, userReview);
        return ResponseEntity.ok(updatedUserReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserReview(@PathVariable Long id) {
        if (!userReviewService.getUserReviewById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userReviewService.deleteUserReview(id);
        return ResponseEntity.noContent().build();
    }
}
