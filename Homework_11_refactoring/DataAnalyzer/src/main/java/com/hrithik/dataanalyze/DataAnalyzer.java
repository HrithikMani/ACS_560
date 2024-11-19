package com.hrithik.dataanalyze;

import java.util.*;
import java.util.stream.Collectors;

/**
 * DataAnalyzer class provides methods to calculate statistical values like mean, median, and mode for datasets.
 */
public class DataAnalyzer {

    /**
     * Calculates the mean (average) of a list of numbers.
     * 
     * @param <T>  The type of number (e.g., Double, Long).
     * @param data The list of numbers.
     * @return The mean of the list.
     */
    public <T extends Number> double calculateMean(List<T> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data list cannot be empty.");
        }
        return data.stream().mapToDouble(Number::doubleValue).average().orElse(0.0);
    }

    /**
     * Calculates the median (middle value) of a list of numbers.
     * 
     * @param <T>  The type of number (e.g., Double, Long).
     * @param data The list of numbers.
     * @return The median of the list.
     */
    public <T extends Number & Comparable<T>> double calculateMedian(List<T> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data list cannot be empty.");
        }
        List<T> sortedData = sortData(data);
        int size = sortedData.size();
        if (size % 2 == 0) {
            return (toDouble(sortedData.get(size / 2 - 1)) + toDouble(sortedData.get(size / 2))) / 2.0;
        } else {
            return toDouble(sortedData.get(size / 2));
        }
    }

    /**
     * Calculates the mode (most frequent value) of a list of numbers.
     * 
     * @param <T>  The type of number (e.g., Double, Long).
     * @param data The list of numbers.
     * @return A map where the key is the mode value(s) and the value is the frequency of occurrence.
     */
    public <T> Map<T, Integer> calculateMode(List<T> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data list cannot be empty.");
        }
        Map<T, Integer> frequencyMap = createFrequencyMap(data);
        int maxFrequency = Collections.max(frequencyMap.values());
        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Sorts a list of comparable elements.
     * 
     * @param <T>  The type of the elements (e.g., Double, Long).
     * @param data The list of elements to sort.
     * @return A sorted list.
     */
    private <T extends Comparable<T>> List<T> sortData(List<T> data) {
        return data.stream().sorted().toList();
    }

    /**
     * Converts a Number to a double value.
     * 
     * @param number The number to convert.
     * @return The double representation of the number.
     */
    private double toDouble(Number number) {
        return number.doubleValue();
    }

    /**
     * Creates a frequency map for a list of elements.
     * 
     * @param <T>  The type of the elements (e.g., Double, Long).
     * @param data The list of elements.
     * @return A map with elements as keys and their frequencies as values.
     */
    private <T> Map<T, Integer> createFrequencyMap(List<T> data) {
        Map<T, Integer> frequencyMap = new HashMap<>();
        for (T item : data) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }
}
