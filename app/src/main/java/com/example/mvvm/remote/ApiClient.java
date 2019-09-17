package com.example.mvvm.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    private static ApiService apiService;


    public static Retrofit getClient(){
        retrofit=new Retrofit.Builder().baseUrl("https://nightly-alpha.carrene.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }

    public static ApiService getApi(){

        apiService=getClient().create(ApiService.class);

        return apiService;

    }

}
