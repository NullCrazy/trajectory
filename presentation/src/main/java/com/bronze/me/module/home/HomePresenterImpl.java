package com.bronze.me.module.home;


import android.app.Activity;

import com.bronze.me.absbase.MvpBasePresenter;
import com.bronze.me.umeng.AuthorizeFactory;
import com.bronze.me.umeng.QQOauth;
import com.bronze.me.umeng.listener.OnQQAuthorizeListener;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/2/26.
 */
public class HomePresenterImpl extends MvpBasePresenter<HomeView> implements HomePresenter {

    @Inject
    public HomePresenterImpl() {
    }

    @Override
    public void QQLogin() {
        AuthorizeFactory.getInstance().createOauthFactort(QQOauth.class)
                .addQQAuthorizeListener(onQQAuthorizeListener)
                .verify((Activity) getView());
    }

    private OnQQAuthorizeListener onQQAuthorizeListener = new OnQQAuthorizeListener() {
        @Override
        public void onQQAuthorizeSuccess() {

        }

        @Override
        public void onQQAuthorizeCancel() {

        }

        @Override
        public void onQQAuthorizeError() {

        }
    };
}
