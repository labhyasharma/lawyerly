package com.studiographene.lawyerly.basecode.di.modules;

import android.app.Application;


import com.studiographene.lawyerly.Dashboard.DashboardActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {

    private final Application mApplication;

    public MyModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DashboardActivity providesDashboard() {
        return new DashboardActivity();
    }


}
