package com.kshitijpatil.tusk.ui.productdetail;


import androidx.databinding.ObservableBoolean;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.data.Repository;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.BasePresenter;

public class ProductDetailsPresenter<V extends ProductDetailsContract.View> extends BasePresenter<V> implements ProductDetailsContract.Presenter<V> {
    private Repository repository;
    private ObservableBoolean isExisting;

    ProductDetailsPresenter(int index) {
        repository = Injector.provideRepository();
        isExisting = new ObservableBoolean(false);
        isExisting.set(repository.isExisting(getProduct(index)));
    }

    Product getProduct(int index) {
        return repository.getProductById(index);
    }

    @Override
    public void addToCart(Product product) {
        boolean existing = repository.isExisting(product);
        if (!existing) {
            repository.saveToCart(product);
            isExisting.set(true);
        }
        getView().onAddedToCart(existing);
    }

    @Override
    public int getCartItemCount() {
        return repository.getCartItemCount();
    }


    @Override
    public ObservableBoolean getIsExisting() {
        return isExisting;
    }
}
