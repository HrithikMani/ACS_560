package com.example.hw2_rest_api.controller;

import com.example.hw2_rest_api.services.DataAnalysisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * REST controller to expose endpoints for data analysis.
 */
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataAnalysisService dataAnalysisService;

    /**
     * Constructor to initialize the data analysis service.
     * 
     * @param dataAnalysisService The service that provides data analysis operations.
     */
    public DataController(DataAnalysisService dataAnalysisService) {
        this.dataAnalysisService = dataAnalysisService;
    }

    /**
     * Endpoint to get mean, median, and mode for ratings.
     * 
     * @return A map containing mean, median, and mode for ratings.
     */
    @GetMapping("/ratings/analysis")
    public Map<String, Double> getRatingsAnalysis() {
        return dataAnalysisService.getRatingsAnalysis();
    }

    /**
     * Endpoint to get mean, median, and mode for reviews.
     * 
     * @return A map containing mean, median, and mode for reviews.
     */
    @GetMapping("/reviews/analysis")
    public Map<String, Double> getReviewsAnalysis() {
        return dataAnalysisService.getReviewsAnalysis();
    }

    /**
     * Endpoint to get mean, median, and mode for installs.
     * 
     * @return A map containing mean, median, and mode for installs.
     */
    @GetMapping("/installs/analysis")
    public Map<String, Double> getInstallsAnalysis() {
        return dataAnalysisService.getInstallsAnalysis();
    }
}
