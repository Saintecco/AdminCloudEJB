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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "estratos_sociales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstratosSociales.findAll", query = "SELECT e FROM EstratosSociales e"),
    @NamedQuery(name = "EstratosSociales.findByIdEstratoSocial", query = "SELECT e FROM EstratosSociales e WHERE e.idEstratoSocial = :idEstratoSocial"),
    @NamedQuery(name = "EstratosSociales.findByEstratoSocial", query = "SELECT e FROM EstratosSociales e WHERE e.estratoSocial = :estratoSocial"),
    @NamedQuery(name = "EstratosSociales.findByFechaCreacion", query = "SELECT e FROM EstratosSociales e WHERE e.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "EstratosSociales.findByUltimaEdicion", query = "SELECT e FROM EstratosSociales e WHERE e.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "EstratosSociales.findByEstado", query = "SELECT e FROM EstratosSociales e WHERE e.estado = :estado"),
    @NamedQuery(name = "EstratosSociales.findByIdClinica", query = "SELECT e FROM EstratosSociales e WHERE e.idClinica = :idClinica")})
public class EstratosSociales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estrato_social")
    private Integer idEstratoSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "estrato_social")
    private String estratoSocial;
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

    public EstratosSociales() {
    }

    public EstratosSociales(Integer idEstratoSocial) {
        this.idEstratoSocial = idEstratoSocial;
    }

    public EstratosSociales(Integer idEstratoSocial, String estratoSocial, Date fechaCreacion, Date ultimaEdicion, String estado, int idClinica) {
        this.idEstratoSocial = idEstratoSocial;
        this.estratoSocial = estratoSocial;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
        this.idClinica = idClinica;
    }

    public Integer getIdEstratoSocial() {
        return idEstratoSocial;
    }

    public void setIdEstratoSocial(Integer idEstratoSocial) {
        this.idEstratoSocial = idEstratoSocial;
    }

    public String getEstratoSocial() {
        return estratoSocial;
    }

    public void setEstratoSocial(String estratoSocial) {
        this.estratoSocial = estratoSocial;
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
        hash += (idEstratoSocial != null ? idEstratoSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstratosSociales)) {
            return false;
        }
        EstratosSociales other = (EstratosSociales) object;
        if ((this.idEstratoSocial == null && other.idEstratoSocial != null) || (this.idEstratoSocial != null && !this.idEstratoSocial.equals(other.idEstratoSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admin_cloud.ejb.entidades.EstratosSociales[ idEstratoSocial=" + idEstratoSocial + " ]";
    }
    
}
