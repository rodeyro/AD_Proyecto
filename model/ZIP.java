package Proyecto_AD_UD1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIP {
    // Exportación de archivos a un archivo ZIP
    public void exportarAZip(String[] archivos, String rutaArchivoZip) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(rutaArchivoZip))) {
            for (String archivo : archivos) {
                File fileToZip = new File(archivo);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }
            System.out.println("Archivos exportados a ZIP correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
