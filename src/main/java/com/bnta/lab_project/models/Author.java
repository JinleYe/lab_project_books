package com.bnta.lab_project.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    // The joinColumn attribute will connect to the owner
    // side of the relationship,and the inverseJoinColumn to the other side
    @ManyToMany
    @JsonIgnoreProperties(value = "authors")
    @JoinTable(
            name = "authors_books",
            joinColumns = {@JoinColumn(name = "author_id", nullable = true)},
            inverseJoinColumns = {@JoinColumn(name = "book_id", nullable = true)}
    )
    private List<Book> books;

    protected Author(){}

    public Author(String name, List<Book> books ) {
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

