package com.example.test2.Config;

import com.example.test2.POJO.Area;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Configuration
public class MyBeans {

    /**
     *
     * 全局变量 SimpleDateFormat，用于对时间规格化。
     * 创建表时使用
     *
     * @return
     */
    @Bean("dateFormat")
    public SimpleDateFormat getSDF(){
        return new SimpleDateFormat("yyyy_MM_dd");
    }




    @Bean("defaultRedisTemplate")
    public RedisTemplate<String,Object> getDefaultRedisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        //反序列化时智能识别变量名（识别没有按驼峰格式命名的变量名）
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //反序列化识别对象类型
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        //反序列化如果有多的属性，不抛出异常
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //反序列化如果碰到不识别的枚举值，是否作为空值解释，true:不会抛不识别的异常, 会赋空值，false:会抛不识别的异常
        om.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);

        jackson2JsonRedisSerializer.setObjectMapper(om);


        //key序列化方式
        template.setKeySerializer(new StringRedisSerializer());
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
