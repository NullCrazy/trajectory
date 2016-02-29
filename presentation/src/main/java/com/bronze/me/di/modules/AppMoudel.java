package com.bronze.me.di.modules;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/2/26.
 */
@Module
public class AppMoudel {
    private Application application;

    public AppMoudel(Application application) {
        this.application = application;
    }

    @Provides
    public Application providesApplication() {
        return application;
    }
}
