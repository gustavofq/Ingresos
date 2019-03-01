package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderCelda extends DefaultTableCellRenderer{
    private final int columna_patron;
    private final int fila;

    public RenderCelda(int columna_patron, int fila) {
        this.columna_patron = columna_patron;
        this.fila = fila;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Font font= new Font("Courier", Font.BOLD,16);
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(column == columna_patron  && fila == row){
            c.setForeground(Color.GREEN);
        }
        
        return c;
    }
    
    
    
}
