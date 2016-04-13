package com.bronze.me.absbase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bronze.me.di.components.AppComponent;
import com.bronze.me.di.modules.ActivityMoudel;
import com.bronze.me.module.TrajectoryApplication;

/**
 * All activity must extend this activity.
 */
public abstract class MvpBaseActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {

    protected P presenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        presenter = createPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        presenter.attachView(this);
    }

    protected abstract void initializeInjector();

    protected AppComponent getAppComponent() {
        return ((TrajectoryApplication) getApplication()).getAppComponent();
    }

    protected ActivityMoudel getActivityMoudel() {
        return new ActivityMoudel(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }
}
