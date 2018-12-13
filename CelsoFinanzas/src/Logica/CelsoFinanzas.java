package Logica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class CelsoFinanzas implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @OneToMany
    private ArrayList<Area> areas = new ArrayList<>();
    @OneToMany
    private ArrayList<Cobrador> cobradores = new ArrayList<>();
    @OneToMany
    private ArrayList<Cobranza> cobranzas = new ArrayList<>();

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

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public ArrayList<Cobrador> getCobradores() {
        return cobradores;
    }

    public void setCobradores(ArrayList<Cobrador> cobradores) {
        this.cobradores = cobradores;
    }

    public ArrayList<Cobranza> getCobranzas() {
        return cobranzas;
    }

    public void setCobranzas(ArrayList<Cobranza> cobranzas) {
        this.cobranzas = cobranzas;
    }
    
    //ABM area
    public void agregarArea(String nombre){
        if(nombre != null){
            Area unArea = new Area(nombre);
            this.areas.add(unArea);
        }
    }
    
    public void modificarArea(String oldName, String newName){
        if(oldName != null){
            Iterator it = this.areas.iterator();
            Area unArea = new Area();
            while(it.hasNext()){
                unArea = (Area) it.next();
                if(unArea.getNombre().contains(oldName)){
                    if(newName != null){
                        unArea.setNombre(newName);
                    }
                }
            }
        }
    }
    
    public void borrarArea(String nombre){
        Iterator it = this.areas.iterator();
        Area unArea = new Area();
        while(it.hasNext()){
            unArea = (Area) it.next();
            if(unArea.getNombre().contains(nombre)){
                this.areas.remove(unArea);
            }
        }
    }
    
    public Area obtenerArea(String nombre){
        Iterator it = this.areas.iterator();
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
        Iterator it = this.areas.iterator();
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
    //fin abm Area
    //inicio Abm cobrador
    public void agregarCobrador(String nombre, String alias, String apellido ,long dni, int comisionC){
        if(dni > 0){//controlar el rango de valor tambien 
            Cobrador unCobrador = new Cobrador(nombre, alias, apellido ,dni, comisionC );
            this.cobradores.add(unCobrador);
        }    
    }
    
    public void modificarCobrador(long oldDni, String nombre, String alias,String apellido, long dni, int comisionC){
        if(oldDni > 0){
            Iterator it = this.cobradores.iterator();
            Cobrador unCobrador = new Cobrador(nombre, alias,apellido, oldDni,comisionC);
            while(it.hasNext()){
                unCobrador = (Cobrador) it.next();
                if(unCobrador.getDni() == oldDni){
                    if(dni > 0){
                        unCobrador.setAlias(alias);
                        unCobrador.setDni(dni);
                        unCobrador.setNombre(nombre);
                        unCobrador.setApellido(apellido);
                        
                    }
                }
            }
        }
    }
    
    public void borrarCobrador(long dni){
        Cobrador unCobrador = new Cobrador();
        Iterator it = this.cobradores.iterator();
        while(it.hasNext()){
            unCobrador = (Cobrador) it.next();
            if(unCobrador.getDni()== dni){
                this.cobradores.remove(unCobrador);
            }
        }
    }
    
    public Cobrador obtenerCobrador(long dni){
        Iterator it = this.cobradores.iterator();
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
    
    public long obtenerDniCobrador(String nombre, String Apellido){
        long dni = 0;
        Iterator it = this.cobradores.iterator();
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
    //fin abm cobrador
    //inicio abm cobranza
    public void agregarCobranza(Double listado, Double afiliado,  int mes, int year, String concepto, long dni, String area){
        if(year != 0){//controlar todos los parametros
            Cobranza unaCobranza = new  Cobranza(listado, afiliado, mes, year, concepto, this.obtenerCobrador(dni), this.obtenerArea(area));
            this.cobranzas.add(unaCobranza);
        }
    }
    
    public void modificarCobranza(int id, Double listado, Double adiliado,int mes, int year, String concepto,long  dni,String area){
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
            }
        }
    }
    
    public void borrarCobranza(int id){
        if(id > 0){
            Iterator it = this.cobranzas.iterator();
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext()){
                unaCobranza = (Cobranza) it.next();
                if(unaCobranza.getId() == id){
                    this.cobranzas.remove(unaCobranza);
                }
            }  
        }
    }
    
    public int obtenerIdCobranza(Area unArea, Cobrador unCobrador,int mes, int year){
        Iterator it = this.cobranzas.iterator();
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
        Iterator it = this.cobranzas.iterator();
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


