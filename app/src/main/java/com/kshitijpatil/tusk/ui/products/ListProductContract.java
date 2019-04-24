package com.kshitijpatil.tusk.ui.products;

import com.kshitijpatil.tusk.ui.base.MvpPresenter;
import com.kshitijpatil.tusk.ui.base.MvpView;

public interface ListProductContract {
    interface Presenter<V extends MvpView> extends MvpPresenter<V> {

    }

    interface View extends MvpView {

    }
}
