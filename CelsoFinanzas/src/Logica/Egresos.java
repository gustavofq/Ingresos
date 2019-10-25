package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Egresos implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private int mes;
    @Basic
    private int year;
    @Basic
    private double impuestos;
    @Basic
    private double subTotal;

    public Egresos() {
    }

    public Egresos(int id, int mes, int year, double impuestos, double subTotal) {
        this.id = id;
        this.mes = mes;
        this.year = year;
        this.impuestos = impuestos;
        this.subTotal = subTotal;
    }

    public Egresos(int mes, int year, double impuestos, double subTotal) {
        this.mes = mes;
        this.year = year;
        this.impuestos = impuestos;
        this.subTotal = subTotal;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    public Double obtenerImporteEgresos(){
        return this.impuestos + this.subTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.mes;
        hash = 79 * hash + this.year;
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
        final Egresos other = (Egresos) obj;
        if (this.mes != other.mes) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }
    
}
