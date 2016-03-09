package com.bronze.me.module.home;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/2/26.
 */
@Module
public class HomeModule {
    @Provides
    public HomePresenter providesHome() {
        return new HomePresenterImpl();
    }
}
