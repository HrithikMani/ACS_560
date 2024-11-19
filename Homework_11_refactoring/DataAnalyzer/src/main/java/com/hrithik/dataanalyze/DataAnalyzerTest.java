package com.hrithik.dataanalyze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class DataAnalyzerTest {

    private static final Logger logger = Logger.getLogger(DataAnalyzerTest.class.getName());
    private final DataAnalyzer dataAnalyzer = new DataAnalyzer();

    @Test
    void testCalculateMean() {
        logger.info("Running testCalculateMean...");
        List<Double> data = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        double mean = dataAnalyzer.calculateMean(data);
        logger.info("Calculated mean: " + mean);
        assertEquals(3.0, mean, 0.001, "Mean should be 3.0");
    }

    @Test
    void testCalculateMean_EmptyList() {
        logger.info("Running testCalculateMean_EmptyList...");
        List<Double> data = Collections.emptyList();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> dataAnalyzer.calculateMean(data));
        logger.warning("Exception message: " + exception.getMessage());
        assertEquals("Data list cannot be empty.", exception.getMessage());
    }

    @Test
    void testCalculateMedian_OddSize() {
        logger.info("Running testCalculateMedian_OddSize...");
        List<Double> data = Arrays.asList(5.0, 1.0, 3.0);
        double median = dataAnalyzer.calculateMedian(data);
        logger.info("Calculated median (odd size): " + median);
        assertEquals(3.0, median, 0.001, "Median should be 3.0");
    }

    @Test
    void testCalculateMedian_EvenSize() {
        logger.info("Running testCalculateMedian_EvenSize...");
        List<Double> data = Arrays.asList(5.0, 1.0, 3.0, 4.0);
        double median = dataAnalyzer.calculateMedian(data);
        logger.info("Calculated median (even size): " + median);
        assertEquals(3.5, median, 0.001, "Median should be 3.5");
    }

    @Test
    void testCalculateMedian_EmptyList() {
        logger.info("Running testCalculateMedian_EmptyList...");
        List<Double> data = Collections.emptyList();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> dataAnalyzer.calculateMedian(data));
        logger.warning("Exception message: " + exception.getMessage());
        assertEquals("Data list cannot be empty.", exception.getMessage());
    }

    @Test
    void testCalculateMode_SingleMode() {
        logger.info("Running testCalculateMode_SingleMode...");
        List<Double> data = Arrays.asList(1.0, 2.0, 2.0, 3.0);
        Map<Double, Integer> mode = dataAnalyzer.calculateMode(data);
        logger.info("Calculated mode (single): " + mode);
        assertEquals(1, mode.size(), "There should be one mode.");
        assertTrue(mode.containsKey(2.0), "Mode should be 2.0");
        assertEquals(2, mode.get(2.0), "Frequency of mode should be 2");
    }

    @Test
    void testCalculateMode_MultipleModes() {
        logger.info("Running testCalculateMode_MultipleModes...");
        List<Double> data = Arrays.asList(1.0, 1.0, 2.0, 2.0, 3.0);
        Map<Double, Integer> mode = dataAnalyzer.calculateMode(data);
        logger.info("Calculated mode (multiple): " + mode);
        assertEquals(2, mode.size(), "There should be two modes.");
        assertTrue(mode.containsKey(1.0), "Mode should include 1.0");
        assertTrue(mode.containsKey(2.0), "Mode should include 2.0");
    }

    @Test
    void testCalculateMode_EmptyList() {
        logger.info("Running testCalculateMode_EmptyList...");
        List<Double> data = Collections.emptyList();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> dataAnalyzer.calculateMode(data));
        logger.warning("Exception message: " + exception.getMessage());
        assertEquals("Data list cannot be empty.", exception.getMessage());
    }
}
