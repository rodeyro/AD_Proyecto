package Proyecto_AD_UD1.model;

import java.io.File;

public class App {
    private final String filename = "C:\\Users\\DAM2_ALU09\\Desktop\\Acceso a Base de datos\\Parte 2\\untitled2\\src\\Proyecto_AD_UD1\\usuarios.bin";
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

   public void deleteUser(String nombreborrar){
       users.deleteUser(nombreborrar);
       fileHander.almacenarUsuarios(users);
   }

    public boolean login(String user, String pass) {
        return session.login(user,pass, this.users);
    }

    public boolean logout(String user) {
        return session.logout(user,this.users);
    }

    public void setXML(Users nombre,File selectedFile,String usuario) {
        XML.exportarUsuarioXML(nombre, String.valueOf(selectedFile), usuario);
    }

    public void setJSON(User nombre, File selectedFile) {
        JSON.exportarUsuario(nombre, String.valueOf(selectedFile));
    }

    public void setAllUsers(Users usuario, File selectedFile) {
        ZIP.crearArchivoZIP(XML.exportarUsuariosXML(usuario),JSON.exportartodosUsuario(usuario), selectedFile);
    }


    public void setPDF(Users nombre, String selectedFile, String usuario) {
        PDF.esportarUsuarioPDF(nombre, selectedFile, usuario);
    }
}
