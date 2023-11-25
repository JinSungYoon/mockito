package com.example.mockito.test_doubles.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;


public class MockTest {

    @Test
    public void demoMockito(){

        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234","Mockito in Action",500, LocalDate.now());
        Book book2 = new Book("1235","Mockito in Action",400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        bookRepositoryMock.verify(book2,1);

    }

    @Test
    public void demoMockWithMockito(){

        BookRepository bookRepositoryMock = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234","Mockito in Action",500, LocalDate.now());
        Book book2 = new Book("1235","Mockito in Action",400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        Mockito.verify(bookRepositoryMock,Mockito.times(1)).save(book2);
        Mockito.verify(bookRepositoryMock,Mockito.times(0)).save(book1);

    }


}
