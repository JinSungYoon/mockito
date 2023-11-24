package com.example.mockito.test_doubles.mock;

import com.example.mockito.test_doubles.mock.Book;
import com.example.mockito.test_doubles.mock.BookService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockTest {

    @Test
    public void demoSpy(){

        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234","Mockito in Action",500, LocalDate.now());
        Book book2 = new Book("1235","Mockito in Action",400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        bookRepositoryMock.verify(book2,1);

    }


}
