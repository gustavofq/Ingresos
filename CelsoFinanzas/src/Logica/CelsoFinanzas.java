package Logica;
import Persistencia.ControladorPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Persistencia.exceptions.ViolacionClaveForaneaException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
    @OneToMany
    private List<Convenio> convenios = new ArrayList<>();
    @OneToMany
    private List<Produccion> producciones = new ArrayList<>();
           
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
    
    public Area obtenerAreaPorNombre(String nombre){
        Iterator it = this.persistencia.obtenerAreas().iterator();
        Area unArea = new Area();
        boolean encontro = false;
        while((it.hasNext()) && (encontro == false)){
            unArea = (Area) it.next();
            if(unArea.getNombre().equals(nombre)){
                encontro = true;
            }
        }
        return unArea;
    }
    
    public List<Area> obtenerAreas(){
        return this.persistencia.obtenerAreas();
    }
    //fin abm Area
    //inicio Abm cobrador
    public void agregarCobrador(String nombre, String alias, String apellido ,long dni, int comisionC) throws PreexistingEntityException{
        if(!this.existeCobrador(dni)){//controlar el rango de valor tambien 
            Cobrador unCobrador = new Cobrador(nombre, alias, apellido ,dni, comisionC );
            this.cobradores.add(unCobrador);
            this.persistencia.agregarUnCobrador(unCobrador);
        }else{
            throw new PreexistingEntityException(alias);
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
        List cobradoresObtenidos = this.persistencia.obtenerCobradores();
        Collections.sort(cobradoresObtenidos);
        return cobradoresObtenidos;
    }
    
    public boolean existeCobrador(long dni){
        Iterator it = this.persistencia.obtenerCobradores().iterator();
        Cobrador unCobrador = new Cobrador();
        boolean existe = false;
        while((it.hasNext()) && (existe==false)){
            unCobrador = (Cobrador) it.next();
            if(unCobrador.getDni() == dni){
                existe = true;
            }
        }
        return existe;
    }
    
    //fin abm cobrador
    //inicio abm cobranza
    public void agregarCobranza(Double listado, int mes, int year, Cobrador unCobrador,Area unArea) throws PreexistingEntityException{
        Cobranza unaCobranza = new Cobranza(listado, mes, year, unCobrador, unArea);
        if(this.existeCobranza(unaCobranza)){
            throw new PreexistingEntityException("ya existe cobranza");
        }else{
            this.persistencia.agregarCobranza(unaCobranza);
        }
    }
    
    public void modificarCobranza(Cobranza unaCobranza) throws Exception{
        this.persistencia.modificarCobranza(unaCobranza);
    }
    
    public void borrarCobranza(int id) throws NonexistentEntityException, ViolacionClaveForaneaException{
        if(id != -1 ){
            if(this.persistencia.obtenerUnaCobranza(id).getIngresos().isEmpty()){
                this.persistencia.borrarCobranza(id);
            }else{
                throw new ViolacionClaveForaneaException(); 
            }
        }else{
            throw new NonexistentEntityException("No existe tal cobranza");
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
        List cobranzasOptenidas = this.persistencia.obtenerCobranzas();
        Collections.sort(cobranzasOptenidas);
        return cobranzasOptenidas;
    }
    
    public boolean existeCobranza(Cobranza unaCobranza){
        boolean existe = false;
        Cobranza otraCobranza = new Cobranza();
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
        while((it.hasNext())&&(existe == false)){
            otraCobranza = (Cobranza) it.next();
            if(unaCobranza.equals(otraCobranza)){
                existe = true;
            }
        }
        return existe;
    }
    
    
    //fin abm cobranzas
    //inicio abm ingresos
    
    
    public void agregarIngreso(Cobranza unaCobranza, Ingreso unIngreso) throws Exception{
        unaCobranza.agregarIngreso(unIngreso);
        unaCobranza.setAfiliado(unaCobranza.calcularAfiliadoTotal());
        unaCobranza.setComision(unaCobranza.calcularComision());
        unaCobranza.setNeto(unaCobranza.calcularNeto());
        this.persistencia.modificarCobranza(unaCobranza);
    }
    
    public void borrarIngreso(Cobranza unaCobranza, Ingreso unIngreso) throws Exception{
        unaCobranza.borrarIngreso(unIngreso);
        this.persistencia.modificarCobranza(unaCobranza);
        this.persistencia.borrarIngreso(unIngreso.getId());
    }
    
    public void modificarIngreso(Cobranza unaCobranza, Ingreso oldIngreso, Ingreso newIngreso) throws Exception{
        unaCobranza.modificarIngreso(oldIngreso,newIngreso);
        this.persistencia.modificarIngreso(newIngreso);
        this.persistencia.modificarCobranza(unaCobranza);
    }
    
    public List<Calendar> obtenerFechas(Cobrador unCobrador, int year, int mes){
        List<Cobranza> cobranzas = this.obtenerCobranzasDeCobrador(unCobrador, year, mes);
        List<Calendar> fechas = new ArrayList<>();
        for(Cobranza unaCobranza: cobranzas){
            for(Ingreso unIngreso:unaCobranza.getIngresos()){
                fechas.add(unIngreso.getFecha());
            }
        }
        List<Calendar> listaFechas = new ArrayList(fechas);
        Collections.sort(fechas);
        return listaFechas;
    }
    
    public Ingreso obtenerIngreso(Cobrador unCobrador,int year, int mes, Area unArea ,int fila) throws NonexistentEntityException{
        Ingreso ingreso = new Ingreso();
        for(Ingreso unIngreso:this.obtenerIngresos(unCobrador, year, mes, unArea)){
            if(unIngreso.getFila() == fila ){
                ingreso = unIngreso;
            }
        }
        if(ingreso == null){
            throw new NonexistentEntityException("no existe tal ingreso.");
        }
        return ingreso;
    }
    
    public boolean existeIngreso(Cobrador unCobrador,int year, int mes, Area unArea ,int fila, Double ingreso){
        boolean existe = false;
        for(Ingreso unIngreso:this.obtenerIngresos(unCobrador, year, mes, unArea)){
            if(unIngreso.getFila() == fila && unIngreso.getAfiliado().equals(ingreso)){
                existe = true;
                System.out.println("Existe ingreso.");
            }
        }
        if(existe ==false ){
            System.out.println("no Existe ingreso.");
        }
        return existe;
    }
    
    public boolean existeIngreso(Cobrador unCobrador,int year, int mes, Area unArea ,int fila){
        boolean existe = false;
        for(Ingreso unIngreso:this.obtenerIngresos(unCobrador, year, mes, unArea)){
            if(unIngreso.getFila() == fila ){
                existe = true;
                System.out.println("Existe ingreso.");
            }
        }
        if(existe ==false ){
            System.out.println("no Existe ingreso.");
        }
        return existe;
    }
    
    public List<Ingreso> obtenerIngresos(Cobrador unCobrador,int year, int mes, Area unArea ){
        List<Cobranza> cobranzas = this.obtenerCobranzasDeCobrador(unCobrador, year, mes);
        List<Ingreso> ingresos = new ArrayList<>();
        for(Cobranza unaCobranza: cobranzas){
            if(unaCobranza.getUnCobrador().equals(unCobrador) 
                    && unaCobranza.getYear() == year 
                    && unaCobranza.getMes() == mes 
                    && unaCobranza.getUnArea().equals(unArea)){
                ingresos = unaCobranza.getIngresos();
            }
        }
        return ingresos;
    }
    
    
    //fin abm ingresos
    //inicio reportes
    public List<Cobranza> obtenerCobranzasDeCobrador(Cobrador unCobrador, int year){
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
    
    public List<Cobranza> obtenerCobranzasDeCobrador(Cobrador unCobrador, int year, int mes){
        List<Cobranza> cobranzasAll = new ArrayList<>();
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext()){
                unaCobranza = (Cobranza) it.next();
                if((unaCobranza.getUnCobrador().getDni() == unCobrador.getDni())&&(unaCobranza.getYear() == year) && unaCobranza.getMes() == mes){
                    cobranzasAll.add(unaCobranza);
                }
            }
        return cobranzasAll;
    }
    
    public boolean existeCobranza(Cobrador unCobrador, int year, int mes, Area unArea){
        Iterator it = this.obtenerCobranzasDeCobrador(unCobrador, year, mes).iterator();
        boolean existe = false;
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext() && existe == false){
                unaCobranza = (Cobranza) it.next();
                if(unaCobranza.getUnArea().equals(unArea)){
                    existe = true;
                }
            }
        return existe;
    }
    
    public Cobranza obtenerCobranza(Cobrador unCobrador, int year, int mes, Area unArea) throws NonexistentEntityException{
        Iterator it = this.obtenerCobranzasDeCobrador(unCobrador, year, mes).iterator();
        boolean existe = false;
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext() && existe == false){
                unaCobranza = (Cobranza) it.next();
                if(unaCobranza.getUnArea().equals(unArea)){
                    existe = true;
                }
            }
            if(existe == false){
                throw new NonexistentEntityException("no exiete la cobranza del cobrador " + unCobrador.getAlias()+ " del mes " + mes + " del año " + year + " en el area " +unArea.getNombre());
            }
        return unaCobranza;
    }

    //inicio abm Convenios
    public void agregarConvenio(String nombre){
        Convenio unConvenio = new Convenio(nombre);
        persistencia.agregarConvenio(unConvenio);
    }
    
    public void modificarConvenio(Convenio unConvenio) throws Exception{
        persistencia.modificarConvenio(unConvenio);
    }
    
    public void borrarConvenio(int id) throws NonexistentEntityException{
        persistencia.borrarConvenio(id);
    }
    
    public List<Convenio> obtenerConvenios(){
        return persistencia.obtenerConvenios();
    }
    
    public Convenio obtenerConvenio(int id){
        return persistencia.obtenerConvenio(id);
    }
    
    //fin abm convenios 
    //inicio abm Produccion
    
    public void agregarProduccion(Double producido, int mes, int year, Convenio unConvenio, Calendar fecha, String factura, Double cobrado) throws PreexistingEntityException{
        Produccion unaProduccion = new Produccion(producido, mes, year, unConvenio,fecha, factura, cobrado);
        if(this.obtenerProduccion(mes, year, unConvenio) == null){
            persistencia.agregarProduccion(unaProduccion);
        }else{
            throw new PreexistingEntityException("Ya existe la produccion " + unaProduccion.toString());
        }
        
    }
    
    public void modificarProduccion(Produccion unaProduccion) throws Exception{
         persistencia.modificarProduccion(unaProduccion);
    }
    
    public void borrarProduccion(int id) throws NonexistentEntityException{
        persistencia.borrarProduccion(id);
    }
    
    public Produccion obtenerProduccion(int id){
        return persistencia.obtenerProduccion(id);
    }
    
    public List<Produccion> obtenerProducciones(){
        List produccion = persistencia.obtenerProducciones();
        Collections.sort(produccion);
        return produccion;
    }
    
    public List<Produccion> obtenerProducciones(int year, Convenio unConvenio){
        List<Produccion> produccionesConvenio = new ArrayList<>();
        Produccion unaProduccion = new Produccion();
        Iterator it = this.persistencia.obtenerProducciones().iterator();
        while(it.hasNext()){
            unaProduccion = (Produccion) it.next();
            if(unaProduccion.getYear() == year && unaProduccion.getUnConvenio().equals(unConvenio)){
                produccionesConvenio.add(unaProduccion);
            }
        }
        return produccionesConvenio;
    }
    
    public Produccion obtenerProduccion(int mes, int year, Convenio unConvenio){
        Produccion unaProduccion = null;
        Iterator it = this.obtenerProducciones(year, unConvenio).iterator();// no esta trayendo convenio
        boolean existe = false;
        while(it.hasNext()&&(!existe)){
            unaProduccion = (Produccion) it.next();//terminar cuando existe es true
            if(unaProduccion.getMes() == mes){
                existe = true;
            }
        }
        if(existe == false){
            unaProduccion = null;
        }
        return unaProduccion;
    }
    
    public Double obtenerImporteCobradoMes( int mes, int year, Convenio unConvenio){
        Double importeCobrado = 0.0;
        Produccion unaProduccion = null;
        Iterator it = this.obtenerProducciones(year, unConvenio).iterator();
        while(it.hasNext()){
            unaProduccion = (Produccion) it.next();
            if(unaProduccion.obtenerMesCobro() == mes){
                importeCobrado+=unaProduccion.getImporteCobrador();
            }
        }
        return importeCobrado;
    }
    
    public boolean existeProduccion(int mes, int year, Convenio unConvenio){
        boolean existe = false;
        if(this.obtenerProduccion(mes,year,unConvenio) != null) existe = true;
        return existe;
    }
    
    //fin abm produccion
    //Obtencion de Listados
    public double obtenerListadoDelCobrador(Cobrador unCobrador, int year , int mes){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasDeCobrador(unCobrador, year)){
            if(unaCobranza.getMes() == mes){
                total += unaCobranza.getListado();
            }
        }
        return total;
    }
    
    public double obtenerListadoDelCobrador(Cobrador unCobrador, int year , int mes, Area unArea){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasDeCobrador(unCobrador, year)){
            if((unaCobranza.getMes() == mes)&&(unaCobranza.getUnArea().equals(unArea))){
                total += unaCobranza.getListado();
            }
        }
        return total;
    }
    
    public double obtenerListadoDelCobrador(Cobrador unCobrador, int year){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasDeCobrador(unCobrador, year)){
            total += unaCobranza.getListado();
        }
        return total;
    }
    
    public double obtenerListadoDelCobrador(Cobrador unCobrador, int year , Area unArea){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasDeCobrador(unCobrador, year)){
            if(unaCobranza.getUnArea().equals(unArea)){
                total += unaCobranza.getListado();
            }
        }
        return total;
    }
    
    public double obtenerListadoDeArea(int year, Area unArea){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzaDeCartera(unArea, year)){
            total += unaCobranza.getListado();
        }
        return total;
    }
    
    public double obtenerListadoMesArea(int year, int mes, Area unArea){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasArea(unArea, year)){
            if(unaCobranza.getMes() == mes){
                total += unaCobranza.getListado();
            }
        }
        return total;
    }
    
    public double obtenerListadoMesYear(int year, int mes){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasYear( year)){
            if(unaCobranza.getMes() == mes){
                total += unaCobranza.getListado();
            }
        }
        return total;
    }
    
    public double obtenerListadoYear(int year){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasYear(year)){
            total += unaCobranza.getListado();
        }
        return total;
    }
    
    //Fin Obtencion de listados.
    //Obtencion de Afiliados.
    
    public double obtenerAfiliadoDelCobrador(Cobrador unCobrador, int year , int mes){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasDeCobrador(unCobrador, year)){
            if(unaCobranza.getMes() == mes){
                total += unaCobranza.calcularAfiliadoTotal();
            }
        }
        return total;
    }
    
    public double obtenerAfiliadoDelCobrador(Cobrador unCobrador, int year , int mes, Area unArea){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasDeCobrador(unCobrador, year)){
            if((unaCobranza.getMes() == mes)&&(unaCobranza.getUnArea().equals(unArea))){
                total += unaCobranza.calcularAfiliadoTotal();
            }
        }
        return total;
    }
    
    public double obtenerAfiliadoDelCobrador(Cobrador unCobrador, int year ){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasDeCobrador(unCobrador, year)){
            total += unaCobranza.calcularAfiliadoTotal();
        }
        return total;
    }
    
    public double obtenerAfiliadoDelCobrador(Cobrador unCobrador, int year, Area unArea){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasDeCobrador(unCobrador, year)){
            if(unaCobranza.getUnArea().equals(unArea)){
                total += unaCobranza.calcularAfiliadoTotal();
            }
        }
        return total;
    }
    
    public double ObtenerAfiliadoDeArea(int year, Area unArea){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasArea(unArea,year)){
            if(unaCobranza.getUnArea().equals(unArea)){
                total += unaCobranza.calcularAfiliadoTotal();
            }
        }
        return total;
    }
    
    public double obtenerAfiliadoMesArea(int year, int mes , Area unArea){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasArea(unArea, year)){
            if(unaCobranza.getMes() == mes){
                total += unaCobranza.calcularAfiliadoTotal();
            }
        }
        return total;
    }
    
    public double obtenerAfiliadoMesYear(int year, int mes){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasYear( year)){
            if(unaCobranza.getMes() == mes){
                total += unaCobranza.calcularAfiliadoTotal();
            }
        }
        return total;
    }
    
    public double obtenerAfiliadoYear(int year){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasYear(year)){
            total += unaCobranza.calcularAfiliadoTotal();
        }
        return total;
    }
    
    //Fin Obtencion de Afiliados.
    //Obtencion de Comisiones.
    
    public double obtenerComisionDelCobrador(Cobrador unCobrador, int year , int mes){
        double total = 0;
        total = (unCobrador.getUnaComision() * this.obtenerAfiliadoDelCobrador(unCobrador, year, mes))/100;
        return total;
    }
    
    public double obtenerComisionDelCobrador(Cobrador unCobrador, int year , int mes, Area unArea){
        double total = 0;
        total = (unCobrador.getUnaComision() * this.obtenerAfiliadoDelCobrador(unCobrador, year, mes,unArea))/100;
        return total;
    }
    
    public double obtenerComisionDelCobrador(Cobrador unCobrador, int year){
        double total = 0;
        total = (unCobrador.getUnaComision() * this.obtenerAfiliadoDelCobrador(unCobrador, year))/100;
        return total;
    }
    
    public double obtenerComisionDelCobrador(Cobrador unCobrador, int year, Area unArea){
        double total = 0;
        total = (unCobrador.getUnaComision() * this.obtenerAfiliadoDelCobrador(unCobrador, year, unArea))/100;
        return total;
    }
    
    public double obtenerComisionDeArea(int year, Area unArea){
        double total = 0;
        for(Cobranza unaCobranza:this.obtenerCobranzasArea(unArea, year)){
            total += (unaCobranza.getUnCobrador().getUnaComision() * unaCobranza.calcularAfiliadoTotal())/100;
        }
        return total;
    }
    
    public double obtenerComisionMesArea(int year, int mes, Area unArea){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasArea(unArea, year)){
            if(unaCobranza.getMes() == mes){
                total += (unaCobranza.getUnCobrador().getUnaComision() * unaCobranza.calcularAfiliadoTotal())/100;
            }
        }
        return total;
    }
    
    public double obtenerComisionMesYear(int year, int mes){
        double total = 0;
        for(Cobranza unaCobranza: this.obtenerCobranzasYear(year)){
            if(unaCobranza.getMes() == mes){
                total += (unaCobranza.getUnCobrador().getUnaComision() * unaCobranza.calcularAfiliadoTotal())/100;
            }
        }
        return total;
    }
    
    public double obtenerComisionYear(int year){
        double total = 0;
        for(Cobranza unaCobranza:this.obtenerCobranzasYear(year)){
            total += (unaCobranza.getUnCobrador().getUnaComision() * unaCobranza.calcularAfiliadoTotal())/100;
        }
        return total;
    }
    
    //Fin obtencion de Comision.
    //Obtencion de Neto
    
    public double obtenerNetoDelCobrador(Cobrador unCobrador, int year , int mes){
        double total = 0;
        total = this.obtenerAfiliadoDelCobrador(unCobrador, year, mes) - this.obtenerComisionDelCobrador(unCobrador, year, mes);
        return total;
    }
    
    public double obtenerNetoDelCobrador(Cobrador unCobrador, int year , int mes,Area unArea){
        double total = 0;
        total = this.obtenerAfiliadoDelCobrador(unCobrador, year, mes,unArea) - this.obtenerComisionDelCobrador(unCobrador, year, mes,unArea);
        return total;
    }
    
    public double obtenerNetoDelCobrador(Cobrador unCobrador, int year){
        double total = 0;
        total = this.obtenerAfiliadoDelCobrador(unCobrador, year) - this.obtenerComisionDelCobrador(unCobrador, year);
        return total;
    }
    
    public double obtenerNetoDelCobrador(Cobrador unCobrador, int year,Area unArea){
        double total = 0;
        total = this.obtenerAfiliadoDelCobrador(unCobrador, year,unArea) - this.obtenerComisionDelCobrador(unCobrador, year,unArea);
        return total;
    }
    
    public double obtenerNetoDeArea(int year, Area unaArea){
        double total = 0;
        total += this.ObtenerAfiliadoDeArea(year, unaArea) - this.obtenerComisionDeArea(year, unaArea);
        return total;
    }
    
    public double obtenerNetoMesArea(int year, int mes, Area unArea){
        return this.obtenerAfiliadoMesArea(year, mes, unArea) - this.obtenerComisionMesArea(year, mes, unArea);
    }
    
    public double obtenerNetoMesYear(int year, int mes){
        return this.obtenerAfiliadoMesYear(year, mes) - this.obtenerComisionMesYear(year, mes);
    }
    
    public double obtenerNetoYear(int year){
        return this.obtenerAfiliadoYear(year) - this.obtenerComisionYear(year);
    }
    
    //Fin obtencion de Neto
    
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
   
    public List<Cobranza> obtenerCobranzasYear(int year){
        List<Cobranza> cobranzasAll = new ArrayList<>();
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext()){
                unaCobranza = (Cobranza) it.next();
                if( unaCobranza.getYear() == year){
                    cobranzasAll.add(unaCobranza);
                }
            }
        return cobranzasAll;
    }
    
    public List<Cobranza> obtenerCobranzasArea(Area unArea, int year){
        List<Cobranza> cobranzasAll = new ArrayList<>();
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext()){
                unaCobranza = (Cobranza) it.next();
                if(( unaCobranza.getYear() == year)&&(unaCobranza.getUnArea().equals(unArea))){
                    cobranzasAll.add(unaCobranza);
                }
            }
        return cobranzasAll;
    }
    
    public List<Cobranza> obtenerCobranzasAreaCobrador(Area unArea, int year,Cobrador unCobrador){
        List<Cobranza> cobranzasAll = new ArrayList<>();
        Iterator it = this.persistencia.obtenerCobranzas().iterator();
            Cobranza unaCobranza = new Cobranza();
            while(it.hasNext()){
                unaCobranza = (Cobranza) it.next();
                if(( unaCobranza.getYear() == year)&&(unaCobranza.getUnArea().equals(unArea))&&unaCobranza.getUnCobrador().equals(unCobrador)){
                    cobranzasAll.add(unaCobranza);
                }
            }
        return cobranzasAll;
    }
    
}