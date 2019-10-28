
package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderEnviado extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Font font= new Font("Courier", Font.BOLD,18);
        table.setForeground(Color.black);
        JLabel label= (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(!hasFocus){
            if(label.getText().contains("(pagado)")){
                label.setBackground(Color.green);
            }else{
                setBackground(null);
            }
        }
        
        if(isSelected){
            setBackground(Color.LIGHT_GRAY);
        }
        
        label.setForeground(Color.BLACK);
        label.setFont(font);
        return label;
    }
    
    
}
