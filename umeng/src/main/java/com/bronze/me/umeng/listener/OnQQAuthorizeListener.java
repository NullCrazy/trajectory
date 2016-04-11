package com.bronze.me.umeng.listener;


/**
 * Created by Chris Kyle on 2016/2/23.
 * <p>
 * Description :
 */
public interface OnQQAuthorizeListener {

    void onQQAuthorizeSuccess();

    void onQQAuthorizeCancel();

    void onQQAuthorizeError();
}
