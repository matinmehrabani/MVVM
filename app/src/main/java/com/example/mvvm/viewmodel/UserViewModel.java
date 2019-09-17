package com.example.mvvm.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.mvvm.BR;
import com.example.mvvm.model.User;
import com.example.mvvm.remote.user.UserRepository;

import java.util.ArrayList;

public class UserViewModel extends BaseObservable {

    private String name;
    private String phone;
    private Context context;
    UserRepository userRepository = new UserRepository();
    UserViewModelInterface userViewModelInterface;

    public UserViewModel(Context context, UserViewModelInterface userViewModelInterface) {
        this.context = context;
        this.userViewModelInterface = userViewModelInterface;
    }

    public void getuser(Context context) {

        userRepository.getUser();
        userRepository.getMutableLiveData().observe((LifecycleOwner) context, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                userViewModelInterface.setUser(users);
            }
        });


    }


}
