package com.example.demo.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dongao on 2017/12/26.
 */
@RestController("/api")
public class ApiController {

    @GetMapping("/test")
    public String test(){
        return    "aaaaaa";
    }
}
