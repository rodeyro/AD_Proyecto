package Proyecto_AD_UD1.model;

import java.io.*;

public class FileHandler {
    private File file ;

    public FileHandler(String path) {
        this.file= new File(path);
    }

    public void almacenarUsuarios(Users users) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(users);
            System.out.println("usuarios almacenados en " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Users leerUsuarios() {
        Users users = new Users();
        User admin = new User("admin","admin", 0, "admin@admin.local");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            users = (Users) ois.readObject();

            // 1. está todo ok
            // return users;

            // 2. el fichero no tiene admin
            // => crear un admin a mayores de los usuarios existentes

            if(users.userExists("admin")){
                return users;
            }

            users.addUser(admin);
            System.out.println("usuarios obtenidos");
            return users;

        } catch (IOException e) {
            users.addUser(admin);
        } catch (ClassNotFoundException e) {
           System.err.println("Error");
            users.addUser(admin);
        }
        almacenarUsuarios(users);
        return users;
    }


}
