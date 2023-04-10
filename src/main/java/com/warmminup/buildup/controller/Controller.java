package com.warmminup.buildup.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {
    @GetMapping("/api/backlog")
    public List<String> backlog(){
        return Arrays.asList("백로그1", "백로그1입니다", "예정" , "보류");
    }
}
