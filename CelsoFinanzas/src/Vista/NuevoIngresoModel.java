/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Cobrador;
import Logica.Cobranza;
import Logica.Ingreso;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class NuevoIngresoModel extends AbstractTableModel{
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private List<Ingreso> ingresosAfiliados;
    private List<Ingreso> ingresosSP;
    private List<Cobranza> cobranzas;
    private Cobranza unaCobranzaSP;
    private String[] columnas = {"FEECHA","CONCEPTO ","AFILIADO","COMISION AF.", "SP." ,"COMISION SP.", "COBRANZA T.","COMISION T.","NETO" };
    private Utilitario unUtilitario = new Utilitario();
    
   
    public NuevoIngresoModel(Cobrador unCobrador, int year, int mes){
        cobranzas = this.unControladorVisual.obtenerCobranzasDeCobrador(unCobrador, year, mes);
        
    }
    
    @Override
    public int getRowCount() {
        return 0;
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
        /*Object value = "??";
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
        }*/
        return null;//value ;
    }
    public Ingreso getUserAt(int row) {
        return null;//ingresos.get(row);
    }
    
    private Double calcularComision(Ingreso unIngreso){
        return null;//(this.unCobranza.getUnCobrador().getUnaComision() * unIngreso.getAfiliado())/100;
    }
    
    private Double calcularNeto(Ingreso unIngreso){
        return  unIngreso.getAfiliado() - this.calcularComision(unIngreso);
    }
    
    private void setIngresos(){
        for(Cobranza unaCobranza: this.cobranzas){
            if(unaCobranza.getUnArea().getNombre().equals("Afiliados")){
                this.ingresosAfiliados = unaCobranza.getIngresos();
            }else{
                this.ingresosSP = unaCobranza.getIngresos();
            }
        }
    }
    
    
    public int determinarMayor(){
        int mayor = 0;
        if(this.ingresosAfiliados.size() >= this.ingresosSP.size()){
            mayor = this.ingresosAfiliados.size();
        }else{
            mayor = this.ingresosSP.size();
        }
       return mayor;
    }
    
}


