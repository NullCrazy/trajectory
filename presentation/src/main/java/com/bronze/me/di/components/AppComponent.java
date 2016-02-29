package com.bronze.me.di.components;

import com.bronze.me.di.modules.AppMoudel;
import com.bronze.me.module.TrajectoryApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016/2/26.
 */
@Singleton
@Component(modules = AppMoudel.class)
public interface AppComponent {
    void inject(TrajectoryApplication application);
}
