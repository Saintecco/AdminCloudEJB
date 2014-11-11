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
@Table(name = "estados_pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosPacientes.findAll", query = "SELECT e FROM EstadosPacientes e"),
    @NamedQuery(name = "EstadosPacientes.findByIdEstadoPaciente", query = "SELECT e FROM EstadosPacientes e WHERE e.idEstadoPaciente = :idEstadoPaciente"),
    @NamedQuery(name = "EstadosPacientes.findByEstadoPaciente", query = "SELECT e FROM EstadosPacientes e WHERE e.estadoPaciente = :estadoPaciente"),
    @NamedQuery(name = "EstadosPacientes.findByFechaCreacion", query = "SELECT e FROM EstadosPacientes e WHERE e.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "EstadosPacientes.findByUltimaEdicion", query = "SELECT e FROM EstadosPacientes e WHERE e.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "EstadosPacientes.findByEstado", query = "SELECT e FROM EstadosPacientes e WHERE e.estado = :estado")})
public class EstadosPacientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_paciente")
    private Integer idEstadoPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "estado_paciente")
    private String estadoPaciente;
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
    @OneToMany(mappedBy = "idEstadoPaciente", fetch = FetchType.LAZY)
    private List<Pacientes> pacientesList;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;

    public EstadosPacientes() {
    }

    public EstadosPacientes(Integer idEstadoPaciente) {
        this.idEstadoPaciente = idEstadoPaciente;
    }

    public EstadosPacientes(Integer idEstadoPaciente, String estadoPaciente, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idEstadoPaciente = idEstadoPaciente;
        this.estadoPaciente = estadoPaciente;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdEstadoPaciente() {
        return idEstadoPaciente;
    }

    public void setIdEstadoPaciente(Integer idEstadoPaciente) {
        this.idEstadoPaciente = idEstadoPaciente;
    }

    public String getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(String estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
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

    public Clinicas getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinicas idClinica) {
        this.idClinica = idClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPaciente != null ? idEstadoPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosPacientes)) {
            return false;
        }
        EstadosPacientes other = (EstadosPacientes) object;
        if ((this.idEstadoPaciente == null && other.idEstadoPaciente != null) || (this.idEstadoPaciente != null && !this.idEstadoPaciente.equals(other.idEstadoPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.EstadosPacientes[ idEstadoPaciente=" + idEstadoPaciente + " ]";
    }
    
}
