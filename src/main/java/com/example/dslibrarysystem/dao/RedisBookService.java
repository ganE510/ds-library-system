package com.example.dslibrarysystem.dao;

import redis.clients.jedis.Jedis;

public class RedisBookService {
    public Jedis publishConnection() {
        // Create the connection
        return new Jedis("localhost");
    }

}
