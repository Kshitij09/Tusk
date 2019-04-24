package com.kshitijpatil.tusk.ui.cart;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.data.Repository;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.BasePresenter;

import java.util.List;

public class CartPresenter<V extends CartContract.View> extends BasePresenter<V> implements CartContract.Presenter<V> {
    Repository repository;

    CartPresenter() {
        repository = Injector.provideRepository();
    }

    @Override
    public List<Product> getCartItems() {
        return repository.getCart();
    }
}
