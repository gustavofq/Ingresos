
package ponerpie;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class PonerPie {
    public static void main(String[] args) throws IOException {
        
        String text = "";
        File _dir = new File(args[0]);
        File[] ficheros = _dir.listFiles();
        System.out.println(ficheros.length);
        if(_dir != null){
            for (int x=0;x<ficheros.length;x++){
                File file = new File(args[0]+"\\"+ficheros[x].getName());
                System.out.println("archivo a modificar: " + args[0] + "\\" + ficheros[x].getName());
                PDDocument document = PDDocument.load(file);
                int noOfPages= document.getNumberOfPages();
                for(int i= 0;i < noOfPages; i++){
                    System.out.println("pagina: " + i + " numero de pagina: " + noOfPages);
                    PDPage page = document.getPage(i);
                    PDPageContentStream contentStream = new PDPageContentStream(document, page,PDPageContentStream.AppendMode.APPEND, true, true); 
                    contentStream.beginText(); 
                    contentStream.newLineAtOffset(200, 50);
                    contentStream.setNonStrokingColor(Color.BLUE);
                    PDType0Font font = PDType0Font.load(document, new File("C:\\Users\\gustavo\\Documents\\NetBeansProjects\\PonerPie\\src\\Swis721_BlkOul_BT_Black.ttf"));
                    contentStream.setFont(font, 20 );
                    contentStream.setLeading(14.5f);
                    text="C.D.D.I - Página " + (i + 1) + " de " + noOfPages ;
                    contentStream.showText(text);
                    contentStream.endText();
                    contentStream.close();
                }
            System.out.println("archivo guardado: "+args[1] +"\\" + "_" +  ficheros[x].getName());
            document.save(args[1] +"\\" + "_" +  ficheros[x].getName());
            document.close();
            }
        }
    } 
}
