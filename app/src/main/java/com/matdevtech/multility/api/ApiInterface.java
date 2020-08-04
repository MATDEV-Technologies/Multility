package com.matdevtech.multility.api;

// Imports
import com.matdevtech.multility.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Main class
public interface ApiInterface {
    // Implementation of the interface update procedure for the API

    @GET("top-headlines")
    Call<News> getNews(

            @Query("country") String country,
            @Query("apiKey") String apiKey
    );


}
