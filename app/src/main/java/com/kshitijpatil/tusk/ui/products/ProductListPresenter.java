package com.kshitijpatil.tusk.ui.products;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.data.Repository;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.BasePresenter;

import java.util.List;

public class ProductListPresenter<V extends ListProductContract.View> extends BasePresenter<V> implements ListProductContract.Presenter<V> {
    private static final String TAG = "ProductListPresenter";
    private Repository repository;


    public ProductListPresenter() {
        repository = Injector.provideRepository();
    }

    public List<Product> getProductList() {
        return repository.getProducts();
    }

}
