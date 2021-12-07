package com.example.db

import com.example.db.books.entity.Book
import com.example.db.books.repository.BookCustomRepository
import com.example.db.books.repository.BookJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
//ta adnotacja domyślnie pozwala wstrzykiwać tylko repozytoria
//@DataJpaTest


@SpringBootTest
class BookJpaRepositoryTest extends Specification {
    @Autowired
    private BookJpaRepository bookRepository
    @Autowired
    private BookCustomRepository bookCustomRepository

    def "czy zapisują się encje"(){
        given:
            def ksiazki = [new Book("Wyspa szczescia"), new Book("Stwórz sobie raj")]
        when:
            bookRepository.saveAll(ksiazki)
        then:
            bookRepository.findAll().size() == 2
    }

    def "test rollbacka"(){
        given:
            def book = new Book("Kek")
        when:
        try {
        bookCustomRepository.saveBook(book)
        } catch(Exception e){}
        then:
        bookRepository.findAll().size() == 1
    }

}
