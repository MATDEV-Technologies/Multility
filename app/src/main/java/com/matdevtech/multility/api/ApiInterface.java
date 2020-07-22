package com.matdevtech.multility.api;

// Imports
import com.matdevtech.multility.models.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Main class
public interface ApiInterface {
    // Interfacing the general metadata for the API and usage in our app
    @GET("top-headlines")
    Call<News> getNews(

            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
