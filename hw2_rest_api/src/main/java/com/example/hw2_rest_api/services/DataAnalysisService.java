package com.example.hw2_rest_api.services;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.repositories.DataRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for analyzing data such as calculating mean, median, and mode.
 */
@Service
public class DataAnalysisService {

    private final DataRepository dataRepository;

    /**
     * Constructor to initialize the data repository.
     * 
     * @param dataRepository The repository that provides access to the data.
     */
    public DataAnalysisService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * Calculates the mean of a list of values.
     * 
     * @param values The list of values to calculate the mean for.
     * @return The mean value.
     */
    public double calculateMean(List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    /**
     * Calculates the median of a list of values.
     * 
     * @param values The list of values to calculate the median for.
     * @return The median value.
     */
    public double calculateMedian(List<Double> values) {
        Collections.sort(values);
        int size = values.size();
        if (size % 2 == 0) {
            return (values.get(size / 2 - 1) + values.get(size / 2)) / 2.0;
        } else {
            return values.get(size / 2);
        }
    }

    /**
     * Calculates the mode of a list of values.
     * 
     * @param values The list of values to calculate the mode for.
     * @return The mode value.
     */
    public double calculateMode(List<Double> values) {
        Map<Double, Long> frequencyMap = values.stream().collect(Collectors.groupingBy(Double::doubleValue, Collectors.counting()));
        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /**
     * Provides analysis for ratings including mean, median, and mode.
     * 
     * @return A map containing mean, median, and mode for ratings.
     */
    public Map<String, Double> getRatingsAnalysis() {
        List<Double> ratings = dataRepository.getAllData().stream()
                .map(DataModel::getRating)
                .filter(rating -> rating > 0)
                .collect(Collectors.toList());

        Map<String, Double> result = new HashMap<>();
        result.put("mean", calculateMean(ratings));
        result.put("median", calculateMedian(ratings));
        result.put("mode", calculateMode(ratings));
        return result;
    }

    /**
     * Provides analysis for reviews including mean, median, and mode.
     * 
     * @return A map containing mean, median, and mode for reviews.
     */
    public Map<String, Double> getReviewsAnalysis() {
        List<Double> reviews = dataRepository.getAllData().stream()
                .map(data -> (double) data.getReviews())
                .collect(Collectors.toList());

        Map<String, Double> result = new HashMap<>();
        result.put("mean", calculateMean(reviews));
        result.put("median", calculateMedian(reviews));
        result.put("mode", calculateMode(reviews));
        return result;
    }

    /**
     * Provides analysis for installs including mean, median, and mode.
     * 
     * @return A map containing mean, median, and mode for installs.
     */
    public Map<String, Double> getInstallsAnalysis() {
        List<Double> installs = dataRepository.getAllData().stream()
                .map(data -> {
                    try {
                        return Double.parseDouble(data.getInstalls());
                    } catch (NumberFormatException e) {
                        return 0.0;
                    }
                })
                .filter(install -> install > 0)
                .collect(Collectors.toList());

        Map<String, Double> result = new HashMap<>();
        result.put("mean", calculateMean(installs));
        result.put("median", calculateMedian(installs));
        result.put("mode", calculateMode(installs));
        return result;
    }
}
