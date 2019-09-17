package com.example.mvvm.remote;

import com.example.mvvm.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.HTTP;

public interface ApiService {

    @HTTP(method = "LIST", path = "/apiv1/currencies")
    Call<List<User>> getList();
}
