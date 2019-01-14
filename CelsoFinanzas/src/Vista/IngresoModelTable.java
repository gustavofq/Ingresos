/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Ingreso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class IngresoModelTable extends AbstractTableModel{
    private List<Ingreso> ingresos;
    private String[] columnas = {"Fecha","Concepto","Afiliado", "Comisión" ,"Neto"};
    private Utilitario unUtilitario = new Utilitario();
    
    public IngresoModelTable(List<Ingreso> ingresos){
        this.ingresos = new ArrayList<>(ingresos);
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
                value = this.unUtilitario.obtenerFecha(unIngreso.getFecha());
                break;
            case 1:
                value = unIngreso.getConcepto();
                break;
            case 2:
                value = unIngreso.getAfiliado();
                break;
            case 3: 
                value = 0;
            case 4: 
                value = 0;
        }
        return value;
    }
    public Ingreso getUserAt(int row) {
        return ingresos.get(row);
    }
    
    
}
