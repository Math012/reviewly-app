package com.math012.reviewly.reviewly_app.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.math012.reviewly.reviewly_app.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tb_title")
    private String titleOfTheWork;
    // TODO Place validation dependence on the defined limiter for rating (0, 5)
    private Integer rating;
    @Column(name = "tb_review")
    private String review;
    @Column(name = "tb_date")
    private LocalDate date;
    @Column(name = "tb_category")
    private String category;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Review() {
    }

    public Review(String titleOfTheWork, Integer rating, String review) {
        this.titleOfTheWork = titleOfTheWork;
        this.rating = rating;
        this.review = review;
    }
}
