package com.xzy.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
public class JedisDemoController {
    private final Jedis jedis;

    public JedisDemoController() {
        jedis = new Jedis("127.0.0.1", 6379);
    }

    @GetMapping("/jedis")
    public String getData() {
        return jedis.get("redis");
    }
}