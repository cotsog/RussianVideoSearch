package com.eazyigz.RussiaMediaSearch.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.eazyigz.RussiaMediaSearch.BR;

public class Cheese extends BaseObservable {
    private String name;

    @Bindable
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

}
