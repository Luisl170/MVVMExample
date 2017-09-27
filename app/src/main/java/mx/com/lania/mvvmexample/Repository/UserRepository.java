package mx.com.lania.mvvmexample.Repository;

import android.arch.lifecycle.LiveData;
import mx.com.lania.mvvmexample.Model.ApiUserResponse;

/**
 * Created by macbook on 26/09/17.
 */

public interface UserRepository {

    LiveData<ApiUserResponse> getUsers();

}
