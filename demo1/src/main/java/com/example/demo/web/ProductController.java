package com.example.demo.web;

import com.example.demo.java.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//rest olmadiginda response body
@Controller
public class ProductController {

    @GetMapping("/product/get")
    @ResponseBody
    public String getProduct(){
        long productId=301;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/product/" + productId;
        Product product1 =  restTemplate.getForObject(url, Product.class);
        System.out.println(product1.getProductName());
        return "edinme basarili";
    }

    @GetMapping("/product/post")
    @ResponseBody
    public String postProduct(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/product";
        Product product = new Product(0, "Fritoz", 540);
        Product result =  restTemplate.postForObject(url, product, Product.class);
        return "yollama basarili" + result.getProductId();
    }

    @GetMapping("/product/put")
    @ResponseBody
    public String putProduct(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/product";
        Product product = new Product(302, "Tablet Bilgisayar", 5404);
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Product>(product), Void.class);
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


//empliyee emplpoyeeid employeename monthlysalary

//rest  ~Product CRUD - yazma okuma

//porduct get post put filan
//api ile

//customer id name totaldebit
//servletcontext

//transfer header cookie gostercek
//api ile de altiini yap
//once aynisini sonra akici olma

//extralari cok ezbere lamyacaksin