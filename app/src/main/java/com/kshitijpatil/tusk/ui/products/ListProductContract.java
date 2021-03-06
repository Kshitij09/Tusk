package com.kshitijpatil.tusk.ui.products;

import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.MvpPresenter;
import com.kshitijpatil.tusk.ui.base.MvpView;

import java.util.List;

public interface ListProductContract {
    interface Presenter<V extends View> extends MvpPresenter<V> {
        List<Product> getProductList();
    }

    interface View extends MvpView {

    }
}
