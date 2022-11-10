package com.example.demo.data.repository;


import com.example.demo.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    //dogru fieldleri yazarsan kendisi yaziveriyor
    @Query("select p from Product as p where p.salesPrice>= :minPrice")
    List<Product> findAllBySalesPriceMin(@Param("minPrice") double minPrice);
}
