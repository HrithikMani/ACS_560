package com.example.hw2_rest_api.repositories;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.util.CSVReader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Repository class to manage data access from CSV files.
 */
@Repository
public class DataRepository {

    private List<DataModel> dataList;

    /**
     * Constructor to load the CSV file and store the data in memory.
     * 
     * @param csvReader The utility to read the CSV file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public DataRepository(CSVReader csvReader) throws IOException {
        this.dataList = csvReader.readCSVFromResources("googleplaystore.csv");
    }

    /**
     * Gets all the data stored in memory.
     * 
     * @return A list of DataModel objects.
     */
    public List<DataModel> getAllData() {
        return dataList;
    }
}
