package com.example.db.books.service;

import com.example.db.books.entity.Book;
import com.example.db.books.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepositoryImpl bookRepositoryImpl;

    public List<Book> saveBook(Book book) throws Exception {
        List<Book> books;
        try{
            bookRepositoryImpl.saveBook(book);
            books = bookRepositoryImpl.findAllBooks();
            } catch(Exception e) {
            throw e;
            }
        return books;
    }

    public List<Book> getBooksByIds(List<String> ids){
        return
    }
    public List<Book> findAllBooks() throws Exception {
        List<Book> books;
        try{
            books = bookRepositoryImpl.findAllBooks();
        } catch(Exception e) {
            throw e;
        }
       return books;
    }

    public Optional<Book> findBookById(Long id) throws Exception {
       Optional<Book> book;
        try{
            book = bookRepositoryImpl.findBookById(id);
        } catch(Exception e) {
            throw e;
        }
        return book;
    }
}
