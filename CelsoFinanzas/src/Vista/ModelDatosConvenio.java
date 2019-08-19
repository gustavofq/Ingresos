
package Vista;

import Logica.Produccion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelDatosConvenio extends AbstractTableModel {

    private Utilitario unUtilitario = new Utilitario();
    private List<Produccion> producciones;
    private String[] columnas = {"MES","PRODUC.","N° FACT.", "COBRADO" ,"FECHA"};
    
    public ModelDatosConvenio(List<Produccion> producciones){
        this.producciones = new ArrayList<>(producciones);
    }
    
    @Override
    public int getRowCount() {
        
        return 12;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column]; 
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(rowIndex== 0 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 1 && columnIndex == 0) aValue = "febrero";
        if(rowIndex== 2 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 3 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 4 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 5 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 6 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 7 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 8 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 9 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 10 && columnIndex == 0) aValue = "Enero";
        if(rowIndex== 11 && columnIndex == 0) aValue = "Enero";
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
       Produccion unaProduccion = this.producciones.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                if(unaProduccion.getMes()==rowIndex){
                    value = this.unUtilitario.getMonth(unaProduccion.getMes());
                }else{
                    value = this.unUtilitario.getMonth(rowIndex);
                }
                break;
            case 1:
                if(unaProduccion.getProducido()== null)value = 0;
                else value = unaProduccion.getProducido(); 
                break;
            case 2:
                value = unaProduccion.getnFactura();
                break;
            case 3:
                if(unaProduccion.getImporteCobrador() == null) value = 0;
                else value = unaProduccion.getImporteCobrador();
                break;
            case 4: 
                if(unaProduccion.getFechaCobrado() != null){
                  value = this.unUtilitario.obtenerFecha(unaProduccion.getFechaCobrado());
                }else{ 
                    value = "";
                }
                break;
            }
        
        return value;
    }
    
    public Produccion getUserAt(int row) {
        return producciones.get(row);
    }
}
