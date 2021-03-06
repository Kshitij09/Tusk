package com.kshitijpatil.tusk.ui.products;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.data.Repository;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.BasePresenter;

import java.util.List;

class ProductListPresenter<V extends ListProductContract.View> extends BasePresenter<V> implements ListProductContract.Presenter<V> {
    private Repository repository;


    ProductListPresenter() {
        repository = Injector.provideRepository();
    }

    @Override
    public List<Product> getProductList() {
        return repository.getProducts();
    }

}
