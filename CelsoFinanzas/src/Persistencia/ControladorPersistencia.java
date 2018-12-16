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
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;


public class ControladorPersistencia implements Serializable{
    private static AreaJpaController unAreaJpaController;
    private static CelsoFinanzasJpaController unCelsoFinanzasJpaController;
    private static CobradorJpaController unCobradorJpaController;
    private static CobranzaJpaController unaCobranzaJpaController;
    
    static {
        unAreaJpaController = new AreaJpaController();
        unCelsoFinanzasJpaController = new CelsoFinanzasJpaController();
        unCobradorJpaController = new CobradorJpaController();
        unaCobranzaJpaController = new CobranzaJpaController();
    }
    //abm areas
    public static void agregarArea(Area unArea){
        try {
            unAreaJpaController.create(unArea);
        } catch (Exception e) {
            System.out.print("Error en agregar area: "+ unArea);
        }
        
    }
    
    public static void modificarArea(Area unArea) {
        try {
            unAreaJpaController.edit(unArea);
        } catch (Exception ex) {
            System.out.println("Error en modificarArea: " + unArea);
        }
    }
    
    public static void borrarArea(Area unArea) {
        try {
            unAreaJpaController.destroy(unArea.getId());
        } catch (NonexistentEntityException ex) {
            System.out.println("Error en BorrarArea: " + unArea);
        }
    }
    
    public static List<Area> obtenerAreas(){
        List<Area> areas = null;
        
        areas = unAreaJpaController.findAreaEntities();
   
        System.out.println("Error en obtenerAreas: " + unAreaJpaController.findAreaEntities().size());
        
        return areas;
    }
    
    public static Area obtenerUnArea(int id){
        return unAreaJpaController.findArea(id);
    }
    //abm Celsofinanzas
    public static void agregarCelsoFinanzas(CelsoFinanzas unCelsoFinanzas){
        unCelsoFinanzasJpaController.create(unCelsoFinanzas);
    }
    
    public static void modificarCelsoFinanzas(CelsoFinanzas unCelsoFinanzas) throws Exception{
        unCelsoFinanzasJpaController.edit(unCelsoFinanzas);
    }
    
    public static void borrarCelsoFinanzas(int id) throws NonexistentEntityException{
        unCelsoFinanzasJpaController.destroy(id);
    }
    
    public static CelsoFinanzas obtenerUnCelsoFinanzas(int id){
        return unCelsoFinanzasJpaController.findCelsoFinanzas(id);
    }
    
    public static  List<CelsoFinanzas> obtenerCelsosFinanzas(){
        return unCelsoFinanzasJpaController.findCelsoFinanzasEntities();
    }
    //abm cobrador
    public static  void agregarUnCobrador(Cobrador unCobrador){
        try {
            unCobradorJpaController.create(unCobrador);
        } catch (Exception e) {
            System.out.println("Error en agregarUnCobrador: " + unCobrador);
        }
        
    }
    
    public static void modificarCobrador(Cobrador unCobrador) throws Exception{
        unCobradorJpaController.edit(unCobrador);
    }
    
    public static void borrarCobrador(long dni) throws NonexistentEntityException{
        unCobradorJpaController.destroy(dni);
    }
    
    public static Cobrador obtenerUnCobrador(long dni){
        return unCobradorJpaController.findCobrador(dni);
    }
    
    public  static List<Cobrador> obtenerCobradores(){
        List<Cobrador> cobradores = null;
        try {
            cobradores = unCobradorJpaController.findCobradorEntities();
        } catch (Exception e) {
            System.out.println("Error en obtenerCobradores: " + unCobradorJpaController.findCobradorEntities().size());
        }
        return cobradores;
    }
    //abm cobranza
    public static void agregarCobranza(Cobranza unaCobranza){
        unaCobranzaJpaController.create(unaCobranza);
    }
    
    public static void modificarCobranza(Cobranza unaCobranza) throws Exception{
        unaCobranzaJpaController.edit(unaCobranza);
    }
    
    public static void borrarCobranza(int id) throws NonexistentEntityException{
        unaCobranzaJpaController.destroy(id);
    }
    
    public static  Cobranza obtenerUnaCobranza(int id){
        return unaCobranzaJpaController.findCobranza(id);
    }
    
    public static List<Cobranza> obtenerCobranzas(){
        return unaCobranzaJpaController.findCobranzaEntities();
    }
}

