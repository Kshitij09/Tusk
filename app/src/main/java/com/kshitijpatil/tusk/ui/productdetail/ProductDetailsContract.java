package com.kshitijpatil.tusk.ui.productdetail;

import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.MvpPresenter;
import com.kshitijpatil.tusk.ui.base.MvpView;

public interface ProductDetailsContract {
    interface Presenter<V extends View> extends MvpPresenter<V> {
        void addToCart(Product product);

        void processBuy(Product product);
    }

    interface View extends MvpView {
        void navigateToCart();

        void navigateToBuy();
    }
}
