package com.kshitijpatil.tusk.data.model;

import java.util.Date;
import java.util.List;

public class Order implements Comparable<Order> {
    String firstName;
    String lastName;
    List<Product> productList;
    Date orderDate;

    public Order(String firstName, String lastName, List<Product> productList, Date orderDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productList = productList;
        this.orderDate = orderDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public int compareTo(Order o) {
        return this.orderDate.compareTo(o.orderDate);
    }
}
