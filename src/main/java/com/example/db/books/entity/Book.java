package com.example.db.books.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Book(String title) {
        this.title = title;
    }

    //hibernate wymaga konstruktora bezparametrowego, jpa wymaga, żeby modyfikator dostępu dla tego konstruktora był public lub protected
    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
