package Logica;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
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

    public Ingreso(Double Afiliado, String concepto, Calendar fecha, int fila) {
        this.Afiliado = Afiliado;
        this.concepto = concepto;
        this.fecha = fecha;
        this.pagado = 0.0;
         this.fila = fila;
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
    
    public void pagar(){
        this.pagado = 1.0;
        if(!this.concepto.contains("(pagado)")){
            this.concepto = this.concepto +"(pagado)";
        }
        
    }
    
    public void noPagar(){
        this.pagado=0.0;
        String texto = this.concepto;
        String sinTexto = texto.replace("(pagado)", "");
        this.concepto= sinTexto;
    }

    public boolean isPagado(){
        boolean estaPagado = false;
        if(this.pagado!=0.0){
            estaPagado = true;
        }
        return estaPagado;
    }
    
    @Override
    public String toString() {
        return "Ingreso{" + "id=" + id + ", Afiliado=" + Afiliado + ", concepto=" + concepto + ", fecha=" + fecha + '}';
    } 

    @Override
    public int compareTo(Ingreso o) {
        return this.fecha.compareTo(o.getFecha());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object unIngreso) {
        Ingreso otroIngreso = (Ingreso) unIngreso;
        boolean iguales = true;
        if(!this.Afiliado.equals(otroIngreso.getAfiliado())){
            iguales = false;
        }
        if(!this.concepto.equals(otroIngreso.getConcepto())){
            iguales = false;
        }
        if(!this.fecha.equals(otroIngreso.getFecha())){
            iguales = false;
        }
        if(this.id != otroIngreso.getId()){
            iguales = false;
        }
        if(this.fila != otroIngreso.getFila()){
            iguales = false;
        }
        return iguales;
    }
    
    
}
