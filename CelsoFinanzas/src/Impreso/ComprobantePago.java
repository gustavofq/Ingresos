package Impreso;
import Logica.Cobranza;
import Logica.Ingreso;
import Vista.Utilitario;
import java.io.File; 
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ComprobantePago {
    Utilitario unUtilitario = new Utilitario();
    private String encabezado = "";
    private String recibimos = "";
    private String cantidad = "";
    private String concepto = "";
    private String concepto2 = "";
    private String fecha = "";
    private String hash  = "";
    private String firma = "";
    private String linea = "";
    private String separador = "--------------------------------------------------------------------------------------------------------------------------------------";
    public ComprobantePago() {
    }
    
    public void imprimir(Cobranza unaCobranza, Ingreso unIngreso) throws IOException{
        this.cargarTexto(unaCobranza, unIngreso);
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText(); 
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 13);
        contentStream.setLeading(15.5f);
        contentStream.newLineAtOffset(25, 750);
        contentStream.showText(this.encabezado);
        contentStream.newLine();
        contentStream.showText(this.hash);
        contentStream.newLine();
        contentStream.showText(this.fecha);
        contentStream.newLine();
        contentStream.showText(this.recibimos);
        contentStream.newLine();
        contentStream.showText(this.concepto);
        contentStream.newLine();
        contentStream.showText(this.concepto2);
        contentStream.newLine();
        contentStream.showText(this.cantidad);
        contentStream.newLine();
        contentStream.showText(this.linea);
        contentStream.newLine();
        contentStream.showText(this.firma);
        contentStream.newLine();
        contentStream.showText(this.separador);
        contentStream.newLine();
        contentStream.showText(this.encabezado);
        contentStream.newLine();
        contentStream.showText(this.hash);
        contentStream.newLine();
        contentStream.showText(this.fecha);
        contentStream.newLine();
        contentStream.showText(this.recibimos);
        contentStream.newLine();
        contentStream.showText(this.concepto);
        contentStream.newLine();
        contentStream.showText(this.concepto2);
        contentStream.newLine();
        contentStream.showText(this.cantidad);
        contentStream.newLine();
        contentStream.showText(this.linea);
        contentStream.newLine();
        contentStream.showText(this.firma);
        contentStream.endText();
        contentStream.close();
        document.save(new File("C:/Users/gustavo/Desktop/nuevo.pdf"));
        document.close();
    }
    
    public void cargarTexto(Cobranza unaCobranza, Ingreso unIngreso){
        String cobrador = unaCobranza.getUnCobrador().getApellido() + " "+ unaCobranza.getUnCobrador().getNombre();
        this.hash = " codigo interno "+ unaCobranza.hashCode();
        this.encabezado = "                                                                          CELSO S.R.L ";
        this.recibimos = "Recibimos de " + cobrador;
        this.cantidad = "la cantidad de: $" + unIngreso.getAfiliado()+".-";
        this.concepto = "en concepto de: cobranza de la cartera "+ unaCobranza.getUnArea().getNombre()+ " correspondiente al año " +unaCobranza.getYear();
        this.concepto2 = "del mes " + this.unUtilitario.getMonth(unaCobranza.getMes())+".";
        this.fecha= "                                                                                                                                         "+ this.unUtilitario.obtenerFecha(unIngreso.getFecha());
        this.linea= "                                                                                                                   ................................ ";
        this.firma = "                                                                                                                       firma y aclaración ";
    }
}
