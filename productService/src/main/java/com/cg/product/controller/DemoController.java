package com.cg.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class DemoController {

    @GetMapping("/")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<String>("Hello from SpringBoot!", HttpStatus.OK);
    }
}
