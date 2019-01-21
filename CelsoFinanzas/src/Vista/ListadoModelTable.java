package Vista;

import Logica.Cobranza;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ListadoModelTable extends AbstractTableModel{
    private List<Cobranza> cobranzas;
    ControladorVisual unControladorVisual = new ControladorVisual();
    private String[] columnas= {"Año","Mes","Cartera","Cobrador","Listado","Cobrado","Comisión","Neto"};
    
    public ListadoModelTable(List<Cobranza> cobranzas){
        this.cobranzas = new ArrayList<>(cobranzas);
    }
    
    @Override
    public int getRowCount() {
        return this.cobranzas.size();
    }
    @Override
    public int getColumnCount() {
        return columnas.length;
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
            case 0: value = unaCobranza.getYear();
                break;
            case 1: value = unaCobranza.getMes();
                break;
            case 2: 
                if(unaCobranza.getUnArea() == null){
                    value = "-";
                }else{
                    value = unaCobranza.getUnArea().getNombre();
                }
                break;
                
            case 3: value = unaCobranza.getUnCobrador().getAlias();
                break;
            case 4: value = unaCobranza.getListado();
                break;
            case 5: 
                if(unaCobranza.calcularAfiliadoTotal() == null){
                    value = 0;
                }else{
                    value = unaCobranza.calcularAfiliadoTotal();
                }
                break;
            case 6: 
                if(unaCobranza.calcularComision() == null){
                    value = 0;
                }else{
                    value = unaCobranza.calcularComision();
                }                
                break;
            case 7: 
                if(unaCobranza.calcularNeto() == null){
                    value = 0;
                }else {
                    value = unaCobranza.calcularNeto();
                }                
                break;
        }
        return value;
    }
    
    public Cobranza getUserAt(int row) {
        return cobranzas.get(row);
    }
    
}
