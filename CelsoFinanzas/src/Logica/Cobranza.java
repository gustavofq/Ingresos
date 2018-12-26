package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cobranza implements Serializable {
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
    private String concepto;
    @Basic
    private Double comision;
    @OneToOne
    private Cobrador unCobrador;
    @OneToOne
    private Area unArea;
    private List<Ingreso> ingresos = new ArrayList<>();

    public Cobranza() {
    }

    public Cobranza(int id, Double listado, Double afiliado, Double neto, int mes, int year, String concepto, Double comision, Cobrador unCobrador, Area unArea) {
        this.id = id;
        this.listado = listado;
        this.afiliado = afiliado;
        this.neto = neto;
        this.mes = mes;
        this.year = year;
        this.concepto = concepto;
        this.comision = comision;
        this.unCobrador = unCobrador;
        this.unArea = unArea;
    }

    public Cobranza(Double listado, Double afiliado, Double neto, int mes, int year, String concepto, Double comision, Cobrador unCobrador, Area unArea) {
        this.listado = listado;
        this.afiliado = afiliado;
        this.neto = neto;
        this.mes = mes;
        this.year = year;
        this.concepto = concepto;
        this.comision = comision;
        this.unCobrador = unCobrador;
        this.unArea = unArea;
    }

    public Cobranza(Double listado, Double afiliado, int mes, int year, String concepto, Cobrador unCobrador, Area unArea) {
        this.listado = listado;
        this.afiliado = afiliado;
        this.mes = mes;
        this.year = year;
        this.concepto = concepto;
        this.unCobrador = unCobrador;
        this.unArea = unArea;
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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
    
    public void calcularNeto(){
            this.neto = this.afiliado - this.comision;
    }
    
    public void calcularComision(){
        this.comision = (this.unCobrador.getUnaComision() * this.afiliado)/100;
    }
   
}
