package com.example.db.books.dto;

public class Book {
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }
//metoda get domyślnie jest niezbędna jackson do deserializacji
//    public String getAdaTitle() {
//        return title;
//    }

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
