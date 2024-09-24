package com.example.hw2_rest_api.services;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.repositories.DataRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class to handle business logic for data operations.
 */
@Service
public class DataService {

    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * Adds data to the repository.
     * 
     * @param dataModel The data model to be added.
     * @param csvFilePath The path to the CSV file.
     * @return boolean indicating success or failure.
     */
    public boolean addData(DataModel dataModel, String csvFilePath) {
        return dataRepository.addDataToStructure(dataModel, csvFilePath);
    }

    /**
     * Updates data in the repository.
     * 
     * @param updatedDataModel The updated data model.
     * @param csvFilePath The path to the CSV file.
     * @return boolean indicating success or failure.
     */
    public boolean updateData(DataModel updatedDataModel, String csvFilePath) {
        return dataRepository.updateDataInStructure(updatedDataModel, csvFilePath);
    }

    /**
     * Deletes data from the repository.
     * 
     * @param dataModel The data model to be deleted.
     * @param csvFilePath The path to the CSV file.
     * @return boolean indicating success or failure.
     */
    public boolean deleteData(DataModel dataModel, String csvFilePath) {
        return dataRepository.deleteDataFromStructure(dataModel, csvFilePath);
    }
    /**
     * Retrieves all data from the repository.
     * 
     * @return A list of DataModel objects.
     */
    public List<DataModel> getAllData() {
        return dataRepository.getAllData();
    }
     /**
     * Searches data entries by a given keyword in the name or category fields.
     *
     * @param keyword The keyword to search within data entries.
     * @return A list of data models matching the search criteria.
     */
    public List<DataModel> searchDataByKeyword(String keyword) {
        return dataRepository.searchData(keyword);
    }
}
