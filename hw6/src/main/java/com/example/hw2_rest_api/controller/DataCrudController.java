package com.example.hw2_rest_api.controller;

import com.example.hw2_rest_api.dto.DataModelDTO;
import com.example.hw2_rest_api.model.ResponseMessage;
import com.example.hw2_rest_api.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* REST controller to handle CRUD operations on data, interacting with the database using JPA.
*/
@RestController
@RequestMapping("/api/crud")
public class DataCrudController {

    private final DataService dataService;

    @Autowired
    public DataCrudController(DataService dataService) {
        this.dataService = dataService;
    }

    /**
     * Get all data as DTOs.
     *
     * @return ResponseEntity containing list of data model DTOs and HTTP status.
     */
    @GetMapping
    public ResponseEntity<List<DataModelDTO>> getAllData() {
        List<DataModelDTO> dataList = dataService.getAllDataDTO();
        return new ResponseEntity<>(dataList, HttpStatus.OK);  // 200 OK
    }

    /**
     * Add new data using DataModelDTO.
     *
     * @param dataModelDTO The data to be added.
     * @return ResponseEntity with HTTP status code.
     */
    @PostMapping
    public ResponseEntity<ResponseMessage> addData(@RequestBody DataModelDTO dataModelDTO) {
        boolean isAdded = dataService.addData(dataModelDTO);
        if (isAdded) {
            return new ResponseEntity<>(new ResponseMessage("Data added successfully", 201), HttpStatus.CREATED);  // 201 Created
        } else {
            return new ResponseEntity<>(new ResponseMessage("Data already exists", 400), HttpStatus.BAD_REQUEST);  // 400 Bad Request
        }
    }

    /**
     * Update existing data using DataModelDTO.
     *
     * @param updatedDataModelDTO The updated data model DTO.
     * @return ResponseEntity with HTTP status code.
     */
    @PutMapping
    public ResponseEntity<ResponseMessage> updateData(@RequestBody DataModelDTO updatedDataModelDTO) {
        boolean isUpdated = dataService.updateData(updatedDataModelDTO);
        if (isUpdated) {
            return new ResponseEntity<>(new ResponseMessage("Data updated successfully", 200), HttpStatus.OK);  // 200 OK
        } else {
            return new ResponseEntity<>(new ResponseMessage("Data not found", 404), HttpStatus.NOT_FOUND);  // 404 Not Found
        }
    }

    /**
     * Delete data by ID.
     *
     * @param id The ID of the data to be deleted.
     * @return ResponseEntity with HTTP status code.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteData(@PathVariable Long id) {
        boolean isDeleted = dataService.deleteData(id);
        if (isDeleted) {
            return new ResponseEntity<>(new ResponseMessage("Data deleted successfully", 200), HttpStatus.OK);  // 200 OK
        } else {
            return new ResponseEntity<>(new ResponseMessage("Data not found", 404), HttpStatus.NOT_FOUND);  // 404 Not Found
        }
    }

    /**
     * Search data by keywords in the name or category fields, returning DataModelDTOs.
     *
     * @param keyword The keyword to search for in the data entries.
     * @return ResponseEntity containing a list of matching data model DTOs and HTTP status.
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchData(@RequestParam String keyword) {
        List<DataModelDTO> searchResults = dataService.searchDataByKeyword(keyword);
        if (searchResults.isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage("No matching data found", 404), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }
}
