package mx.com.lania.mvvmexample.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import mx.com.lania.mvvmexample.Model.User;
import mx.com.lania.mvvmexample.R;

/**
 * Created by macbook on 20/09/17.
 */

public class UsersAdapterRecylclerView extends RecyclerView.Adapter<UsersAdapterRecylclerView.UserViewHolder>{

    private List<User> users;
    private int resource;

    public UsersAdapterRecylclerView(List<User> users, int resource) {
        this.users = users;
        this.resource = resource;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.name.setText(user.getName());
        holder.lastname.setText(user.getLastName());
        holder.nickname.setText(user.getNickName());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView lastname;
        TextView nickname;

        public UserViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameCard);
            lastname = (TextView) view.findViewById(R.id.lastNameCard);
            nickname = (TextView) view.findViewById(R.id.nickNameCard);
        }
    }
}
