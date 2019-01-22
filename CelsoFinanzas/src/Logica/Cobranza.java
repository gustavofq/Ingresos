package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public  class Cobranza implements Serializable,Comparable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private Double listado;
    @Basic
    private Double afiliado;
    @Basic
    private Double neto;
    @Basic
    private int mes;
    @Basic
    private int year;
    @Basic
    private Double comision;
    @OneToOne
    private Cobrador unCobrador;
    @OneToOne
    private Area unArea;
    @OneToMany
    private List<Ingreso> Ingresos  = new ArrayList<>();
    

    public Cobranza() {
    }

    public Cobranza(Double listado, int mes, int year, Cobrador unCobrador, Area unArea) {
        this.listado = listado;
        this.mes = mes;
        this.year = year;
        this.unCobrador = unCobrador;
        this.unArea = unArea;
        this.afiliado = 0.0;
        this.comision = 0.0;
        this.neto = 0.0;
    }
    
    public Cobranza(Double listado, int mes, int year, Cobrador unCobrador, Area unArea, List<Ingreso> ingresos){
        this.listado = listado;
        this.mes = mes;
        this.year = year;
        this.unCobrador = unCobrador;
        this.unArea = unArea;
        this.Ingresos = ingresos;
        this.afiliado = 0.0;
        this.comision = 0.0;
        this.neto = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getListado() {
        return listado;
    }

    public void setListado(Double listado) {
        this.listado = listado;
    }

    public Double getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Double afiliado) {
        this.afiliado = afiliado;
    }

    public Double getNeto() {
        return neto;
    }

    public void setNeto(Double neto) {
        this.neto = neto;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public Cobrador getUnCobrador() {
        return unCobrador;
    }

    public void setUnCobrador(Cobrador unCobrador) {
        this.unCobrador = unCobrador;
    }

    public Area getUnArea() {
        return unArea;
    }

    public void setUnArea(Area unArea) {
        this.unArea = unArea;
    }

    public List<Ingreso> getIngresos() {
        List<Ingreso> ingresosObtenidos = this.Ingresos;
        Collections.sort(ingresosObtenidos);
        return ingresosObtenidos;
    }

    public void setIngresos(List<Ingreso> Ingresos) {
        this.Ingresos = Ingresos;
    }
 
    public Double calcularNeto(){
        if(this.comision == null){
           this.comision = 0.0; 
        }else{            
            Double totalComision = this.calcularComision();
            this.comision = this.calcularAfiliadoTotal() - totalComision;
        }
        
        return this.comision;
    }
    
    public Double calcularComision(){
        if(this.afiliado == null){
            this.afiliado = 0.0;
        }else{
            Double comisionCobrador = new Double(this.unCobrador.getUnaComision());
            this.comision = (  comisionCobrador * this.calcularAfiliadoTotal() ) / 100;        
        }
        return this.comision;
    }
   
    public Double calcularAfiliadoTotal(){
        Double total = new Double(0);
        for(Ingreso unIngreso: this.Ingresos){
            total += unIngreso.getAfiliado();
        }
        return total;
    }

    public void agregarIngreso(Ingreso unIngreso){
        this.Ingresos.add(unIngreso);
    }
    
    public void borrarIngreso(Ingreso unIngreso){
        this.Ingresos.remove(unIngreso);
    }
    
    public void modificarIngreso(Ingreso oldIngreso, Ingreso newIngreso){

    }
    
    @Override
    public String toString() {
        return "Cobranza{" + "id=" + id + ", listado=" + listado + ", afiliado=" + afiliado + ", neto=" + neto + ", mes=" + mes + ", year=" + year + '}';
    }

    @Override
    public int compareTo(Object o) {
        int resultado =1;
        Cobranza unaCobranza = (Cobranza) o;
        if ((this.year == unaCobranza.getYear())&&(this.mes == unaCobranza.getMes())){
            resultado = 0;
        }else if(this.year == unaCobranza.getYear()){
            if(this.mes < unaCobranza.getMes()){
                resultado = -1;
            }
        }else if(this.year < unaCobranza.getYear()){
            resultado = -1;
        }
        return resultado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.mes;
        hash = 59 * hash + this.year;
        hash = 59 * hash + Objects.hashCode(this.unCobrador);
        hash = 59 * hash + Objects.hashCode(this.unArea);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cobranza other = (Cobranza) obj;
        if (this.mes != other.mes) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.unCobrador, other.unCobrador)) {
            return false;
        }
        if (!Objects.equals(this.unArea, other.unArea)) {
            return false;
        }
        return true;
    }
    
    
    
}
