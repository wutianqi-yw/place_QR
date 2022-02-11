package com.example.test2.Config;

import com.example.test2.POJO.Area;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.text.SimpleDateFormat;

@Configuration
public class MyBeans {

    @Bean("dateFormat")
    public SimpleDateFormat getSDF(){
        return new SimpleDateFormat("yyyy_MM_dd");
    }

    @Bean
    public RedisTemplate<String,Object> getDefaultRedisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setConnectionFactory(factory);
        //key序列化方式
        template.setKeySerializer(redisSerializer);
        //value序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //value hashmap序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.setEnableTransactionSupport(true);
        return template;
    }

    @Bean("myArea")
    public Area area(){

        Area a1 = Area.builder().id(16L).area_level(1).father(null).risk_level(1).children(null).name("a1").build();
        Area a2 = Area.builder().id(17L).area_level(2).father(a1).risk_level(1).children(null).name("a2").build();
        Area a3 = Area.builder().id(18L).area_level(3).father(a1).risk_level(1).children(null).name("a3").build();
        a1.setChildren(new Area[]{a2,a3});
        return a1;
    }

}
