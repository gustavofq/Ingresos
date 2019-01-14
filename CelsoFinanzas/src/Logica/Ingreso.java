
package Logica;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
@Entity
public class Ingreso implements Serializable {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private Double Afiliado;
    @Basic
    private String concepto;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fecha;
   /* @OneToOne
    private Cobranza unaCobranza;*/

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

    public Ingreso(Double Afiliado, String concepto, Calendar fecha, Cobranza unaCobranza) {
        this.Afiliado = Afiliado;
        this.concepto = concepto;
        this.fecha = fecha;
        //this.unaCobranza = unaCobranza;
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

    public String obtenerDate(){
       Calendar cal = this.fecha;
       Date dat = cal.getTime();
       Format formatter = new SimpleDateFormat("dd/MM/yyyy");
       String s = formatter.format(dat);
       return s;
    }
    
    @Override
    public String toString() {
        return "Ingreso{" + "id=" + id + ", Afiliado=" + Afiliado + ", concepto=" + concepto + ", fecha=" + fecha + '}';
    } 
}
