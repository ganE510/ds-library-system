package com.example.dslibrarysystem.dao;

import redis.clients.jedis.Jedis;

public class RedisBookService {
    public Jedis publishConnection() {
        //TODO: Need to change this line because ip address is not solid every time
        // Create the connection
        return new Jedis("172.18.0.2");
    }

}
