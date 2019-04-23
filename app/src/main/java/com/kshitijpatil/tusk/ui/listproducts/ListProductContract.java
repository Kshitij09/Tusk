package com.kshitijpatil.tusk.ui.listproducts;

import com.kshitijpatil.tusk.ui.base.MvpPresenter;
import com.kshitijpatil.tusk.ui.base.MvpView;

public interface ListProductContract {
    interface Presenter<V extends MvpView> extends MvpPresenter<V> {

    }

    interface View extends MvpView {

    }
}
