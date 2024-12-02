package com.example.hw2_rest_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.repositories.DataModelRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DataModelService {

    @Autowired
    private DataModelRepository dataModelRepository;

    
    public List<DataModel> getAllDataModels() {
        return dataModelRepository.findAll();
    }

    public Optional<DataModel> getDataModelById(Long id) {
        return dataModelRepository.findById(id);
    }

    public DataModel saveDataModel(DataModel dataModel) {
        return dataModelRepository.save(dataModel);
    }

    public DataModel updateDataModel(Long id, DataModel dataModel) {
        dataModel.setId(id);
        return dataModelRepository.save(dataModel);
    }

    public void deleteDataModel(Long id) {
        dataModelRepository.deleteById(id);
    }
}
