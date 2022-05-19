package com.bnta.lab_project.controllers;


import com.bnta.lab_project.models.Book;
import com.bnta.lab_project.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(required = false, name = "title") String word){
        if(word != null) {
            List<Book> found = bookRepository.findBooksByTitleIsContainingIgnoreCase(word);
            return new ResponseEntity<>(found, found.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
        }

        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/index-{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id){
        var book = bookRepository.findById(id);
        return new ResponseEntity<>(book, book.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
    }

    @PostMapping
    public void createNewBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    @DeleteMapping("/delete-{id}")
    public void deleteBookById(@PathVariable Long id){
        bookRepository.deleteById(id);
    }




}
