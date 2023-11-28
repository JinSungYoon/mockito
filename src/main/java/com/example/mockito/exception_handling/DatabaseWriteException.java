package com.example.mockito.exception_handling;

public class DatabaseWriteException extends RuntimeException {
    public DatabaseWriteException(String s) {
        super(s);
    }
}
