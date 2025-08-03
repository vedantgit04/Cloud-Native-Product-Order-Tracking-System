package com.example.ProductService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //
@RequestMapping("/say")
public class SampleController {

    @GetMapping("/hello/{name}/{city}")
    String sayhello(@PathVariable("name") String name,@PathVariable("city") String city){
        return "Hello " + name + " " +city;
    }

}
