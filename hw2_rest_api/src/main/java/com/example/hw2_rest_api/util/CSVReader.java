package com.example.hw2_rest_api.util;

import com.example.hw2_rest_api.model.DataModel;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to read and parse CSV files.
 */
@Component
public class CSVReader {

    /**
     * Reads a CSV file from an InputStream and parses it into a list of DataModel objects.
     * 
     * @param inputStream The input stream to read the CSV file from.
     * @return A list of DataModel objects parsed from the CSV.
     * @throws IOException If an I/O error occurs.
     */
    public List<DataModel> readCSV(InputStream inputStream) throws IOException {
        List<DataModel> dataModels = new ArrayList<>();
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                DataModel dataModel = new DataModel();

                // Clean and set name and category
                dataModel.setName(data[0].replaceAll("\"", "").trim());
                dataModel.setCategory(data[1].replaceAll("\"", "").trim());

                // Parse rating, handle NaN or invalid values
                try {
                    double rating = Double.parseDouble(data[2]);
                    dataModel.setRating(rating);
                } catch (NumberFormatException e) {
                    dataModel.setRating(0.0);  // Default value if NaN or invalid
                }

                // Parse reviews
                try {
                    dataModel.setReviews(Integer.parseInt(data[3]));
                } catch (NumberFormatException e) {
                    dataModel.setReviews(0);  // Default value if invalid
                }

                // Set size
                dataModel.setSize(data[4]);

                // Clean installs and type
                dataModel.setInstalls(data[5].replaceAll("\"", ""));
                dataModel.setType(data[6].replaceAll("\"", ""));

                // Parse price
                try {
                    dataModel.setPrice(Double.parseDouble(data[7]));
                } catch (NumberFormatException e) {
                    dataModel.setPrice(0.0);  // Default value if invalid
                }

                // Set content rating and genres
                dataModel.setContentRating(data[8].replaceAll("\"", "").trim());
                dataModel.setGenres(data[9].replaceAll("\"", "").trim());

                // Add to list
                dataModels.add(dataModel);
            }
        }

        return dataModels;
    }

    /**
     * Reads a CSV file from the resources folder.
     * 
     * @param filePath The path to the CSV file in the resources folder.
     * @return A list of DataModel objects parsed from the CSV.
     * @throws IOException If an I/O error occurs.
     */
    public List<DataModel> readCSVFromResources(String filePath) throws IOException {
        InputStream inputStream = new ClassPathResource(filePath).getInputStream();
        return readCSV(inputStream);
    }
}
