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
@Table(name = "tipos_de_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeDocumentos.findAll", query = "SELECT t FROM TiposDeDocumentos t"),
    @NamedQuery(name = "TiposDeDocumentos.findByIdTipoDeDocumento", query = "SELECT t FROM TiposDeDocumentos t WHERE t.idTipoDeDocumento = :idTipoDeDocumento"),
    @NamedQuery(name = "TiposDeDocumentos.findByTipoDeDocumento", query = "SELECT t FROM TiposDeDocumentos t WHERE t.tipoDeDocumento = :tipoDeDocumento"),
    @NamedQuery(name = "TiposDeDocumentos.findByFechaCreacion", query = "SELECT t FROM TiposDeDocumentos t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TiposDeDocumentos.findByUltimaEdicion", query = "SELECT t FROM TiposDeDocumentos t WHERE t.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "TiposDeDocumentos.findByEstado", query = "SELECT t FROM TiposDeDocumentos t WHERE t.estado = :estado")})
public class TiposDeDocumentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_de_documento")
    private Integer idTipoDeDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "tipo_de_documento")
    private String tipoDeDocumento;
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

    public TiposDeDocumentos() {
    }

    public TiposDeDocumentos(Integer idTipoDeDocumento) {
        this.idTipoDeDocumento = idTipoDeDocumento;
    }

    public TiposDeDocumentos(Integer idTipoDeDocumento, String tipoDeDocumento, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idTipoDeDocumento = idTipoDeDocumento;
        this.tipoDeDocumento = tipoDeDocumento;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdTipoDeDocumento() {
        return idTipoDeDocumento;
    }

    public void setIdTipoDeDocumento(Integer idTipoDeDocumento) {
        this.idTipoDeDocumento = idTipoDeDocumento;
    }

    public String getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
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
        hash += (idTipoDeDocumento != null ? idTipoDeDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeDocumentos)) {
            return false;
        }
        TiposDeDocumentos other = (TiposDeDocumentos) object;
        if ((this.idTipoDeDocumento == null && other.idTipoDeDocumento != null) || (this.idTipoDeDocumento != null && !this.idTipoDeDocumento.equals(other.idTipoDeDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.TiposDeDocumentos[ idTipoDeDocumento=" + idTipoDeDocumento + " ]";
    }
    
}
