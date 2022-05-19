package com.bnta.lab_project.repositories;

import com.bnta.lab_project.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAuthorsByNameIsContainingIgnoreCase(String name);

//    void deleteById(Long id);

}
