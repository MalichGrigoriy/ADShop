package com.adshopmalychtest.util.ExpandableRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.adshopmalychtest.util.Log;

import java.util.ArrayList;
import java.util.List;

public abstract class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter {

    protected static final int PARENT = -2;
    protected static final int CHILD = -3;


    private final ArrayList<Object> allItemList = new ArrayList<>();

    public ExpandableRecyclerViewAdapter(List<ExpandableRecyclerParent> parentItemList) {
        allItemList.clear();
        for (ExpandableRecyclerParent parentItem : parentItemList) {
            allItemList.add(parentItem);
            if (parentItem.isOpenState()) {
                allItemList.addAll(parentItem.getChild());
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object item = allItemList.get(position);

        if (item instanceof ExpandableRecyclerChild)
            return CHILD;
        else
            return PARENT;
    }

    @Override
    public int getItemCount() {
        return allItemList.size();
    }

    public void parentClick(View view) {
        int startPosition = ((RecyclerView) view.getParent()).getChildAdapterPosition(view);
        ExpandableRecyclerParent parentItem = (ExpandableRecyclerParent) allItemList.get(startPosition);
        parentItem.changeOpenState();
        Log.d("" + startPosition);
        if (parentItem.isOpenState()) {
            Log.d("" + parentItem.getChild().size());
            allItemList.addAll(startPosition + 1, parentItem.getChild());
            notifyItemRangeInserted(startPosition + 1, parentItem.getChild().size());
        } else {
            Log.d("" + parentItem.getChild().size());
            allItemList.removeAll(parentItem.getChild());
            notifyItemRangeRemoved(startPosition + 1, parentItem.getChild().size());
        }
    }

    public void childClick(View view) {
        int childPosition = ((RecyclerView) view.getParent()).getChildAdapterPosition(view);
        ExpandableRecyclerChild childItem = (ExpandableRecyclerChild) allItemList.get(childPosition);
        if (childItem.isChecked())
            childItem.setChecked(false);
        else {
            int parentPosition = 0;
            ExpandableRecyclerParent parentItem = null;
            for (int i = childPosition; i >= 0; i--) {
                if (allItemList.get(i) instanceof ExpandableRecyclerParent) {
                    parentPosition = i;
                    parentItem = (ExpandableRecyclerParent) allItemList.get(i);
                    break;
                }
            }

            if (parentItem != null) {
                parentItem.checkChild(childPosition - parentPosition - 1);
            }
        }
    }

    protected Object getItemByPosition(int position) {
        return allItemList.get(position);
    }

    protected void setChildClickListener(View root) {
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                childClick(view);
            }
        });
    }

    protected void setParentClickListener(View root) {
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentClick(view);
            }
        });
    }

}
