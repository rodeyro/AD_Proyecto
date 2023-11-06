package Proyecto_AD_UD1.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XML {
    public static void exportarUsuarioXML(Users usuario, String rutaArchivo , String nusuario) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = doc.createElement("Users");
            doc.appendChild(rootElement);

            Element userElement = doc.createElement("User");
            rootElement.appendChild(userElement);

            Element nombre = doc.createElement("Name");
            nombre.appendChild(doc.createTextNode(usuario.getUser(nusuario).getName()));
            userElement.appendChild(nombre);

            Element password = doc.createElement("Password");
            password.appendChild(doc.createTextNode(String.valueOf(usuario.getUser(nusuario).getPasswordHash())));
            userElement.appendChild(password);

            Element edad = doc.createElement("Age");
            edad.appendChild(doc.createTextNode(String.valueOf(usuario.getUser(nusuario).getAge())));
            userElement.appendChild(edad);

            Element email = doc.createElement("Email");
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
    public static void exportarUsuariosXML(Users usuarios, String rutaArchivo) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

                Element rootElement = doc.createElement("Users");
                doc.appendChild(rootElement);

                for (User usuario : usuarios.getUsers().values()) {
                    Element usuarioElement = doc.createElement("User");
                    rootElement.appendChild(usuarioElement);

                    Element nameElement = doc.createElement("Name");
                    nameElement.appendChild(doc.createTextNode(String.valueOf(usuario.getName())));
                    usuarioElement.appendChild(nameElement);

                    Element idElement = doc.createElement("Password");
                    idElement.appendChild(doc.createTextNode(String.valueOf(usuario.getPasswordHash())));
                    usuarioElement.appendChild(idElement);

                    Element ageElement = doc.createElement("Age");
                    ageElement.appendChild(doc.createTextNode(String.valueOf(usuario.getAge())));
                    usuarioElement.appendChild(ageElement);

                    Element correoElement = doc.createElement("Email");
                    correoElement.appendChild(doc.createTextNode(usuario.getEmail()));
                    usuarioElement.appendChild(correoElement);
                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(rutaArchivo));
                transformer.transform(source, result);

                System.out.println("Usuarios exportados correctamente a " + rutaArchivo);
            } catch (Exception e) {
                System.out.println("Error al exportar usuarios a XML: " + e.getMessage());
            }
        }
    }


}

