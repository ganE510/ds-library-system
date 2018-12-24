package com.example.dslibrarysystem;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
Check these codes on: http://www.runoob.com/redis/redis-java.html
 */
public class RedisExamples {
    public static void main(String[] args) {

        // Connect the local service
        Jedis jedis = new Jedis("localhost");
        System.out.println("Successfully connect");
        // To check if the service is running
        System.out.println("check if the service is running: "+jedis.ping());

        // FIRST: SET & GET a pair of String values
        // Set a String data
        jedis.set("runoobkey", "www.runoob.com");
        // Get the data back
        System.out.println("Get back the String value: "+ jedis.get("runoobkey"));

        // SECOND: SET & GET a list value
        // Store list into the database
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // Get the list's values back
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for (String s : list) {
            System.out.println("Items are: " + s);
        }

        // THIRD: GET the keys' values
        // Get data and print
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println("Keys in the database are: " + key);
        }
    }
}
