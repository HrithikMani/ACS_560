package com.hrithik.dataanalyze;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DataProcessingService processes CSV data to perform statistical analysis.
 */
public class DataProcessingService {

    private final DataAnalyzer dataAnalyzer = new DataAnalyzer();

    /**
     * Analyzes the data for ratings and install counts.
     *
     * @param data The raw data from the CSV file.
     * @return An instance of AnalysisResults containing the analysis results.
     */
    public AnalysisResults analyzeData(List<String[]> data) {
        // Extract and clean ratings
        List<Double> ratings = extractColumnAsDouble(data, 2);
        double meanRating = dataAnalyzer.calculateMean(ratings);
        double medianRating = dataAnalyzer.calculateMedian(ratings);
        Map<Double, Integer> modeRatings = dataAnalyzer.calculateMode(ratings);

        // Extract and clean install counts
        List<Long> installs = extractColumnAsLong(data, 5);
        double meanInstalls = dataAnalyzer.calculateMean(installs);
        double medianInstalls = dataAnalyzer.calculateMedian(installs);
        Map<Long, Integer> modeInstalls = dataAnalyzer.calculateMode(installs);

        return new AnalysisResults(meanRating, medianRating, modeRatings, meanInstalls, medianInstalls, modeInstalls);
    }

    private List<Double> extractColumnAsDouble(List<String[]> data, int columnIndex) {
        return data.stream()
                .map(row -> {
                    try {
                        return Double.parseDouble(row[columnIndex]);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .filter(value -> value != null)
                .toList();
    }

    private List<Long> extractColumnAsLong(List<String[]> data, int columnIndex) {
        return data.stream()
                .map(row -> {
                    try {
                        return Long.parseLong(row[columnIndex].replace(",", "").replace("+", ""));
                    } catch (Exception e) {
                        return null;
                    }
                })
                .filter(value -> value != null)
                .toList();
    }
}
