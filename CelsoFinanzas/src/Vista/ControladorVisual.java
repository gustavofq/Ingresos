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
    public void agregarCobrador(String nombre, String alias, String apellido, long dni, int comision) throws PreexistingEntityException{
        this.unCelsoFinanzas.agregarCobrador(nombre, alias, apellido, dni, comision);
    }
    
    public void modificarCobrador(Cobrador unCobrador) throws Exception{
        this.unCelsoFinanzas.modificarCobrador(unCobrador);
    }
    
    public void borrarCobrador(long dni) throws NonexistentEntityException, ViolacionClaveForaneaException{
        this.unCelsoFinanzas.borrarCobrador(dni);
    }
  
    public List<Cobrador> obtenerCobradores(){
        return this.unCelsoFinanzas.obtenerCobradores();
    }
    //fin abm cobrador
    //abm cobranza
    public void agregarCobranza(Double listado, int mes, int year, Cobrador unCobrador,Area unArea) throws PreexistingEntityException{
        this.unCelsoFinanzas.agregarCobranza(listado, mes, year, unCobrador,unArea);
    }
    
    public void modificarCobranza(Cobranza unaCobranza) throws Exception{
        this.unCelsoFinanzas.modificarCobranza(unaCobranza);
    } 
    
    public void borrarCobranza(int id) throws NonexistentEntityException, ViolacionClaveForaneaException{
        this.unCelsoFinanzas.borrarCobranza(id);
    }
    
    public List<Cobranza> obtenerCobranzas(){
        return this.unCelsoFinanzas.obtenerCobranzas();
    }
    
    public List<Cobranza> obenerCobranzasDeCobrador(Cobrador unCobrador, int year){
        return this.unCelsoFinanzas.obtenerCobranzasDeCobrador(unCobrador, year);
    }
    
    public List<Cobranza> obtenerCobranzaDeCartera(Area unArea, int year){
        return this.unCelsoFinanzas.obtenerCobranzaDeCartera(unArea, year);
    }
    public List<Cobranza> cobranzasDeCartera(Area unArea, int year){
        return this.unCelsoFinanzas.obtenerCobranzaDeCartera(unArea, year);
    }
    
    public void agregarIngreso(Cobranza unaCobranza, Ingreso unIngreso) throws Exception{
        this.unCelsoFinanzas.agregarIngreso(unaCobranza, unIngreso);
    }
    
    public void borrarIngreso(Cobranza unaCobranza, Ingreso unIngreso) throws Exception{
        this.unCelsoFinanzas.borrarIngreso(unaCobranza, unIngreso);
    }
    
    public void modificarIngreso(Cobranza unaCobranza, Ingreso oldIngreso, Ingreso newIngreso) throws Exception{
        this.unCelsoFinanzas.modificarIngreso(unaCobranza, oldIngreso, newIngreso);
    }
    
    public List<Cobranza> obtenerCobrnzasYear(int year){
        return this.unCelsoFinanzas.obtenerCobrnzasYear(year);
    }
    
    public List<Cobranza> obtenerCobranzasArea(Area unArea, int year){
        return this.unCelsoFinanzas.obtenerCobranzasArea(unArea, year);
    }
    
    public List<Cobranza> obtenerCobranzasAreaCobrador(Area unArea, int year,Cobrador unCobrador){
        return this.unCelsoFinanzas.obtenerCobranzasAreaCobrador(unArea, year, unCobrador);
    }
    
    public double obtenerListadoDelCobrador(Cobrador unCobrador, int year , int mes){
        return this.unCelsoFinanzas.obtenerListadoDelCobrador(unCobrador, year, mes);
    }
    
    public double obtenerAfiliadoDelCobrador(Cobrador unCobrador, int year , int mes){
        return this.unCelsoFinanzas.obtenerAfiliadoDelCobrador(unCobrador, year, mes);
    }
    
    public double obtenerComisionDelCobrador(Cobrador unCobrador, int year , int mes){
        return this.unCelsoFinanzas.obtenerComisionDelCobrador(unCobrador, year, mes);
    }
    
    public double obtenerNetoDelCobrador(Cobrador unCobrador, int year , int mes){
        return this.unCelsoFinanzas.obtenerNetoDelCobrador(unCobrador, year, mes);
    }
}