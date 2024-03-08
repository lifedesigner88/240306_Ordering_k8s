package com.example.ordering.item.controller;

import com.example.ordering.item.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MsaTestController {

    private final RestTemplate restTemplate;
    private final String MEMBER_API = "http://sejong-member-service/";


    @Autowired
    public MsaTestController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("test/findmember")
    public MemberDto findmember(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");
        System.out.println("token: " + token);


        String url = MEMBER_API + "member/myInfo";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, MemberDto.class).getBody();
    }

}
