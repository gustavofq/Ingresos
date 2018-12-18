package Vista;

import Logica.CelsoFinanzas;
import Logica.Cobrador;
import Logica.Cobranza;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;

public class ControladorVisual {
    private CelsoFinanzas unCelsoFinanzas = new CelsoFinanzas();

    public ControladorVisual(CelsoFinanzas unCelsoFinanzas) {
        this.unCelsoFinanzas = unCelsoFinanzas;
        
    }

    public ControladorVisual() {
    }

    

    public CelsoFinanzas getUnCelsoFinanzasna() {
        return unCelsoFinanzas;
    }

    public void setUnCelsoFinanzasna(CelsoFinanzas unCelsoFinanzasna) {
        this.unCelsoFinanzas = unCelsoFinanzasna;
    }
    //abm 
    public void agregarArea(String nombre){
        this.unCelsoFinanzas.agregarArea(nombre);
    }
    
    public void modificarArea(String oldName, String newName) throws Exception{
        this.unCelsoFinanzas.modificarArea(oldName, newName);
    }
    
    public void borrarArea(String nombre) throws NonexistentEntityException{
        this.unCelsoFinanzas.borrarArea(nombre);
    }
    
    
    public List obtenerAreas(){
        return this.unCelsoFinanzas.getAreas();
    }
    
    public int obtenerArea(String nombre){
        int id = 0;
        try {
           id = this.unCelsoFinanzas.obtenerIdArea(nombre); 
        } catch (Exception e) {
            System.out.print("no se pudo obtener id area");
        }
        return id;
    }
    
    public void agregarCobrador(String nombre, String alias, String apellido, long dni, int comision){
        this.unCelsoFinanzas.agregarCobrador(nombre, alias, apellido, dni, comision);
    }
    
    public void modificarCobrador(long oldDni, String nombre, String alias, String apellido, long dni, int comision) throws Exception{
        this.unCelsoFinanzas.modificarCobrador(oldDni, nombre, alias, apellido, dni, comision);
    }
    
    public void borrarCobrador(long dni) throws NonexistentEntityException{
        this.unCelsoFinanzas.borrarCobrador(dni);
    }
    
    public long obtenerDniCobrador(String nombre, String apellido){
        return this.unCelsoFinanzas.obtenerDniCobrador(nombre, apellido);
    }
    
    public List<Cobrador> obtenerCobradores(){
        return this.unCelsoFinanzas.obtenerCobradores();
    }
    
    public Cobrador obtenerCobradorPorAlias(String alias){
        return this.unCelsoFinanzas.obtenerCobradorPorAlias(alias);
    }
    
    
    public void agregarCobranza(Double listado, Double afiliado,int mes, int year,String concepto,long  dni,String  area){
        this.unCelsoFinanzas.agregarCobranza(listado, afiliado, mes, year, concepto, dni, area);
    }
    
    public void modificarCobranza(int id, Double listado, Double adiliado,int mes, int year, String concepto,long  dni,String area) throws Exception{
        this.unCelsoFinanzas.modificarCobranza(id, listado, adiliado, mes, year, concepto, dni, area);
    }
    
    public void borrarCobranza(int id) throws NonexistentEntityException{
        this.unCelsoFinanzas.borrarCobranza(id);
    }
    
    public Cobranza ObtenerCobranzaPorId(int id){
        return this.unCelsoFinanzas.obtenerCobranzaPorId(id);
    }
    
    public List obtenerCobranzas(){
        return this.unCelsoFinanzas.getCobranzas();
    }


}
