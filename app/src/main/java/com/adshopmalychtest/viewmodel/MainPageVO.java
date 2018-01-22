package com.adshopmalychtest.viewmodel;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.adshopmalychtest.App;
import com.adshopmalychtest.BR;
import com.adshopmalychtest.model.api.ApiFacade;
import com.adshopmalychtest.model.dto.ParentItem;
import com.adshopmalychtest.util.Log;
import com.adshopmalychtest.view.adapter.ParenItemRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MainPageVO extends BaseVO {

    @Inject
    ApiFacade apiFacade;

    private ArrayList<ParentItem> parentItemArrayList = new ArrayList<>();

    private Subscription parentListSubscription;


    public MainPageVO() {
        App.getComponent().inject(this);
    }

    public void onCreate() {
        Log.d();
        getParentList();
    }

    private void getParentList() {
        if (parentItemArrayList.isEmpty() && (parentListSubscription == null || parentListSubscription.isUnsubscribed())) {
            Log.d();
            setLoading(true);
            setRequestFailed(false);
            parentListSubscription = apiFacade.getParentItemList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<ParentItem>>() {
                        @Override
                        public void onCompleted() {
                            Log.d();
                            setLoading(false);
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(e);
                            setLoading(false);
                            setRequestFailed(true);
                        }

                        @Override
                        public void onNext(List<ParentItem> parentList) {
                            Log.d();
                            setParentItemArrayList(parentList);
                        }
                    });
        }
    }

    @Bindable
    public ArrayList<ParentItem> getParentItemList() {
        Log.d();
        return parentItemArrayList;
    }

    private void setParentItemArrayList(List<ParentItem> parentItemArrayList) {
        Log.d();
        this.parentItemArrayList.clear();
        this.parentItemArrayList.addAll(parentItemArrayList);
        notifyPropertyChanged(BR.parentItemList);
    }

    @BindingAdapter({"ListData"})
    public static void setContents(RecyclerView recyclerView, List<ParentItem> parentItemList) {
        Log.d();
        if (parentItemList != null && !parentItemList.isEmpty()) {
            if (recyclerView.getAdapter() != null) {
                recyclerView.getAdapter().notifyDataSetChanged();
                Log.d();
            } else {
                recyclerView.setAdapter(new ParenItemRecyclerViewAdapter(parentItemList));
                Log.d();
            }
        }
    }

    public void onResume() {
        Log.d();
    }
}
