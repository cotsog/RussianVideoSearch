package com.eazyigz.RussiaMediaSearch.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

public class Cheese extends BaseObservable {
    @Bindable
    public final ObservableField<String> name = new ObservableField<>();

}
