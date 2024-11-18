package com.example.hw2_rest_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.services.DataModelService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data-models")
public class DataModelController {

    @Autowired
    private DataModelService dataModelService;

    @GetMapping
    public List<DataModel> getAllDataModels() {
        return dataModelService.getAllDataModels();
    }
    @GetMapping("/all-with-reviews")
    public ResponseEntity<List<DataModel>> getAllDataModelsWithReviews() {
        List<DataModel> dataModels = dataModelService.getAllDataModels();
        return ResponseEntity.ok(dataModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataModel> getDataModelById(@PathVariable Long id) {
        Optional<DataModel> dataModel = dataModelService.getDataModelById(id);
        return dataModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DataModel> createDataModel(@RequestBody DataModel dataModel) {
        DataModel createdDataModel = dataModelService.saveDataModel(dataModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDataModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataModel> updateDataModel(@PathVariable Long id, @RequestBody DataModel dataModel) {
        if (!dataModelService.getDataModelById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        DataModel updatedDataModel = dataModelService.updateDataModel(id, dataModel);
        return ResponseEntity.ok(updatedDataModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDataModel(@PathVariable Long id) {
        if (!dataModelService.getDataModelById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        dataModelService.deleteDataModel(id);
        return ResponseEntity.noContent().build();
    }
}
