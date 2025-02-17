package com.math012.reviewly.reviewly_app.service.impl;

import com.math012.reviewly.reviewly_app.domain.model.Review;
import com.math012.reviewly.reviewly_app.domain.model.User;
import com.math012.reviewly.reviewly_app.domain.repository.ReviewRepository;
import com.math012.reviewly.reviewly_app.domain.repository.UserRepository;
import com.math012.reviewly.reviewly_app.dto.ReviewDTO;
import com.math012.reviewly.reviewly_app.exception.RequiredFieldsException;
import com.math012.reviewly.reviewly_app.exception.ReviewNotFoundException;
import com.math012.reviewly.reviewly_app.service.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO, String username, String category) {
        User user = userRepository.findByUsername(username).orElseThrow(()->
                new UsernameNotFoundException("Username: " + username +" not found"));

        Review review = new Review(
                reviewDTO.getTitle()
                , reviewDTO.getRating()
                , reviewDTO.getReview()
        );
        review.setCategory(selectCategory(category));
        review.setUser(user);
        review.setDate(LocalDate.now());
        review.setCategory(category);
        reviewDTO.setCategory(category);
        reviewRepository.save(review);
        return reviewDTO;
    }

    @Override
    public String selectCategory(String selectedCategory) {
        return switch (selectedCategory) {
            case "books" -> "Book";
            case "movies" -> "Movie";
            case "series" -> "Serie";
            // TODO - IMPLEMENTS THE CORRECT EXCEPTION AND MESSAGE
            default -> throw new RequiredFieldsException("Error switch case");
        };
    }

    @Override
    public List<Object> findAllCategoriesByName(String category) {
        return reviewRepository.findAllCategory(category);
    }

    @Override
    public List<Review> findAllReviewsByUsername(String username) {
        return reviewRepository.findAllReviewsByUsername(username);
    }

    @Override
    public String updateReviewById(Long id, ReviewDTO updateReview) {
        Review newReview = reviewRepository.findById(id).orElseThrow(()->
                new ReviewNotFoundException("Review não encontrada, tente novamente!")
                );
        newReview.setTitleOfTheWork(updateReview.getTitle());
        newReview.setReview(updateReview.getReview());
        System.out.println("TITLE: " + updateReview.getTitle());
        System.out.println("REVIEW: " + updateReview.getReview());
        reviewRepository.save(newReview);
        return "Alteração feita com sucesso!";
    }

    @Override
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}
