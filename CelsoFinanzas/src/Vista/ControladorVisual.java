package Vista;

import Logica.Area;
import Logica.CelsoFinanzas;
import Logica.Cobrador;
import Logica.Cobranza;
import Logica.Ingreso;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.Calendar;
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
    //abm Areas
    public void agregarArea(String nombre){
        this.unCelsoFinanzas.agregarArea(nombre);
    }
    
    public void modificarArea(String oldName, String newName) throws Exception{
        this.unCelsoFinanzas.modificarArea(oldName, newName);
    }
    
    public void borrarArea(int id) throws NonexistentEntityException{
        this.unCelsoFinanzas.borrarArea(id);
    }
    
    
    public List<Area> obtenerAreas(){
        return this.unCelsoFinanzas.obtenerAreas();
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
    //fin abm areas
    //abm cobrador 
    public void agregarCobrador(String nombre, String alias, String apellido, long dni, int comision){
        this.unCelsoFinanzas.agregarCobrador(nombre, alias, apellido, dni, comision);
    }
    
    public void modificarCobrador(long oldDni, String nombre, String alias, String apellido, long dni, int comision) throws Exception{
        this.unCelsoFinanzas.modificarCobrador(oldDni, nombre, alias, apellido, dni, comision);
    }
    
    public void borrarCobrador(long dni) throws NonexistentEntityException{
        this.unCelsoFinanzas.borrarCobrador(dni);
    }
    
    public List<Area> obtenerAlias(){
        return this.unCelsoFinanzas.obtenerAlias();
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
    //fin abm cobrador
    //
    
    public void agregarCobranza(Double listado, int mes, int year, Cobrador unCobrador,Area unArea){
        this.unCelsoFinanzas.agregarCobranza(listado, mes, year, unCobrador,unArea);
    }
    
    public void modificarCobranza(int id, Double listado, Double adiliado,int mes, int year,long  dni,String area) throws Exception{
        this.unCelsoFinanzas.modificarCobranza(id, listado, adiliado, mes, year, dni, area);
    }
    
    public void borrarCobranza(int id) throws NonexistentEntityException{
        this.unCelsoFinanzas.borrarCobranza(id);
    }
    
    public Cobranza ObtenerCobranzaPorId(int id){
        return this.unCelsoFinanzas.obtenerCobranzaPorId(id);
    }
    
    public List<Cobranza> obtenerCobranzas(){
        return this.unCelsoFinanzas.obtenerCobranzas();
    }
    
    public List<Cobranza> obenerCobranzasDeCobrador(Cobrador unCobrador, int year){
        return this.unCelsoFinanzas.obenerCobranzasDeCobrador(unCobrador, year);
    }
    
    public List<Cobranza> obenerCobranzasDeCobrador(Cobrador unCobrador, int year, Area unArea){
        return this.unCelsoFinanzas.obenerCobranzasDeCobrador(unCobrador, year, unArea);
    }
    
    public void agregarIngreso(Double Afiliado, String concepto, Calendar fecha, Cobranza unaCobranza){
        this.unCelsoFinanzas.agregarIngreso(Afiliado, concepto, fecha, unaCobranza);
    }
    
    public Ingreso obtenerIngreso(int id){
        return this.unCelsoFinanzas.obtenerIngreso(id);
    }
    
    public List<Ingreso> obtenerIngresos( int id){
        return this.unCelsoFinanzas.obtenerIngresos(id);
    }
    
    public Double calcularAfiliado(int idCobranza){
        return this.unCelsoFinanzas.calcularAfiliado(idCobranza);
    }
    
    public Double calcularNeto(int idCobranza){
        return this.unCelsoFinanzas.calcularNeto(idCobranza);
    }
    
    public Double calcularComision(int idCobranza){
        return this.unCelsoFinanzas.calcularComision(idCobranza);
    }
    
    public boolean cobranzaPagada(int idCobranza){
        return this.unCelsoFinanzas.cobranzaPagada(idCobranza);
    }
}
