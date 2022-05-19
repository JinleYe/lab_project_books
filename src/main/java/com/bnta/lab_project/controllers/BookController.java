package com.bnta.lab_project.controllers;


import com.bnta.lab_project.models.Author;
import com.bnta.lab_project.models.Book;
import com.bnta.lab_project.models.Category;
import com.bnta.lab_project.repositories.AuthorRepository;
import com.bnta.lab_project.repositories.BookRepository;
import com.bnta.lab_project.repositories.CategoryRepository;
import com.bnta.lab_project.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

//    @Autowired
//    AuthorRepository authorRepository;
//
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @Autowired
//    ReviewRepository reviewRepository;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(required = false, name = "title") String word){
        if(word != null) {
            List<Book> found = bookRepository.findBooksByTitleIsContainingIgnoreCase(word);
            return new ResponseEntity<>(found, found.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
        }

        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id){
        var book = bookRepository.findById(id);
        return new ResponseEntity<>(book, book.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
    }

    @GetMapping("/search-price={price}")
    public ResponseEntity<List<Book>> getBookByPriceOrderByAsc(@PathVariable float price){
        var found = bookRepository.findBooksByPriceIsLessThanOrderByPriceAsc(price);
        return new ResponseEntity<>(found, found.isEmpty()? HttpStatus.NOT_FOUND : HttpStatus.FOUND);
    }

    @GetMapping("/review/greater-{star}")
    public List<Book> getBookReviewGreaterThan(@PathVariable int star){
        var result = bookRepository.findBookReviewGreaterThan(star);
        return result;
    }


    @PostMapping
    public void createNewBook(@RequestBody Book book){
        bookRepository.save(book);
    }

//    @DeleteMapping("/delete-{id}")
//    public void deleteBookById(@PathVariable Long id){
//        bookRepository.deleteById(id);
//    }


    @DeleteMapping("/delete-{id}")
    public void deleteBookById(@PathVariable Long id){
        var found_book = bookRepository.findById(id);
        if(found_book.isPresent()){
            var book = found_book.get();

            // remove book in authors table
            book.getAuthors().stream().forEach(a -> a.removeBook(book));

            // remove book in categories table
            book.getCategories().stream().forEach(c -> c.removeBook(book));

            // remove authors
            book.setAuthors(new ArrayList<>());

            // remove categories
            book.setCategories(new ArrayList<>());
        }

        bookRepository.deleteById(id);
    }






}
