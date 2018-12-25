package com.example.dslibrarysystem;

import com.example.dslibrarysystem.dao.RedisBookService;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/*
Use this to publish an initial database in Redis,
 will be removed when docker is configured
 */
public class RedisPublisher {
    public static void main(String[] args) {

        // Publish the data into the database
        // Create a connection to the database
        RedisBookService rbs = new RedisBookService();
        Jedis jedis = rbs.publishConnection();

        // First book
        Map<String, String> booksInfo1 = new HashMap();
        booksInfo1.put("ISBN", "000816469X");
        booksInfo1.put("Author", "David Williams");
        booksInfo1.put("PublishYear", "2018");
        booksInfo1.put("Price", "6.0");
        jedis.hmset("The Ice Monster", booksInfo1);

        // Second book
        Map<String, String> booksInfo2 = new HashMap();
        booksInfo2.put("ISBN", "1408711702");
        booksInfo2.put("Author", "J.K. Rowling");
        booksInfo2.put("PublishYear", "2018");
        booksInfo2.put("Price", "8.0");
        jedis.hmset("Fantastic Beasts: The Crimes of Grindelwald", booksInfo2);

        // Third book
        Map<String, String> booksInfo3 = new HashMap();
        booksInfo3.put("ISBN", "0241321980");
        booksInfo3.put("Author", "Jeff Kinney");
        booksInfo3.put("PublishYear", "2017");
        booksInfo3.put("Price", "5.0");
        jedis.hmset("Diary of a Wimpy Kid: The Meltdown", booksInfo3);

    }
}
