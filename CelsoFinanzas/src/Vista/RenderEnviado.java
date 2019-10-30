
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
    
    
    public RenderEnviado() {
    }

    public RenderEnviado(int year, Convenio unConvenio) {
        this.year = year;
        this.unConvenio = unConvenio;
    }
    
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Font font= new Font("Courier", Font.BOLD,18);
        table.setForeground(Color.black);
        JLabel label= (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(!hasFocus){
            for(Produccion unaProduccion: this.unControladorVisual.obtenerProducciones(year, unConvenio)){
                if(unaProduccion.getEstado().contains("enviado por mail.")){
                    if(column ==1){
                        label.setBackground(Color.YELLOW);
                    }
                
                }else{
                    setBackground(null);
                }
            }
             setBackground(null);
        }
        
        if(isSelected){
            setBackground(Color.LIGHT_GRAY);
        }
        
        label.setForeground(Color.BLACK);
        label.setFont(font);
        return label;
    }
    
    
}
