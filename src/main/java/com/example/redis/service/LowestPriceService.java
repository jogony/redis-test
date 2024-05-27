package com.example.redis.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LowestPriceService {

    public Set getZsetValue(String key) {
        Set myTempSet = new HashSet();
        return myTempSet;
    }
}
