package com.mega.it.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //JSON 반환하는 컨트롤러
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}