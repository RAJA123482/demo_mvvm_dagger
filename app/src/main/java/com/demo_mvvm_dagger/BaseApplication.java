package com.demo_mvvm_dagger;

import android.app.Application;

import com.demo_mvvm_dagger.component.AppComponent;
import com.demo_mvvm_dagger.component.DaggerAppComponent;

public class BaseApplication extends Application {

    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
