package com.example.http.controllers;

import com.example.http.dto.ProductInfo;
import com.example.http.dto.request.CreateProductRequest;
import com.example.http.dto.response.ProductResponse;
import com.example.http.exception.CustomException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HttpController {
    @PostMapping("/product")
    public ProductResponse getProductWithId(@RequestBody CreateProductRequest productRequest) {
        return new ProductResponse(productRequest.getPrice(),
                new ProductInfo(123, productRequest.getInfo().getDate()));
    }

    @GetMapping("/headers")
    public String listAllHeaders(Model model, @RequestHeader HttpHeaders headers) {
        model.addAttribute("headers", headers);
        return "headers";
    }

    @GetMapping("/exception")
    public String requestWithException() throws CustomException {
        throw new CustomException("Error: my custom exception");
    }
}
