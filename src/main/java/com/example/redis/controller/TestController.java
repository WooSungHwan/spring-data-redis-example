package com.example.redis.controller;

import com.example.redis.dto.TestDto;
import com.example.redis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Cacheable(
            value = "TestDto",
            key = "#id",
            cacheManager = "cacheManager",
            unless = "#id == ''",
            condition = "#id.startsWith('test')"
    )
    @GetMapping("/getTest")
    public TestDto getData(@RequestParam String id) {
        return testService.getTestSvc(id);
    }
}
