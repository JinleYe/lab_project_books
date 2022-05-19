package com.bnta.lab_project.controllers;


import com.bnta.lab_project.models.Book;
import com.bnta.lab_project.models.Category;
import com.bnta.lab_project.models.Review;
import com.bnta.lab_project.repositories.CategoryRepository;
import com.bnta.lab_project.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reviews")
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(
            @RequestParam(required = false, name = "comment") String word)
    {
        if(word != null) {
            List<Review> found = reviewRepository.findReviewsByCommentIsContainingIgnoreCase(word);
            return new ResponseEntity<>(found, found.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
        }
        return new ResponseEntity<>(reviewRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping("/books-star={num}")
    public ResponseEntity<List<Book>> getBookListByStarsGreaterThan(@PathVariable int num){
        List<Book> found = reviewRepository.findByStarNumberGreaterThan(num).stream().map(re -> re.getBook()).toList();
        return new ResponseEntity<>(found, found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
    }


    // show
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Review>> getReviewById(@PathVariable Long id){
        return new ResponseEntity<>(reviewRepository.findById(id),
                reviewRepository.findById(id).isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
    }

    // post
    @PostMapping
    public void createNewReview(@RequestBody Review review){
        reviewRepository.save(review);
    }

    // delete
    @DeleteMapping("/delete-{id}")
    public void deleteCategoryById(@PathVariable Long id){
        reviewRepository.deleteById(id);
    }
}
