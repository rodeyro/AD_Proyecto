package Proyecto_AD_UD1.model;

import java.io.File;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;
    private FileHandler fileHander;

    public App() {
        this.fileHander = new FileHandler(this.filename);
        this.users = fileHander.leerUsuarios();
        this.session = new Session();

    }

    public String getFilename() {
        return filename;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public FileHandler getFileHander() {
        return fileHander;
    }

    public void setFileHander(FileHandler fileHander) {
        this.fileHander = fileHander;
    }

    public void createUser(String nombre, String pass, int edad, String correo) {
        User user = new User(nombre, pass, edad, correo);
        users.addUser(user);
        fileHander.almacenarUsuarios(users);
    }

    public void changePassword(String nombre, String pass, int edad, String correo){
        User user = new User(nombre, pass, edad, correo);
        users.addUser(user);
        fileHander.almacenarUsuarios(users);
    }

   /* public void deleteUser(String nombre, String pass, int edad, String correo){
        Users usuarioborara = users.getUser(nombre);
        fileHander.eliminarUsuarios(usuarioborara);

   }*/

    public boolean login(String user, String pass) {
        Session session = new Session();

        //1. comprobar user+pass de usuario
        return session.login(user,pass, this.users);

        //2. si ok => guardamos en session el usuario

        //3. si ok => return true;

    }

    public void setXML(Users nombre,File selectedFile,String usuario  ) {
        XML.exportarUsuarioXML(nombre, String.valueOf(selectedFile), usuario);
    }

}
