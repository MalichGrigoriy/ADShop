package com.adshopmalychtest.model.api;

import android.widget.ListAdapter;

import com.adshopmalychtest.model.dto.ParentItem;

import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

public class ApiFacade {

    private MainApi mainApi;

    public ApiFacade() {
        mainApi = new MainApi();
    }

    public Observable<List<ParentItem>> getParentItemList() {
        return mainApi.getList()
                .subscribeOn(Schedulers.io());
    }

}
