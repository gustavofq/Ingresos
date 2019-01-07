package Logica;
import Persistencia.ControladorPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Persistencia.exceptions.ViolacionClaveForaneaException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public boolean existeArea(String nombre){
        boolean existe = false; 
        if(this.obtenerArea(nombre).getNombre().length() > 0){     
            existe = true;
        }
        return existe;
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
            if(unArea.getNombre().contains(nombre)){
                existe = true;
            }
        }
        return existe;
    }
    
    public Area obtenerArea(String nombre){
        Iterator it = this.persistencia.obtenerAreas().iterator();
        Area unArea = new Area();
        boolean existe = false;
        while((it.hasNext()) && (existe == false)){
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
    
    public void agregarComision(long dni, int comision) throws Exception{
        Cobrador unCobrador = this.obtenerCobrador(dni);
        unCobrador.setUnaComision(comision);
        this.persistencia.modificarCobrador(unCobrador);
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
    
    public void agregarCobranza(Double listado, int mes, int year, Cobrador unCobrador,Area unArea){
        Cobranza unaCobranza = new Cobranza(listado, mes, year, unCobrador, unArea);
        this.persistencia.agregarCobranza(unaCobranza);
    }
    
    public void modificarCobranza(int id, Double listado, Double adiliado,int mes, int year,long  dni,String area) throws Exception{
        Iterator it = this.cobranzas.iterator();
        Cobranza unaCobranza = new Cobranza();
        while(it.hasNext()){
            unaCobranza = (Cobranza)it.next();
            if(unaCobranza.getId() == id){
                unaCobranza.setListado(listado);
                unaCobranza.setAfiliado(adiliado);
                unaCobranza.setMes(mes);
                unaCobranza.setYear(year);
                unaCobranza.setUnCobrador(this.obtenerCobrador(dni));
                //unaCobranza.setUnArea(this.obtenerArea(area));
                this.cobranzas.add(unaCobranza);
                this.persistencia.modificarCobranza(unaCobranza);
            }
        }
    }
    
    public void borrarCobranza(int id) throws NonexistentEntityException, ViolacionClaveForaneaException{
        if(this.persistencia.obtenerUnaCobranza(id).getIngresos().isEmpty()){
            this.persistencia.borrarCobranza(id);
        }else{
            throw new ViolacionClaveForaneaException(); 
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
    
    public List<Cobranza> obenerCobranzasDeCobrador(Cobrador unCobrador, int year, Area unArea){
        List<Cobranza> cobranzas = new ArrayList<>();
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext()){
                unaCobranza = (Cobranza) it.next();
                if((unaCobranza.getUnCobrador().getDni() == unCobrador.getDni())&&(unaCobranza.getYear() == year)&&(unaCobranza.getUnArea().getId() == unArea.getId())){
                    cobranzas.add(unaCobranza);
                }
            }
        return cobranzas;
    }
    
    
    public void agregarListado(int idCobranza, Ingreso unIngreso) throws Exception{
        Cobranza unaCobranza = this.persistencia.obtenerUnaCobranza(idCobranza);
        
        this.persistencia.modificarCobranza(unaCobranza);
        this.persistencia.agregarIngreso(unIngreso);
    }
    
    //fina abm combranza
    //abmIngresos
    
    public void agregarIngreso(Double Afiliado, String concepto, Calendar fecha, Cobranza unaCobranza) throws Exception{
        Ingreso unIngreso = new Ingreso(Afiliado, concepto, fecha, unaCobranza);
        unaCobranza.agregarIngreso(unIngreso);
        this.persistencia.modificarCobranza(unaCobranza);
        //this.persistencia.agregarIngreso(unIngreso);
    }
    
    public void modificarIngreso(int id,Double Afiliado, String concepto, Calendar fecha, Cobranza unaCobranza){
        
    }
    
    public void borrarIngreso(int id) throws NonexistentEntityException{
        this.persistencia.borrarIngreso(id);
    }
    
    public Ingreso obtenerIngreso(int id){
        return this.persistencia.obtenerIngreso(id);
    }
    
    public List<Ingreso> obtenerIngresos(int id){
        Iterator it = this.persistencia.obtenerIngresos().iterator();
        List<Ingreso> ingresos = new ArrayList<>();
        Ingreso unIngreso = new Ingreso();
        while (it.hasNext()){
            unIngreso = (Ingreso) it.next();
           //if(unIngreso.getUnaCobranza().getId() == id){
                ingresos.add(unIngreso);
            //}
        }
        return ingresos;
    }
    
    public Double calcularAfiliado(int idCobranza){
        Double afiliado = new Double(0);
        if(this.existeCobranza(idCobranza)){
            Iterator it = this.persistencia.obtenerIngresos().iterator();
            Ingreso unIngreso = new Ingreso();
            while (it.hasNext()){
                unIngreso = (Ingreso) it.next();
               // if(unIngreso.getUnaCobranza().getId() == idCobranza){
                    afiliado += unIngreso.getAfiliado();
               // }
            }
        }
        return afiliado;
    }
    
    public Double calcularNeto(int idCobranza){
        Double neto= new Double(0);
        Double afiliado = this.calcularAfiliado(idCobranza);
        Double comision = this.obtenerCobranzaPorId(idCobranza).getComision();
        if(this.existeCobranza(idCobranza)){
            calcularComision(idCobranza);
            neto =   afiliado - comision;
        }
        return neto;
    }
    
    public Double calcularComision(int idCobranza){
        Double comision = new Double(0);
        if(this.existeCobranza(idCobranza)){
            comision = (this.obtenerCobranzaPorId(idCobranza).getUnCobrador().getUnaComision() * this.calcularAfiliado(idCobranza))/100;
        }
        return comision;
    }
    
    public boolean cobranzaPagada(int idCobranza){
        boolean pagado = false;
        if(this.calcularAfiliado(idCobranza) >= this.obtenerCobranzaPorId(idCobranza).getListado()){
            pagado = true;
        }
        return pagado;
    }
    
    public boolean existeCobranza(int idCobranza){
        boolean existe = false;
        if(this.persistencia.obtenerUnaCobranza(idCobranza) != null){
            existe =true;
        }
        return existe ;
    }
    
    public void agregarIngreso(Cobranza unaCobranza, Ingreso unIngreso) throws Exception{
        unaCobranza.agregarIngreso(unIngreso);
        unaCobranza.setAfiliado(unaCobranza.calcularAfiliadoTotal());
        unaCobranza.setComision(unaCobranza.calcularComision());
        unaCobranza.setNeto(unaCobranza.calcularNeto());
        this.persistencia.modificarCobranza(unaCobranza);
    }
}


