package com.example.dslibrarysystem.domain;

import javax.annotation.Resource;

public class BookInfo {

    private String bookName;
    private String ISBN;
    private String author;
    private String publishYear;
    private double price;

    public String getBookName() {
        return bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
