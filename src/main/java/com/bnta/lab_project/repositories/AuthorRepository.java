package com.bnta.lab_project.repositories;

import com.bnta.lab_project.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
