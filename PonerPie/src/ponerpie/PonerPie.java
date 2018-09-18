
package ponerpie;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PonerPie {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\gustavo\\Desktop\\Propuesta de proyecto(1).pdf");
        PDDocument document = PDDocument.load(file);
        if(document)
        int noOfPages= document.getNumberOfPages();
        String text = "";
        for(int i= 0;i < noOfPages; i++){
            System.out.println("pagina: " + i + " numero de pagina: " + noOfPages);
            PDPage page = document.getPage(i);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            
            contentStream.beginText(); 
            contentStream.newLineAtOffset(25, 700);
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 16 );
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
