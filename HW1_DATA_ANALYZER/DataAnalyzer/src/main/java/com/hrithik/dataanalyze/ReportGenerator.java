package com.hrithik.dataanalyze;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ReportGenerator class is responsible for generating reports from the analyzed data.
 */
public class ReportGenerator {

    /**
     * Generates a report and writes it to a specified file.
     * 
     * @param filename The name or path of the file where the report will be saved.
     * @param reportContent The content of the report to be saved.
     * @throws IOException If an I/O error occurs while writing the file.
     */
    public void generateReport(String filename, String reportContent) throws IOException {
        // Validate that the output file has a valid extension (e.g., .txt)
        if (!filename.endsWith(".txt")) {
            throw new IOException("The output file must be a .txt file.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(reportContent);
        }
    }
}
