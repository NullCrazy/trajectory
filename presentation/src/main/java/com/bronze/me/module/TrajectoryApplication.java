package com.bronze.me.module;

import android.app.Application;

import com.bronze.me.di.components.AppComponent;
import com.bronze.me.di.components.DaggerAppComponent;
import com.bronze.me.di.modules.AppMoudel;

/**
 * Created by Administrator on 2016/2/26.
 */
public class TrajectoryApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appMoudel(new AppMoudel(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
