package com.example.shoppingproject.entity;

import javax.persistence.*;

@Entity
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartProductId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private long productId;

    private long salesQuantity;

    private double salesPrice;

    private double lineAmount;

    public CartProduct(Cart cart, long productId, long salesQuantity, double salesPrice) {
        this.cart = cart;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        updateLineAmount();
    }

    private void updateLineAmount(){
        lineAmount = salesQuantity * salesPrice;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(long salesQuantity) {
        this.salesQuantity = salesQuantity;
        updateLineAmount();
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
        updateLineAmount();
    }
}
