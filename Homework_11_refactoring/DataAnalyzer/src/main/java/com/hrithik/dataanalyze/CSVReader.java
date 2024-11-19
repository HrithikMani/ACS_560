package com.hrithik.dataanalyze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVReader class provides methods to read and validate CSV files.
 */
public class CSVReader {

    /**
     * Validates whether the provided file is a valid CSV file.
     * 
     * @param filename The name or path of the file to validate.
     * @throws IllegalArgumentException If the file is not valid or null.
     */
    private void validateCSVFile(String filename) {
        if (filename == null || !filename.endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid file: Must be a non-null .csv file.");
        }
    }

    /**
     * Reads a CSV file and returns the data as a list of string arrays.
     * Each array represents a row in the CSV file.
     * 
     * @param filename The name or path of the CSV file to read.
     * @return A list of string arrays, where each array represents a row in the CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public List<String[]> readCSV(String filename) throws IOException {
        validateCSVFile(filename);

        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }
}
