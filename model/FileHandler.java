package Proyecto_AD_UD1.model;

import java.io.*;

public class FileHandler {
    private static final String FILE_NAME = "usuarios.bin";
    private static final byte[] HEADER = { (byte) 0xFF, (byte) 0xEE, (byte) 0x20, (byte) 0x23, (byte) 0xEE, (byte) 0xFF };

    private File file;

    public FileHandler(String path) {
        this.file = new File(path);
    }

    public void almacenarUsuarios(Users users) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.write(HEADER);
            out.writeObject(users);
            System.out.println("Usuarios almacenados en " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Users leerUsuarios() {
        Users users = new Users();
        User admin = new User("admin", "admin", 0, "admin@admin.local");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            byte[] header = new byte[HEADER.length];
            ois.read(header);

            if (!validarCabecera(header)) {
                throw new RuntimeException("Cabecera incorrecta en el archivo.");
            }

            users = (Users) ois.readObject();

            if (users.userExists("admin")) {
                return users;
            }

            users.addUser(admin);
            System.out.println("Usuario admin añadido.");
            almacenarUsuarios(users);
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, crearlo y añadir usuario admin por defecto
            users.addUser(admin);
            almacenarUsuarios(users);
            System.out.println("Archivo no encontrado. Se creó un nuevo archivo con el usuario admin por defecto.");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error al leer usuarios: " + e.getMessage());
        }
        return users;
    }

    private static boolean validarCabecera(byte[] header) {
        if (header.length != HEADER.length) {
            return false;
        }
        for (int i = 0; i < HEADER.length; i++) {
            if (header[i] != HEADER[i]) {
                return false;
            }
        }
        return true;
    }
}
