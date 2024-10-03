package com.example.hw2_rest_api.services;

import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.repositories.DataRepository;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;
import java.util.Optional;

@Service
public class DataService implements ApplicationRunner {

    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    // Load CSV data on startup
    @Override
    public void run(org.springframework.boot.ApplicationArguments args) throws Exception {
        String csvFilePath = "googleplaystore.csv";  // Set your actual file path here
        loadCsvData(csvFilePath);
    }

    // Method to load CSV data
    public void loadCsvData(String filePath) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder()
                        .withSeparator(',')
                        .withQuoteChar('"')
                        .withEscapeChar('\\')
                        .withIgnoreQuotations(false)
                        .build())
                .withMultilineLimit(Integer.MAX_VALUE)
                .build()) {

            List<String[]> rows = reader.readAll();

            if (rows.isEmpty()) {
                System.err.println("CSV file is empty.");
                return;
            }

            for (String[] row : rows.subList(1, rows.size())) {  // Skip the header row
                try {
                    if (row.length >= 9) {
                        DataModel dataModel = new DataModel();
                        dataModel.setName(row[0]);
                        dataModel.setCategory(row[1]);
                        dataModel.setRating(Float.parseFloat(row[2].isEmpty() ? "0" : row[2]));
                        dataModel.setReviews(Integer.parseInt(row[3].isEmpty() ? "0" : row[3]));
                        dataModel.setSize(row[4]);
                        dataModel.setInstalls(row[5]);
                        dataModel.setType(row[6]);
                        dataModel.setPrice(Float.parseFloat(row[7].isEmpty() ? "0" : row[7]));
                        dataModel.setContentRating(row[8]);

                        // Save each row if it doesn't already exist in the repository
                        if (!dataRepository.findByName(dataModel.getName()).isPresent()) {
                            dataRepository.save(dataModel);
                        }
                    } else {
                        System.err.println("Skipping incomplete line: " + String.join(",", row));
                    }
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.err.println("Skipping malformed line: " + String.join(",", row));
                }
            }
            System.out.println("CSV data loaded into H2 database successfully.");
        } catch (Exception e) {
            System.err.println("Error while loading CSV data: " + e.getMessage());
        }
    }

    // CRUD operations
    public List<DataModel> getAllData() {
        return (List<DataModel>) dataRepository.findAll();
    }

    public boolean addData(DataModel dataModel) {
        Optional<DataModel> existingData = dataRepository.findByName(dataModel.getName());
        if (existingData.isPresent()) {
            return false;  // Data already exists
        }
        dataRepository.save(dataModel);
        return true;
    }

    public boolean updateData(DataModel updatedDataModel) {
        Optional<DataModel> existingData = dataRepository.findById(updatedDataModel.getId());
        if (existingData.isPresent()) {
            dataRepository.save(updatedDataModel);
            return true;
        }
        return false;  // Data not found
    }

    public boolean deleteData(Long id) {
        if (dataRepository.existsById(id)) {
            dataRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<DataModel> searchDataByKeyword(String keyword) {
        return dataRepository.findByNameContainingOrCategoryContaining(keyword, keyword);
    }

    public Optional<DataModel> getDataById(Long id) {
        return dataRepository.findById(id);
    }
}
