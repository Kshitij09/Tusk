package com.kshitijpatil.tusk.ui.data.model;

public class Product {
    String name;
    long price;
    String description;
    float rating;

    public Product() {
        // for firebase
    }

    public Product(String name, long price, String description, float rating) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
