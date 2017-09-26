package mx.com.lania.mvvmexample.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import java.util.List;
import mx.com.lania.mvvmexample.Model.User;
import mx.com.lania.mvvmexample.Repository.UserRepository;

/**
 * Created by macbook on 20/09/17.
 */

public class UserViewModel extends ViewModel{

    private LiveData<List<User>> users;
    private UserRepository userRepository;

    public UserViewModel() {
        userRepository = new UserRepository();
    }

    public LiveData<List<User>> getUsers() {
        if (users == null)
            users = userRepository.getUsers();
        return users;
    }

}
