package Logica;
import Persistencia.ControladorPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Persistencia.exceptions.ViolacionClaveForaneaException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class CelsoFinanzas implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @OneToMany
    private List<Area> areas = new ArrayList<>();
    @OneToMany
    private List<Cobrador> cobradores = new ArrayList<>();
    @OneToMany
    private List<Cobranza> cobranzas = new ArrayList<>();
    @OneToMany 
    private List<Ingreso> ingresos = new ArrayList<>();
    
    ControladorPersistencia persistencia = new ControladorPersistencia();
    
    public CelsoFinanzas() {
    }

    public CelsoFinanzas(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public List<Cobrador> getCobradores() {
        return cobradores;
    }

    public void setCobradores(ArrayList<Cobrador> cobradores) {
        this.cobradores = cobradores;
    }

    public List<Cobranza> getCobranzas() {
        return cobranzas;
    }

    public void setCobranzas(ArrayList<Cobranza> cobranzas) {
        this.cobranzas = cobranzas;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Ingreso> ingresos) {
        this.ingresos = ingresos;
    }
    //ABM area
    public void agregarArea(String nombre) throws PreexistingEntityException{
        if(nombre != null){
            if(!this.nombreAreaUtiliazada(nombre)){
                Area unArea = new Area(nombre);
                this.areas.add(unArea);
                this.persistencia.agregarArea(unArea);
            }else{
                throw new PreexistingEntityException("Ya existe un area con el nombre " + nombre);
            }
        }
    }

    public void modificarArea(Area unArea) throws Exception{
        if(unArea != null){
            if(!nombreAreaUtiliazada(unArea.getNombre())){
                this.persistencia.modificarArea(unArea);
            }else{
                throw new PreexistingEntityException("Ya existe un area con el nombre " + unArea.getNombre());
            }
        }else{
            throw new NullPointerException("el area es null");
        } 
    }
    
    public void borrarArea(int id) throws NonexistentEntityException, ViolacionClaveForaneaException{
        if(!areaUtilizada(id)){
            this.persistencia.borrarArea(id);
        }else{
            throw new ViolacionClaveForaneaException();
        }
    }
    
    public boolean areaUtilizada(int id){
        Iterator it  = this.obtenerCobranzas().iterator();
        boolean existe = false;
        while(it.hasNext() && existe == false){
            Cobranza unaCobranza  = (Cobranza) it.next();
            if(unaCobranza.getUnArea().getId() == id){
                existe = true;
            }
        }
        return existe;
    }
    
    public boolean nombreAreaUtiliazada(String nombre){
        Iterator it = this.persistencia.obtenerAreas().iterator();
        Area unArea = new Area();
        boolean existe = false;
        while((it.hasNext()) && (existe == false)){
            unArea = (Area) it.next();
            if(unArea.getNombre().equals(nombre)){
                existe = true;
            }
        }
        return existe;
    }
    
    public List<Area> obtenerAreas(){
        return this.persistencia.obtenerAreas();
    }
    //fin abm Area
    //inicio Abm cobrador
    public void agregarCobrador(String nombre, String alias, String apellido ,long dni, int comisionC){
        if(dni > 0){//controlar el rango de valor tambien 
            Cobrador unCobrador = new Cobrador(nombre, alias, apellido ,dni, comisionC );
            this.cobradores.add(unCobrador);
            this.persistencia.agregarUnCobrador(unCobrador);
        }    
    }
    
    public void modificarCobrador(Cobrador unCobrador) throws Exception{
        this.persistencia.modificarCobrador(unCobrador);
    }
    
    public void borrarCobrador(long dni) throws NonexistentEntityException, ViolacionClaveForaneaException{
        if(!this.cobradorUtilizado(dni)){
            this.persistencia.borrarCobrador(dni);
        }else{
            throw new ViolacionClaveForaneaException();
        }
        
    }

    public boolean cobradorUtilizado(long dni){
        boolean esUtilizado = false;
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
        Cobranza unaCobranza = new Cobranza();
        while(it.hasNext() && esUtilizado == false){
            unaCobranza = (Cobranza) it.next();
            if(unaCobranza.getUnCobrador().getDni() == dni){
                esUtilizado = true;
            }
        }
        return esUtilizado;
    }
    
    public Cobrador obtenerCobrador(long dni){
        Iterator it = this.persistencia.obtenerCobradores().iterator();
        Cobrador unCobrador = new Cobrador();
        boolean existe = false;
        while((it.hasNext()) && (existe==false)){
            unCobrador = (Cobrador) it.next();
            if(unCobrador.getDni() == dni){
                existe = true;
            }
        }
        return unCobrador;
    }

    public List<Cobrador> obtenerCobradores(){
        return this.persistencia.obtenerCobradores();
    }
    //fin abm cobrador
    //inicio abm cobranza
    public void agregarCobranza(Double listado, int mes, int year, Cobrador unCobrador,Area unArea){
        Cobranza unaCobranza = new Cobranza(listado, mes, year, unCobrador, unArea);
        this.persistencia.agregarCobranza(unaCobranza);
    }
    
    public void borrarCobranza(int id) throws NonexistentEntityException, ViolacionClaveForaneaException{
        if(this.persistencia.obtenerUnaCobranza(id).getIngresos().isEmpty()){
            this.persistencia.borrarCobranza(id);
        }else{
            throw new ViolacionClaveForaneaException(); 
        }
    }

    public Cobranza obtenerCobranzaPorId(int id){
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
            Cobranza unaCobranza = new Cobranza();
            boolean encontro = false;
            while((it.hasNext()) && (encontro == false)){
                unaCobranza = (Cobranza) it.next();
                if(unaCobranza.getId() == id){
                    encontro = true;
                }
            }
        return unaCobranza;
    }
    
    public List<Cobranza> obtenerCobranzas(){
        return this.persistencia.obtenerCobranzas();
    }
    
    public List<Cobranza> obenerCobranzasDeCobrador(Cobrador unCobrador, int year){
        List<Cobranza> cobranzasAll = new ArrayList<>();
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext()){
                unaCobranza = (Cobranza) it.next();
                if((unaCobranza.getUnCobrador().getDni() == unCobrador.getDni())&&(unaCobranza.getYear() == year)){
                    cobranzasAll.add(unaCobranza);
                }
            }
        return cobranzasAll;
    }
    
    public List<Cobranza> obtenerCobranzaDeCartera(Area unArea, int year){
        List<Cobranza> cobranzasAll = new ArrayList<>();
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext()){
                unaCobranza = (Cobranza) it.next();
                if(unaCobranza.getUnArea().equals(unArea) && unaCobranza.getYear() == year){
                    cobranzasAll.add(unaCobranza);
                }
            }
        return cobranzasAll;
    }
    
    public void agregarIngreso(Cobranza unaCobranza, Ingreso unIngreso) throws Exception{
        unaCobranza.agregarIngreso(unIngreso);
        unaCobranza.setAfiliado(unaCobranza.calcularAfiliadoTotal());
        unaCobranza.setComision(unaCobranza.calcularComision());
        unaCobranza.setNeto(unaCobranza.calcularNeto());
        this.persistencia.modificarCobranza(unaCobranza);
    }
    
    public void borrarListado(Cobranza unaCobranza, Ingreso unIngreso) throws Exception{
        unaCobranza.borrarIngreso(unIngreso);
        
        this.persistencia.modificarCobranza(unaCobranza);
    }
    
    public void modificarIngreso(Cobranza unaCobranza, Ingreso oldIngreso, Ingreso newIngreso) throws Exception{
        unaCobranza.modificarIngreso(oldIngreso,newIngreso);
        this.persistencia.modificarIngreso(newIngreso);
        this.persistencia.modificarCobranza(unaCobranza);
    }
   
}