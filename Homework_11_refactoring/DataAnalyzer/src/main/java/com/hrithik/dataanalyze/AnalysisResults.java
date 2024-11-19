package com.hrithik.dataanalyze;

import java.util.Map;

/**
 * AnalysisResults stores the results of the statistical analysis.
 */
public class AnalysisResults {

    private final double meanRating;
    private final double medianRating;
    private final Map<Double, Integer> modeRatings;

    private final double meanInstalls;
    private final double medianInstalls;
    private final Map<Long, Integer> modeInstalls;

    public AnalysisResults(double meanRating, double medianRating, Map<Double, Integer> modeRatings,
                           double meanInstalls, double medianInstalls, Map<Long, Integer> modeInstalls) {
        this.meanRating = meanRating;
        this.medianRating = medianRating;
        this.modeRatings = modeRatings;
        this.meanInstalls = meanInstalls;
        this.medianInstalls = medianInstalls;
        this.modeInstalls = modeInstalls;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Rating Analysis\n")
                .append("Mean Rating: ").append(meanRating).append("\n")
                .append("Median Rating: ").append(medianRating).append("\n")
                .append("Mode Ratings: ").append(modeRatings.keySet()).append("\n\n")
                .append("Install Count Analysis\n")
                .append("Mean Installs: ").append(meanInstalls).append("\n")
                .append("Median Installs: ").append(medianInstalls).append("\n")
                .append("Mode Installs: ").append(modeInstalls.keySet()).append("\n")
                .toString();
    }
}
