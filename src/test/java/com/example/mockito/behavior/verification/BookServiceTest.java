package com.example.mockito.behavior.verification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testAddBook(){
        Book book = new Book(null,"Mockito In Action",500, LocalDate.now());
        bookService.addBook(book);
//        doNothing().when(bookRepository).save(book);
        Mockito.verify(bookRepository).save(book);
    }

    @Test
    public void addBook(BookRequest bookRequest){
        Book book = new Book();
        book.setPrice(bookRequest.getPrice());
        book.setTitle(bookRequest.getTitle());
        book.setPublished(bookRequest.getPublished());
        bookRepository.save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice(){
        BookRequest bookRequest = new BookRequest("Mockito In Action",500,LocalDate.now());
        Book book = new Book(null,"Mockito In Action",500,LocalDate.now());

        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository,Mockito.times(0)).save(book);

    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice1(){
        BookRequest bookRequest = new BookRequest("Mockito In Action",600,LocalDate.now());
        Book book = new Book(null,"Mockito In Action",600,LocalDate.now());

        // bookRepository에서 아무런 동작도 하지 않도록 설정하는 코드(Mockito.doNothing())
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository,Mockito.times(2)).save(book);

    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice2(){
        BookRequest bookRequest = new BookRequest("Mockito In Action",500,LocalDate.now());
        Book book = new Book(null,"Mockito In Action",500,LocalDate.now());

        // bookRepository에서 아무런 동작도 하지 않도록 설정하는 코드(Mockito.doNothing())
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        Mockito.verify(bookRepository,Mockito.never()).save(book);

    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice3(){
        BookRequest bookRequest = new BookRequest("Mockito In Action",600,LocalDate.now());
        Book book = new Book(null,"Mockito In Action",600,LocalDate.now());

        // bookRepository에서 아무런 동작도 하지 않도록 설정하는 코드(Mockito.doNothing())
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        // Mockito.atLeast() : 최소한 몇번 호출 되는지
        Mockito.verify(bookRepository,Mockito.atLeast(2)).save(book);
        // Mockito.atMost() : 최대 몇번까지 호출 되는지
        Mockito.verify(bookRepository,Mockito.atMost(2)).save(book);
        // Mockito.atLeastOnce() : 특정 메서드가 최소 한 번 이상 호출되었는지를 확인하기 위해 사용
        Mockito.verify(bookRepository,Mockito.atLeastOnce()).save(book);
        // Mockito.atMostOnce() : 메서드가 최대 한 번까지만 호출되었어야 하는 경우에 유용합니다.
        Mockito.verify(bookRepository,Mockito.atMostOnce()).save(book);

    }

    @Test
    public void testUpdatePrice(){
        bookService.updatePrice(null,600);
        Mockito.verifyNoInteractions(bookRepository);
    }

    @Test
    public void testUpdatePrice1(){
        Book book = new Book("1234","Mockito In Action",500,LocalDate.now());
        Mockito.when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234",700);
        Mockito.verify(bookRepository).findBookById("1234");
        Mockito.verify(bookRepository).save(book);
        // verifyNoMoreInteractions : 다음에는 어떠한 상효작용(Method)이 없다는 의미
        Mockito.verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void testUpdatePrice2(){
        Book book = new Book("1234","Mockito In Action",500,LocalDate.now());
        Mockito.when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234",600);

        // Mockito.inOrder : 목 객체에 대한 순서를 검증하는 메소드로, 특정 메서드가 순서대로 이루어지는지 확인.
        InOrder inOrder = Mockito.inOrder(bookRepository);
        inOrder.verify(bookRepository).findBookById("1234");
        inOrder.verify(bookRepository).save(book);

    }
}
