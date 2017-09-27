package mx.com.lania.mvvmexample.Service;

import java.util.List;

import mx.com.lania.mvvmexample.Model.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by macbook on 20/09/17.
 */

public interface UserWebService {

    @GET("usersFake")
    Call<List<User>> getUsers();

}
