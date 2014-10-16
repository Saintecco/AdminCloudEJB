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
@Table(name = "claves_arqueo_de_caja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClavesArqueoDeCaja.findAll", query = "SELECT c FROM ClavesArqueoDeCaja c"),
    @NamedQuery(name = "ClavesArqueoDeCaja.findByIdClaveArqueoDeCaja", query = "SELECT c FROM ClavesArqueoDeCaja c WHERE c.idClaveArqueoDeCaja = :idClaveArqueoDeCaja"),
    @NamedQuery(name = "ClavesArqueoDeCaja.findByClaveArqueoDeCaja", query = "SELECT c FROM ClavesArqueoDeCaja c WHERE c.claveArqueoDeCaja = :claveArqueoDeCaja"),
    @NamedQuery(name = "ClavesArqueoDeCaja.findByFechaCreacion", query = "SELECT c FROM ClavesArqueoDeCaja c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ClavesArqueoDeCaja.findByUltimaEdicion", query = "SELECT c FROM ClavesArqueoDeCaja c WHERE c.ultimaEdicion = :ultimaEdicion")})
public class ClavesArqueoDeCaja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clave_arqueo_de_caja")
    private Integer idClaveArqueoDeCaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "clave_arqueo_de_caja")
    private String claveArqueoDeCaja;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Clinicas idClinica;

    public ClavesArqueoDeCaja() {
    }

    public ClavesArqueoDeCaja(Integer idClaveArqueoDeCaja) {
        this.idClaveArqueoDeCaja = idClaveArqueoDeCaja;
    }

    public ClavesArqueoDeCaja(Integer idClaveArqueoDeCaja, String claveArqueoDeCaja, Date fechaCreacion, Date ultimaEdicion) {
        this.idClaveArqueoDeCaja = idClaveArqueoDeCaja;
        this.claveArqueoDeCaja = claveArqueoDeCaja;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
    }

    public Integer getIdClaveArqueoDeCaja() {
        return idClaveArqueoDeCaja;
    }

    public void setIdClaveArqueoDeCaja(Integer idClaveArqueoDeCaja) {
        this.idClaveArqueoDeCaja = idClaveArqueoDeCaja;
    }

    public String getClaveArqueoDeCaja() {
        return claveArqueoDeCaja;
    }

    public void setClaveArqueoDeCaja(String claveArqueoDeCaja) {
        this.claveArqueoDeCaja = claveArqueoDeCaja;
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
        hash += (idClaveArqueoDeCaja != null ? idClaveArqueoDeCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClavesArqueoDeCaja)) {
            return false;
        }
        ClavesArqueoDeCaja other = (ClavesArqueoDeCaja) object;
        if ((this.idClaveArqueoDeCaja == null && other.idClaveArqueoDeCaja != null) || (this.idClaveArqueoDeCaja != null && !this.idClaveArqueoDeCaja.equals(other.idClaveArqueoDeCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.ClavesArqueoDeCaja[ idClaveArqueoDeCaja=" + idClaveArqueoDeCaja + " ]";
    }
    
}
