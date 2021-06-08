package com.example.vosuqjava.ui.viewmodel;

import com.example.vosuqjava.data.model.Item;
import com.example.vosuqjava.data.api.ApiService;

import java.util.List;

import io.reactivex.Single;

public class ItemViewModel {

    private ApiService apiService;

    public ItemViewModel(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<List<Item>> getItems(){
        return apiService.getItems();
    }
}
