package Vista;

import Logica.Area;
import Logica.CelsoFinanzas;
import Logica.Cobrador;
import Logica.Cobranza;
import Logica.Ingreso;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Persistencia.exceptions.ViolacionClaveForaneaException;
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
   
    public List<Cobranza> obtenerCobranzasDeCobrador(Cobrador unCobrador, int year){
        return this.unCelsoFinanzas.obtenerCobranzasDeCobrador(unCobrador, year);
    }
    
    public List<Cobranza> obtenerCobranzasDeCobrador(Cobrador unCobrador, int year, int mes){
        return this.unCelsoFinanzas.obtenerCobranzasDeCobrador(unCobrador, year, mes);
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
    
    public List<Calendar> obtenerFechas(Cobrador unCobrador, int year, int mes){
        return this.unCelsoFinanzas.obtenerFechas(unCobrador, year, mes);
    }
    
    public List<Cobranza> obtenerCobrnzasYear(int year){
        return this.unCelsoFinanzas.obtenerCobranzasYear(year);
    }
    
    public List<Cobranza> obtenerCobranzasArea(Area unArea, int year){
        return this.unCelsoFinanzas.obtenerCobranzasArea(unArea, year);
    }
    
    public List<Cobranza> obtenerCobranzasAreaCobrador(Area unArea, int year,Cobrador unCobrador){
        return this.unCelsoFinanzas.obtenerCobranzasAreaCobrador(unArea, year, unCobrador);
    }
    
    //obtener listados
    
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
    
    public double obtenerListadoDelCobrador(Cobrador unCobrador, int year , int mes, Area unArea){
        return this.unCelsoFinanzas.obtenerListadoDelCobrador(unCobrador, year, mes,unArea);
    }
    
    public double obtenerAfiliadoDelCobrador(Cobrador unCobrador, int year , int mes, Area unArea){
        return this.unCelsoFinanzas.obtenerAfiliadoDelCobrador(unCobrador, year, mes,unArea);
    }
    
    public double obtenerComisionDelCobrador(Cobrador unCobrador, int year , int mes, Area unArea){
        return this.unCelsoFinanzas.obtenerComisionDelCobrador(unCobrador, year, mes,unArea);
    }
    
    public double obtenerNetoDelCobrador(Cobrador unCobrador, int year , int mes, Area unArea){
        return this.unCelsoFinanzas.obtenerNetoDelCobrador(unCobrador, year, mes,unArea);
    }
    
    public double obtenerListadoDelCobrador(Cobrador unCobrador, int year){
        return this.unCelsoFinanzas.obtenerListadoDelCobrador(unCobrador, year);
    }
    
    public double obtenerAfiliadoDelCobrador(Cobrador unCobrador, int year ){
        return this.unCelsoFinanzas.obtenerAfiliadoDelCobrador(unCobrador, year);
    }
    
    public double obtenerComisionDelCobrador(Cobrador unCobrador, int year ){
        return this.unCelsoFinanzas.obtenerComisionDelCobrador(unCobrador, year);
    }
    
    public double obtenerNetoDelCobrador(Cobrador unCobrador, int year ){
        return this.unCelsoFinanzas.obtenerNetoDelCobrador(unCobrador, year);
    }
    
    public double obtenerListadoDelCobrador(Cobrador unCobrador, int year, Area unArea){
        return this.unCelsoFinanzas.obtenerListadoDelCobrador(unCobrador, year,unArea);
    }
    
    public double obtenerAfiliadoDelCobrador(Cobrador unCobrador, int year, Area unArea ){
        return this.unCelsoFinanzas.obtenerAfiliadoDelCobrador(unCobrador, year,unArea);
    }
    
    public double obtenerComisionDelCobrador(Cobrador unCobrador, int year , Area unArea){
        return this.unCelsoFinanzas.obtenerComisionDelCobrador(unCobrador, year,unArea);
    }
    
    public double obtenerNetoDelCobrador(Cobrador unCobrador, int year , Area unArea){
        return this.unCelsoFinanzas.obtenerNetoDelCobrador(unCobrador, year,unArea);
    }
    
    //valore por area
    
    public double obtenerListadoDeArea(int year, Area unArea){
        return this.unCelsoFinanzas.obtenerListadoDeArea(year,unArea);
    }
    
    public double obtenerAfiliadoDeArea(int year, Area unArea ){
        return this.unCelsoFinanzas.ObtenerAfiliadoDeArea(year, unArea);
    }
    
    public double obtenerComisionDeArea( int year , Area unArea){
        return this.unCelsoFinanzas.obtenerComisionDeArea( year,unArea);
    }
    
    public double obtenerNetoDeArea(int year , Area unArea){
        return this.unCelsoFinanzas.obtenerNetoDeArea(year,unArea);
    }
    
    //valores por año
    
    public double obtenerListadoYear(int year){
        return this.unCelsoFinanzas.obtenerListadoYear(year);
    }
    
    public double obtenerAfiliadoYear(int year){
        return this.unCelsoFinanzas.obtenerAfiliadoYear(year);
    }
    
    public double obtenerComisionYear(int year){
        return this.unCelsoFinanzas.obtenerComisionYear(year);
    }
    
    public double obtenerNetoYear(int year){
        return this.unCelsoFinanzas.obtenerNetoYear(year);
    }
    
    // valores por mes area.
    
    public double obtenerListadoMesArea(int year,int mes , Area unArea){
        return this.unCelsoFinanzas.obtenerListadoMesArea(year,mes,unArea);
    }
    
    public double obtenerAfiliadoMesArea(int year,int mes , Area unArea){
        return this.unCelsoFinanzas.obtenerAfiliadoMesArea(year,mes,unArea);
    }
    
    public double obtenerComisionMesArea(int year,int mes , Area unArea){
        return this.unCelsoFinanzas.obtenerComisionMesArea(year,mes,unArea);
    }
    
    public double obtenerNetoMesArea(int year,int mes , Area unArea){
        return this.unCelsoFinanzas.obtenerNetoMesArea(year,mes,unArea);
    }
    
    //valores por mes año.
    public double obtenerListadoMesYear(int year,int mes ){
        return this.unCelsoFinanzas.obtenerListadoMesYear(year,mes);
    }
    
    public double obtenerAfiliadoMesYear(int year,int mes ){
        return this.unCelsoFinanzas.obtenerAfiliadoMesYear(year,mes);
    }
    
    public double obtenerComisionMesYear(int year,int mes){
        return this.unCelsoFinanzas.obtenerComisionMesYear(year,mes);
    }
    
    public double obtenerNetoMesYear(int year,int mes ){
        return this.unCelsoFinanzas.obtenerNetoMesYear(year,mes);
    }
    
    public boolean existeCobranza(Cobrador unCobrador, int year, int mes, Area unArea){
        return this.unCelsoFinanzas.existeCobranza(unCobrador, year, mes, unArea);
    }
    
    public Cobranza obtenerCobranza(Cobrador unCobrador, int year, int mes, Area unArea){
        return this.unCelsoFinanzas.obtenerCobranza(unCobrador, year, mes, unArea);
    }
}