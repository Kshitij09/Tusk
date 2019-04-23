package com.kshitijpatil.tusk.ui.listproducts;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.ui.base.BasePresenter;
import com.kshitijpatil.tusk.ui.data.Repository;
import com.kshitijpatil.tusk.ui.data.model.Product;

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
