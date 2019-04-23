package com.kshitijpatil.tusk.ui.base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V view;

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    public V getView() {
        return view;
    }
}
