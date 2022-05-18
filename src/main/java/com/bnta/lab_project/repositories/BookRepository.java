package com.bnta.lab_project.repositories;

import com.bnta.lab_project.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
