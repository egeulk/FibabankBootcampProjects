package com.example.commerce.Dto;

import com.example.commerce.Entity.Cart;

public class CardProductDto {
    private long cartProductId;
    private Cart cart;

    private long productId;

    private long salesQuantity;

    private double salesPrice;

    private double lineAmount;

    public CardProductDto(Cart cart, long productId, long salesQuantity, double salesPrice) {
        this.cart = cart;
        this.productId = productId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
        updateLineAmount();
    }

    private void updateLineAmount(){
        lineAmount = salesQuantity * salesPrice;
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

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }
}
