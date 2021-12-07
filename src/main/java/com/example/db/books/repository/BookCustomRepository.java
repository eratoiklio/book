package com.example.db.books.repository;


import com.example.db.books.entity.Book;

public interface BookCustomRepository {
    Book saveBook(Book book) throws Exception;
}
