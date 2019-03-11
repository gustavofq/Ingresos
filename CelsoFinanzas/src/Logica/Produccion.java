
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Produccion implements Serializable {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private Double producido;
    @Basic
    private int mes;
    @Basic
    private int año;
    @OneToOne
    private Convenio unConvenio;
    @Basic
    private String estado;
    @OneToMany
    private List<Cobro> cobrado = new ArrayList<>();

    public Produccion() {
    }

    public Produccion(int id, Double producido, int mes, int año, Convenio unConvenio, String estado) {
        this.id = id;
        this.producido = producido;
        this.mes = mes;
        this.año = año;
        this.unConvenio = unConvenio;
        this.estado = estado;
    }

    public Produccion(Double producido, int mes, int año, Convenio unConvenio) {
        this.producido = producido;
        this.mes = mes;
        this.año = año;
        this.unConvenio = unConvenio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getProducido() {
        return producido;
    }

    public void setProducido(Double producido) {
        this.producido = producido;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Convenio getUnConvenio() {
        return unConvenio;
    }

    public void setUnConvenio(Convenio unConvenio) {
        this.unConvenio = unConvenio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.producido);
        hash = 13 * hash + this.mes;
        hash = 13 * hash + this.año;
        hash = 13 * hash + Objects.hashCode(this.unConvenio);
        hash = 13 * hash + Objects.hashCode(this.estado);
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
        final Produccion other = (Produccion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.unConvenio, other.unConvenio)) {
            return false;
        }
        return true;
    }

    public void enviarMail(){
        this.estado ="enviado por mail.";
    }
    
    public void enviarFisico(){
        this.estado = "enviado fisicamente.";
    }
    
    public void noEnviar(){
        this.estado = "no enviado.";
    }
    
    
    public void agregarCobro(Cobro unCobro){
        this.cobrado.add(unCobro);
    }
    
    public void modificarCobro(Cobro oldCobro, Cobro newCobro){
        this.cobrado.set(oldCobro.getId(), newCobro);
    }
    
    public void borrarCobro(Cobro unCobro){
        this.cobrado.remove(unCobro.getId());
    }
    
    public List<Cobro> obtenerCobros(){
        return this.cobrado;
    }
    
    public Double obtenerCobro(){
        Double total = 0.0;
        Cobro unCobro;
        Iterator it = this.cobrado.iterator();
        while(it.hasNext()){
            unCobro = (Cobro)it.next();
            total += unCobro.getImporte();
        }
        return total;
    }
    
    public boolean isPagado(){
        boolean pagado = false;
        if(this.producido.equals(this.obtenerCobro())){
            pagado = true;
        }
        return pagado;
    } 
    
}
