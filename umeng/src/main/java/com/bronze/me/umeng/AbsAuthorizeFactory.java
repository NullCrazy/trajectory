package com.bronze.me.umeng;

/**
 * Created by lxg on 2016/4/13.
 */
public abstract class AbsAuthorizeFactory {
    public abstract <T extends UmShare> T createOauthFactort(Class<T> clazz);
}
