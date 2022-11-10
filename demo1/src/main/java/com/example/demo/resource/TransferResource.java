package com.example.demo.resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferResource {

    @GetMapping("/transfer/header")
    public ResponseEntity<?> getHeader(
            @RequestHeader(value = "input", defaultValue = "Bos") String input){

        String output = "Giren: " + input;
        System.out.println("Cikti> " + output);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/transfer/setheader")
    public ResponseEntity<?> setHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("input", "input degeri");
        return ResponseEntity.ok().headers(headers).body("Baslik Gonderildi");
    }
}
