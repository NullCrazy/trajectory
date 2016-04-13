package com.bronze.me.module.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.bronze.me.R;
import com.bronze.me.absbase.MvpBaseActivity;
import com.bronze.me.data.repository.cache.PreferencesHelper;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends MvpBaseActivity<HomePresenter> implements HomeView {
    private final String TAG = this.getClass().getSimpleName();
    private HomeComponent homeComponent;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    PreferencesHelper preferencesHelper;

    @Override
    protected HomePresenter createPresenter() {
        return homeComponent.getHomePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
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
