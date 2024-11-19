package com.hrithik.dataanalyze;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class that drives the application.
 * It handles user interaction and delegates business logic to appropriate services.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for CSV Input
        System.out.print("Enter the CSV filename to analyze (e.g., src/main/resources/googleplaystore.csv): ");
        String inputFilename = scanner.nextLine();

        try {
            // Read and Validate CSV File
            CSVReader csvReader = new CSVReader();
            List<String[]> data = csvReader.readCSV(inputFilename);

            // Process Data and Generate Report
            DataProcessingService service = new DataProcessingService();
            AnalysisResults results = service.analyzeData(data);

            // Display Results in Console
            System.out.println(results);

            // Save Results to a File
            System.out.print("Enter the filename to save the report (e.g., report.txt): ");
            String outputFilename = scanner.nextLine();

            ReportGenerator reportGenerator = new ReportGenerator();
            reportGenerator.generateReport(outputFilename, results.toString());

            System.out.println("Report generated successfully: " + new File(outputFilename).getAbsolutePath());

        } catch (IllegalArgumentException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
