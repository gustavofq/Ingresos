
package Vista;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormatSymbols;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class Utilitario {

    public Utilitario() {
    }
    
    /**Determina si la cadena es Long.
     *@param texto String a comprobar si es Long.
     *@return      true si es Long, false si no es Long.
     */
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
     
    /**Limpia todos los jTextField y JPasswordField contenidos en un JPanel.
     *@param panel JPanel que contiene los JTextFiel y JPasswordField a limpiar.
     */ 
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
    
    /**Carga JComboBox con una lista de String.
     *@param items List de objetos a cargar.
     *@param unCombo JComboBox el cual se cargará.
     */
    @Deprecated
    public void cargarCombo(List items, JComboBox unCombo){
        unCombo.removeAllItems();
        Iterator it = items.iterator();
        Object unObjeto = new Object();
        while(it.hasNext()){
            unObjeto = (Object) it.next();
            unCombo.addItem(unObjeto.toString());
        }
    }
    /**Carga JComboBox con una lista de objetos.
     *@param items List de objetos a cargar.
     *@param unCombo JComboBox el cual se cargará.
     */
    public void cargarComboObjeto(List items, JComboBox unCombo){
        unCombo.removeAllItems();
        Iterator it = items.iterator();
        Object unObjeto = new Object();
        while(it.hasNext()){
            unObjeto = (Object) it.next();
            unCombo.addItem(unObjeto);
        }
    }
    
     /**Comprueba si todos los JTextFiel y JPasswordField contienen datos.
     *@param panel JPanel que contiene los elementos a comprobar.
     *@return true si los elementos contiene datos, false si los elementos no c
     * contiene datos.
     */
     public boolean campoCompleto(JPanel panel){
        boolean completo = true;
        int i = 0;
        while((i  < panel.getComponents().length)&&(completo)){
            if(panel.getComponents()[i] instanceof JTextField){
                String texto = ((JTextField) panel.getComponents()[i]).getText();
                if(texto.equals("")){
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
    
    public boolean comboBoxCompleto(JPanel panel){
        boolean completo = true;
        int i = 0;
        while((i  < panel.getComponents().length)&&(completo)){
            if(panel.getComponents()[i] instanceof JComboBox){
                if(((JComboBox) panel.getComponents()[i]).getSelectedIndex() == -1){
                    completo = false;
                }
            }
            i++;
        }
        return completo;
    }
     
    /**Establece el año actual en un JTextField. 
     *@param unCampo <code>JTextField</code> en el cual se establecerá el año actual.
     */
    public void cargarAnhoActual(JTextField unCampo){
        Calendar cal= Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        unCampo.setText(Integer.toString(year));
    }
    
    /** Establece el mes actual en un JMonthChooser.
     *@param unMonthChooser <code>JMonthChooser</code> el cual se establecerá.
     */ 
    public void cargarMesActual(JMonthChooser unMonthChooser){
        Calendar cal = Calendar.getInstance();
        int mes = cal.get(Calendar.MONTH);
        unMonthChooser.setMonth(mes);
    }
    /**Establece la fecha actual.
     * @param jdc JDateChooser el cual se establecerá la fecha actual.
     */
    public void cargarFechaActual(JDateChooser jdc){
        Calendar cal = Calendar.getInstance();
        jdc.setCalendar(cal);
    }
    
    /**Limpia todos los valores contenidios en un Jtable.
     *@param tabla   Jtable el cual se limpiará.  
     */
    public void LimpiarTabla(JTable tabla){
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) tabla.getModel();
        int fila = tabla.getRowCount();
        for (int i = 0; i < fila ; i++){
            model.removeRow(0);
        }
    }
    
    /**Conbrueba si una cadena es numerica.
     *@param cadena String a comprobar
     *@return true si es numerico, false si no es numerico.
     */
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
    
    public boolean isDouble(String cadena){
        boolean esNumerico = false;
	try {
		Double.parseDouble(cadena);
		esNumerico = true;
	} catch (NumberFormatException nfe){
		esNumerico = false;
	}
        return esNumerico;
    }
    
    /**Convierte Calendar a String en formato dd/MM/yyyy.
     *@param fecha Calendar a transformar.
     *@return String con el formato dd/MM/yyyy del Calendar.
     */
    public String obtenerFecha(Calendar fecha){
       Calendar cal = fecha;
       Date dat = cal.getTime();
       String s = "";
       if(dat != null){
           Format formatter = new SimpleDateFormat("dd/MM/yyyy");
           s = formatter.format(dat);
       }else{
           s="-";
       }
       
       return s;
    }
    
    /**elimina el caracter que no sea numerico.
     *@param text JtexField el cual se eliminará el caracter no numerico.
     */
    public void borrarLetra(JTextField text){
        if(text.getText().length()>=1){
            if(!isNumeric(text.getText())){
                String cadena =  text.getText();
                String cadena2 = cadena.substring(0, (cadena.length())-1);
                text.setText(cadena2);
            }
        }
    }
    
    /**elimina el caracter que supera el parametro de cantidad.
     *@param cantidad tamaño maximo.
     *@param text JtexField el cual se limitará.
     */
    public void limitarLetra(int cantidad, JTextField text){
        if(text.getText().length()>=0){
            if(text.getText().length()>cantidad){
                String cadena =  text.getText();
                String cadena2 = cadena.substring(0, cantidad);
                text.setText(cadena2);
            }
        }
    }
    
    public void limitChars(JTextField textField, int cant){
        textField.setColumns(cant);
        PlainDocument doc = (PlainDocument) textField.getDocument();
        doc.setDocumentFilter(new MyIntFilter());
    }
    
    public void posicionarCombo(JComboBox combo, Object object){
        int i = combo.getItemCount() -1;
        boolean listo = false;
        while((i>=0)&&(listo == false)){
            if(combo.getItemAt(i).toString().equals(object.toString())){
                combo.setSelectedIndex(i);
                listo = true;
            }
            i--;
        }
    }
    
    public void marcarCamposVacios(JPanel panel){
        int i = 0;
        while((i  < panel.getComponents().length)){
            if(panel.getComponents()[i] instanceof JTextField){
                String texto = ((JTextField) panel.getComponents()[i]).getText();
                if(texto.equals("")){
                    ((JTextField) panel.getComponents()[i]).setBackground(Color.getHSBColor(249, 114, 85));
                }
            }
            i++;
        }
    }
    
    public void desmarcarCamposVacios(JTextField texto){
        texto.setBackground(Color.white);
    }
    
    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month];
    }
    
    public void CambiarEncabezado(JTable table, Font unaFuente){
        JTableHeader th = table.getTableHeader();
        th.setFont(unaFuente);
        table.setTableHeader(th);
    }
    
    public void establecerFormato(JPanel panel, Font unaFuente){
        int i = 0;
        while((i  < panel.getComponents().length)){
            if(panel.getComponents()[i] instanceof JLabel){
                ((JLabel) panel.getComponents()[i]).setFont(unaFuente);
            }
            i++;
        }
    }
    
    class MyIntFilter extends DocumentFilter {
    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.insert(offset, string);
        if (test(sb.toString())) {
            super.insertString(fb, offset, string, attr);
        } else {
         // warn the user and don't allow the insert
        }
    }

   private boolean test(String text) {
        try {
            Integer.parseInt(text);
            return true;
            
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,AttributeSet attrs) throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.replace(offset, offset + length, text);
        if (test(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            // warn the user and don't allow the insert
        }
    }
}
}

