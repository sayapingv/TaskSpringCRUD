package web.model;

import java.util.ArrayList;
import java.util.List;

public class UserCreationList {

    private List<User> users;

    public UserCreationList() {
        users = new ArrayList<>();
    }

    public UserCreationList(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> books) {
        this.users = books;
    }
}