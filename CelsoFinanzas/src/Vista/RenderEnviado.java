
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
    private int[] estados = new int[12];
    
    
    
    public RenderEnviado() {
    }

    public RenderEnviado(int year, Convenio unConvenio) {
        this.year = year;
        this.unConvenio = unConvenio;
        this.cargarEstados();
    }
    
    private void cargarEstados(){
        
        for(Produccion unaProduccion : unControladorVisual.obtenerProducciones(year, unConvenio)){
            estados[unaProduccion.getMes()]=unaProduccion.obtenerEstado();
            
        }
               
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //Cells are by default rendered as a JLabel.
    JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    
    
    if(!hasFocus){
        if(column==1){
        if(row==0){
            if(estados[0]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[0]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==1){
            if(estados[1]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[1]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==2){
            if(estados[2]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[2]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==3){
            if(estados[3]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[3]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==4){
            if(estados[4]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[4]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==5){
            if(estados[5]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[5]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==6){
            if(estados[6]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[6]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==7){
            if(estados[7]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[7]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==8){
            if(estados[8]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[8]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==9){
            if(estados[9]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[9]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==10){
            if(estados[10]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[10]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
        if(row==11){
            if(estados[11]==1){//enviado fisicamente (verde)
                l.setBackground(Color.green);
            }else if(estados[11]==-1){//enviado por correo electronico (amarillo)
                l.setBackground(Color.yellow);
            }else{//no enviado (blanco)
                l.setBackground(null);
            }
        }
    }else{
        l.setBackground(null);
    }
    }
    if(isSelected){
        l.setBackground(Color.blue);
    }
    
    return l;
    }
    
    
}
