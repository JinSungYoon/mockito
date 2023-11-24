package com.example.mockito.test_doubles.dummy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    // In memory database, HashMap or List
    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {

    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
