
package ponerpie;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PonerPie {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\gustavo\\Desktop\\Propuesta de proyecto(1).pdf");
        PDDocument document = PDDocument.load(file);
        int noOfPages= document.getNumberOfPages();
        String text = "";
        for(int i= 0;i < noOfPages; i++){
            System.out.println("pagina: " + i + " numero de pagina: " + noOfPages);
            PDPage page = document.getPage(i);
            PDPageContentStream contentStream = new PDPageContentStream(document, page,PDPageContentStream.AppendMode.APPEND, true, true); 
            contentStream.beginText(); 
            contentStream.newLineAtOffset(200, 50);
            PDType0Font font = PDType0Font.load(document, new File("C:\\Users\\gustavo\\Documents\\NetBeansProjects\\PonerPie\\src\\Swis721_BlkOul_BT_Black.ttf"));
            
            
            
            contentStream.setFont(font, 20 );
            
            
            contentStream.setLeading(14.5f);
            text="C.D.D.I - Página " + (i + 1) + " de " + noOfPages ;
            contentStream.showText(text);
            contentStream.endText();
            contentStream.close();
        }
        document.save("C:\\Users\\gustavo\\Desktop\\_Propuesta de proyecto(1).pdf");
        document.close();
        
    }
    
}
