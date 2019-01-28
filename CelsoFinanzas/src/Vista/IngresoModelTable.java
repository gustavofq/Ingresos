package Vista;

import Logica.Cobranza;
import Logica.Ingreso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class IngresoModelTable extends AbstractTableModel{
    private List<Ingreso> ingresos;
    private Cobranza unCobranza;
    private String[] columnas = {"Fecha","Concepto","Afiliado", "Comisión" ,"Neto", "Pagado"};
    private Utilitario unUtilitario = new Utilitario();
    
    @Deprecated 
    public IngresoModelTable(List<Ingreso> ingresos){
        this.ingresos = new ArrayList<>(ingresos);
    }
    
    public IngresoModelTable(Cobranza unaCobranza){
        this.ingresos = unaCobranza.getIngresos();
        this.unCobranza = unaCobranza;
    }
    
    @Override
    public int getRowCount() {
        return this.ingresos.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
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
                if(this.calcularComision(unIngreso) == null){
                    value = 0;
                }else{
                    value = this.calcularComision(unIngreso);
                }
                
                break;
            case 4: 
                value = this.calcularNeto(unIngreso);
                break;
            case 5: 
                value = unIngreso.getPagado();
                break;
        }
        return value;
    }
    public Ingreso getUserAt(int row) {
        return ingresos.get(row);
    }
    
    private Double calcularComision(Ingreso unIngreso){
        return (this.unCobranza.getUnCobrador().getUnaComision() * unIngreso.getAfiliado())/100 ;
    }
    
    private Double calcularNeto(Ingreso unIngreso){
        return  unIngreso.getAfiliado() - this.calcularComision(unIngreso);
    }
}
