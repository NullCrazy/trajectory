package com.bronze.me.module.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.bronze.me.R;
import com.bronze.me.absbase.MvpBaseActivity;
import com.bronze.me.data.repository.cache.PreferencesHelper;
import com.squareup.picasso.Picasso;

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
    @Inject
    Picasso picasso;
    @Inject
    HomePresenter homePresenter;

    @Override
    protected HomePresenter createPresenter() {
        return homePresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        Log.i("TAG", preferencesHelper.toString());
        Log.i("TAG", picasso.toString());
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
