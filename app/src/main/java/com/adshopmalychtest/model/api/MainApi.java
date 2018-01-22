package com.adshopmalychtest.model.api;

import com.adshopmalychtest.BuildConfig;
import com.adshopmalychtest.model.apiinterface.MainApiInterface;
import com.adshopmalychtest.model.dto.ParentItem;
import com.adshopmalychtest.model.util.ApiResponseInterceptor;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class MainApi implements MainApiInterface {


    private MainApiInterface getMainApiInterface() {

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG)
            clientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        clientBuilder.addInterceptor(new ApiResponseInterceptor());

        OkHttpClient client = clientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BuildConfig.serverUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                .build();

        return retrofit.create(MainApiInterface.class);
    }

    @Override
    public Observable<List<ParentItem>> getList() {
        return getMainApiInterface().getList();
    }
}
