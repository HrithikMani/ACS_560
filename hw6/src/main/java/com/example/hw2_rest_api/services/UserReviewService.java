package com.example.hw2_rest_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.model.UserReview;
import com.example.hw2_rest_api.repositories.DataRepository;
import com.example.hw2_rest_api.repositories.UserReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserReviewService {

    @Autowired
    private UserReviewRepository userReviewRepository;

    @Autowired
    private DataRepository dataRepository; // Repository for the app entity (DataModel)

    // Save a review associated with an app
    @Transactional
    public UserReview saveReview(Long appId, UserReview review) throws Exception {
        // Fetch the app associated with the reviewS
        Optional<DataModel> app = dataRepository.findById(appId);
        if (app.isPresent()) {
            review.setDataModel(app.get()); // Associate the app with the review
            return userReviewRepository.save(review);
        } else {
            throw new Exception("App not found with id: " + appId);
        }
    }

    // Retrieve reviews for a specific app
    public List<UserReview> getReviewsByAppId(Long appId) {
        return userReviewRepository.findByDataModelId(appId);
    }

    // Delete a review by review ID
    public void deleteReview(Long reviewId) {
        userReviewRepository.deleteById(reviewId);
    }
}
