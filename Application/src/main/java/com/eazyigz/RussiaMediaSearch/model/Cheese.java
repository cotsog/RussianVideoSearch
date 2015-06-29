package com.eazyigz.RussiaMediaSearch.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease
public class Cheese extends BaseObservable implements Parcelable {
    @Bindable
    public String name;

    public Cheese(String name) {
        this.name = name;
    }

    protected Cheese(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Cheese> CREATOR = new Creator<Cheese>() {
        @Override
        public Cheese createFromParcel(Parcel in) {
            return new Cheese(in);
        }

        @Override
        public Cheese[] newArray(int size) {
            return new Cheese[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
