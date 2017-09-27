package mx.com.lania.mvvmexample.View;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.List;

import javax.inject.Inject;

import mx.com.lania.mvvmexample.Adapter.UsersAdapterRecylclerView;
import mx.com.lania.mvvmexample.MVVMApplication;
import mx.com.lania.mvvmexample.Model.User;
import mx.com.lania.mvvmexample.R;
import mx.com.lania.mvvmexample.ViewModel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private UserViewModel userViewModel;
    private ProgressBar progressBar;
    private DoubleBounce doubleBounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.spin_kit);
        doubleBounce = new DoubleBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        ((MVVMApplication) getApplication()).getAppComponent().inject(this);
        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel.class);
        userViewModel.getUsers().observe(this, apiUserResponse -> {
            if (apiUserResponse.getError() != null){

            }
            else {
                handleResponse(apiUserResponse.getUsers());
            }
        });
    }

    public void handleResponse(List<User> users) {
        if (users != null) {
            RecyclerView userRecycler = findViewById(R.id.usersRecylcler);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            userRecycler.setLayoutManager(linearLayoutManager);
            UsersAdapterRecylclerView usersAdapterRecylclerView = new UsersAdapterRecylclerView(users, R.layout.card_user);
            userRecycler.setAdapter(usersAdapterRecylclerView);
        }
    }

}



