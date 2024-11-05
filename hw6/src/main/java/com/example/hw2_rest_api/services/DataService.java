package com.example.hw2_rest_api.services;

import com.example.hw2_rest_api.dto.DataModelDTO;
import com.example.hw2_rest_api.dto.UserReviewDTO;
import com.example.hw2_rest_api.model.DataModel;
import com.example.hw2_rest_api.model.UserReview;
import com.example.hw2_rest_api.repositories.DataRepository;
import com.example.hw2_rest_api.repositories.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DataService {

    private final DataRepository dataRepository;
    private final UserReviewRepository userReviewRepository;

    @Autowired
    public DataService(DataRepository dataRepository, UserReviewRepository userReviewRepository) {
        this.dataRepository = dataRepository;
        this.userReviewRepository = userReviewRepository;
    }

    public List<DataModelDTO> getAllDataDTO() {
        return dataRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public boolean addData(DataModelDTO dataModelDTO) {
        Optional<DataModel> existingData = dataRepository.findByName(dataModelDTO.getName());
        if (existingData.isPresent()) {
            return false; // Data already exists
        }
        DataModel dataModel = convertToEntity(dataModelDTO);
        dataRepository.save(dataModel);
        return true;
    }

    public boolean updateData(DataModelDTO updatedDataModelDTO) {
        Optional<DataModel> existingData = dataRepository.findById(updatedDataModelDTO.getId());
        if (existingData.isEmpty()) {
            return false; // Data not found
        }
        DataModel dataModel = convertToEntity(updatedDataModelDTO);
        dataRepository.save(dataModel);
        return true;
    }

    public boolean deleteData(Long id) {
        if (!dataRepository.existsById(id)) {
            return false; // Data not found
        }
        dataRepository.deleteById(id);
        return true;
    }

    public List<DataModelDTO> searchDataByKeyword(String keyword) {
        return dataRepository.findByNameContainingOrCategoryContaining(keyword, keyword).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DataModelDTO convertToDTO(DataModel dataModel) {
        List<UserReviewDTO> userReviews = dataModel.getUserReviews().stream()
                .map(review -> new UserReviewDTO(
                        review.getId(),
                        review.getSentiment(),
                        review.getSentimentPolarity(),
                        review.getSentimentSubjectivity(),
                        review.getReview()))
                .collect(Collectors.toList());

        return new DataModelDTO(
                dataModel.getId(),
                dataModel.getName(),
                dataModel.getCategory(),
                dataModel.getRating(),
                dataModel.getReviews(),
                dataModel.getSize(),
                dataModel.getInstalls(),
                dataModel.getType(),
                dataModel.getPrice(),
                dataModel.getContentRating(),
                dataModel.getGenres(),
                userReviews);
    }

    private DataModel convertToEntity(DataModelDTO dataModelDTO) {
        DataModel dataModel = new DataModel();
        dataModel.setId(dataModelDTO.getId());
        dataModel.setName(dataModelDTO.getName());
        dataModel.setCategory(dataModelDTO.getCategory());
        dataModel.setRating(dataModelDTO.getRating());
        dataModel.setReviews(dataModelDTO.getReviews());
        dataModel.setSize(dataModelDTO.getSize());
        dataModel.setInstalls(dataModelDTO.getInstalls());
        dataModel.setType(dataModelDTO.getType());
        dataModel.setPrice(dataModelDTO.getPrice());
        dataModel.setContentRating(dataModelDTO.getContentRating());
        dataModel.setGenres(dataModelDTO.getGenres());

        List<UserReview> userReviews = dataModelDTO.getUserReviews().stream()
                .map(reviewDTO -> new UserReview(
                        reviewDTO.getId(),
                        reviewDTO.getSentiment(),
                        reviewDTO.getSentimentPolarity(),
                        reviewDTO.getSentimentSubjectivity(),
                        reviewDTO.getReview(),
                        dataModel))
                .collect(Collectors.toList());

        dataModel.setUserReviews(userReviews);

        return dataModel;
    }
}
