package com.example.demo.presentation.mvc;

import com.example.demo.data.entity.Product;
import com.example.demo.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/inventory")
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/product/insert")
    @ResponseBody
    public String insertProduct(){
        Product product = new Product(0, "Cep telefonu", 1230);
        productRepository.save(product);
        return "Sokuldu " + product.getProductId();
    }

    @GetMapping("/product/find")
    @ResponseBody
    public String findProduct() {
        long productId=1;
        Optional optional = productRepository.findById(productId);
        if (optional.isPresent()){
            Product product =  (Product) optional.get();
            return "urun bulundu " + product.getProductName();
        }
        return "Urun bulunamadi";
    }

    @GetMapping("/product/list")
    @ResponseBody
    public String listProducts() {
        Iterable<Product> products = productRepository.findAll();
        int count=0;
        for(Product product : products){
            System.out.println(product.getProductId()+product.getProductName()+product.getSalesPrice());
            count++;
        }
        return "Urun sayisi " + count;
    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String delete(){
        long productId=4;
        productRepository.deleteById(productId);
        return "silindi";
    }

    @GetMapping("/product/expensive")
    @ResponseBody
    public String listExpensiveProducts(){
        double minPrice = 1200;
        Iterable<Product> products = productRepository.findAllBySalesPriceMin(minPrice);
        int count=0;
        for(Product product : products){
            System.out.println(product.getProductId()+product.getProductName()+product.getSalesPrice());
            count++;
        }
        return minPrice+ "dan pahali olanlar " + count  ;
    }

}
