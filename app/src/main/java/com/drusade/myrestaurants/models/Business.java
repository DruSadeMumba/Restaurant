
package com.drusade.myrestaurants.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Business {

    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("is_closed")
    @Expose
    private Boolean isClosed;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("review_count")
    @Expose
    private Integer reviewCount;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("coordinates")
    @Expose
    private Coordinates coordinates;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("transactions")
    @Expose
    private List<String> transactions = null;
    private String pushId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Business() {
    }

    /**
     * 
     * @param distance
     * @param rating
     * @param coordinates
     * @param transactions
     * @param url
     * @param isClosed
     * @param phone
     * @param reviewCount
     * @param price
     * @param imageUrl
     * @param name
     * @param alias
     * @param location
     * @param id
     * @param categories
     */
    public Business(Double rating, String price, String phone, String id, String alias, Boolean isClosed, List<Category> categories, Integer reviewCount, String name, String url, Coordinates coordinates, String imageUrl, Location location, Double distance, List<String> transactions) {
        super();
        this.rating = rating;
        this.price = price;
        this.phone = phone;
        this.id = id;
        this.alias = alias;
        this.isClosed = isClosed;
        this.categories = categories;
        this.reviewCount = reviewCount;
        this.name = name;
        this.url = url;
        this.coordinates = coordinates;
        this.imageUrl = imageUrl;
        this.location = location;
        this.distance = distance;
        this.transactions = transactions;
    }

    //Getters
    public Double getRating() {
        return rating;
    }
    public String getPrice() {
        return price;
    }
    public String getPhone() {
        return phone;
    }
    public String getId() {
        return id;
    }
    public Boolean getIsClosed() {
        return isClosed;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public Integer getReviewCount() {
        return reviewCount;
    }
    public String getAlias() {
        return alias;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    public Coordinates getCoordinates() {return coordinates;}
    public String getImageUrl() {
        return imageUrl;
    }
    public Location getLocation() {
        return location;
    }
    public Double getDistance() {
        return distance;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public String getPushId() {return pushId;}

    //Setters
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setCoordinates(Coordinates coordinates) {this.coordinates = coordinates;}
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
    public void setPushId(String pushId) {this.pushId = pushId;}
}
