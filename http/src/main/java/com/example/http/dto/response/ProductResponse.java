package com.example.http.dto.response;

import com.example.http.dto.ProductInfo;
import lombok.Value;

@Value
public class ProductResponse {
    private final float price;
    private final ProductInfo info;
}
