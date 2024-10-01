package com.example.hw2_rest_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.repositories.DataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    public List<DataModel> getAllData() {
        return (List<DataModel>) dataRepository.findAll();
    }

    // Add new data
    public boolean addData(DataModel dataModel) {
        Optional<DataModel> existingData = dataRepository.findByName(dataModel.getName());
        if (existingData.isPresent()) {
            return false;  // Data already exists
        }
        dataRepository.save(dataModel);
        return true;
    }

    // Update existing data
    public boolean updateData(DataModel updatedDataModel) {
        Optional<DataModel> existingData = dataRepository.findById(updatedDataModel.getId());
        if (existingData.isPresent()) {
            dataRepository.save(updatedDataModel);
            return true;
        }
        return false;  // Data not found
    }

    // Delete data by ID
    public boolean deleteData(Long id) {
        if (dataRepository.existsById(id)) {
            dataRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Search data by keyword in name or category
    public List<DataModel> searchDataByKeyword(String keyword) {
        return dataRepository.findByNameContainingOrCategoryContaining(keyword, keyword);
    }

    // Get data by ID
    public Optional<DataModel> getDataById(Long id) {
        return dataRepository.findById(id);
    }
}
