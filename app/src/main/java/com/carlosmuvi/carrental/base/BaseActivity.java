package com.carlosmuvi.carrental.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public abstract class BaseActivity<P extends BasePresenter, V extends BaseView> extends AppCompatActivity {

    private P presenter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        bindPresenter();
    }

    private void bindPresenter() {
        this.presenter = getPresenter();
        this.presenter.setView(getView());
    }

    protected abstract P getPresenter();

    protected abstract V getView();

    protected abstract @LayoutRes int getLayoutId();
}
