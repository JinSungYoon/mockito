package com.example.mockito.stubbing;

import java.time.LocalDate;

public class BookRequest {

    private String title;
    private int price;

    private LocalDate published;

    public BookRequest(String title, int price, LocalDate published) {
        this.title = title;
        this.price = price;
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", published=" + published +
                '}';
    }


}
