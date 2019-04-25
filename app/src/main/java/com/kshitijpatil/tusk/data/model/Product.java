package com.kshitijpatil.tusk.data.model;

import androidx.annotation.DrawableRes;

public class Product {
    String name;
    long price;
    String description;
    float rating;
    int preview;
    int quantity;

    public Product() {
        // for firebase
    }

    public Product(String name, long price, String description, float rating, @DrawableRes int preview) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.rating = rating;
        this.preview = preview;
        quantity = 1;
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

    public int getPreview() {
        return preview;
    }

    public void setPreview(int preview) {
        this.preview = preview;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
