package Proyecto_AD_UD1.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class ZIP {
    // Exportación de archivos a un archivo ZIP
    public static void exportarAZip(String rutaArchivoZip) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(rutaArchivoZip))) {
            // XML.exportartodosUsuarioXML(Users , rutaArchivoZip);
            //JSON.exportartodosUsuario(Users , rutaArchivoZip);
            System.out.println("Archivos exportados a ZIP correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
