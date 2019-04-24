package com.kshitijpatil.tusk.ui.productdetail;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.data.Repository;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.BasePresenter;

public class ProductDetailsPresenter<V extends ProductDetailsContract.View> extends BasePresenter<V> implements ProductDetailsContract.Presenter<V> {
    Repository repository;

    ProductDetailsPresenter() {
        repository = Injector.provideRepository();
    }

    Product getProduct(int index) {
        return repository.getProductById(index);
    }

    @Override
    public void addToCart(Product product) {

    }

    @Override
    public void processBuy(Product product) {

    }
}
