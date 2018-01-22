package com.adshopmalychtest.util.ExpandableRecyclerView;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.adshopmalychtest.BR;

public class ExpandableRecyclerChild extends BaseObservable {

    private boolean checked;

    @Bindable
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        if (this.checked != checked) {
            this.checked = checked;
            notifyPropertyChanged(BR.checked);
        }
    }
}
