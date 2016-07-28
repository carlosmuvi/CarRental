package com.carlosmuvi.carrental.base.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.carlosmuvi.carrental.base.BasePresenter;
import com.carlosmuvi.carrental.base.BaseView;
import com.carlosmuvi.carrental.base.application.AppComponent;
import com.carlosmuvi.carrental.base.application.BaseComponent;
import com.carlosmuvi.carrental.base.application.CarRentalApp;

/**
 * Created by carlosmuvi on 28/07/16.
 */

public abstract class BaseActivity<C extends BaseComponent, P extends BasePresenter, V extends BaseView>
    extends AppCompatActivity implements BaseView {

    protected P presenter;
    protected C component;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setupComponent();
        bindPresenter();
    }

    private void setupComponent() {
        this.component = buildComponent();
        bindComponent();
    }


    private void bindPresenter() {
        this.presenter = getPresenter();
        this.presenter.setView(getView());
    }

    /**
     * Presenter binder. Returned presenter instance will be used as current activity presentation bind.
     * @return
     */
    protected abstract P getPresenter();

    /**
     * DI component building. Returned component instance will be used as current activity DI component.
     * @return
     */
    protected abstract C buildComponent();

    /**
     * Activity - component binding method. inject component into activity when implementing this method.
     */
    protected abstract void bindComponent();

    /**
     * MVP View binding.
     * @return
     */
    protected abstract V getView();


    protected abstract @LayoutRes int getLayoutId();

    @Override public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public AppComponent getAppComponent() {
        return ((CarRentalApp) getApplication()).getComponent();
    }
}
