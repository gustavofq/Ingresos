/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Cobranza;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class ListadoModelTable extends AbstractTableModel{
    private List<Cobranza> cobranzas;
    private String[] columnas= {"Listado","Cobrado","Comisión","Neto"};
    
    public ListadoModelTable(List<Cobranza> cobranzas){
        this.cobranzas = new ArrayList<>(cobranzas);
    }
    
    @Override
    public int getRowCount() {
        return this.cobranzas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        Cobranza unaCobranza = this.cobranzas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = unaCobranza.getYear();
                break;
            case 1:
                value = unaCobranza.getMes();
                break;
            case 2:
                if(unaCobranza.getUnArea() == null){
                    value = "-";
                }else{
                    value = unaCobranza.getUnArea().getNombre();
                }
                
                break;
            case 3:
                value = unaCobranza.getUnCobrador();
                break;
        }
        return value;
    }
    
    public Cobranza getUserAt(int row) {
        return cobranzas.get(row);
    }
    
}
