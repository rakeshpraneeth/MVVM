package com.krp.mvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * This class describes the Company object.
 * Each variable in the class is a field that describes about the company.
 * The getter and setter methods are used to get and set the data with Api
 */

public class Company implements Parcelable {

    private String name;
    private String catchPhrase;
    private String bs;

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.catchPhrase);
        dest.writeString(this.bs);
    }

    public Company() {
    }

    protected Company(Parcel in) {
        this.name = in.readString();
        this.catchPhrase = in.readString();
        this.bs = in.readString();
    }

    public static final Parcelable.Creator<Company> CREATOR = new Parcelable.Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel source) {
            return new Company(source);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };
}
