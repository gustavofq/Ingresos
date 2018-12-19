package Logica;
import Persistencia.ControladorPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
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
    
    //ABM area
    public void agregarArea(String nombre){
        if(nombre != null){
            //if(this.existeArea(nombre)){
                Area unArea = new Area(nombre);
                this.areas.add(unArea);
                this.persistencia.agregarArea(unArea);
            //}
        }
    }
    
    public boolean existeArea(String nombre){
        boolean existe = false; 
        if(this.obtenerArea(nombre) != null){
            existe = true;
        }
        return existe;
    }
    
    public void modificarArea(String oldName, String newName) throws Exception{
        if(oldName != null){
            Iterator it = this.areas.iterator();
            Area unArea = new Area();
            while(it.hasNext()){
                unArea = (Area) it.next();
                if(unArea.getNombre().contains(oldName)){
                    if(newName != null){
                        if(this.existeArea(newName)){
                            unArea.setNombre(newName);
                            this.persistencia.modificarArea(unArea);
                        }
                    }
                }
            }
        }
    }
    
    public void borrarArea(String nombre) throws NonexistentEntityException{
        Iterator it = this.areas.iterator();
        Area unArea = new Area();
        while(it.hasNext()){
            unArea = (Area) it.next();
            if(unArea.getNombre().contains(nombre)){
                this.areas.remove(unArea);
                this.persistencia.borrarArea(unArea);
            }
        }
    }
    
    public Area obtenerArea(String nombre){
        Iterator it = this.persistencia.obtenerAreas().iterator();
        Area unArea = new Area();
        boolean existe = false;
        while((it.hasNext()) && (existe==false)){
            unArea = (Area) it.next();
            if(unArea.getNombre().contains(nombre)){
                existe = true;
            }
        }
        return unArea;
    }
    
    public int obtenerIdArea(String nombre){
        Iterator it = this.persistencia.obtenerAreas().iterator();
        Area unArea = new Area();
        boolean existe = false;
        while((it.hasNext()) && (existe==false)){
            unArea = (Area) it.next();
            if(unArea.getNombre().contains(nombre)){
                existe = true;
            }
        }
        return unArea.getId();
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
    
    public void modificarCobrador(long oldDni, String nombre, String alias,String apellido, long dni, int comisionC) throws Exception{
        if(oldDni > 0){
            Iterator it = this.persistencia.obtenerCobradores().iterator();
            Cobrador unCobrador = new Cobrador(nombre, alias,apellido, oldDni,comisionC);
            while(it.hasNext()){
                unCobrador = (Cobrador) it.next();
                if(unCobrador.getDni() == oldDni){
                    if(dni > 0){
                        unCobrador.setAlias(alias);
                        //unCobrador.setDni(dni);
                        unCobrador.setNombre(nombre);
                        unCobrador.setApellido(apellido);
                        this.persistencia.modificarCobrador(unCobrador);
                    }
                }
            }
        }
    }
    
    public void borrarCobrador(long dni) throws NonexistentEntityException{
         this.persistencia.borrarCobrador(dni);
    }
    
    public List obtenerAlias(){
        Iterator it = this.persistencia.obtenerCobradores().iterator();
        List<String> alias = new ArrayList<>();
        boolean existe = false;
        while((it.hasNext()) && (existe==false)){
            alias.add(((Cobrador) it.next()).getAlias());
        }
        return alias;
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
    
    public Cobrador obtenerCobradorPorAlias(String alias){
        Iterator it = this.persistencia.obtenerCobradores().iterator();
        Cobrador unCobrador = new Cobrador();
        boolean existe = false;
        while((it.hasNext()) && (existe==false)){
            unCobrador = (Cobrador) it.next();
            if((unCobrador.getAlias().contains(alias))){
                existe = true;
            }
        }
        return unCobrador;

    }
    
    public long obtenerDniCobrador(String nombre, String Apellido){
        long dni = 0;
        Iterator it = this.persistencia.obtenerCobradores().iterator();
        Cobrador unCobrador = new Cobrador();
        boolean existe = false;
        while((it.hasNext()) && (existe==false)){
            unCobrador = (Cobrador) it.next();
            if((unCobrador.getApellido().contains(Apellido))&&(unCobrador.getNombre().contains(nombre))){
                existe = true;
            }
        }
        return unCobrador.getDni();
        
    }
    
    public List<Cobrador> obtenerCobradores(){
        return this.persistencia.obtenerCobradores();
    }
    
    public boolean existeCobrador(Long dni){
        boolean existe = false;
        if(this.obtenerCobrador(dni) != null){
            existe = true;
        }
        return existe;
    }
    
    //fin abm cobrador
    //inicio abm cobranza
    public void agregarCobranza(Double listado, Double afiliado,  int mes, int year, String concepto, long dni, String area){
        if(year != 0){//controlar todos los parametros
            Cobranza unaCobranza = new  Cobranza(listado, afiliado, mes, year, concepto, this.obtenerCobrador(dni), this.obtenerArea(area));
            this.cobranzas.add(unaCobranza);
            this.persistencia.agregarCobranza(unaCobranza);
        }
    }
    
    public void modificarCobranza(int id, Double listado, Double adiliado,int mes, int year, String concepto,long  dni,String area) throws Exception{
        Iterator it = this.cobranzas.iterator();
        Cobranza unaCobranza = new Cobranza();
        while(it.hasNext()){
            unaCobranza = (Cobranza)it.next();
            if(unaCobranza.getId() == id){
                unaCobranza.setListado(listado);
                unaCobranza.setAfiliado(adiliado);
                unaCobranza.setMes(mes);
                unaCobranza.setYear(year);
                unaCobranza.setConcepto(concepto);
                unaCobranza.setUnCobrador(this.obtenerCobrador(dni));
                unaCobranza.setUnArea(this.obtenerArea(area));
                this.cobranzas.add(unaCobranza);
                this.persistencia.modificarCobranza(unaCobranza);
            }
        }
    }
    
    public void borrarCobranza(int id) throws NonexistentEntityException{
        if(id > 0){
            Iterator it = this.cobranzas.iterator();
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext()){
                unaCobranza = (Cobranza) it.next();
                if(unaCobranza.getId() == id){
                    this.cobranzas.remove(unaCobranza);
                    this.persistencia.borrarCobranza(id);
                }
            }  
        }
    }
    
    public int obtenerIdCobranza(Area unArea, Cobrador unCobrador,int mes, int year){
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
            Cobranza unaCobranza = new Cobranza();
            boolean encontro = false;
            while((it.hasNext()) && (encontro == false)){
                unaCobranza = (Cobranza) it.next();
                if((unaCobranza.getUnCobrador() == unCobrador) && (unaCobranza.getUnArea() == unArea) && (unaCobranza.getMes() == mes) && (unaCobranza.getYear() == year)){
                    encontro = true;
                }
            }
        return unaCobranza.getId();
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
    //fina abm combranza

}


