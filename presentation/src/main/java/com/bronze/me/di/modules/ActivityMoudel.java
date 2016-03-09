package com.bronze.me.di.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lxg-pc on 2016/3/9.
 */
@Module
public class ActivityMoudel {
    private Activity activity;

    public ActivityMoudel(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Activity providesActivity() {
        return this.activity;
    }
}
