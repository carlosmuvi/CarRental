package com.carlosmuvi.carrental.base;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public abstract class BasePresenter {

    private BaseView view;

    public BaseView getView() {
        return view;
    }

    public void setView(BaseView view) {
        this.view = view;
    }
}
