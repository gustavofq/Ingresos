/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author gustavo
 */
public class RenderMonto extends DefaultTableCellRenderer{
    private int listado ;
    private int ingreso;

    public RenderMonto(int listado, int ingreso) {
        this.listado = listado;
        this.ingreso = ingreso;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Font font= new Font("Courier", Font.BOLD,18);
        table.setForeground(Color.black);
        JLabel label= (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(!hasFocus){
            if(table.getValueAt(row, listado)!= null && table.getValueAt(row, ingreso)!= null ){
                if((Double)table.getValueAt(row, listado) 
                        <= (Double)table.getValueAt(row, ingreso) 
                        && ((Double)table.getValueAt(row, listado)!=0)){
                    label.setBackground(Color.green);
                }else {
                    if  ((Double)table.getValueAt(row, listado)!=0.0) {
                        label.setBackground(Color.red);
                    }
                }
                if(((Double)table.getValueAt(row, listado)==0.0)){
                    label.setBackground(null);
                }
            }
            
        }
        if(column!= 1){
            label.setBackground(null);
        }
        if(isSelected){
            label.setBackground(Color.LIGHT_GRAY);
        }
        label.setForeground(Color.BLACK);
        label.setFont(font);
        return label;
    }
}
