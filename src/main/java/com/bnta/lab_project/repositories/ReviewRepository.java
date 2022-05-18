package com.bnta.lab_project.repositories;

import com.bnta.lab_project.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
