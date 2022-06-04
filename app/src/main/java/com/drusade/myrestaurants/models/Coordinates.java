
package com.drusade.myrestaurants.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Coordinates {

    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Coordinates() {
    }

    /**
     * 
     * @param latitude
     * @param longitude
     */
    public Coordinates(Double latitude, Double longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Getters
    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }

    //Setters
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
