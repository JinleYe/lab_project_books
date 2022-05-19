package com.bnta.lab_project.controllers;


import com.bnta.lab_project.models.Category;
import com.bnta.lab_project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories(
            @RequestParam(required = false, name = "name") String word)
    {
        if(word != null) {
            List<Category> found = categoryRepository.findCategoriesByNameIsContainingIgnoreCase(word);
            return new ResponseEntity<>(found, found.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
        }
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }

    // show
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryRepository.findById(id),
                categoryRepository.findById(id).isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
    }

    // post
    @PostMapping
    public void createNewCategory(@RequestBody Category category){
        categoryRepository.save(category);
    }

    // delete
    @DeleteMapping("/delete-{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }




}
