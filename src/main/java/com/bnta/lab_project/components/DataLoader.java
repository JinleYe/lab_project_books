package com.bnta.lab_project.components;

import com.bnta.lab_project.models.Author;
import com.bnta.lab_project.models.Book;
import com.bnta.lab_project.repositories.AuthorRepository;
import com.bnta.lab_project.repositories.BookRepository;
import com.bnta.lab_project.repositories.CategoryRepository;
import com.bnta.lab_project.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.time.LocalDate;

public class DataLoader implements ApplicationRunner {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Book book1 = new Book("Gradle in Action", LocalDate.of(2014, 02, 1), (float) 25.19)








    }
}
