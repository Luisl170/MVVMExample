package mx.com.lania.mvvmexample.Model;

/**
 * Created by macbook on 19/09/17.
 */

public class User {

    private int id;
    private String name;
    private String lastName;
    private String nickName;

    public User(int id, String name, String lastName, String nickName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
