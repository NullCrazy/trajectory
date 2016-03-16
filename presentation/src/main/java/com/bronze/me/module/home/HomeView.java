package com.bronze.me.module.home;

import android.content.pm.PackageInfo;

import com.bronze.me.module.MvpView;

/**
 * Created by lxg-pc on 2016/3/9.
 */
public interface HomeView extends MvpView {
    void setApplist(PackageInfo info);
}
