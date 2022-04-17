package com.example.http.dto.request;

import com.example.http.dto.ProductInfo;
import lombok.Value;

@Value
public class CreateProductRequest {
    private final float price;
    private final ProductInfo info;
}
