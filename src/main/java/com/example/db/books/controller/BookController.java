package com.example.db.books.controller;

import com.example.db.books.dto.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// ta adnotacja mowi do springa zeby utworzł i zarządzał obiektem tej klasy. Klasa ta będzie przyjmowała, żadania http i domyślnie zwracała json.
@RestController
public class BookController {
    //towrzy hendler przyjmujący ządania http w tym wypadku za pomocą metody get
    @GetMapping(value="/books")
    //adnotacja requestParam informuje springa że będę przekazywała argumenty przez url, format urla to http://localhost:8080/books?ids=1&ids=2
    public List<Book> getBooks(@RequestParam( name = "id") List<Long> ids){
        return  getBooksByIds(ids);
      }

    private List<Book> getBooksByIds(List<Long> ids) {
        var books = Arrays.asList(new Book(1L, "Wladca pierścienie"), new Book(2L, "Straż, straż"), new Book(3L, "Matylda"));
        return books.stream().filter(book -> ids.contains(book.getId())).collect(Collectors.toList());
    }
}
