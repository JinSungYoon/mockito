package com.example.mockito.test_doubles.spy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

public class SpyTest {

    @Test
    public void demoSpy(){

        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("1234","Mockito in Action",250, LocalDate.now());
        Book book2 = new Book("1235","Mockito in Action",250, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(2,bookRepositorySpy.timesCalled());
        assertTrue(bookRepositorySpy.calledWith(book2));

    }

}
