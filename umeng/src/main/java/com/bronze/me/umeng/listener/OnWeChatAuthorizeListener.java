package com.bronze.me.umeng.listener;


/**
 * Created by Chris Kyle on 2016/2/23.
 * <p>
 * Description :
 */
public interface OnWeChatAuthorizeListener {

    void onWeChatAuthorizeSuccess();

    void onWeChatAuthorizeCancel();

    void onWeChatAuthorizeError();
}
