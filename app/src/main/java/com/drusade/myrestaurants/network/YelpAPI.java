package com.drusade.myrestaurants.network;

import com.drusade.myrestaurants.models.YelpBusinessesSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpAPI {
    @GET("businesses/search")
    Call<YelpBusinessesSearchResponse> getRestaurants(
            @Query("location") String location,
            @Query("term") String term
    );
}
