package com.example.redis.dto;

import lombok.Data;

import java.util.List;

@Data
public class Keyword {

    private String keyword; //유야용품 - 하기스 기저귀, A사 딸랑
    private List<ProductGrp> productGrpList;
}
