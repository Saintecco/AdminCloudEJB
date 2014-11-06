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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tipos_de_vinculacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeVinculacion.findAll", query = "SELECT t FROM TiposDeVinculacion t"),
    @NamedQuery(name = "TiposDeVinculacion.findByIdTipoDeVinculacion", query = "SELECT t FROM TiposDeVinculacion t WHERE t.idTipoDeVinculacion = :idTipoDeVinculacion"),
    @NamedQuery(name = "TiposDeVinculacion.findByTipoDeVinculacion", query = "SELECT t FROM TiposDeVinculacion t WHERE t.tipoDeVinculacion = :tipoDeVinculacion"),
    @NamedQuery(name = "TiposDeVinculacion.findByFechaCreacion", query = "SELECT t FROM TiposDeVinculacion t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TiposDeVinculacion.findByUltimaEdicion", query = "SELECT t FROM TiposDeVinculacion t WHERE t.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "TiposDeVinculacion.findByEstado", query = "SELECT t FROM TiposDeVinculacion t WHERE t.estado = :estado")})
public class TiposDeVinculacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_de_vinculacion")
    private Integer idTipoDeVinculacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "tipo_de_vinculacion")
    private String tipoDeVinculacion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDeVinculacion", fetch = FetchType.LAZY)
    private List<Pacientes> pacientesList;

    public TiposDeVinculacion() {
    }

    public TiposDeVinculacion(Integer idTipoDeVinculacion) {
        this.idTipoDeVinculacion = idTipoDeVinculacion;
    }

    public TiposDeVinculacion(Integer idTipoDeVinculacion, String tipoDeVinculacion, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idTipoDeVinculacion = idTipoDeVinculacion;
        this.tipoDeVinculacion = tipoDeVinculacion;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdTipoDeVinculacion() {
        return idTipoDeVinculacion;
    }

    public void setIdTipoDeVinculacion(Integer idTipoDeVinculacion) {
        this.idTipoDeVinculacion = idTipoDeVinculacion;
    }

    public String getTipoDeVinculacion() {
        return tipoDeVinculacion;
    }

    public void setTipoDeVinculacion(String tipoDeVinculacion) {
        this.tipoDeVinculacion = tipoDeVinculacion;
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
        hash += (idTipoDeVinculacion != null ? idTipoDeVinculacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeVinculacion)) {
            return false;
        }
        TiposDeVinculacion other = (TiposDeVinculacion) object;
        if ((this.idTipoDeVinculacion == null && other.idTipoDeVinculacion != null) || (this.idTipoDeVinculacion != null && !this.idTipoDeVinculacion.equals(other.idTipoDeVinculacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.TiposDeVinculacion[ idTipoDeVinculacion=" + idTipoDeVinculacion + " ]";
    }
    
}
