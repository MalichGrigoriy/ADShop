package com.adshopmalychtest.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.adshopmalychtest.R;
import com.adshopmalychtest.databinding.ItemChildBinding;
import com.adshopmalychtest.databinding.ItemParentBinding;
import com.adshopmalychtest.model.dto.ChildItem;
import com.adshopmalychtest.model.dto.ParentItem;
import com.adshopmalychtest.util.ExpandableRecyclerView.ExpandableRecyclerParent;
import com.adshopmalychtest.util.ExpandableRecyclerView.ExpandableRecyclerViewAdapter;

import java.util.List;

public class ParenItemRecyclerViewAdapter extends ExpandableRecyclerViewAdapter {


    private LayoutInflater layoutInflater;

    public ParenItemRecyclerViewAdapter(List<ParentItem> parentItemList) {
        super((List<ExpandableRecyclerParent>) (List<?>) parentItemList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        switch (viewType) {
            case CHILD:
                ItemChildBinding itemChildBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_child, parent, false);
                setChildClickListener(itemChildBinding.getRoot());
                return new ChildHolder(itemChildBinding);
            default:
                ItemParentBinding itemParentBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_parent, parent, false);
                setParentClickListener(itemParentBinding.getRoot());
                return new ParentHolder(itemParentBinding);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ParentHolder) {
            ParentItem parentItem = (ParentItem) getItemByPosition(position);
            ((ParentHolder) holder).binding.setParent(parentItem);

        } else if (holder instanceof ChildHolder) {
            ChildItem childItem = (ChildItem) getItemByPosition(position);
            ((ChildHolder) holder).binding.setChild(childItem);
        }
    }

    private class ParentHolder extends RecyclerView.ViewHolder {
        private ItemParentBinding binding;

        ParentHolder(ItemParentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

    private class ChildHolder extends RecyclerView.ViewHolder {
        private ItemChildBinding binding;

        ChildHolder(ItemChildBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
