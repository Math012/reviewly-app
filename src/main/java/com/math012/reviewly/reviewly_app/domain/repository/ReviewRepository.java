package com.math012.reviewly.reviewly_app.domain.repository;

import com.math012.reviewly.reviewly_app.domain.model.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT c FROM Review c WHERE c.category=:categorySelected")
    List<Object> findAllCategory(@Param("categorySelected")String categorySelected);

    @Query("SELECT r FROM Review r WHERE r.user.username =:username")
    List<Review> findAllReviewsByUsername(@Param("username") String username);


}
