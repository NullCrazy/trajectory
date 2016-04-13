package com.bronze.me.umeng;

/**
 * Created by lxg on 2016/4/13.
 */
public class AuthorizeFactory extends AbsAuthorizeFactory {
    private static AuthorizeFactory factory;

    private AuthorizeFactory() {
    }

    public static AuthorizeFactory getInstance() {
        if (factory == null) {
            synchronized (AuthorizeFactory.class) {
                if (factory == null) {
                    factory = new AuthorizeFactory();
                }
            }
        }
        return factory;
    }

    @Override
    public <T extends UmShare> T createOauthFactort(Class<T> clazz) {
        UmShare umShare = null;
        try {
            umShare = (T) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) umShare;
    }
}
