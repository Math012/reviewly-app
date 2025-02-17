package com.math012.reviewly.reviewly_app.service.interfaces;

import com.math012.reviewly.reviewly_app.domain.model.Review;
import com.math012.reviewly.reviewly_app.dto.ReviewDTO;

import java.util.List;
import java.util.Objects;

public interface ReviewService {

    ReviewDTO createReview(ReviewDTO reviewDTO, String username, String category);

    String selectCategory(String category);

    List<Object> findAllCategoriesByName(String category);

    List<Review> findAllReviewsByUsername(String username);

    String updateReviewById(Long id, ReviewDTO updateReview);

    void deleteReviewById(Long id);
}
