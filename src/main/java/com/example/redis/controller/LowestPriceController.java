package com.example.redis.controller;

import com.example.redis.service.LowestPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequiredArgsConstructor
@RestController
public class LowestPriceController {

    private final LowestPriceService priceService;

    @GetMapping("/getZsetValue")
    public Set getZsetValue() {
        return priceService.getZsetValue("");
    }
}
