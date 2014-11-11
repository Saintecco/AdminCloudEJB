/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saintec
 */
@Entity
@Table(name = "razas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Razas.findAll", query = "SELECT r FROM Razas r"),
    @NamedQuery(name = "Razas.findByIdRaza", query = "SELECT r FROM Razas r WHERE r.idRaza = :idRaza"),
    @NamedQuery(name = "Razas.findByRaza", query = "SELECT r FROM Razas r WHERE r.raza = :raza"),
    @NamedQuery(name = "Razas.findByFechaCreacion", query = "SELECT r FROM Razas r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Razas.findByUltimaEdicion", query = "SELECT r FROM Razas r WHERE r.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "Razas.findByEstado", query = "SELECT r FROM Razas r WHERE r.estado = :estado")})
public class Razas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_raza")
    private Integer idRaza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "raza")
    private String raza;
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
    @OneToMany(mappedBy = "idRaza", fetch = FetchType.LAZY)
    private List<Pacientes> pacientesList;

    public Razas() {
    }

    public Razas(Integer idRaza) {
        this.idRaza = idRaza;
    }

    public Razas(Integer idRaza, String raza, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idRaza = idRaza;
        this.raza = raza;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Integer idRaza) {
        this.idRaza = idRaza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
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

    @XmlTransient
    public List<Pacientes> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<Pacientes> pacientesList) {
        this.pacientesList = pacientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRaza != null ? idRaza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Razas)) {
            return false;
        }
        Razas other = (Razas) object;
        if ((this.idRaza == null && other.idRaza != null) || (this.idRaza != null && !this.idRaza.equals(other.idRaza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.Razas[ idRaza=" + idRaza + " ]";
    }
    
}
