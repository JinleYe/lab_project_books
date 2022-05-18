package com.bnta.lab_project.components;

import com.bnta.lab_project.models.Author;
import com.bnta.lab_project.models.Book;
import com.bnta.lab_project.models.Category;
import com.bnta.lab_project.models.Review;
import com.bnta.lab_project.repositories.AuthorRepository;
import com.bnta.lab_project.repositories.BookRepository;
import com.bnta.lab_project.repositories.CategoryRepository;
import com.bnta.lab_project.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
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

        Book book1 = new Book("Gradle in Action", LocalDate.of(2014, 2, 1), (float) 25.19);
        Book book2 = new Book("Spring Boot in Action", LocalDate.of(2015, 12, 1), (float) 25.19);
        Book book3 = new Book("Elasticsearch in Action", LocalDate.of(2015, 11, 1), (float) 35.19);
        Book book4 = new Book("Scala in Action", LocalDate.of(2013, 4, 1), (float) 31.49);
        Book book5 = new Book("Introducing Data Science", LocalDate.of(2016, 5, 1), (float) 25.19);
        Book book6 = new Book("Git in Practice", LocalDate.of(2014, 9, 1), (float) 22.39);
        Book book7 = new Book("Clean Code", LocalDate.of(2008, 8, 1), (float) 25.99);
        Book book8 = new Book("Clean Craftsmanship: Disciplines, Standards, and Ethics", LocalDate.of(2021, 10, 1), (float) 23.29);

        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8));

        Category category1 = new Category("Java", Arrays.asList(book1, book2, book3, book4));
        Category category2 = new Category("Data Science", Arrays.asList(book3, book5));
        Category category3 = new Category("Software Engineering", Arrays.asList(book1, book6));
        Category category4 = new Category("Coding Practices", Arrays.asList(book7, book8));

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3, category4));

        Author author1 = new Author("Robert Martin", Arrays.asList(book7, book8));
        Author author2 = new Author("Benjamin Muschko", Arrays.asList(book1));
        Author author3 = new Author("Craig Walls", Arrays.asList(book2));
        Author author4 = new Author("Radu Gheorghe", Arrays.asList(book3));
        Author author5 = new Author("Matthew Lee Hinman", Arrays.asList(book3));
        Author author6 = new Author("Roy Russo", Arrays.asList(book3));
        Author author7 = new Author("Nilanjan Raychaudhuri", Arrays.asList(book4));
        Author author8 = new Author("Davy Cielen", Arrays.asList(book5));
        Author author9 = new Author("Arno D. B. Meysman", Arrays.asList(book5));
        Author author10 = new Author("Davy Cielen", Arrays.asList(book5));
        Author author11 = new Author("Mike McQuaid", Arrays.asList(book6));

        authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4, author5, author6, author7,
                author8, author9, author10, author11));

        Review review1 = new Review(4, "Great book", book1);
        Review review2 = new Review(3, "Average book", book1);
        Review review3 = new Review(5, "Easy to digest", book2);
        Review review4 = new Review(4, "Have fun reading it", book2);
        Review review5 = new Review(2, "Very complicated", book3);
        Review review6 = new Review(3, "Great book to start", book4);
        Review review7 = new Review(1, "I can't understand", book4);
        Review review8 = new Review(5, "Lots of good examples", book5);
        Review review9 = new Review(5, "Definitely recommended", book5);
        Review review10 = new Review(1, "Bad quality", book6);
        Review review11 = new Review(5, "Best book ever", book7);
        Review review12 = new Review(5, "Glad to buy it", book7);
        Review review13 = new Review(5, "Every software engineer deserves one", book7);
        Review review14 = new Review(4, "Nice author", book8);

        reviewRepository.saveAll(Arrays.asList(review1, review2, review3, review4, review5, review6,
                review7, review8, review9, review10, review11, review12, review13, review14));













    }
}
