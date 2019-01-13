
package Vista;

import com.toedter.calendar.JMonthChooser;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Utilitario {

    public Utilitario() {
    }
    
    
     public boolean isLong(String texto){
         boolean isLong = true;
         try {
            Long.parseLong(texto);
            isLong = true;
        } catch (NumberFormatException excepcion) {
            isLong = false;
        }
         return isLong;
     }
     
    public void LimpiarCaja(JPanel panel){
        for(int i = 0; panel.getComponents().length > i; i++){
            if(panel.getComponents()[i] instanceof JTextField){
                ((JTextField)panel.getComponents()[i]).setText("");
            }
            else if(panel.getComponents()[i] instanceof JPasswordField){
                ((JPasswordField)panel.getComponents()[i]).setText("");
            }
        }
    }
    
    public void cargarCombo(List items, JComboBox unCombo){
        unCombo.removeAllItems();
        Iterator it = items.iterator();
        Object unObjeto = new Object();
        while(it.hasNext()){
            unObjeto = (Object) it.next();
            unCombo.addItem(unObjeto.toString());
        }
    }
    
     public void cargarComboObjeto(List items, JComboBox unCombo){
        unCombo.removeAllItems();
        Iterator it = items.iterator();
        Object unObjeto = new Object();
        while(it.hasNext()){
            unObjeto = (Object) it.next();
            unCombo.addItem(unObjeto);
        }
    }
    
     
     public boolean campoCompleto(JPanel panel){
        boolean completo = true;
        int i = 0;
        while((i  < panel.getComponents().length)&&(completo)){
            if(panel.getComponents()[i] instanceof JTextField){
                String texto = ((JTextField) panel.getComponents()[i]).getText();
                if(texto.length() == 0){
                    completo = false;
            
            }
            }
            else if(panel.getComponents()[i] instanceof JPasswordField){
                if(((JPasswordField)panel.getComponents()[i]).getPassword().equals(" "));
                    completo = false;
            }
            i++;
        }
        return completo;
    }
     
    public void cargarAnhoActual(JTextField unCampo){
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        unCampo.setText(Integer.toString(year));
    }
     
    public void cargarMesActual(JMonthChooser unMonthChooser){
        Calendar cal = Calendar.getInstance();
        int mes = cal.get(Calendar.MONTH);
        unMonthChooser.setMonth(mes);
    }
    
    public void LimpiarTabla(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tabla.getModel();
        int fila = tabla.getRowCount();
        for (int i = 0; i < fila ; i++){
            model.removeRow(0);
        }
    }
    
    public boolean isNumeric(String cadena){
        boolean esNumerico = false;
	try {
		Integer.parseInt(cadena);
		esNumerico = true;
	} catch (NumberFormatException nfe){
		esNumerico = false;
	}
        return esNumerico;
    }
}

