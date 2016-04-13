package com.bronze.me.di.components;

import android.content.Context;

import com.bronze.me.data.repository.cache.PreferencesHelper;
import com.bronze.me.di.modules.AppMoudel;
import com.bronze.me.module.TrajectoryApplication;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016/2/26.
 */
@Singleton
@Component(modules = AppMoudel.class)
public interface AppComponent {
    void inject(TrajectoryApplication application);

    PreferencesHelper getPreferencesHelper();

    Context context();
}
