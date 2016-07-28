package com.carlosmuvi.carrental.base;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public abstract class BasePresenter<V extends BaseView> {

    private V view;

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }


}
