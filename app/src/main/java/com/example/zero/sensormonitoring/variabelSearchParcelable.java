package com.example.zero.sensormonitoring;

import android.os.Parcel;
import android.os.Parcelable;

public class variabelSearchParcelable implements Parcelable {

    private String dataBaseSearch;

    protected variabelSearchParcelable(Parcel in) {
        dataBaseSearch = in.readString();
    }

    protected variabelSearchParcelable() {

    }

    public static final Creator<variabelSearchParcelable> CREATOR = new Creator<variabelSearchParcelable>() {
        @Override
        public variabelSearchParcelable createFromParcel(Parcel in) {
            return new variabelSearchParcelable(in);
        }

        @Override
        public variabelSearchParcelable[] newArray(int size) {
            return new variabelSearchParcelable[size];
        }
    };

    public String getDataBaseSearch() {
        return dataBaseSearch;
    }

    public void setDataBaseSearch(String dataBaseSearch) {
        this.dataBaseSearch = dataBaseSearch;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dataBaseSearch);
    }
}