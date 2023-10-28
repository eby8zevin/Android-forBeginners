package com.ahmadabuhasan.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class CoinActivity implements Parcelable {
    String name;
    String detail;
    int photo;

    protected CoinActivity(Parcel in) {
        name = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    public static final Parcelable.Creator<CoinActivity> CREATOR = new Parcelable.Creator<CoinActivity>() {
        @Override
        public CoinActivity createFromParcel(Parcel source) {
            return new CoinActivity(source);
        }

        @Override
        public CoinActivity[] newArray(int size) {
            return new CoinActivity[size];
        }
    };

    public CoinActivity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeInt(photo);
    }
}
