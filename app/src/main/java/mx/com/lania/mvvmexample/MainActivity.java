package mx.com.lania.mvvmexample;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mx.com.lania.mvvmexample.Adapter.UsersAdapterRecylclerView;
import mx.com.lania.mvvmexample.ViewModel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private RecyclerView userRecycler;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUsers().observe(this, users -> {
            if (users != null) {
                userRecycler = findViewById(R.id.usersRecylcler);
                linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                userRecycler.setLayoutManager(linearLayoutManager);
                UsersAdapterRecylclerView usersAdapterRecylclerView = new UsersAdapterRecylclerView(users, R.layout.card_user);
                userRecycler.setAdapter(usersAdapterRecylclerView);
            }
        });
    }
}


