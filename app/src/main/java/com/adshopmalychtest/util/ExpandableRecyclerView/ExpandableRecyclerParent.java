package com.adshopmalychtest.util.ExpandableRecyclerView;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.adshopmalychtest.BR;

import java.util.List;

public abstract class ExpandableRecyclerParent extends BaseObservable {


    private boolean openState;

    @Bindable
    public boolean isOpenState() {
        return openState;
    }

    public void setOpenState(boolean openState) {
        this.openState = openState;
    }

    @Bindable
    public boolean isStateChanged() {
        return openState;
    }


    public void changeOpenState() {
        setOpenState(!isOpenState());
        notifyPropertyChanged(BR.stateChanged);
    }

    public void checkChild(int position) {

        for (int i = 0; i <= getChild().size() - 1; i++) {
            if (i == position)
                getChild().get(i).setChecked(true);
            else
                getChild().get(i).setChecked(false);
        }
    }

    public abstract List<ExpandableRecyclerChild> getChild();
}
