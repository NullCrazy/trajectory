package com.bronze.me.umeng;

import com.bronze.me.umeng.listener.OnQQAuthorizeListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by lxg on 2016/4/10.
 */
public class QQOauth extends UmShare {
    private OnQQAuthorizeListener qqAuthorizeListener;

    public QQOauth() {
        this.platform = SHARE_MEDIA.QQ;
    }

    public QQOauth addQQAuthorizeListener(OnQQAuthorizeListener qqAuthorizeListener) {
        this.qqAuthorizeListener = qqAuthorizeListener;
        return this;
    }

    @Override
    protected void onOauthSuccess(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        qqAuthorizeListener.onQQAuthorizeSuccess();
    }

    @Override
    protected void onOauthError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        qqAuthorizeListener.onQQAuthorizeError();
    }

    @Override
    protected void onOauthCancel(SHARE_MEDIA share_media, int i) {
        qqAuthorizeListener.onQQAuthorizeCancel();
    }
}
