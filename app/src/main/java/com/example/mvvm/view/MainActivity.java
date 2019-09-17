package com.example.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvm.R;

import com.example.mvvm.model.User;
import com.example.mvvm.model.Adapter;
import com.example.mvvm.viewmodel.UserViewModel;
import com.example.mvvm.viewmodel.UserViewModelInterface;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserViewModelInterface {


    UserViewModel userViewModel;
RecyclerView recyclerView;
Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
initUi();
userViewModel.getuser(this);


    }

    @Override
    public void setUser(List<User> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Adapter(list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initUi() {
recyclerView=findViewById(R.id.recyclerview);
userViewModel=new UserViewModel(this,this);
    }
}
