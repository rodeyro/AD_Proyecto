package Proyecto_AD_UD1.model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;

public class PDF {
    public static String esportarUsuarioPDF(Users nombre, String selectedFile, String usuario){
        PDDocument document = new PDDocument();

        PDPage page = new PDPage();
        document.addPage(page);
        try{
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.newLineAtOffset(60, 710);
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.setLeading(15);
            contentStream.showText(nombre.getUser(usuario).getName());
            contentStream.newLine();
            contentStream.showText(String.valueOf(nombre.getUser(usuario).getPasswordHash()));
            contentStream.newLine();
            contentStream.showText(String.valueOf(nombre.getUser(usuario).getAge()));
            contentStream.newLine();
            contentStream.showText(nombre.getUser(usuario).getEmail());
            contentStream.endText();
            contentStream.close();

            document.save(selectedFile);
            document.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return selectedFile;
    }
}
