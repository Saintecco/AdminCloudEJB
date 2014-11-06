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
@Table(name = "estados_civiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosCiviles.findAll", query = "SELECT e FROM EstadosCiviles e"),
    @NamedQuery(name = "EstadosCiviles.findByIdEstadoCivil", query = "SELECT e FROM EstadosCiviles e WHERE e.idEstadoCivil = :idEstadoCivil"),
    @NamedQuery(name = "EstadosCiviles.findByEstadoCivil", query = "SELECT e FROM EstadosCiviles e WHERE e.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "EstadosCiviles.findByFechaCreacion", query = "SELECT e FROM EstadosCiviles e WHERE e.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "EstadosCiviles.findByUltimaEdicion", query = "SELECT e FROM EstadosCiviles e WHERE e.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "EstadosCiviles.findByEstado", query = "SELECT e FROM EstadosCiviles e WHERE e.estado = :estado")})
public class EstadosCiviles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_civil")
    private Integer idEstadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "estado_civil")
    private String estadoCivil;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoCivil", fetch = FetchType.LAZY)
    private List<Pacientes> pacientesList;

    public EstadosCiviles() {
    }

    public EstadosCiviles(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public EstadosCiviles(Integer idEstadoCivil, String estadoCivil, Date ultimaEdicion, String estado) {
        this.idEstadoCivil = idEstadoCivil;
        this.estadoCivil = estadoCivil;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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
        hash += (idEstadoCivil != null ? idEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosCiviles)) {
            return false;
        }
        EstadosCiviles other = (EstadosCiviles) object;
        if ((this.idEstadoCivil == null && other.idEstadoCivil != null) || (this.idEstadoCivil != null && !this.idEstadoCivil.equals(other.idEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.EstadosCiviles[ idEstadoCivil=" + idEstadoCivil + " ]";
    }
    
}
