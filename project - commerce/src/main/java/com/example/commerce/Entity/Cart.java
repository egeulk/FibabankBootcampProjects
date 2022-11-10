package com.example.commerce.Entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Cart {


    private long cartId;

    private String customerName;

    private double totalAmount;

    public enum status{
        YENI,
        BITMIS
    }

    private status cartStatus = status.YENI;

    @OneToMany(mappedBy = "cart")
    private List<CartProduct> orderList = new LinkedList<>();
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

    public status getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(status cartStatus) {
        this.cartStatus = cartStatus;
    }

    public List<CartProduct> getOrderList() {
        return orderList;
    }

    public void addOrder(CartProduct cartProduct) {
        orderList.add(cartProduct);
    }
}
