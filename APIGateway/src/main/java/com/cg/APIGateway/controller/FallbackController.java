package com.cg.APIGateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/productFallback")
    public ResponseEntity<String> productFallback()
    {
        return new ResponseEntity<String>("Product Service is not available, pls try after some time", HttpStatus.NOT_FOUND);
    }
}
