package com.kshitijpatil.tusk.ui.cart;

import androidx.databinding.ObservableLong;

import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.MvpPresenter;
import com.kshitijpatil.tusk.ui.base.MvpView;

import java.util.List;

public interface CartContract {

    interface Presenter<V extends View> extends MvpPresenter<V> {
        List<Product> getCartItems();

        void removeCartItem(Product product);

        void setItemQuantity(Product product, int quantity);

        ObservableLong getTotal();
    }

    interface View extends MvpView {
        void navigateBuy(android.view.View view);
    }
}
