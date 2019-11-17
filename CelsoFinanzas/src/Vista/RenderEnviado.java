
package Vista;

import Logica.Convenio;
import Logica.Produccion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderEnviado extends DefaultTableCellRenderer {
    private int year;
    private Convenio unConvenio;
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private int[] enviadosMail = new int[12];
    
    
    public RenderEnviado() {
    }

    public RenderEnviado(int year, Convenio unConvenio) {
        this.year = year;
        this.unConvenio = unConvenio;
    }
    
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Font font= new Font("Courier", Font.BOLD,18);
        JLabel label= (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(!hasFocus){
           if(column ==1){
               if(unControladorVisual.obtenerProducciones(0, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(0, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row ==0){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(0, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==0){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(0, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==0){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(1, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(1, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 1){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(1, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row == 1){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(1, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==1){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(2, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(2, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 2){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(2, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==2){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(2, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==2){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(3, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(3, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 3){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(3, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row == 3){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(3, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==3){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(4, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(4, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 4){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(4, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==4){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(4, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==4){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(5, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(5, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 5){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(5, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==5){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(5, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==5){
                       label.setBackground(null);
                   }
               }
           }
           if(column ==1){
               if(unControladorVisual.obtenerProducciones(6, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(6, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 6){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(6, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==6){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(6, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==6){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(7, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(7, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 7){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(7, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==7){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(7, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==7){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(8, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(8, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 8){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(8, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==8){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(8, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==8){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(9, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(9, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 9){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(9, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==9){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(9, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==9){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(10, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(10, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 10){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(10, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==10){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(10, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==10){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(11, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(11, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 11){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(11, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==11){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(11, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==11){
                       label.setBackground(null);
                   }
               }
           }
           else{
               setBackground(null);
           }
        }
        if(isSelected){
            if(column ==1){
               if(unControladorVisual.obtenerProducciones(0, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(0, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row ==0){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(0, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==0){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(0, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==0){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(1, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(1, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 1){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(1, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==1){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(1, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==1){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(2, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(2, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 2){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(2, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==2){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(2, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==2){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(3, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(3, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 3){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(3, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==3){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(3, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==3){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(4, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(4, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 4){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(4, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==4){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(4, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==4){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(5, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(5, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 5){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(5, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==5){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(5, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==5){
                       label.setBackground(null);
                   }
               }
           }
           if(column ==1){
               if(unControladorVisual.obtenerProducciones(6, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(6, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 6){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(6, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==6){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(6, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==6){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(7, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(7, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 7){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(7, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==7){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(7, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==7){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(8, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(8, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 8){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(8, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==8){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(8, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==8){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(9, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(9, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 9){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(9, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==9){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(9, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==9){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(10, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(10, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 10){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(10, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==10){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(10, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==10){
                       label.setBackground(null);
                   }
               }
           }if(column ==1){
               if(unControladorVisual.obtenerProducciones(11, year, unConvenio)!=null)
               if(unControladorVisual.obtenerProducciones(11, year, unConvenio).getEstado().contains("enviado por mail.")){
                   if(row == 11){
                       label.setBackground(Color.yellow);
                   }
               }else if(unControladorVisual.obtenerProducciones(11, year, unConvenio).getEstado().contains("enviado fisicamente.")){
                   if(row ==11){
                       label.setBackground(Color.GREEN);
                   }
               }else if(unControladorVisual.obtenerProducciones(11, year, unConvenio).getEstado().contains("no enviado.")){
                   if(row ==11){
                       label.setBackground(null);
                   }
               }
           }
           else{
               setBackground(null);
           }
        }
        
       
        label.setForeground(Color.BLACK);
        label.setFont(font);
        return label;
    }
    
    
}
