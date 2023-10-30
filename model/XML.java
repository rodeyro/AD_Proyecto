package Proyecto_AD_UD1.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XML {
    // Exportación de un usuario en formato XML
    public static void exportarUsuarioXML(Users usuario, String rutaArchivo , String nusuario) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = doc.createElement("usuarios");
            doc.appendChild(rootElement);

            Element userElement = doc.createElement("usuario");
            rootElement.appendChild(userElement);

            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(usuario.getUser(nusuario).getName()));
            userElement.appendChild(nombre);

            Element password = doc.createElement("Password");
            password.appendChild(doc.createTextNode(String.valueOf(usuario.getUser(nusuario).getPasswordHash())));
            userElement.appendChild(password);

            Element edad = doc.createElement("edad");
            edad.appendChild(doc.createTextNode(String.valueOf(usuario.getUser(nusuario).getAge())));
            userElement.appendChild(edad);

            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode(usuario.getUser(nusuario).getEmail()));
            userElement.appendChild(email);

            FileWriter fileWriter = new FileWriter(rutaArchivo);
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(fileWriter));
            fileWriter.close();

            System.out.println("Usuario exportado a XML correctamente.");

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    // Exportación de todos los usuarios en formato XML
    public void exportarTodosUsuariosXML(List<Users> usuarios, String rutaArchivo) {
        // Implementar lógica similar para exportar todos los usuarios a XML
    }
}
