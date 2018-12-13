package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cobrador implements Serializable {
    @Basic
    private String nombre;
    @Basic
    private String alias;
    @Basic 
    private String apellido;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    

}
