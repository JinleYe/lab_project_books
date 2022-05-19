package com.bnta.lab_project;

import com.bnta.lab_project.models.Author;
import com.bnta.lab_project.models.Book;
import com.bnta.lab_project.repositories.AuthorRepository;
import com.bnta.lab_project.repositories.BookRepository;
import com.bnta.lab_project.repositories.CategoryRepository;
import com.bnta.lab_project.repositories.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class LabProjectApplicationTests {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ReviewRepository reviewRepository;


    @Test
    void contextLoads() {
    }

    // Author Tests
    @Test
    public void testGetAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        assertThat(authors.size()).isEqualTo(11);
    }

    @Test
    public void testFindAuthorByNameContainingIgnoreCase(){
        List<Author> list1 = authorRepository.findAuthorsByNameIsContainingIgnoreCase("robert");
        assertThat(list1.size()).isEqualTo(1);
    }

    @Test
    public void testDeleteAuthorById(){
        authorRepository.deleteById(1L);
        List<Author> authors = authorRepository.findAll();
        assertThat(authors.size()).isEqualTo(10);
    }


    // Book Tests
    @Test
    public void testGetAllBooks(){
        List<Book> books = bookRepository.findAll();
        assertThat(books.size()).isEqualTo(8);
    }

    @Test
    public void testCanFindBookByName(){
        List<Book> books = bookRepository.findBooksByTitleIsContainingIgnoreCase("action");
        assertThat(books.size()).isEqualTo(4);
    }

    @Test
    public void testGetBookByPriceOrderByAsc(){
        List<Book> books = bookRepository.findBooksByPriceIsLessThanOrderByPriceAsc(25);
        assertThat(books.size()).isEqualTo(2);
    }

//    @Test
//    public void testDeleteBookById(){
//        bookRepository.deleteById(1L);
//        assertThat(bookRepository.findAll().size()).isEqualTo(7);
//    }



}
