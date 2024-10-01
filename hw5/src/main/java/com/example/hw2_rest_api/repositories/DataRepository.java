package com.example.hw2_rest_api.repositories;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.util.CSVReader;
import com.example.hw2_rest_api.util.FileUtil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.Optional;
@Repository
public interface DataRepository extends JpaRepository<DataModel, Long> {
	// Find by name
    Optional<DataModel> findByName(String name);

    // Search by name or category
    List<DataModel> findByNameContainingOrCategoryContaining(String name, String category);
}

