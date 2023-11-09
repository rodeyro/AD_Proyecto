package Proyecto_AD_UD1.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Session {
    private User user;

    public Session() {
        this.user = null;
    }

    public boolean login(String username, String pass, Users users) {
        User user = users.getUser(username);
        if (user == null) {
            return false;
        }
        boolean ok = user.checkPassword(pass);
        if (ok) {
            this.user = user;
            logEvent(username, "LOGIN");
        }
        return ok;
    }

    public boolean logout(String username, Users users) {
        User user = users.getUser(username);
        if (user == null) {
            return false;
        }else if (user != null) {
            this.user = null;
            logEvent(username, "LOGOUT");
        }
        return true;
    }

    private void logEvent(String username, String eventType) {
        String timestamp = getCurrentTimestamp();
        String logEntry = timestamp + " " + username + " " + eventType;
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\DAM2_ALU09\\Desktop\\Acceso a Base de datos\\Parte 2\\untitled2\\src\\Proyecto_AD_UD1\\session.log", true)))) {
            writer.println(logEntry);
            System.out.println(logEntry);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
