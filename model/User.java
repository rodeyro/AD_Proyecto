package Proyecto_AD_UD1.model;

import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String passwordHash;
    private int age;
    private String email;

    public User(String name, String password, int age, String email) {
        this.name = name;
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean checkPassword(String pass) {
        return BCrypt.checkpw(pass, passwordHash);
    }
}
