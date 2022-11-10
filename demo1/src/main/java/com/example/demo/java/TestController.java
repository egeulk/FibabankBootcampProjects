package com.example.demo.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class TestController {

    @GetMapping("message")
    @ResponseBody
    public String getMessage(){
        return "MVC message";
    }
}
