package com.bronze.me.module.home;

import com.bronze.me.module.MvpPresenter;

/**
 * Created by lxg-pc on 2016/3/9.
 */
public interface HomePresenter extends MvpPresenter<HomeView> {
    String getHello();
}
