package com.bronze.me.module.home;

import com.bronze.me.module.MvpBasePresenter;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/2/26.
 */
public class HomePresenterImpl extends MvpBasePresenter<HomeView> implements HomePresenter {

    @Inject
    public HomePresenterImpl() {
    }

    public String getHello() {
        return "Hello world";
    }
}
