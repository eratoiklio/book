package com.example.db.books.controller;

import com.example.db.books.dto.BookDTO;
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
    public List<BookDTO> getBooks(@RequestParam( name = "id") List<Long> ids){
        return  getBooksByIds(ids);
      }

    private List<BookDTO> getBooksByIds(List<Long> ids) {
        var books = Arrays.asList(new BookDTO(1L, "Wladca pierścienie"), new BookDTO(2L, "Straż, straż"), new BookDTO(3L, "Matylda"));
        return books.stream().filter(bookDTO -> ids.contains(bookDTO.getId())).collect(Collectors.toList());
    }
}
