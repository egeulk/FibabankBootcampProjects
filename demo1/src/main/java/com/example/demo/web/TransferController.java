package com.example.demo.web;

import com.example.demo.java.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TransferController {
    @GetMapping("/client/header")
    @ResponseBody
    public String getHeader(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/transfer/header";
        HttpHeaders header = new HttpHeaders();
        header.add("input" , "input degeri");
        HttpEntity<String> entity = new HttpEntity<>("Govde", header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return "Baslik Gonderildi " + response.getBody();
    }

    @GetMapping("/client/setheader")
    @ResponseBody
    public String setHeader(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/transfer/setheader";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("Govde");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        return "Baslik Gonderildi " + response.getHeaders().getFirst("input");
    }


}
