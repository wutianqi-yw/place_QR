package com.example.test2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.support.collections.RedisCollectionFactoryBean;
import org.springframework.data.redis.support.collections.RedisStore;

import javax.annotation.Resource;

@SpringBootTest
class Test2ApplicationTests {

    @Resource(name = "defaultRedisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        System.out.println(stringSerializer.getClass());

        redisTemplate.opsForValue().set("maxValue",Long.MAX_VALUE-2);
        redisTemplate.opsForValue().increment("maxValue");
        Object abc1 = redisTemplate.opsForValue().get("maxValue");
        System.out.println(abc1);
        System.out.println(abc1.getClass());
    }

}
