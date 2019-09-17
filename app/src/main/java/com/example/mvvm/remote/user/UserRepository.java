package com.example.mvvm.remote.user;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm.model.User;
import com.example.mvvm.remote.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

  private MutableLiveData<ArrayList<User>> mutableLiveData=new MutableLiveData<>();

    ArrayList<User> arrayList= new ArrayList<>();

    public UserRepository() {
    }

public void getUser(){

    ApiClient.getApi().getList().enqueue(new Callback<List<User>>() {
        @Override
        public void onResponse(Call<List<User>> call, Response<List<User>> response) {
            Log.e("response", "onResponse: "+response.body().toString());
for(int i=0;i<response.body().size();i++){

    arrayList.add(response.body().get(i));
}
            mutableLiveData.setValue(arrayList);

        }

        @Override
        public void onFailure(Call<List<User>> call, Throwable t) {
            Log.e("matinnn", "onFailure: "+t.toString());
        }
    });

}

    public MutableLiveData<ArrayList<User>> getMutableLiveData() {
        return mutableLiveData;
    }
}
