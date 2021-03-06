package Logica;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cobrador implements Serializable, Comparable<Cobrador> {
    @Basic
    private String nombre;
    @Basic
    private String alias;
    @Basic 
    private String apellido;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long dni;
    @Basic
    private int unaComision;

    public Cobrador() {
    }

    public Cobrador(String nombre, String alias, String apellido, long dni, int unaComision) {
        this.nombre = nombre;
        this.alias = alias;
        this.apellido = apellido;
        this.dni = dni;
        this.unaComision = unaComision;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getUnaComision() {
        return unaComision;
    }

    public void setUnaComision(int unaComision) {
        this.unaComision = unaComision;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido +" (" + alias +")";
    }

    @Override
    public int compareTo(Cobrador o) {
        return this.apellido.compareTo(o.getApellido());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.alias);
        hash = 37 * hash + Objects.hashCode(this.apellido);
        hash = 37 * hash + (int) (this.dni ^ (this.dni >>> 32));
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
        final Cobrador other = (Cobrador) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }
    
    
}
