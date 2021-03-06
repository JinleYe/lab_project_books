package com.bnta.lab_project.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany
    @JsonIgnoreProperties(value = "categories")
    @JoinTable(
            name = "categories_books",
            joinColumns = {@JoinColumn(name = "category_id", nullable = true)},
            inverseJoinColumns = {@JoinColumn(name = "book_id", nullable = true)}
    )
    private List<Book> books;

    protected Category(){}

    public Category(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    // modify books list
    public void addBook(Book book){
        this.books.add(book);
    }

    public void removeBook(Book book){
        this.books.remove(book);
    }
}
