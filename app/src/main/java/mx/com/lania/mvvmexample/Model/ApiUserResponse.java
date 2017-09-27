package mx.com.lania.mvvmexample.Model;

import java.util.List;

/**
 * Created by macbook on 25/09/17.
 */

public class ApiUserResponse {

    private List<User> Users;
    private Throwable error;

    public ApiUserResponse(List<User> users) {
        Users = users;
        this.error = null;
    }

    public ApiUserResponse(Throwable error) {
        this.error = error;
        this.Users = null;
    }

    public List<User> getUsers() {
        return Users;
    }

    public Throwable getError() {
        return error;
    }
}
