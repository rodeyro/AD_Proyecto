package Proyecto_AD_UD1.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.io.File;
import java.io.IOException;

public class JSON {

    public static void exportarUsuario(User usuario, String rutaArchivo) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();

            objectWriter.writeValue(new File(rutaArchivo),usuario);
            System.out.println("Usuario exportado correctamente a JSON.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al exportar el usuario a JSON: " + e.getMessage());
        }
    }
    public static void exportartodosUsuario(Users usuario, String rutaArchivo) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();

            objectWriter.writeValue(new File(rutaArchivo), usuario);
            System.out.println("Usuario exportado correctamente a JSON.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al exportar el usuario a JSON: " + e.getMessage());
        }
    }
}