package com.math012.reviewly.reviewly_app.domain.repository;

import com.math012.reviewly.reviewly_app.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
