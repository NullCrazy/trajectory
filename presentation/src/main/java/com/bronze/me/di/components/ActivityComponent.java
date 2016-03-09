package com.bronze.me.di.components;

import android.app.Activity;

import com.bronze.me.di.PerActivity;
import com.bronze.me.di.modules.ActivityMoudel;

import dagger.Component;

/**
 * Created by lxg-pc on 2016/3/9.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityMoudel.class)
public interface ActivityComponent {
    Activity activity();
}
