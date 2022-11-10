package com.example.inventoryproject.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String productName;

    private double salesPrice;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
