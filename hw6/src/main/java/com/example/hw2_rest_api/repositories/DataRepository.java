package com.example.hw2_rest_api.repositories;

import com.example.hw2_rest_api.model.DataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface DataRepository extends JpaRepository<DataModel, Long> {
    Optional<DataModel> findByName(String name);
    List<DataModel> findByNameContainingOrCategoryContaining(String name, String category);
}
