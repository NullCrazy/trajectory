package com.bronze.me.module;

import android.app.Application;

import com.bronze.me.di.components.AppComponent;
import com.bronze.me.di.components.DaggerAppComponent;
import com.bronze.me.di.modules.AppMoudel;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by Administrator on 2016/2/26.
 */
public class TrajectoryApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        initShare();
    }

    private void initShare() {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        //微信 appid appsecret
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        //新浪微博 appkey appsecret
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        // QQ和Qzone appid appkey
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appMoudel(new AppMoudel(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
