package com.example.mockito.stubbing;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
        List<Book> newBooks = bookRepository.findNewBooks(days);
        // 500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450
        for(Book book : newBooks){
            int price = book.getPrice();
            int newPrice = price - (discountRate * price / 100);
            book.setPrice(newPrice);
        }

        return newBooks;

    }

    public int calculateTotalCost(List<String> bookIds){

        int total = 0;

        for(String bookId : bookIds){
            Book book = bookRepository.findBookByBookId(bookId);
            total = total + book.getPrice();
        }
        return total;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void addBook(BookRequest bookRequest){
        Book book = new Book();
        book.setPrice(bookRequest.getPrice());
        book.setTitle(bookRequest.getTitle());
        book.setPublished(bookRequest.getPublished());
        bookRepository.save(book);
    }

}
