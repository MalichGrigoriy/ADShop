package com.adshopmalychtest.di;

import com.adshopmalychtest.App;
import com.adshopmalychtest.view.fragment.MainPageFragment;
import com.adshopmalychtest.viewmodel.MainPageVO;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ViewModule.class, ModelModule.class})

public interface AppComponent {

    void inject(MainPageFragment mainPageFragment);

    void inject(App app);

    void inject(MainPageVO mainPageVO);
}
