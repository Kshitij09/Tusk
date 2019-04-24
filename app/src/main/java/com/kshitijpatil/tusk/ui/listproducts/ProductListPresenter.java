package com.kshitijpatil.tusk.ui.listproducts;

import com.kshitijpatil.tusk.Injector;
import com.kshitijpatil.tusk.data.Repository;
import com.kshitijpatil.tusk.ui.base.BasePresenter;

public class ProductListPresenter<V extends ListProductContract.View> extends BasePresenter<V> implements ListProductContract.Presenter<V> {
    private static final String TAG = "ProductListPresenter";
    Repository repository;

    public ProductListPresenter() {
        repository = Injector.provideRepository();
    }
}
