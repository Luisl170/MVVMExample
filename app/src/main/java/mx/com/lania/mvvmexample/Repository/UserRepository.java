package mx.com.lania.mvvmexample.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import java.util.List;


import mx.com.lania.mvvmexample.Model.User;
import mx.com.lania.mvvmexample.Services.UserWebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macbook on 20/09/17.
 */

public class UserRepository {

    public static final String BASE_URL = "https://androidtutorials.herokuapp.com/";
    private UserWebService userWebService;

    public UserRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        userWebService = retrofit.create(UserWebService.class);
    }

    public LiveData<List<User>> getUsers() {
        final MutableLiveData<List<User>> data = new MutableLiveData<>();
        userWebService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                data.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
        return data;
    }

}
