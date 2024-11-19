package com.hrithik.dataanalyze;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ReportGenerator class is responsible for generating reports from the analyzed data.
 */
public class ReportGenerator {

    /**
     * Validates the file extension for the output file.
     *
     * @param filename The name or path of the file.
     * @param expectedExtension The expected file extension (e.g., ".txt").
     * @throws IllegalArgumentException If the file does not have the expected extension.
     */
    private void validateFileExtension(String filename, String expectedExtension) {
        if (filename == null || !filename.endsWith(expectedExtension)) {
            throw new IllegalArgumentException("Invalid file: Must end with " + expectedExtension);
        }
    }

    /**
     * Generates a report and writes it to a specified file.
     *
     * @param filename The name or path of the file where the report will be saved.
     * @param reportContent The content of the report to be saved.
     * @throws IOException If an I/O error occurs while writing the file.
     */
    public void generateReport(String filename, String reportContent) throws IOException {
        validateFileExtension(filename, ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(reportContent);
        }
    }
}
