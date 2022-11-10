package com.example.demo.business.service;

import com.example.demo.business.dto.ProductDto;
import com.example.demo.data.entity.Product;
import com.example.demo.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public long create(ProductDto productDto) {
         Product product = new Product();
         product.setProductName(productDto.getProductName());
         product.setSalesPrice(productDto.getSalesPrice());
         productRepository.save(product);
         return product.getProductId();
    }

    @Override
    public void update(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        productRepository.save(product);
    }

    @Override
    public ProductDto find(long productId) {
        Optional optional = productRepository.findById(productId);
        if (optional.isPresent()){
            Product product =  (Product) optional.get();
            ProductDto productDto = new ProductDto();
            productDto.setProductName(product.getProductName());
            productDto.setSalesPrice(product.getSalesPrice());
            return productDto;
        }
        return null;
    }

    @Override
    public List<ProductDto> findAll() {
        Iterable<Product> products = productRepository.findAll();
        List<ProductDto> list = new ArrayList<ProductDto>();
        int count=0;
        for(Product product : products){
            ProductDto productDto = new ProductDto();
            productDto.setProductName(product.getProductName());
            productDto.setSalesPrice(product.getSalesPrice());
            list.add(productDto);
        }
        return list;
    }

    @Override
    public void delete(long productId) {
        productRepository.deleteById(productId);
    }

    private Product toEntity(ProductDto dto){
        return new Product(dto.getProductId(), dto.getProductName(), dto.getSalesPrice());
    }

    private ProductDto toDto(Product product){
        return new ProductDto(product.getProductId(), product.getProductName(), product.getSalesPrice());
    }




}
