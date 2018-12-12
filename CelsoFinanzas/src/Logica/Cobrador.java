package Logica;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cobrador {
    @Basic
    private String nombre;
    @Basic
    private String alias;
    @Id
    private long dni;
    @OneToOne
    private ComisionC unaComision;

    public Cobrador() {
    }

    public Cobrador(String nombre, String alias, long dni, ComisionC unaComision) {
        this.nombre = nombre;
        this.alias = alias;
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

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public ComisionC getUnaComision() {
        return unaComision;
    }

    public void setUnaComision(ComisionC unaComision) {
        this.unaComision = unaComision;
    }

}
