package com.bnta.lab_project.repositories;

import com.bnta.lab_project.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findCategoriesByNameIsContainingIgnoreCase(String word);
}
