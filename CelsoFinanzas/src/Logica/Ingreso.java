
package Logica;

import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Ingreso {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @Basic
    private Double Afiliado;
    @Basic
    private String concepto;
    @Basic 
    private Calendar fecha;

    public Ingreso() {
    }

    public Ingreso(int id, Double Afiliado, String concepto, Calendar fecha) {
        this.id = id;
        this.Afiliado = Afiliado;
        this.concepto = concepto;
        this.fecha = fecha;
    }

    public Ingreso(Double Afiliado, String concepto, Calendar fecha) {
        this.Afiliado = Afiliado;
        this.concepto = concepto;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAfiliado() {
        return Afiliado;
    }

    public void setAfiliado(Double Afiliado) {
        this.Afiliado = Afiliado;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

   
}
