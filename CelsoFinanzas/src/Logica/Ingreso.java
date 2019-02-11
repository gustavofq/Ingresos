package Logica;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
@Entity
public class Ingreso implements Serializable,Comparable<Ingreso> {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private Double Afiliado;
    @Basic
    private String concepto;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fecha;
    @Basic 
    private Double pagado;
    @Basic 
    private int fila;
    
    public Ingreso() {
    }

    public Ingreso(int id, Double Afiliado, String concepto, Calendar fecha) {
        this.id = id;
        this.Afiliado = Afiliado;
        this.concepto = concepto;
        this.fecha = fecha;
        this.pagado = 0.0;
        this.fila = 0;
    }

    public Ingreso(Double Afiliado, String concepto, Calendar fecha) {
        this.Afiliado = Afiliado;
        this.concepto = concepto;
        this.fecha = fecha;
        this.pagado = 0.0;
         this.fila = 0;
    }

    public Ingreso(Double Afiliado, String concepto, Calendar fecha, Cobranza unaCobranza) {
        this.Afiliado = Afiliado;
        this.concepto = concepto;
        this.fecha = fecha;
        this.pagado = 0.0;
        this.fila = 0;
    }

    public Ingreso(Double Afiliado, String concepto, Calendar fecha, Cobranza unaCobranza ,int fila) {
        this.Afiliado = Afiliado;
        this.concepto = concepto;
        this.fecha = fecha;
        this.pagado = 0.0;
        this.fila = fila;
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

    public Double getPagado() {
        return pagado;
    }

    public void setPagado(Double pagado) {
        this.pagado = pagado;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
    
    
    
    @Override
    public String toString() {
        return "Ingreso{" + "id=" + id + ", Afiliado=" + Afiliado + ", concepto=" + concepto + ", fecha=" + fecha + '}';
    } 

    @Override
    public int compareTo(Ingreso o) {
        return this.fecha.compareTo(o.getFecha());
    }
}
