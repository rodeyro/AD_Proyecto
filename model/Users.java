package Proyecto_AD_UD1.model;

import java.io.Serializable;
import java.util.HashMap;

public class Users implements Serializable {
    private HashMap<String, User> users;

    public Users() {
        users = new HashMap<>();
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

    public  void deleteUser(String nombre) {
        users.remove(nombre);
    }

    public User getUser(String user) {
        return users.get(user);
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }
}
