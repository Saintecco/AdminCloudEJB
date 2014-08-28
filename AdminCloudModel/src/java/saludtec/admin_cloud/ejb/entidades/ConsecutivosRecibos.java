/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admin_cloud.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saintec
 */
@Entity
@Table(name = "consecutivos_recibos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsecutivosRecibos.findAll", query = "SELECT c FROM ConsecutivosRecibos c"),
    @NamedQuery(name = "ConsecutivosRecibos.findByIdInformacionFacturacion", query = "SELECT c FROM ConsecutivosRecibos c WHERE c.idInformacionFacturacion = :idInformacionFacturacion"),
    @NamedQuery(name = "ConsecutivosRecibos.findByNumeroActual", query = "SELECT c FROM ConsecutivosRecibos c WHERE c.numeroActual = :numeroActual"),
    @NamedQuery(name = "ConsecutivosRecibos.findByFechaCreacion", query = "SELECT c FROM ConsecutivosRecibos c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ConsecutivosRecibos.findByUltimaEdicion", query = "SELECT c FROM ConsecutivosRecibos c WHERE c.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "ConsecutivosRecibos.findByEstado", query = "SELECT c FROM ConsecutivosRecibos c WHERE c.estado = :estado"),
    @NamedQuery(name = "ConsecutivosRecibos.findByIdClinica", query = "SELECT c FROM ConsecutivosRecibos c WHERE c.idClinica = :idClinica")})
public class ConsecutivosRecibos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_informacion_facturacion")
    private Integer idInformacionFacturacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_actual")
    private int numeroActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultima_edicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaEdicion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_clinica")
    private int idClinica;

    public ConsecutivosRecibos() {
    }

    public ConsecutivosRecibos(Integer idInformacionFacturacion) {
        this.idInformacionFacturacion = idInformacionFacturacion;
    }

    public ConsecutivosRecibos(Integer idInformacionFacturacion, int numeroActual, Date fechaCreacion, Date ultimaEdicion, String estado, int idClinica) {
        this.idInformacionFacturacion = idInformacionFacturacion;
        this.numeroActual = numeroActual;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
        this.idClinica = idClinica;
    }

    public Integer getIdInformacionFacturacion() {
        return idInformacionFacturacion;
    }

    public void setIdInformacionFacturacion(Integer idInformacionFacturacion) {
        this.idInformacionFacturacion = idInformacionFacturacion;
    }

    public int getNumeroActual() {
        return numeroActual;
    }

    public void setNumeroActual(int numeroActual) {
        this.numeroActual = numeroActual;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimaEdicion() {
        return ultimaEdicion;
    }

    public void setUltimaEdicion(Date ultimaEdicion) {
        this.ultimaEdicion = ultimaEdicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformacionFacturacion != null ? idInformacionFacturacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsecutivosRecibos)) {
            return false;
        }
        ConsecutivosRecibos other = (ConsecutivosRecibos) object;
        if ((this.idInformacionFacturacion == null && other.idInformacionFacturacion != null) || (this.idInformacionFacturacion != null && !this.idInformacionFacturacion.equals(other.idInformacionFacturacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admin_cloud.ejb.entidades.ConsecutivosRecibos[ idInformacionFacturacion=" + idInformacionFacturacion + " ]";
    }
    
}
