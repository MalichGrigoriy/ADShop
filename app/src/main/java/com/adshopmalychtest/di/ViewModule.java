package com.adshopmalychtest.di;

import com.adshopmalychtest.viewmodel.MainPageVO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
class ViewModule {

    @Provides
    @Singleton
    MainPageVO provideMainageVO() {
        return new MainPageVO();
    }
}
