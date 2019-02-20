package Vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderCelda extends DefaultTableCellRenderer{
    private JLabel componente;
    private int fila;
    private int columna;

    public RenderCelda(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if((table.getSelectedRow()!=0)&&(isSelected)){
            componente.setBackground(Color.GREEN);
        }
       
        return componente;
    }
    
}
