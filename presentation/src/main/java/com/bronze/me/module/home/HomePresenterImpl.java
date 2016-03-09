package com.bronze.me.module.home;

import com.bronze.me.module.MvpBasePresenter;

/**
 * Created by Administrator on 2016/2/26.
 */
public class HomePresenterImpl extends MvpBasePresenter<HomeView> implements HomePresenter {
    public String getHello() {
        return "Hello world";
    }
}
