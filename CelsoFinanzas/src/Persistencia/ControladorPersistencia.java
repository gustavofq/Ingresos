/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Area;
import Logica.CelsoFinanzas;
import Logica.Cobrador;
import Logica.Cobranza;
import Logica.Convenio;
import Logica.Egresos;
import Logica.Ingreso;
import Logica.Produccion;
import Persistencia.exceptions.IllegalOrphanException;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;


public class ControladorPersistencia implements Serializable{
    private static AreaJpaController unAreaJpaController;
    private static CelsoFinanzasJpaController unCelsoFinanzasJpaController;
    private static CobradorJpaController unCobradorJpaController;
    private static CobranzaJpaController unaCobranzaJpaController;
    private static IngresoJpaController unIngresoJpaController;
    private static ConvenioJpaController unConvenioJpaController;
    private static ProduccionJpaController unaProduccionJpaController;
    private static EgresosJpaController unEgresosJpaController;
    
    static {
        unAreaJpaController = new AreaJpaController();
        unCelsoFinanzasJpaController = new CelsoFinanzasJpaController();
        unCobradorJpaController = new CobradorJpaController();
        unaCobranzaJpaController = new CobranzaJpaController();
        unIngresoJpaController = new IngresoJpaController();
        unConvenioJpaController = new ConvenioJpaController();
        unaProduccionJpaController = new ProduccionJpaController();
        unEgresosJpaController = new EgresosJpaController();
    }
    //abm areas
    public  void agregarArea(Area unArea) throws PreexistingEntityException{
        try {
            unAreaJpaController.create(unArea); 
        } catch (Exception e) {
            throw new PreexistingEntityException("Ya existe " + unArea);
        }
        
    }
    
    public  void modificarArea(Area unArea) {
        try {
            unAreaJpaController.edit(unArea);
        } catch (Exception ex) {
           
        }
    }
    
    public  void borrarArea(int id) {
        try {
            unAreaJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            
        }
    }
    
    public  List<Area> obtenerAreas(){
        return unAreaJpaController.findAreaEntities();
    }
    
    public  Area obtenerUnArea(int id){
        return unAreaJpaController.findArea(id);
    }
    
    //abm Celsofinanzas
    public  void agregarCelsoFinanzas(CelsoFinanzas unCelsoFinanzas){
        unCelsoFinanzasJpaController.create(unCelsoFinanzas);
    }
    
    public  void modificarCelsoFinanzas(CelsoFinanzas unCelsoFinanzas) throws Exception{
        unCelsoFinanzasJpaController.edit(unCelsoFinanzas);
    }
    
    public  void borrarCelsoFinanzas(int id) throws NonexistentEntityException, IllegalOrphanException{
        unCelsoFinanzasJpaController.destroy(id);
    }
    
    public  CelsoFinanzas obtenerUnCelsoFinanzas(int id){
        return unCelsoFinanzasJpaController.findCelsoFinanzas(id);
    }
    
    public   List<CelsoFinanzas> obtenerCelsosFinanzas(){
        return unCelsoFinanzasJpaController.findCelsoFinanzasEntities();
    }
    //abm cobrador
    public   void agregarUnCobrador(Cobrador unCobrador){
        try {
            unCobradorJpaController.create(unCobrador);
        } catch (Exception e) {
            System.out.println("Error en agregarUnCobrador: " + unCobrador);
        }
    }
    
    public void modificarCobrador(Cobrador unCobrador) throws Exception{
        unCobradorJpaController.edit(unCobrador);
    }
    
    public void borrarCobrador(long dni) throws NonexistentEntityException{
        unCobradorJpaController.destroy(dni);
    }
    
    public Cobrador obtenerUnCobrador(long dni){
        return unCobradorJpaController.findCobrador(dni);
    }
    
    public   List<Cobrador> obtenerCobradores(){
        List<Cobrador> cobradores = null;
        try {
            cobradores = unCobradorJpaController.findCobradorEntities();
        } catch (Exception e) {
            
        }
        return cobradores;
    }
    
    //abm cobranza
    
    public void agregarCobranza(Cobranza unaCobranza){
        unaCobranzaJpaController.create(unaCobranza);
    }
    
    public void modificarCobranza(Cobranza unaCobranza) throws Exception{
        unaCobranzaJpaController.edit(unaCobranza);
    }
    
    public void borrarCobranza(int id) throws NonexistentEntityException{
        unaCobranzaJpaController.destroy(id);
    }
    
    public  Cobranza obtenerUnaCobranza(int id){
        return unaCobranzaJpaController.findCobranza(id);
    }
    
    public List<Cobranza> obtenerCobranzas(){
        return unaCobranzaJpaController.findCobranzaEntities();
    }
    
    public void agregarIngreso(Ingreso unIngreso){
        unIngresoJpaController.create(unIngreso);
    }
    
    public void borrarIngreso(int id) throws NonexistentEntityException{
        unIngresoJpaController.destroy(id);
    }
    
    public void modificarIngreso(Ingreso unIngreso) throws Exception{
        unIngresoJpaController.edit(unIngreso);
    }
    
    public List<Ingreso> obtenerIngresos(){
        return unIngresoJpaController.findIngresoEntities();
    }
    
    public Ingreso obtenerIngreso(int id){
        return unIngresoJpaController.findIngreso(id);
    }
    
    //abm convenios
    
    public void agregarConvenio(Convenio unConvenio){
        unConvenioJpaController.create(unConvenio);
    }
    
    public void modificarConvenio(Convenio unConvenio) throws Exception{
        unConvenioJpaController.edit(unConvenio);
    }
    
    public void borrarConvenio(int id) throws NonexistentEntityException{
        unConvenioJpaController.destroy(id);
    }
    
    public Convenio obtenerConvenio(int id){
        return unConvenioJpaController.findConvenio(id);
    }
    
    public List<Convenio> obtenerConvenios(){
        return unConvenioJpaController.findConvenioEntities();
    }
    
    //fin adm convenios
    //inioc abm Produccion
    
    public void agregarProduccion(Produccion unaProduccion){
        unaProduccionJpaController.create(unaProduccion);
    }
    
    public void modificarProduccion(Produccion unaProduccion) throws Exception{
        unaProduccionJpaController.edit(unaProduccion);
    }
    
    public void borrarProduccion(int id) throws NonexistentEntityException{
        unaProduccionJpaController.destroy(id);
    }
    
    public Produccion obtenerProduccion(int id){
        return unaProduccionJpaController.findProduccion(id);
    }
    
    public List<Produccion> obtenerProducciones(){
        return unaProduccionJpaController.findProduccionEntities();
    }
    
    public void agregarEgresos(Egresos unEgreso){
        unEgresosJpaController.create(unEgreso);
    }
    
    public void borrarEgresos(int id) throws NonexistentEntityException{
        unEgresosJpaController.destroy(id);
    }
    
    public void modificarEgresos(Egresos egreso) throws Exception{
        unEgresosJpaController.edit(egreso);
    }
    
    public Egresos obtenerUnEgreso(int id){
        return unEgresosJpaController.findEgresos(id);
    }
    
    public List<Egresos> obtenerEgresos(){
        return unEgresosJpaController.findEgresosEntities();
    }
}

