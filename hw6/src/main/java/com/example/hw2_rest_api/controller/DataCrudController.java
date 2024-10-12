package com.example.hw2_rest_api.controller;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.model.ResponseMessage;
import com.example.hw2_rest_api.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
     * Get all data.
     *
     * @return ResponseEntity containing list of data models and HTTP status.
     */
    @GetMapping
    public ResponseEntity<?> getAllData() {
        try {
            List<DataModel> dataList = dataService.getAllData();
            return new ResponseEntity<>(dataList, HttpStatus.OK);  // 200 OK
        } catch (Exception e) {
            ResponseMessage responseMessage = new ResponseMessage("Internal Server Error", 500);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
        }
    }
    /**
     * Add new data.
     *
     * @param dataModel The data to be added.
     * @return ResponseEntity with HTTP status code.
     */
    @PostMapping
    public ResponseEntity<ResponseMessage> addData(@RequestBody DataModel dataModel) {
        try {
            boolean isAdded = dataService.addData(dataModel);
            if (isAdded) {
                ResponseMessage responseMessage = new ResponseMessage("Data added successfully", 201);
                return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);  // 201 Created
            } else {
                ResponseMessage responseMessage = new ResponseMessage("Data already exists", 400);
                return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);  // 400 Bad Request
            }
        } catch (Exception e) {
            ResponseMessage responseMessage = new ResponseMessage("Internal Server Error", 500);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
        }
    }

    /**
     * Update existing data.
     *
     * @param updatedDataModel The updated data model.
     * @return ResponseEntity with HTTP status code.
     */
    @PutMapping
    public ResponseEntity<ResponseMessage> updateData(@RequestBody DataModel updatedDataModel) {
        try {
            boolean isUpdated = dataService.updateData(updatedDataModel);
            if (isUpdated) {
                ResponseMessage responseMessage = new ResponseMessage("Data updated successfully", 200);
                return new ResponseEntity<>(responseMessage, HttpStatus.OK);  // 200 OK
            } else {
                ResponseMessage responseMessage = new ResponseMessage("Data not found", 404);
                return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);  // 404 Not Found
            }
        } catch (Exception e) {
            ResponseMessage responseMessage = new ResponseMessage("Internal Server Error", 500);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
        }
    }

    /**
     * Delete data.
     *
     * @param id The ID of the data to be deleted.
     * @return ResponseEntity with HTTP status code.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteData(@PathVariable Long id) {
        try {
            boolean isDeleted = dataService.deleteData(id);
            if (isDeleted) {
                ResponseMessage responseMessage = new ResponseMessage("Data deleted successfully", 200);
                return new ResponseEntity<>(responseMessage, HttpStatus.OK);  // 200 OK
            } else {
                ResponseMessage responseMessage = new ResponseMessage("Data not found", 404);
                return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);  // 404 Not Found
            }
        } catch (Exception e) {
            ResponseMessage responseMessage = new ResponseMessage("Internal Server Error", 500);
            return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
        }
    }

    /**
     * Search data by keywords in the name or category fields.
     *
     * @param keyword The keyword to search for in the data entries.
     * @return ResponseEntity containing a list of matching data models and HTTP status.
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchData(@RequestParam String keyword) {
        try {
            List<DataModel> searchResults = dataService.searchDataByKeyword(keyword);
            if (searchResults.isEmpty()) {
                return new ResponseEntity<>(new ResponseMessage("No matching data found", 404), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("Internal Server Error", 500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

  
}
