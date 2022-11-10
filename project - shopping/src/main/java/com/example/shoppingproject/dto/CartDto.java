package com.example.shoppingproject.dto;

import com.example.shoppingproject.entity.Cart;

public class CartDto {
    private long cartId;

    private String customerName;

    private double totalAmount;

    public enum status{
        YENI,
        BITMIS
    }

    private Cart.status cartStatus = Cart.status.YENI;


    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Cart.status getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(Cart.status cartStatus) {
        this.cartStatus = cartStatus;
    }

}
