package com.ezreal.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {

    @RequestMapping(path = "/test",method = RequestMethod.GET)
    public String getHelloWord(){
        return "Hello Word!";
    }
}
