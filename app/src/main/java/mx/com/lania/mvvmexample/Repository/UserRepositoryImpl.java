package mx.com.lania.mvvmexample.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import mx.com.lania.mvvmexample.Model.ApiUserResponse;
import mx.com.lania.mvvmexample.Model.User;
import mx.com.lania.mvvmexample.Service.UserWebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by macbook on 20/09/17.
 */

public class UserRepositoryImpl implements UserRepository{

    @Inject
    UserWebService userWebService;

    @Inject
    public UserRepositoryImpl() {}

    public LiveData<ApiUserResponse> getUsers() {
        final MutableLiveData<ApiUserResponse> liveData = new MutableLiveData<>();
        //final MutableLiveData<List<User>> data = new MutableLiveData<>();
        userWebService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                liveData.setValue(new ApiUserResponse(response.body()));
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                liveData.setValue(new ApiUserResponse(t));
            }
        });
        return liveData;
    }

}
