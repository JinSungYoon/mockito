package com.example.mockito.test_doubles.spy;

import java.util.Collection;

public class BookRepositorySpy implements BookRepository{

    int saveCalled = 0;
    Book lastedAddedBook = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lastedAddedBook = book;

    }

    public int timesCalled(){
        return saveCalled;
    }

    public boolean calledWith(Book book){
        return lastedAddedBook.equals(book);
    }

}
