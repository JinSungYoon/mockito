package com.example.mockito.test_doubles.mock;

import com.example.mockito.test_doubles.mock.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryMock implements BookRepository{
    int saveCalled = 0;
    Book lastedAddedBook = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lastedAddedBook = book;

    }

    public void verify(Book book,int times){
        assertEquals(times,saveCalled);
        assertEquals(book,lastedAddedBook);
    }

}
