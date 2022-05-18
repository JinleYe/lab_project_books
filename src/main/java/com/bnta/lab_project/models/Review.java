package com.bnta.lab_project.models;


import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_of_stars")
    private int starNumber;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    protected Review(){}

    public Review(int starNumber, String comment, Book book) {
        this.starNumber = starNumber;
        this.comment = comment;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public int getStarNumber() {
        return starNumber;
    }

    public String getComment() {
        return comment;
    }

    public Book getBook() {
        return book;
    }

    public void setStarNumber(int starNumber) {
        this.starNumber = starNumber;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
