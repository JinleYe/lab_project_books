package com.bnta.lab_project.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    // TODO :many to many relationship
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;




}
