package com.eazyigz.RussiaMediaSearch.view;

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

@ParcelablePlease
public class Cheese implements Parcelable {

    String name;

    private Cheese() {
    }

    public Cheese(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        CheeseParcelablePlease.writeToParcel(this, dest, flags);
    }

    public static final Creator<Cheese> CREATOR = new Creator<Cheese>() {
        public Cheese createFromParcel(Parcel source) {
            Cheese target = new Cheese();
            CheeseParcelablePlease.readFromParcel(target, source);
            return target;
        }

        public Cheese[] newArray(int size) {
            return new Cheese[size];
        }
    };
}

