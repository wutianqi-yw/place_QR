package com.example.test2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.RedisCollectionFactoryBean;
import org.springframework.data.redis.support.collections.RedisStore;

@SpringBootTest
class Test2ApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        RedisCollectionFactoryBean redisCollectionFactoryBean = new RedisCollectionFactoryBean();
        redisTemplate.opsForValue().set("abc","abc");
    }

}
