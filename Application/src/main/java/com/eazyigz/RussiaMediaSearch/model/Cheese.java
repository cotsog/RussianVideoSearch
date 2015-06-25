package com.eazyigz.RussiaMediaSearch.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Cheese extends BaseObservable {
    @Bindable
    public final String name;

    public Cheese(String name) {
        this.name = name;
    }
}
