package com.example.redis.service;

import com.example.redis.dto.TestDto;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestDto getTestSvc(String id){
        TestDto tvo = new TestDto(id, id + "님, 안녕하세요~!");
        System.out.println("[id:" + id + "] Service 에서 연산을 수행합니다");
        return tvo;
    }


}
