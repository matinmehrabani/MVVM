package com.example.mvvm.viewmodel;

import com.example.mvvm.model.User;

import java.util.List;

public interface UserViewModelInterface {


    void setUser(List<User> list);
    void initUi();
}
