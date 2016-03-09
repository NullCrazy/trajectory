package com.bronze.me.module.home;

import android.os.Bundle;
import android.util.Log;

import com.bronze.me.R;
import com.bronze.me.module.MvpBaseActivity;

public class HomeActivity extends MvpBaseActivity<HomePresenter> implements HomeView {
    private static final String TAG = "HomeActivity";
    private HomeComponent homeComponent;

    @Override
    protected HomePresenter createPresenter() {
        return homeComponent.getHomePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String s = presenter.getHello();
        Log.i(TAG, s);
    }

    @Override
    public void initializeInjector() {
        homeComponent = DaggerHomeComponent.builder()
                .appComponent(getAppComponent())
                .activityMoudel(getActivityMoudel())
                .homeModule(new HomeModule())
                .build();
        homeComponent.inject(this);
    }
}
