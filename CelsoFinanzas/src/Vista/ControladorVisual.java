package Vista;

import Logica.Area;
import Logica.CelsoFinanzas;
import Logica.Cobrador;
import Logica.Cobranza;
import Logica.Ingreso;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Persistencia.exceptions.ViolacionClaveForaneaException;
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
    public void agregarArea(String nombre) throws PreexistingEntityException{
        this.unCelsoFinanzas.agregarArea(nombre);
    }
    
    public void modificarArea(Area unArea) throws Exception{
        this.unCelsoFinanzas.modificarArea(unArea);
    }
    
    public void borrarArea(int id) throws NonexistentEntityException, ViolacionClaveForaneaException{
        this.unCelsoFinanzas.borrarArea(id);
    }
    
    public List<Area> obtenerAreas(){
        return this.unCelsoFinanzas.obtenerAreas();
    }
    
    //fin abm areas
    //abm cobrador 
    public void agregarCobrador(String nombre, String alias, String apellido, long dni, int comision){
        this.unCelsoFinanzas.agregarCobrador(nombre, alias, apellido, dni, comision);
    }
    
    public void modificarCobrador(Cobrador unCobrador) throws Exception{
        this.unCelsoFinanzas.modificarCobrador(unCobrador);
    }
    
    public void borrarCobrador(long dni) throws NonexistentEntityException{
        this.unCelsoFinanzas.borrarCobrador(dni);
    }
  
    public List<Cobrador> obtenerCobradores(){
        return this.unCelsoFinanzas.obtenerCobradores();
    }
    //fin abm cobrador
    //abm cobranza
    public void agregarCobranza(Double listado, int mes, int year, Cobrador unCobrador,Area unArea){
        this.unCelsoFinanzas.agregarCobranza(listado, mes, year, unCobrador,unArea);
    }
    
    public void borrarCobranza(int id) throws NonexistentEntityException, ViolacionClaveForaneaException{
        this.unCelsoFinanzas.borrarCobranza(id);
    }
    
    public List<Cobranza> obtenerCobranzas(){
        return this.unCelsoFinanzas.obtenerCobranzas();
    }
    
    public List<Cobranza> obenerCobranzasDeCobrador(Cobrador unCobrador, int year){
        return this.unCelsoFinanzas.obenerCobranzasDeCobrador(unCobrador, year);
    }
    
    public void agregarIngreso(Cobranza unaCobranza, Ingreso unIngreso) throws Exception{
        this.unCelsoFinanzas.agregarIngreso(unaCobranza, unIngreso);
    }
}