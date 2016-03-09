package com.bronze.me.module.home;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bronze.me.R;
import com.bronze.me.module.MvpBaseActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends MvpBaseActivity<HomePresenter> implements HomeView {
    private static final String TAG = "HomeActivity";
    @Bind(R.id.img_butter)
    ImageView imageView;

    @Inject
    Picasso picasso;
    private HomeComponent homeComponent;

    @Override
    protected HomePresenter createPresenter() {
        return homeComponent.getHomePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Log.i(TAG, presenter.getHello());
        picasso.load("http://cdn.duitang.com/uploads/item/201208/15/20120815193117_S2HVM.thumb.224_0.jpeg")
                .into(imageView);
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
