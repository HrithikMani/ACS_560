package com.example.hw2_rest_api.repositories;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.util.CSVReader;
import com.example.hw2_rest_api.util.FileUtil;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Collectors;

/**
 * Repository class to manage data access from CSV files.
 */
@Repository
public class DataRepository {

    private List<DataModel> dataList;
    private final String writableCSVFilePath = "data/googleplaystore.csv";  // Path to writable directory

    /**
     * Constructor to load the CSV file and store the data in memory.
     *
     * @param csvReader The utility to read the CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public DataRepository(CSVReader csvReader) throws IOException {
        // Copy CSV from resources to the writable directory if it doesn't exist
        String resourceFilePath = "/googleplaystore.csv";  // Path in resources
        FileUtil.copyFileFromResources(resourceFilePath, writableCSVFilePath);

        // Now load the data from the writable CSV file
        this.dataList = csvReader.readCSVFromFile(new File(writableCSVFilePath));
    }

    /**
     * Gets all the data stored in memory.
     *
     * @return A list of DataModel objects.
     */
    public List<DataModel> getAllData() {
        return dataList;
    }

    /**
     * Adds data to the data structure and appends it to the CSV.
     * Duplicate data should not be added.
     * If saving to CSV fails, the operation is rolled back.
     * 
     * @param dataModel The data to be added.
     * @param csvFilePath The path to the CSV file.
     * @return boolean indicating success or failure.
     */
    public boolean addDataToStructure(DataModel dataModel, String csvFilePath) {
        // Check for duplicate data
        if (!dataList.contains(dataModel)) {
            // Add data to in-memory structure
            dataList.add(dataModel);

            // Attempt to append the new data to the CSV file
            if (!appendData(dataModel, csvFilePath)) {
                // Rollback: Remove the added data if saving to the CSV fails
                dataList.remove(dataModel);
                System.out.println("Failed to add data: " + dataModel.getName());
                return false;
            }
            System.out.println("Data added: " + dataModel.getName() + " at " + csvFilePath);
            return true; // Data added and saved to CSV successfully
        } else {
            System.out.println("Duplicate data not added: " + dataModel.getName());
            return false;
        }
    }

    /**
     * Updates data in the data structure.
     * Non-existing data should be validated.
     * If the data is updated, the CSV file is updated.
     * If saving to the CSV fails, the operation is rolled back.
     * 
     * @param updatedDataModel The updated data model to be saved.
     * @param csvFilePath The path to the CSV file.
     * @return boolean indicating success or failure.
     */
    public boolean updateDataInStructure(DataModel updatedDataModel, String csvFilePath) {
        // Check if the data exists in the data structure
        int index = dataList.indexOf(updatedDataModel);
        if (index >= 0) {
            // Backup the original data before update in case we need to rollback
            DataModel originalDataModel = dataList.get(index);

            // Update the data in-memory
            dataList.set(index, updatedDataModel);

            // Save the updated data to the CSV file
            if (!saveData(dataList, csvFilePath)) {
                // Rollback: Revert to original data if saving to the CSV fails
                dataList.set(index, originalDataModel);
                System.out.println("Failed to update data: " + updatedDataModel.getName());
                return false;
            }
            System.out.println("Data updated: " + updatedDataModel.getName() + " at " + csvFilePath);
            return true; // Data updated and saved to CSV successfully
        } else {
            System.out.println("Data not found for update: " + updatedDataModel.getName());
            return false;
        }
    }

    /**
     * Deletes data from the data structure.
     * Non-existing data should be validated.
     * If the data is deleted, the CSV file is updated.
     * If saving to the CSV fails, the operation should be rolled back.
     * 
     * @param dataModel The data to be deleted.
     * @param csvFilePath The path to the CSV file.
     * @return boolean indicating success or failure.
     */
    public boolean deleteDataFromStructure(DataModel dataModel, String csvFilePath) {
        // Check if the data exists in the data structure
        if (dataList.contains(dataModel)) {
            // Backup the data to rollback if necessary
            int index = dataList.indexOf(dataModel);
            DataModel originalDataModel = dataList.get(index);

            // Remove the data from the list
            dataList.remove(dataModel);

            // Save the updated data list to the CSV file
            if (!saveData(dataList, csvFilePath)) {
                // Rollback: Re-add the original data if saving to CSV fails
                dataList.add(index, originalDataModel);
                System.out.println("Failed to delete data: " + dataModel.getName());
                return false;
            }
            System.out.println("Data deleted: " + dataModel.getName() + " from " + csvFilePath);
            return true; // Data deleted and saved to CSV successfully
        } else {
            System.out.println("Data not found for deletion: " + dataModel.getName());
            return false;
        }
    }

    /**
     * Appends data to the CSV file (for add operation).
     * 
     * @param dataModel The data to be appended.
     * @param csvFilePath The path to the CSV file.
     * @return boolean indicating success or failure.
     */
    public boolean appendData(DataModel dataModel, String csvFilePath) {
        int currentLine = 0;

        // Step 1: Create a File object to get the complete path
        File file = new File(csvFilePath);
        String absolutePath = file.getAbsolutePath();

        // Step 2: Count the number of lines in the file to determine the line number
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                currentLine++;
            }
        } catch (IOException e) {
            System.err.println("Failed to read the file to count lines: " + absolutePath);
            e.printStackTrace();
            return false;
        }

        // Step 3: Append the data to the file
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.append(dataModel.toCSVString());
            fileWriter.append("\n");
            
            // Print where the data is written
            System.out.println("Data written successfully to file: " + absolutePath);
            System.out.println("Written on line: " + (currentLine + 1));  // Since we're appending, it's the next line
            return true;
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + absolutePath);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Saves data to the CSV file (for update and delete operations).
     * Overwrites the existing file with the current data.
     * 
     * @param dataList The list of DataModel objects.
     * @param csvFilePath The path to the CSV file.
     * @return boolean indicating success or failure.
     */
    public boolean saveData(List<DataModel> dataList, String csvFilePath) {
        try (FileWriter fileWriter = new FileWriter(csvFilePath, false)) {  // false means overwrite the file
            for (DataModel dataModel : dataList) {
                fileWriter.append(dataModel.toCSVString());  // Use toCSVString for proper CSV format
                fileWriter.append("\n");  // Newline for the next record
            }
            System.out.println("Data saved to: " + csvFilePath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Searches the data list for entries that match the given keyword in either
     * the name or category fields.
     *
     * @param keyword The keyword to search for.
     * @return A list of data models that match the search keyword.
     */
    public List<DataModel> searchData(String keyword) {
        return dataList.stream()
                .filter(data -> data.getName().toLowerCase().contains(keyword.toLowerCase())
                        || data.getCategory().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
