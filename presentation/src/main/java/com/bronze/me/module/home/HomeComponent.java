package com.bronze.me.module.home;

import com.bronze.me.di.PerActivity;
import com.bronze.me.di.components.AppComponent;
import com.bronze.me.di.modules.ActivityMoudel;

import dagger.Component;

/**
 * Created by Administrator on 2016/2/26.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityMoudel.class, HomeModule.class})
public interface HomeComponent {
    void inject(HomeActivity homeActivity);

    HomePresenter getHomePresenter();
}
