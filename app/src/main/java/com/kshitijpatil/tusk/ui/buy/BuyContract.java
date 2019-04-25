package com.kshitijpatil.tusk.ui.buy;

import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.MvpPresenter;
import com.kshitijpatil.tusk.ui.base.MvpView;

import java.util.List;

public interface BuyContract {

    interface Presenter<V extends View> extends MvpPresenter<V> {
        long getTotal();

        void placeOrder();

        List<Product> getCart();
    }

    interface View extends MvpView {

    }
}
