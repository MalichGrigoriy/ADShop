package com.adshopmalychtest.model.dto;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.adshopmalychtest.BR;
import com.adshopmalychtest.util.ExpandableRecyclerView.ExpandableRecyclerChild;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChildItem extends ExpandableRecyclerChild {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
