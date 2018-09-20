
package ponerpie;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
/*
autor : Quintana Gustavo Fernando.
parametros: 
-args[0] :Direccion del directorio contenedor de los documentos 
pdf sin poner pie.
-args[1]: direccion del directorio contenedor de los documentos pdf con
el pie puesto.
*/
public class PonerPie {
    public static void main(String[] args) throws IOException {
        String text = "";
        File _dir = new File(args[0]);
        File[] ficheros = _dir.listFiles();
        String path = new java.io.File(".").getCanonicalPath();
        System.out.println(path);
        if(_dir != null){
            for (int x=0;x<ficheros.length;x++){
                File file = new File(args[0]+"\\"+ficheros[x].getName());
                System.out.println("Agregando pie a: " + args[0] + "\\" + ficheros[x].getName());
                PDDocument document = PDDocument.load(file);
                int noOfPages= document.getNumberOfPages();
                for(int i= 0;i < noOfPages; i++){
                    PDPage page = document.getPage(i);
                    PDPageContentStream contentStream = new PDPageContentStream(document, page,PDPageContentStream.AppendMode.APPEND, true, true); 
                    contentStream.beginText(); 
                    contentStream.newLineAtOffset(200, 50);
                    contentStream.setNonStrokingColor(Color.BLUE);
                    
                    
                    
                    
                    PDType0Font font = PDType0Font.load(document, new File(args[2]));
                    contentStream.setFont(font, 20 );
                    contentStream.setLeading(14.5f);
                    text="C.D.D.I - Página " + (i + 1) + " de " + noOfPages ;
                    contentStream.showText(text);
                    contentStream.endText();
                    contentStream.close();
                }
            System.out.println("archivo guardado: "+args[1] +"\\" +  ficheros[x].getName());
            String nombreNuevo = ficheros[x].getName().substring(1, ficheros[x].getName().length());
            document.save(args[1] +"\\" + "" + nombreNuevo);
            document.close();
            }
        }
    System.out.println("El proceso ha terminado con exito.");    
    }   
}