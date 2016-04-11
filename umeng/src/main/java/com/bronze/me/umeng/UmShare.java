package com.bronze.me.umeng;

import android.app.Activity;
import android.content.Intent;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by lxg on 2016/4/10.
 */
public abstract class UmShare implements Authorize {
    protected UMShareAPI umShareAPI;
    protected SHARE_MEDIA platform;


    @Override
    public void verify(Activity activity) {
        if (umShareAPI == null) {
            umShareAPI = UMShareAPI.get(activity);
        }
        umShareAPI.doOauthVerify(activity, platform, umAuthListener);
    }

    @Override
    public void authorizeCallBack(int requestCode, int resultCode, Intent data) {
        if (umShareAPI != null) {
            umShareAPI.onActivityResult(requestCode, resultCode, data);
        }
    }

    protected abstract void onOauthSuccess(SHARE_MEDIA share_media, int i, Map<String, String> map);

    protected abstract void onOauthError(SHARE_MEDIA share_media, int i, Throwable throwable);

    protected abstract void onOauthCancel(SHARE_MEDIA share_media, int i);

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            onOauthSuccess(share_media, i, map);
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            onOauthError(share_media, i, throwable);
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            onOauthCancel(share_media, i);
        }
    };

}
