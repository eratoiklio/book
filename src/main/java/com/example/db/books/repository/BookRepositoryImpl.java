package com.example.db.books.repository;

import com.example.db.books.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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

    public List<Book> findAllBooks(){
       return bookJpaRepository.findAll();
    }

    public Optional<Book> findBookById(Long id){
        return bookJpaRepository.findById(id);
    }

    public void deleteBookById(Long id){

    }
}
