package com.math012.reviewly.reviewly_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class ReviewDTO {

    private String title;
    private String review;
    private Integer rating;
    private String category;

    public ReviewDTO(String title, String review, Integer rating) {
        this.title = title;
        this.review = review;
        this.rating = rating;
    }
}
