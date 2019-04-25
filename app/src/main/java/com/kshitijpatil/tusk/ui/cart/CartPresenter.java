package com.kshitijpatil.tusk.ui.cart;

import androidx.databinding.ObservableLong;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.data.Repository;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.BasePresenter;

import java.util.List;

public class CartPresenter<V extends CartContract.View> extends BasePresenter<V> implements CartContract.Presenter<V> {
    private Repository repository;
    private ObservableLong total;

    CartPresenter() {
        repository = Injector.provideRepository();
        total = new ObservableLong();
        calculateTotal();
    }

    @Override
    public List<Product> getCartItems() {
        return repository.getCart();
    }

    @Override
    public void removeCartItem(Product product) {
        repository.removeCartItem(product);
        calculateTotal();
    }

    @Override
    public ObservableLong getTotal() {
        return total;
    }

    private void calculateTotal() {
        List<Product> products = repository.getCart();
        long sum = 0;
        for (Product product : products) {
            sum += (product.getPrice() * product.getQuantity());
        }
        total.set(sum);
    }

    @Override
    public void setItemQuantity(Product product, int quantity) {
        repository.setItemQuantity(product, quantity);
        calculateTotal();
    }
}
