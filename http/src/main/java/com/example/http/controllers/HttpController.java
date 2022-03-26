package com.example.http.controllers;

import com.example.http.dto.Product;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class HttpController {
    @PostMapping("/product")
    public Product getProductWithId(@RequestBody Product product) {
        product.getInfo().setId(123);
        return product;
    }

    @GetMapping("/headers")
    public ArrayList<String> listAllHeaders(@RequestHeader Map headers) {
        var result = new ArrayList<String>();
        headers.forEach((key, value) -> {
            result.add(key.toString() + ": " + value.toString());
        });
        return result;
    }

    @GetMapping("/exception")
    public String requestWithException() {
        throw new RuntimeException();
    }
}
