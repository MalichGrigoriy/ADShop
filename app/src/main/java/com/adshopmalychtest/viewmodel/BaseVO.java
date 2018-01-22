package com.adshopmalychtest.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.adshopmalychtest.BR;
import com.adshopmalychtest.util.Log;

public class BaseVO extends BaseObservable {

    private boolean requestFailed;
    private boolean loading = false;

    @Bindable
    public boolean isLoading() {
        return loading;
    }

    void setLoading(boolean b) {
        Log.d("" + b);
        if (loading != b) {
            loading = b;
            notifyPropertyChanged(BR.loading);
        }
    }

    @Bindable
    public boolean isRequestFailed() {
        return requestFailed;
    }

    void setRequestFailed(boolean requestFailed) {
        Log.d();
        if (this.requestFailed != requestFailed) {
            this.requestFailed = requestFailed;
            notifyPropertyChanged(BR.requestFailed);
        }
    }

    public void retry(View view) {
        Log.d();
    }
}
