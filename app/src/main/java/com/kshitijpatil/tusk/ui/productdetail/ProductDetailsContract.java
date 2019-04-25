package com.kshitijpatil.tusk.ui.productdetail;

import androidx.databinding.ObservableBoolean;

import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.base.MvpPresenter;
import com.kshitijpatil.tusk.ui.base.MvpView;

public interface ProductDetailsContract {
    interface Presenter<V extends View> extends MvpPresenter<V> {
        void addToCart(Product product);
        boolean isItemAdded(Product product);
        int getCartItemCount();
        void processBuy(Product product);

        ObservableBoolean getIsExisting();
    }

    interface View extends MvpView {
        void onAddedToCart(boolean existing);

        void navigateToBuy();
    }
}
