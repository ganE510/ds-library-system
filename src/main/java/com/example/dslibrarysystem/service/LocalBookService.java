package com.example.dslibrarysystem.service;

import com.example.dslibrarysystem.dao.RedisBookService;
import com.example.dslibrarysystem.domain.BookInfo;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.*;

@Service
public class LocalBookService {

    // Create a connection to the database
    RedisBookService rbs = new RedisBookService();
    Jedis jedis = rbs.publishConnection();

    /*
    This is used to get all the books info back
     */
    public Map getAllBooks() {
        Map<String, String> books = new HashMap();
        Set<String> keys = jedis.keys("*");
        System.out.println("Listing all the books in the database... ...");
        for (String bookName : keys) {
            System.out.println("Book name is: " + bookName);
            List<String> ISBNinDB = jedis.hmget(bookName, "ISBN");
            System.out.println("Book isbn is: " + ISBNinDB.get(0));
            books.put(bookName, ISBNinDB.get(0));
        }
        return books;
    }

    /*
    This is used to get a book info by using a isbn
     */
    public BookInfo getBookInfo(String isbn) {
        BookInfo bookInfo = new BookInfo();
        Set<String> keys = jedis.keys("*");
        for (String bookName : keys) {
            List<String> ISBNinDB = jedis.hmget(bookName, "ISBN", "Author", "PublishYear", "Price");
            if (ISBNinDB.get(0).equals(isbn)) {
                bookInfo.setISBN(ISBNinDB.get(0));
                bookInfo.setAuthor(ISBNinDB.get(1));
                bookInfo.setPublishYear(ISBNinDB.get(2));
                bookInfo.setPrice(Double.valueOf(ISBNinDB.get(3)));
                bookInfo.setBookName(bookName);
            }
        }
        return bookInfo;
    }
}
