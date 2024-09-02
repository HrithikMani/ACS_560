package com.hrithik.dataanalyze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DataAnalyzer class provides methods to calculate statistical values like mean, median, and mode for datasets.
 */
public class DataAnalyzer {

    /**
     * Calculates the mean (average) of a list of Double values.
     * 
     * @param data The list of Double values.
     * @return The mean of the list.
     */
    public double calculateMean(List<Double> data) {
        double sum = 0;
        for (Double num : data) {
            sum += num;
        }
        return sum / data.size();
    }

    /**
     * Calculates the median (middle value) of a list of Double values.
     * 
     * @param data The list of Double values.
     * @return The median of the list.
     */
    public double calculateMedian(List<Double> data) {
        List<Double> sortedData = new ArrayList<>(data);
        Collections.sort(sortedData);
        int size = sortedData.size();
        if (size % 2 == 0) {
            return (sortedData.get(size / 2 - 1) + sortedData.get(size / 2)) / 2.0;
        } else {
            return sortedData.get(size / 2);
        }
    }

    /**
     * Calculates the mode (most frequent value) of a list of Double values.
     * 
     * @param data The list of Double values.
     * @return A map where the key is the mode value(s) and the value is the frequency of occurrence.
     */
    public Map<Double, Integer> calculateMode(List<Double> data) {
        Map<Double, Integer> frequencyMap = new HashMap<>();
        for (double num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = Collections.max(frequencyMap.values());
        Map<Double, Integer> modes = new HashMap<>();
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.put(entry.getKey(), entry.getValue());
            }
        }
        return modes;
    }

    /**
     * Calculates the mean (average) of a list of Long values.
     * 
     * @param data The list of Long values.
     * @return The mean of the list.
     */
    public double calculateMeanLong(List<Long> data) {
        double sum = 0;
        for (Long num : data) {
            sum += num;
        }
        return sum / data.size();
    }

    /**
     * Calculates the median (middle value) of a list of Long values.
     * 
     * @param data The list of Long values.
     * @return The median of the list.
     */
    public double calculateMedianLong(List<Long> data) {
        List<Long> sortedData = new ArrayList<>(data);
        Collections.sort(sortedData);
        int size = sortedData.size();
        if (size % 2 == 0) {
            return (sortedData.get(size / 2 - 1) + sortedData.get(size / 2)) / 2.0;
        } else {
            return sortedData.get(size / 2);
        }
    }

    /**
     * Calculates the mode (most frequent value) of a list of Long values.
     * 
     * @param data The list of Long values.
     * @return A map where the key is the mode value(s) and the value is the frequency of occurrence.
     */
    public Map<Long, Integer> calculateModeLong(List<Long> data) {
        Map<Long, Integer> frequencyMap = new HashMap<>();
        for (long num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = Collections.max(frequencyMap.values());
        Map<Long, Integer> modes = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.put(entry.getKey(), entry.getValue());
            }
        }
        return modes;
    }
}
