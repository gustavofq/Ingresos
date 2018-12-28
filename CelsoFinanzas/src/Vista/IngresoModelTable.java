/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Cobranza;
import Logica.Ingreso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class IngresoModelTable extends AbstractTableModel{

    private List<Ingreso> ingresos;
    private String[] columnas = {"Concepto","Afiliado", "Comisión" ,"Neto"};
    
    public IngresoModelTable(List<Ingreso> ingresos){
        this.ingresos = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return this.ingresos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column]; 
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        Ingreso unIngreso = this.ingresos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = unIngreso.getConcepto();
                break;
            case 1:
                value = unIngreso.getAfiliado();
                break;
        }
        return value;
    }
    public Ingreso getUserAt(int row) {
        return this.ingresos.get(row);
    }
    
    
}
