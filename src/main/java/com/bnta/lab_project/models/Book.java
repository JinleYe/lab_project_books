package com.bnta.lab_project.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private LocalDate publishDate;

    @Column
    private Float price;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;


    @ManyToMany(mappedBy = "books")
    private List<Category> categories;

    @OneToMany
    private List<Review> comments;



}
