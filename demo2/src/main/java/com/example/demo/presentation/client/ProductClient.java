package com.example.demo.presentation.client;

import com.example.demo.business.dto.ProductDto;
import com.example.demo.data.entity.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductClient {

    @GetMapping("/product/get")
    @ResponseBody
    public String getProduct(){
        long productId=301;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/product/" + productId;
        ProductDto product1 =  restTemplate.getForObject(url, ProductDto.class);
        System.out.println(product1.getProductName());
        return "edinme basarili";
    }

    @GetMapping("/product/post")
    @ResponseBody
    public String postProduct(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/product";
        ProductDto product = new ProductDto(0, "Fritoz", 540);
        Product result =  restTemplate.postForObject(url, product, Product.class);
        return "yollama basarili" + result.getProductId();
    }

    @GetMapping("/product/put")
    @ResponseBody
    public String putProduct(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/product";
        ProductDto product = new ProductDto(302, "Tablet Bilgisayar", 5404);
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<ProductDto>(product), Void.class);
        return "koyma basarili";
    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct(){
        long productId=303;
        String url = "http://localhost:8080/api/product" + productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "silme basarili";
    }

}
