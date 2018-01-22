package com.adshopmalychtest.di;

import com.adshopmalychtest.model.api.ApiFacade;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class ModelModule {

    @Provides
    @Singleton
    ApiFacade provideApiFacade() {
        return new ApiFacade();
    }
}
