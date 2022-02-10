package com.example.test2.Mapper.Primary;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.RedisCollectionFactoryBean;

public class RedisMapper {


    private RedisTemplate redisTemplate;

    public void test(){
        RedisCollectionFactoryBean redisCollectionFactoryBean = new RedisCollectionFactoryBean();
    }
}
