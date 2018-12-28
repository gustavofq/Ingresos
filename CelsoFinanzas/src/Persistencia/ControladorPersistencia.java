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
import Logica.Ingreso;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;


public class ControladorPersistencia implements Serializable{
    private static AreaJpaController unAreaJpaController;
    private static CelsoFinanzasJpaController unCelsoFinanzasJpaController;
    private static CobradorJpaController unCobradorJpaController;
    private static CobranzaJpaController unaCobranzaJpaController;
    private static IngresoJpaController unIngresoJpaController;
    
    static {
        unAreaJpaController = new AreaJpaController();
        unCelsoFinanzasJpaController = new CelsoFinanzasJpaController();
        unCobradorJpaController = new CobradorJpaController();
        unaCobranzaJpaController = new CobranzaJpaController();
        unIngresoJpaController = new IngresoJpaController();
        
    }
    //abm areas
    public  void agregarArea(Area unArea){
        try {
            unAreaJpaController.create(unArea);
        } catch (Exception e) {
            System.out.print("Error en agregar area: "+ unArea.getId() + " " + unArea.getNombre());
        }
        
    }
    
    public  void modificarArea(Area unArea) {
        try {
            unAreaJpaController.edit(unArea);
        } catch (Exception ex) {
            System.out.println("Error  Persistencia en modificarArea: " + unArea);
        }
    }
    
    public  void borrarArea(int id) {
        try {
            unAreaJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            System.out.println("Error Persistencia en BorrarArea: ");
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
    
    public  void borrarCelsoFinanzas(int id) throws NonexistentEntityException{
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
        unCobradorJpaController.destroy(unCobrador.getDni());
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
            System.out.println("Error en obtenerCobradores: " + unCobradorJpaController.findCobradorEntities().size());
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
}

