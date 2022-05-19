package com.bnta.lab_project.repositories;

import com.bnta.lab_project.models.Author;
import com.bnta.lab_project.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByTitleIsContainingIgnoreCase(String name);

}
