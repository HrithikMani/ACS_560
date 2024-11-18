package com.example.hw2_rest_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hw2_rest_api.model.UserReview;
import com.example.hw2_rest_api.repositories.UserReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserReviewService {

    @Autowired
    private UserReviewRepository userReviewRepository;

    public List<UserReview> getAllUserReviews() {
        return userReviewRepository.findAll();
    }

    public Optional<UserReview> getUserReviewById(Long id) {
        return userReviewRepository.findById(id);
    }

    public UserReview saveUserReview(UserReview userReview) {
        return userReviewRepository.save(userReview);
    }

    public UserReview updateUserReview(Long id, UserReview userReview) {
        userReview.setId(id);
        return userReviewRepository.save(userReview);
    }

    public void deleteUserReview(Long id) {
        userReviewRepository.deleteById(id);
    }
}
