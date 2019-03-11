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
public class Cobro implements Serializable {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private Double importe;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaCobrado;

    public Cobro() {
    }

    public Cobro(Double importe, Calendar fechaCobrado) {
        this.importe = importe;
        this.fechaCobrado = fechaCobrado;
    }
    
    public Cobro(int ID, Double importe, Calendar fechaCobrado) {
        this.id = ID;
        this.importe = importe;
        this.fechaCobrado = fechaCobrado;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Calendar getFechaCobrado() {
        return fechaCobrado;
    }

    public void setFechaCobrado(Calendar fechaCobrado) {
        this.fechaCobrado = fechaCobrado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.importe);
        hash = 41 * hash + Objects.hashCode(this.fechaCobrado);
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
        final Cobro other = (Cobro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
   
    
}
