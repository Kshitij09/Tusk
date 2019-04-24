package com.kshitijpatil.tusk.ui.productdetail;


import androidx.lifecycle.MutableLiveData;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.data.Repository;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.BasePresenter;

public class ProductDetailsPresenter<V extends ProductDetailsContract.View> extends BasePresenter<V> implements ProductDetailsContract.Presenter<V> {
    private Repository repository;
    private MutableLiveData<Boolean> isExisting;

    ProductDetailsPresenter(int index) {
        repository = Injector.provideRepository();
        isExisting = new MutableLiveData<>();
        isExisting.setValue(repository.isExisting(getProduct(index)));
    }

    Product getProduct(int index) {
        return repository.getProductById(index);
    }

    @Override
    public void addToCart(Product product) {
        boolean existing = repository.isExisting(product);
        if (!existing) {
            repository.saveToCart(product);
            isExisting.setValue(true);
        }
        getView().onAddedToCart(existing);
    }

    @Override
    public boolean isItemAdded(Product product) {
        return repository.isExisting(product);
    }

    @Override
    public int getCartItemCount() {
        return repository.getCartItemCount();
    }

    @Override
    public void processBuy(Product product) {

    }

    public MutableLiveData<Boolean> getIsExisting() {
        return isExisting;
    }
}
