package com.example.db.books.repository;

import com.example.db.books.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class BookRepositoryImpl implements BookCustomRepository {

    private BookJpaRepository bookJpaRepository;

    public BookRepositoryImpl(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    @Transactional
    public Book saveBook(Book book) throws Exception {
        var savedBook = bookJpaRepository.save(book);
        if(savedBook.getTitle() == "Kek"){
            throw new RuntimeException();
        }
        return savedBook;
    }
}
