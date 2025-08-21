package com.example.ProductService.Configs;


import com.example.ProductService.Models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
public class RedisTemplateConfig {
    @Bean
    public RedisTemplate<String, Object> CreateRedisTemplate(RedisConnectionFactory redisConnectionFactory){
           RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
           redisTemplate.setConnectionFactory((redisConnectionFactory));

           return redisTemplate;
    }
}
