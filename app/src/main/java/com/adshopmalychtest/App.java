package com.adshopmalychtest;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.adshopmalychtest.di.AppComponent;
import com.adshopmalychtest.di.DaggerAppComponent;;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class App extends Application {

    private static App mInstance;
    protected static AppComponent appComponent;
    private RefWatcher refWatcher;

    public static AppComponent getComponent() {
        return appComponent;
    }


    protected void initComponent() {
        appComponent = DaggerAppComponent.
                builder()
                .build();
        appComponent.inject(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        mInstance = this;
        initComponent();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    public static RefWatcher getRefWatcher(Context context) {
        App application = (App) context.getApplicationContext();
        return application.refWatcher;
    }




}
