package com.example.vosuqjava.data.api;

import com.example.vosuqjava.data.model.Item;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("Symbol")
    Single<List<Item>> getItems();
}
