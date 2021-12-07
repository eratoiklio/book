package com.example.db.books.controller;

import com.example.db.books.dto.BookDTO;
import com.example.db.books.entity.Book;
import com.example.db.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//RESTFull zakłada nie używanie czasownikó w path
// ta adnotacja mowi do springa zeby utworzł i zarządzał obiektem tej klasy. Klasa ta będzie przyjmowała, żadania http i domyślnie zwracała json.
@RestController
@RequestMapping(value="/books")
public class BookController {
    //towrzy hendler przyjmujący ządania http w tym wypadku za pomocą metody get
    @GetMapping()
    //adnotacja requestParam informuje springa że będę przekazywała argumenty przez url, format urla to http://localhost:8080/books?ids=1&ids=2
    public List<BookDTO> getBooks(@RequestParam( name = "id") List<Long> ids){
        return  getBooksByIds(ids);
      }

//    private List<BookDTO> getBooksByIds(List<Long> ids) {
//        var books = Arrays.asList(new BookDTO(1L, "Wladca pierścienie"), new BookDTO(2L, "Straż, straż"), new BookDTO(3L, "Matylda"));
//        return books.stream().filter(bookDTO -> ids.contains(bookDTO.getId())).collect(Collectors.toList());
//    }
    @Autowired
    BookService bookService;



    @RequestMapping(method = RequestMethod.POST)
    private List<Book> saveBooks(@RequestBody String title) throws Exception{
        List<Book> books = new LinkedList<Book>;
            try {
                books=  bookService.saveBook(new Book(title));
            }
            catch(Exception e){}
            return books;
    }
}
