package com.bnta.lab_project.repositories;

import com.bnta.lab_project.models.Book;
import com.bnta.lab_project.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByCommentIsContainingIgnoreCase(String word);

    List<Review> findByStarNumberGreaterThan(int num);
}
