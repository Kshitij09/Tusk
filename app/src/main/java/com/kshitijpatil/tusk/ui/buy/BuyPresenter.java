package com.kshitijpatil.tusk.ui.buy;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.data.Repository;
import com.kshitijpatil.tusk.data.model.Order;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.BasePresenter;

import java.util.Calendar;
import java.util.List;

public class BuyPresenter<V extends BuyContract.View> extends BasePresenter<V> implements BuyContract.Presenter<V> {
    private Repository repository;
    private String firstName = "John";
    private String lastName = "Doe";

    BuyPresenter() {
        repository = Injector.provideRepository();
    }

    @Override
    public List<Product> getCart() {
        return repository.getCart();
    }

    @Override
    public long getTotal() {
        List<Product> products = repository.getCart();
        long sum = 0;
        for (Product product : products) {
            sum += (product.getPrice() * product.getQuantity());
        }
        return sum;
    }

    @Override
    public void placeOrder() {
        repository.addOrder(new Order(firstName, lastName, repository.getCart(), Calendar.getInstance().getTime()));
    }
}
