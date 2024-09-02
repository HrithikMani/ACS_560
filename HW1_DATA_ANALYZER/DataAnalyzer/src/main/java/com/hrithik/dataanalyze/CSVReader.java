package com.hrithik.dataanalyze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVReader class provides a method to read data from a CSV file.
 */
public class CSVReader {

    /**
     * Reads a CSV file and returns the data as a list of string arrays.
     * Each array represents a row in the CSV file.
     * 
     * @param filename The name or path of the CSV file to read.
     * @return A list of string arrays, where each array represents a row in the CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public List<String[]> readCSV(String filename) throws IOException {
        // Validate that the input file is a CSV file
        if (!filename.endsWith(".csv")) {
            throw new IOException("The file must be a .csv file.");
        }

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
