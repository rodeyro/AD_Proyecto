package Proyecto_AD_UD1.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;


    public App() {
        FileHandler fileHander = new FileHandler(this.filename);
        this.users = new Users();
        fileHander.leerUsuarios();
        fileHander.almacenarUsuarios(this.users.getUsers());
        this.session = new Session();

    }

    public Session getSession() {
        return session;
    }


    private ActionListener btnIniciarSesionActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        return al;
    }
}
