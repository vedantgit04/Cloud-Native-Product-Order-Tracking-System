package com.example.ProductService.Configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced  // when we are requesting the userservice from product service the productservice manages the load
    public RestTemplate GetRestTemplate(){
          return new RestTemplateBuilder().build();
    }
}
