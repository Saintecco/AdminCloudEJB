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
@Table(name = "como_supo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComoSupo.findAll", query = "SELECT c FROM ComoSupo c"),
    @NamedQuery(name = "ComoSupo.findByIdComoSupo", query = "SELECT c FROM ComoSupo c WHERE c.idComoSupo = :idComoSupo"),
    @NamedQuery(name = "ComoSupo.findByComoSupo", query = "SELECT c FROM ComoSupo c WHERE c.comoSupo = :comoSupo"),
    @NamedQuery(name = "ComoSupo.findByFechaCreacion", query = "SELECT c FROM ComoSupo c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ComoSupo.findByUltimaEdicion", query = "SELECT c FROM ComoSupo c WHERE c.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "ComoSupo.findByEstado", query = "SELECT c FROM ComoSupo c WHERE c.estado = :estado")})
public class ComoSupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_como_supo")
    private Integer idComoSupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "como_supo")
    private String comoSupo;
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
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;

    public ComoSupo() {
    }

    public ComoSupo(Integer idComoSupo) {
        this.idComoSupo = idComoSupo;
    }

    public ComoSupo(Integer idComoSupo, String comoSupo, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idComoSupo = idComoSupo;
        this.comoSupo = comoSupo;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdComoSupo() {
        return idComoSupo;
    }

    public void setIdComoSupo(Integer idComoSupo) {
        this.idComoSupo = idComoSupo;
    }

    public String getComoSupo() {
        return comoSupo;
    }

    public void setComoSupo(String comoSupo) {
        this.comoSupo = comoSupo;
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

    public Clinicas getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinicas idClinica) {
        this.idClinica = idClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComoSupo != null ? idComoSupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComoSupo)) {
            return false;
        }
        ComoSupo other = (ComoSupo) object;
        if ((this.idComoSupo == null && other.idComoSupo != null) || (this.idComoSupo != null && !this.idComoSupo.equals(other.idComoSupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admin_cloud.ejb.entidades.ComoSupo[ idComoSupo=" + idComoSupo + " ]";
    }
    
}
