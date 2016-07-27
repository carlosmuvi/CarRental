package com.carlosmuvi.carrental.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    private P presenter;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        bindPresenter();
    }

    private void bindPresenter() {
        this.presenter = getPresenter();
    }

    protected abstract P getPresenter();

    protected abstract @LayoutRes int getLayoutId();
}
