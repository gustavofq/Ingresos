
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.Temporal;
@Entity
public class Produccion implements Serializable, Comparable<Produccion> {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private Double producido;
    @Basic
    private int mes;
    @Basic
    private int year;
    @OneToOne
    private Convenio unConvenio;
    @Basic
    private String estado;
    @Basic
    private Double importeCobrador;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaCobrado;
    @Basic
    private String nFactura;
    
    public Produccion() {
    }

    public Produccion(int id, Double producido, int mes, int año, Convenio unConvenio, String estado) {
        this.id = id;
        this.producido = producido;
        this.mes = mes;
        this.year = año;
        this.unConvenio = unConvenio;
        this.estado = estado;
    }

    public Produccion(Double producido, int mes, int año, Convenio unConvenio) {
        this.producido = producido;
        this.mes = mes;
        this.year = año;
        this.unConvenio = unConvenio;
        this.nFactura = "".toUpperCase();
        this.importeCobrador=0.0;
        this.fechaCobrado = null;
        this.noEnviar();
    }
    
    
    public Produccion(Double producido, int mes, int año, Convenio unConvenio, Calendar fecha, String factura, Double cobrado) {
        this.producido = producido;
        this.mes = mes;
        this.year = año;
        this.unConvenio = unConvenio;
        this.nFactura = factura.toUpperCase();
        this.importeCobrador=cobrado;
        this.fechaCobrado = fecha;
        this.noEnviar();
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public Double getImporteCobrador() {
        return importeCobrador;
    }

    public void setImporteCobrador(Double importeCobrador) {
        this.importeCobrador = importeCobrador;
    }

    public Calendar getFechaCobrado() {
        return fechaCobrado;
    }

    public void setFechaCobrado(Calendar fechaCobrado) {
        this.fechaCobrado = fechaCobrado;
    }

    public String getnFactura() {
        return nFactura.toUpperCase();
    }

    public void setnFactura(String nFactura) {
        this.nFactura = nFactura.toUpperCase();
    }

    public int  obtenerMesCobro(){
        int mesCobro = -1;
        if(fechaCobrado != null){
            mesCobro = this.fechaCobrado.get(Calendar.MONTH);
        }
        
        return mesCobro;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.producido);
        hash = 13 * hash + this.mes;
        hash = 13 * hash + this.year;
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
    
    public boolean isPagado(){
        boolean pagado = false;
        if(this.producido.equals(this.importeCobrador)){
            pagado = true;
        }
        return pagado;
    } 

    @Override
    public int compareTo(Produccion o) {
        int resultado = 1;
        if(this.year == o.getYear() && this.mes == o.getMes()){
            resultado = 0;
        }else if(this.year == o.getYear()){
            if(this.mes < o.getMes()){
                resultado = -1;
            }
        }else if(this.year < o.getYear()){
            resultado = -1;
        }
        return resultado;   
    }

    @Override
    public String toString() {
        return "Produccion{" + "id=" + id + ", producido=" + producido + ", mes=" + mes + ", year=" + year + ", unConvenio=" + unConvenio + ", importeCobrador=" + importeCobrador + " mes: "+this.fechaCobrado.get(Calendar.MONTH)+'}';
    }
    
    
    
}
