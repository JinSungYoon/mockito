package com.example.mockito.test_doubles.stub;

import com.example.mockito.test_doubles.stub.Book;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    void save(Book book);

    Collection<Book> findAll();

    List<Book> findNewBooks(int days);

}
