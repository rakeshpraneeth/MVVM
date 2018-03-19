package com.krp.mvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * This class describes the Address object.
 * Each variable in the class is a field that describes about the Address.
 * The getter and setter methods are used to get and set the data with Api.
 */

public class Address implements Parcelable {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public String getStreet() {
        return street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.street);
        dest.writeString(this.suite);
        dest.writeString(this.city);
        dest.writeString(this.zipcode);
        dest.writeParcelable(this.geo, flags);
    }

    public Address() {
    }

    protected Address(Parcel in) {
        this.street = in.readString();
        this.suite = in.readString();
        this.city = in.readString();
        this.zipcode = in.readString();
        this.geo = in.readParcelable(Geo.class.getClassLoader());
    }

    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
}
