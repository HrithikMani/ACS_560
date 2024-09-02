package com.hrithik.dataanalyze;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class that drives the application.
 * It reads a CSV file, analyzes the data, and generates a report.
 */
public class Main {
    
    /**
     * Main method to start the program.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for CSV Input
        System.out.print("Enter the CSV filename to analyze (e.g., src/main/resources/googleplaystore.csv): ");
        String inputFilename = scanner.nextLine();

        // Instantiate necessary components
        CSVReader csvReader = new CSVReader();
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        ReportGenerator reportGenerator = new ReportGenerator();

        try {
            // Read the CSV file
            List<String[]> data = csvReader.readCSV(inputFilename);

            // Perform Rating Analysis
            List<Double> ratings = data.stream()
                                       .map(row -> {
                                           try {
                                               return Double.parseDouble(row[2]);
                                           } catch (NumberFormatException e) {
                                               return null;
                                           }
                                       })
                                       .filter(value -> value != null && !Double.isNaN(value))
                                       .toList();

            double meanRating = dataAnalyzer.calculateMean(ratings);
            double medianRating = dataAnalyzer.calculateMedian(ratings);
            Map<Double, Integer> modeRatings = dataAnalyzer.calculateMode(ratings);

            // Perform Install Count Analysis (after cleaning)
            List<Long> installs = data.stream()
                                      .map(row -> {
                                          try {
                                              return Long.parseLong(row[5].replace(",", "").replace("+", ""));
                                          } catch (NumberFormatException e) {
                                              return null;
                                          }
                                      })
                                      .filter(value -> value != null)
                                      .toList();

            double meanInstalls = dataAnalyzer.calculateMeanLong(installs);
            double medianInstalls = dataAnalyzer.calculateMedianLong(installs);
            Map<Long, Integer> modeInstalls = dataAnalyzer.calculateModeLong(installs);

            // Prepare the report content
            StringBuilder reportContent = new StringBuilder();
            reportContent.append("Rating Analysis\n");
            reportContent.append("Mean Rating: ").append(meanRating).append("\n");
            reportContent.append("Median Rating: ").append(medianRating).append("\n");
            reportContent.append("Mode Ratings: ").append(modeRatings.keySet()).append("\n");

            reportContent.append("\nInstall Count Analysis\n");
            reportContent.append("Mean Installs: ").append(meanInstalls).append("\n");
            reportContent.append("Median Installs: ").append(medianInstalls).append("\n");
            reportContent.append("Mode Installs: ").append(modeInstalls.keySet()).append("\n");

            // Display the report content in the console
            System.out.println(reportContent.toString());

            // Save the report to a file
            System.out.print("Enter the filename to save the report (e.g., report.txt): ");
            String outputFilename = scanner.nextLine();
            File reportFile = new File(outputFilename);
            reportGenerator.generateReport(reportFile.getAbsolutePath(), reportContent.toString());

            // Show the absolute path of the saved file
            System.out.println("Report generated successfully.");
            System.out.println("The report has been saved to: " + reportFile.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
