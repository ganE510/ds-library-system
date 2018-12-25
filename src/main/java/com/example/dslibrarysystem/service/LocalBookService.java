package com.example.dslibrarysystem.service;

import com.example.dslibrarysystem.dao.RedisBookService;
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
        for (String bookName : keys) {
            System.out.println("Book name is: " + bookName);
            List<String> isbn = jedis.hmget(bookName, "ISBN");
            System.out.println("Book isbn is: " + isbn.get(0));
            books.put(bookName, isbn.get(0));
        }
        return books;
    }
}
