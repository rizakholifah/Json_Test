package com.ibzindustries.jsonserverapp.modelClass;

import android.os.Parcel;
import android.os.Parcelable;

public class Merchant implements Parcelable {
    private int merchantID;
    private String merchantName, merchantSlug;

    public Merchant(int merchantID, String merchantName, String merchantSlug) {
        this.merchantID = merchantID;
        this.merchantName = merchantName;
        this.merchantSlug = merchantSlug;
    }

    protected Merchant(Parcel in) {
        merchantID = in.readInt();
        merchantName = in.readString();
        merchantSlug = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(merchantID);
        dest.writeString(merchantName);
        dest.writeString(merchantSlug);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Merchant> CREATOR = new Creator<Merchant>() {
        @Override
        public Merchant createFromParcel(Parcel in) {
            return new Merchant(in);
        }

        @Override
        public Merchant[] newArray(int size) {
            return new Merchant[size];
        }
    };
}
