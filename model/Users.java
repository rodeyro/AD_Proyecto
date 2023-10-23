package Proyecto_AD_UD1.model;

import java.util.HashMap;

public class Users {
    private HashMap<String, User> users = new HashMap<>();

    public Users() {
        User user = new User("admin","admin", 0, "admin@admin.local");
        users.put(user.getName(),user);
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public  void addUser(User usuario) {
        users.put(usuario.getName(),usuario);
    }

    public User getUser(String user) {
        return users.get(user);
    }

}
