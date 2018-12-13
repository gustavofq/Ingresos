package Vista;

import Logica.CelsoFinanzas;
import Logica.Cobranza;
import java.util.ArrayList;

public class ControladorVisual {
    private CelsoFinanzas unCelsoFinanzasna;

    public ControladorVisual() {
    }

    public ControladorVisual(CelsoFinanzas unCelsoFinanzasna) {
        this.unCelsoFinanzasna = unCelsoFinanzasna;
    }

    public CelsoFinanzas getUnCelsoFinanzasna() {
        return unCelsoFinanzasna;
    }

    public void setUnCelsoFinanzasna(CelsoFinanzas unCelsoFinanzasna) {
        this.unCelsoFinanzasna = unCelsoFinanzasna;
    }
    
    //abm 
    public void agregarArea(String nombre){
        this.unCelsoFinanzasna.agregarArea(nombre);
    }
    
    public void modificarArea(String oldName, String newName){
        this.unCelsoFinanzasna.modificarArea(oldName, newName);
    }
    
    public void borrarArea(String nombre){
        this.unCelsoFinanzasna.borrarArea(nombre);
    }
    
    
    public ArrayList obtenerAreas(){
        return this.unCelsoFinanzasna.getAreas();
    }
    
    public int obtenerArea(String nombre){
        int id = 0;
        try {
           id = this.unCelsoFinanzasna.obtenerIdArea(nombre); 
        } catch (Exception e) {
            System.out.print("no se pudo obtener id area");
        }
        return id;
    }
    
    public void agregarCobrador(String nombre, String alias, String apellido, long dni, int comision){
        this.unCelsoFinanzasna.agregarCobrador(nombre, alias, apellido, dni, comision);
    }
    
    public void modificarCobrador(long oldDni, String nombre, String alias, String apellido, long dni, int comision){
        this.unCelsoFinanzasna.modificarCobrador(oldDni, nombre, alias, apellido, dni, comision);
    }
    
    public void borrarCobrador(long dni){
        this.unCelsoFinanzasna.borrarCobrador(dni);
    }
    
    public long obtenerDniCobrador(String nombre, String apellido){
        return this.unCelsoFinanzasna.obtenerDniCobrador(nombre, apellido);
    }
    
    public void agregarCobranza(Double listado, Double afiliado,int mes, int year,String concepto,long  dni,String  area){
        this.unCelsoFinanzasna.agregarCobranza(listado, afiliado, mes, year, concepto, dni, area);
    }
    
    public void modificarCobranza(int id, Double listado, Double adiliado,int mes, int year, String concepto,long  dni,String area){
        this.unCelsoFinanzasna.modificarCobranza(id, listado, adiliado, mes, year, concepto, dni, area);
    }
    
    public void borrarCobranza(int id){
        this.unCelsoFinanzasna.borrarCobranza(id);
    }
    
    public Cobranza ObtenerCobranzaPorId(int id){
        return this.unCelsoFinanzasna.obtenerCobranzaPorId(id);
    }
    
    public ArrayList obtenerCobranzas(){
        return this.unCelsoFinanzasna.getCobranzas();
    }
    
}
