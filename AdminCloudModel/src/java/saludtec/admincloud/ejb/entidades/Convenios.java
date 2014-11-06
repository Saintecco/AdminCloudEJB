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
@Table(name = "convenios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenios.findAll", query = "SELECT c FROM Convenios c"),
    @NamedQuery(name = "Convenios.findByIdConvenio", query = "SELECT c FROM Convenios c WHERE c.idConvenio = :idConvenio"),
    @NamedQuery(name = "Convenios.findByConvenio", query = "SELECT c FROM Convenios c WHERE c.convenio = :convenio"),
    @NamedQuery(name = "Convenios.findByCodigoConvenio", query = "SELECT c FROM Convenios c WHERE c.codigoConvenio = :codigoConvenio"),
    @NamedQuery(name = "Convenios.findByFechaCreacion", query = "SELECT c FROM Convenios c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Convenios.findByUltimaEdicion", query = "SELECT c FROM Convenios c WHERE c.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "Convenios.findByEstado", query = "SELECT c FROM Convenios c WHERE c.estado = :estado")})
public class Convenios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_convenio")
    private Integer idConvenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "convenio")
    private String convenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigo_convenio")
    private String codigoConvenio;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConvenio", fetch = FetchType.LAZY)
    private List<RelProcedimientosConvenios> relProcedimientosConveniosList;

    public Convenios() {
    }

    public Convenios(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Convenios(Integer idConvenio, String convenio, String codigoConvenio, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idConvenio = idConvenio;
        this.convenio = convenio;
        this.codigoConvenio = codigoConvenio;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(String codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
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
    public List<RelProcedimientosConvenios> getRelProcedimientosConveniosList() {
        return relProcedimientosConveniosList;
    }

    public void setRelProcedimientosConveniosList(List<RelProcedimientosConvenios> relProcedimientosConveniosList) {
        this.relProcedimientosConveniosList = relProcedimientosConveniosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConvenio != null ? idConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenios)) {
            return false;
        }
        Convenios other = (Convenios) object;
        if ((this.idConvenio == null && other.idConvenio != null) || (this.idConvenio != null && !this.idConvenio.equals(other.idConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.Convenios[ idConvenio=" + idConvenio + " ]";
    }
    
}
