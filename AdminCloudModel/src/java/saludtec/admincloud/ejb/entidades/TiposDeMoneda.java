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
@Table(name = "tipos_de_moneda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeMoneda.findAll", query = "SELECT t FROM TiposDeMoneda t"),
    @NamedQuery(name = "TiposDeMoneda.findByIdTipoDeMoneda", query = "SELECT t FROM TiposDeMoneda t WHERE t.idTipoDeMoneda = :idTipoDeMoneda"),
    @NamedQuery(name = "TiposDeMoneda.findByTipoMoneda", query = "SELECT t FROM TiposDeMoneda t WHERE t.tipoMoneda = :tipoMoneda"),
    @NamedQuery(name = "TiposDeMoneda.findByValor", query = "SELECT t FROM TiposDeMoneda t WHERE t.valor = :valor"),
    @NamedQuery(name = "TiposDeMoneda.findByFechaCreacion", query = "SELECT t FROM TiposDeMoneda t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TiposDeMoneda.findByUltimaEdicion", query = "SELECT t FROM TiposDeMoneda t WHERE t.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "TiposDeMoneda.findByEstado", query = "SELECT t FROM TiposDeMoneda t WHERE t.estado = :estado")})
public class TiposDeMoneda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_de_moneda")
    private Integer idTipoDeMoneda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_moneda")
    private String tipoMoneda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;

    public TiposDeMoneda() {
    }

    public TiposDeMoneda(Integer idTipoDeMoneda) {
        this.idTipoDeMoneda = idTipoDeMoneda;
    }

    public TiposDeMoneda(Integer idTipoDeMoneda, String tipoMoneda, double valor, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idTipoDeMoneda = idTipoDeMoneda;
        this.tipoMoneda = tipoMoneda;
        this.valor = valor;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdTipoDeMoneda() {
        return idTipoDeMoneda;
    }

    public void setIdTipoDeMoneda(Integer idTipoDeMoneda) {
        this.idTipoDeMoneda = idTipoDeMoneda;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
        hash += (idTipoDeMoneda != null ? idTipoDeMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposDeMoneda)) {
            return false;
        }
        TiposDeMoneda other = (TiposDeMoneda) object;
        if ((this.idTipoDeMoneda == null && other.idTipoDeMoneda != null) || (this.idTipoDeMoneda != null && !this.idTipoDeMoneda.equals(other.idTipoDeMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.TiposDeMoneda[ idTipoDeMoneda=" + idTipoDeMoneda + " ]";
    }
    
}
