package com.bronze.me.di.modules;

import android.app.Application;
import android.content.Context;

import com.bronze.me.data.repository.cache.PreferencesHelper;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

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
    @Singleton
    public Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    public Picasso providesPicasso(Context context) {
        return Picasso.with(context);
    }

    @Provides
    @Singleton
    public PreferencesHelper providesSharedPreferences(PreferencesHelper spfUtils) {
        return spfUtils;
    }
}
