package com.example.db.books.dto;

public class BookDTO {
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }
//metoda get domyślnie jest niezbędna jackson do deserializacji
//    public String getAdaTitle() {
//        return title;
//    }

    public BookDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
