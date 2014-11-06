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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saintec
 */
@Entity
@Table(name = "modulos_clinicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModulosClinicas.findAll", query = "SELECT m FROM ModulosClinicas m"),
    @NamedQuery(name = "ModulosClinicas.findByIdModuloClinica", query = "SELECT m FROM ModulosClinicas m WHERE m.idModuloClinica = :idModuloClinica"),
    @NamedQuery(name = "ModulosClinicas.findByFechaCreacion", query = "SELECT m FROM ModulosClinicas m WHERE m.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ModulosClinicas.findByUltimaEdicion", query = "SELECT m FROM ModulosClinicas m WHERE m.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "ModulosClinicas.findByEstado", query = "SELECT m FROM ModulosClinicas m WHERE m.estado = :estado")})
public class ModulosClinicas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modulo_clinica")
    private Integer idModuloClinica;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "ultima_edicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaEdicion;
    @Size(max = 50)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;
    @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Modulos idModulo;

    public ModulosClinicas() {
    }

    public ModulosClinicas(Integer idModuloClinica) {
        this.idModuloClinica = idModuloClinica;
    }

    public Integer getIdModuloClinica() {
        return idModuloClinica;
    }

    public void setIdModuloClinica(Integer idModuloClinica) {
        this.idModuloClinica = idModuloClinica;
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

    public Modulos getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Modulos idModulo) {
        this.idModulo = idModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModuloClinica != null ? idModuloClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModulosClinicas)) {
            return false;
        }
        ModulosClinicas other = (ModulosClinicas) object;
        if ((this.idModuloClinica == null && other.idModuloClinica != null) || (this.idModuloClinica != null && !this.idModuloClinica.equals(other.idModuloClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.ModulosClinicas[ idModuloClinica=" + idModuloClinica + " ]";
    }
    
}
