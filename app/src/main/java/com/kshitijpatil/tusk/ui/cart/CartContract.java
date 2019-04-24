package com.kshitijpatil.tusk.ui.cart;

import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.MvpPresenter;
import com.kshitijpatil.tusk.ui.base.MvpView;

import java.util.List;

interface CartContract {
    interface Presenter<V extends View> extends MvpPresenter<V> {
        List<Product> getCartItems();
    }

    interface View extends MvpView {

    }
}
