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
import java.util.List;

/**
 *
 * @author gustavo
 */
public class ControladorPersistencia {
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
    public void agregarArea(Area unArea){
        unAreaJpaController.create(unArea);
    }
    
    public void modificarArea(Area unArea) throws Exception{
        unAreaJpaController.edit(unArea);
    }
    
    public void borrarArea(Area unArea) throws NonexistentEntityException{
        unAreaJpaController.destroy(unArea.getId());
    }
    
    public List<Area> obtenerAreas(){
        return unAreaJpaController.findAreaEntities();
    }
    
    public Area obtenerUnArea(int id){
        return unAreaJpaController.findArea(id);
    }
    //abm Celsofinanzas
    public void agregarCelsoFinanzas(CelsoFinanzas unCelsoFinanzas){
        unCelsoFinanzasJpaController.create(unCelsoFinanzas);
    }
    
    public void modificarCelsoFinanzas(CelsoFinanzas unCelsoFinanzas) throws Exception{
        unCelsoFinanzasJpaController.edit(unCelsoFinanzas);
    }
    
    public void borrarCelsoFinanzas(int id) throws NonexistentEntityException{
        unCelsoFinanzasJpaController.destroy(id);
    }
    
    public CelsoFinanzas obtenerUnCelsoFinanzas(int id){
        return unCelsoFinanzasJpaController.findCelsoFinanzas(id);
    }
    
    public List<CelsoFinanzas> obtenerCelsosFinanzas(){
        return unCelsoFinanzasJpaController.findCelsoFinanzasEntities();
    }
    //abm cobrador
    public void agregarUnCobrador(Cobrador unCobrador){
        unCobradorJpaController.create(unCobrador);
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
    
    public List<Cobrador> obtenerCobradores(){
        return unCobradorJpaController.findCobradorEntities();
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
    
    public Cobranza obtenerUnaCobranza(int id){
        return unaCobranzaJpaController.findCobranza(id);
    }
    
    public List<Cobranza> obtenerCobranzas(){
        return unaCobranzaJpaController.findCobranzaEntities();
    }
}

