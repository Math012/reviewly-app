package com.math012.reviewly.reviewly_app.controller;

import com.math012.reviewly.reviewly_app.domain.model.Review;
import com.math012.reviewly.reviewly_app.dto.ReviewDTO;
import com.math012.reviewly.reviewly_app.service.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/publications/{username}/{category}")
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO
            , @PathVariable(name = "username")String username, @PathVariable(name = "category")String category){
        return ResponseEntity.ok(reviewService.createReview(reviewDTO,username,category));
    }

    @GetMapping("/all/category/{category}")
    public ResponseEntity<Object> getReviewByCategory(@PathVariable("category")String category){
        return ResponseEntity.ok(reviewService.findAllCategoriesByName(category));
    }

    @GetMapping("/all/reviews/{username}")
    public ResponseEntity<List<Review>> findAllReviewsByUsername(@PathVariable("username")String username){
        return ResponseEntity.ok(reviewService.findAllReviewsByUsername(username));
    }

    @PutMapping("/update/reviews/by/{id}")
    public ResponseEntity<String> updateReview(@PathVariable("id")Long id, @RequestBody ReviewDTO reviewDTO){
        return ResponseEntity.ok(reviewService.updateReviewById(id,reviewDTO));
    }

    @DeleteMapping("/delete/reviews/by/{id}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable("id")Long id){
        reviewService.deleteReviewById(id);
        return ResponseEntity.ok().build();
    }
}
