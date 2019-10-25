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

    public double getImporte() {
        return subTotal;
    }

    public void setImporte(double importe) {
        this.subTotal = importe;
    }
    
    private Double obtenerImporteEgresos(){
        return this.impuestos + this.subTotal;
    }
    
}
