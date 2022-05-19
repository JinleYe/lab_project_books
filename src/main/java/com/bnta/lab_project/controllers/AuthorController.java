package com.bnta.lab_project.controllers;


import com.bnta.lab_project.models.Author;
import com.bnta.lab_project.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    // index
    @GetMapping
    public ResponseEntity<List<Author>> getAuthors(
            @RequestParam(required = false, name = "name") String name){

        if(name != null) {
//            String n = Character.toTitleCase(name.charAt(0)) + name.substring(1, name.length()-1);
            return new ResponseEntity<>(authorRepository.findAuthorsByNameIsContainingIgnoreCase(name), HttpStatus.FOUND);
        }

        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK);
    }

    // show
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable Long id){
        var author = authorRepository.findById(id);
        return new ResponseEntity<>(author, author.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
    }

    // post
    @PostMapping
    public ResponseEntity<Author> createNewAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorRepository.save(author), HttpStatus.CREATED);
    }

    // Delete
    @DeleteMapping("/delete-{id}")
    public void deleteAuthorById(@PathVariable Long id){
        authorRepository.deleteById(id);
    }


}
