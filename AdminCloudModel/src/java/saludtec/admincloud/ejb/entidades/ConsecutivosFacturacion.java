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
@Table(name = "consecutivos_facturacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsecutivosFacturacion.findAll", query = "SELECT c FROM ConsecutivosFacturacion c"),
    @NamedQuery(name = "ConsecutivosFacturacion.findByIdInformacionFacturacion", query = "SELECT c FROM ConsecutivosFacturacion c WHERE c.idInformacionFacturacion = :idInformacionFacturacion"),
    @NamedQuery(name = "ConsecutivosFacturacion.findByResolucion", query = "SELECT c FROM ConsecutivosFacturacion c WHERE c.resolucion = :resolucion"),
    @NamedQuery(name = "ConsecutivosFacturacion.findByFechaResolucion", query = "SELECT c FROM ConsecutivosFacturacion c WHERE c.fechaResolucion = :fechaResolucion"),
    @NamedQuery(name = "ConsecutivosFacturacion.findByNumeroInicial", query = "SELECT c FROM ConsecutivosFacturacion c WHERE c.numeroInicial = :numeroInicial"),
    @NamedQuery(name = "ConsecutivosFacturacion.findByNumeroFinal", query = "SELECT c FROM ConsecutivosFacturacion c WHERE c.numeroFinal = :numeroFinal"),
    @NamedQuery(name = "ConsecutivosFacturacion.findByNumeroActual", query = "SELECT c FROM ConsecutivosFacturacion c WHERE c.numeroActual = :numeroActual"),
    @NamedQuery(name = "ConsecutivosFacturacion.findByFechaCreacion", query = "SELECT c FROM ConsecutivosFacturacion c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ConsecutivosFacturacion.findByUltimaEdicion", query = "SELECT c FROM ConsecutivosFacturacion c WHERE c.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "ConsecutivosFacturacion.findByEstado", query = "SELECT c FROM ConsecutivosFacturacion c WHERE c.estado = :estado")})
public class ConsecutivosFacturacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_informacion_facturacion")
    private Integer idInformacionFacturacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "resolucion")
    private String resolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_resolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaResolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_inicial")
    private int numeroInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_final")
    private int numeroFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_actual")
    private int numeroActual;
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

    public ConsecutivosFacturacion() {
    }

    public ConsecutivosFacturacion(Integer idInformacionFacturacion) {
        this.idInformacionFacturacion = idInformacionFacturacion;
    }

    public ConsecutivosFacturacion(Integer idInformacionFacturacion, String resolucion, Date fechaResolucion, int numeroInicial, int numeroFinal, int numeroActual, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idInformacionFacturacion = idInformacionFacturacion;
        this.resolucion = resolucion;
        this.fechaResolucion = fechaResolucion;
        this.numeroInicial = numeroInicial;
        this.numeroFinal = numeroFinal;
        this.numeroActual = numeroActual;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdInformacionFacturacion() {
        return idInformacionFacturacion;
    }

    public void setIdInformacionFacturacion(Integer idInformacionFacturacion) {
        this.idInformacionFacturacion = idInformacionFacturacion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public int getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(int numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public int getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(int numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public int getNumeroActual() {
        return numeroActual;
    }

    public void setNumeroActual(int numeroActual) {
        this.numeroActual = numeroActual;
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
        hash += (idInformacionFacturacion != null ? idInformacionFacturacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsecutivosFacturacion)) {
            return false;
        }
        ConsecutivosFacturacion other = (ConsecutivosFacturacion) object;
        if ((this.idInformacionFacturacion == null && other.idInformacionFacturacion != null) || (this.idInformacionFacturacion != null && !this.idInformacionFacturacion.equals(other.idInformacionFacturacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.ConsecutivosFacturacion[ idInformacionFacturacion=" + idInformacionFacturacion + " ]";
    }
    
}
