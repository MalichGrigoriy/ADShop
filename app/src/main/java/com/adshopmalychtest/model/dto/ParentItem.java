
package com.adshopmalychtest.model.dto;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.adshopmalychtest.BR;

import java.util.List;

import com.adshopmalychtest.util.ExpandableRecyclerView.ExpandableRecyclerChild;
import com.adshopmalychtest.util.ExpandableRecyclerView.ExpandableRecyclerParent;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentItem extends ExpandableRecyclerParent {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("children")
    @Expose
    private List<ChildItem> children;


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

    public List<ChildItem> getChildren() {
        return children;
    }

    public void setChildren(List<ChildItem> children) {
        this.children = children;
    }

    public boolean hasChild() {
        return children != null && !children.isEmpty();
    }


    @Override
    public List<ExpandableRecyclerChild> getChild() {
        return (List<ExpandableRecyclerChild>) (List<?>) children;
    }
}
