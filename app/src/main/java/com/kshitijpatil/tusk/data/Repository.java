package com.kshitijpatil.tusk.data;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.data.model.Order;
import com.kshitijpatil.tusk.data.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Repository {
    private static Repository repository = null;
    private List<Product> products;
    private List<Product> cartProducts;
    private TreeSet<Order> orders;

    public Repository() {
        products = Arrays.asList(new Product("Amazon Echo - Smart speaker with Alexa | Powered by Dolby – Black", 7999, "Amazon Echo is a hands-free smart speaker that you control using your voice. It connects to Alexa – a cloud based voice service to play music, make calls, check weather and news, set alarms, control smart home devices, and much more.", 4.7f, R.drawable.pr_echo),
                new Product("Daniel Wellington Classic Petite Durham Black 28mm ", 9299, "Daniel Wellington is a Swedish Watch Brand founded in 2011. A testament to minimalist Scandinavian design and with precision and accuracy of Japanese movement, Daniel Wellington timepieces will appeal to almost everyone with a taste for classic and timeless design.", 4.4f, R.drawable.pr_danial_watch),
                new Product("Seagate 2TB Backup Plus Slim (Black) USB 3.0 External Hard Drive", 5590, "Slim is an easy way to protect and share your digital life. Ready to go with up to 2 TB of storage space for your most important files, it also features a sleek and protective metal finish available in classic black, silver, red or blue. Choose your flavour and join the millions of satisfied customers with one of Seagate’s most popular and trusted portable drives.", 4.0f, R.drawable.pr_hdd));
        cartProducts = new ArrayList<>();
        orders = new TreeSet<>();
    }

    // Singleton design pattern
    public synchronized static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int index) {
        return products.get(index);
    }

    public void saveToCart(Product product) {
        cartProducts.add(product);
    }

    public List<Product> getCart() {
        return cartProducts;
    }

    public int getCartItemCount() {
        return cartProducts.size();
    }

    public boolean isExisting(Product product) {
        return cartProducts.contains(product);
    }

    public void removeCartItem(Product product) {
        cartProducts.remove(product);
    }

    public void setItemQuantity(Product product, int quantity) {
        int index = cartProducts.indexOf(product);
        cartProducts.set(index, cartProducts.get(index).setQuantity(quantity));
    }

    public void addOrder(Order order) {
        cartProducts.clear();
        orders.add(order);
    }
}
