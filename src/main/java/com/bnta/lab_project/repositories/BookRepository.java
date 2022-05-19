package com.bnta.lab_project.repositories;

import com.bnta.lab_project.models.Author;
import com.bnta.lab_project.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByTitleIsContainingIgnoreCase(String name);

    List<Book> findBooksByPriceIsLessThanOrderByPriceAsc(float price);


    @Query("SELECT b FROM Book b JOIN b.reviews r WHERE r.starNumber > :starNumber")
    List<Book> findBookReviewGreaterThan(@Param("starNumber") int starNumber);



}
