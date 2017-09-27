package mx.com.lania.mvvmexample.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import mx.com.lania.mvvmexample.Model.ApiUserResponse;
import mx.com.lania.mvvmexample.Repository.UserRepository;

/**
 * Created by macbook on 20/09/17.
 */

public class UserViewModel extends ViewModel{

    private MediatorLiveData<ApiUserResponse> mApiUserResponse;
    private UserRepository userRepository;

    @Inject
    public UserViewModel(UserRepository userRepository) {
        mApiUserResponse = new MediatorLiveData<>();
        this.userRepository = userRepository;
    }

    @NonNull
    public LiveData<ApiUserResponse> getApiUserResponse() {
        return mApiUserResponse;
    }

    public LiveData<ApiUserResponse> getUsers() {
        mApiUserResponse.addSource(
                userRepository.getUsers(),
                apiUserResponse -> mApiUserResponse.setValue(apiUserResponse)
        );
        return mApiUserResponse;
    }

}
