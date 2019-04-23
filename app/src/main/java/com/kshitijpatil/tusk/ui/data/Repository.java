package com.kshitijpatil.tusk.ui.data;

import com.kshitijpatil.tusk.ui.data.model.Product;

import java.util.Arrays;
import java.util.List;

public class Repository {
    private static Repository repository = null;
    List<Product> products;

    public Repository() {
        products = Arrays.asList(new Product("Amazon Echo", 7999, "Amazon Echo is a hands-free speaker you control with your voice", 4.7f));
    }

    public synchronized static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public List<Product> getProducts() {
        return products;
    }
}
