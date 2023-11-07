package Proyecto_AD_UD1.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIP {
        public static void crearArchivoZIP(String xmlFilePath, String jsonFilePath, File selectedFile) {
            try {
                FileOutputStream fos = new FileOutputStream(selectedFile);
                ZipOutputStream zipOut = new ZipOutputStream(fos);

                // Agregar archivo XML al ZIP
                File fileToZip = new File(xmlFilePath);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();

                fileToZip = new File(jsonFilePath);
                fis = new FileInputStream(fileToZip);
                zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);
                bytes = new byte[1024];
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();

                zipOut.close();
                fos.close();

                System.out.println("Archivo ZIP creado con éxito.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
