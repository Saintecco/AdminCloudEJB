/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "claves_correccion_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClavesCorreccionFactura.findAll", query = "SELECT c FROM ClavesCorreccionFactura c"),
    @NamedQuery(name = "ClavesCorreccionFactura.findByIdClaveCorreccionFactura", query = "SELECT c FROM ClavesCorreccionFactura c WHERE c.idClaveCorreccionFactura = :idClaveCorreccionFactura"),
    @NamedQuery(name = "ClavesCorreccionFactura.findByClaveCorreccionFactura", query = "SELECT c FROM ClavesCorreccionFactura c WHERE c.claveCorreccionFactura = :claveCorreccionFactura"),
    @NamedQuery(name = "ClavesCorreccionFactura.findByFechaCreacion", query = "SELECT c FROM ClavesCorreccionFactura c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ClavesCorreccionFactura.findByUltimaEdicion", query = "SELECT c FROM ClavesCorreccionFactura c WHERE c.ultimaEdicion = :ultimaEdicion")})
public class ClavesCorreccionFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clave_correccion_factura")
    private Integer idClaveCorreccionFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "clave_correccion_factura")
    private String claveCorreccionFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ultima_edicion")
    @Temporal(TemporalType.DATE)
    private Date ultimaEdicion;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;

    public ClavesCorreccionFactura() {
    }

    public ClavesCorreccionFactura(Integer idClaveCorreccionFactura) {
        this.idClaveCorreccionFactura = idClaveCorreccionFactura;
    }

    public ClavesCorreccionFactura(Integer idClaveCorreccionFactura, String claveCorreccionFactura, Date fechaCreacion, Date ultimaEdicion) {
        this.idClaveCorreccionFactura = idClaveCorreccionFactura;
        this.claveCorreccionFactura = claveCorreccionFactura;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
    }

    public Integer getIdClaveCorreccionFactura() {
        return idClaveCorreccionFactura;
    }

    public void setIdClaveCorreccionFactura(Integer idClaveCorreccionFactura) {
        this.idClaveCorreccionFactura = idClaveCorreccionFactura;
    }

    public String getClaveCorreccionFactura() {
        return claveCorreccionFactura;
    }

    public void setClaveCorreccionFactura(String claveCorreccionFactura) {
        this.claveCorreccionFactura = claveCorreccionFactura;
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

    public Clinicas getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinicas idClinica) {
        this.idClinica = idClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClaveCorreccionFactura != null ? idClaveCorreccionFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClavesCorreccionFactura)) {
            return false;
        }
        ClavesCorreccionFactura other = (ClavesCorreccionFactura) object;
        if ((this.idClaveCorreccionFactura == null && other.idClaveCorreccionFactura != null) || (this.idClaveCorreccionFactura != null && !this.idClaveCorreccionFactura.equals(other.idClaveCorreccionFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.ClavesCorreccionFactura[ idClaveCorreccionFactura=" + idClaveCorreccionFactura + " ]";
    }
    
}
