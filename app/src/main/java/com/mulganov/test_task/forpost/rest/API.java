package com.mulganov.test_task.forpost.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    interface JSONPlaceHolderApi {
        @GET("/api/")
        Call<Post> getUsers(@Query("results") int results);
    }
}
