package com.adshopmalychtest.model.apiinterface;

import com.adshopmalychtest.model.dto.ParentItem;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface MainApiInterface {
    @GET("list")
    Observable<List<ParentItem>> getList();
}
