package com.bronze.me.module.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bronze.me.R;
import com.bronze.me.module.TrajectoryApplication;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity {
    private HomeComponent homeComponent;
    @Inject
    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initializeInjector();
        String s = presenter.getHello();
        System.out.println(s);
    }

    private void initializeInjector() {
        homeComponent = DaggerHomeComponent.builder()
                .appComponent(((TrajectoryApplication) getApplication()).getAppComponent())
                .homeModule(new HomeModule())
                .build();
        homeComponent.inject(this);

    }
}
