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
@Table(name = "companias_de_seguros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompaniasDeSeguros.findAll", query = "SELECT c FROM CompaniasDeSeguros c"),
    @NamedQuery(name = "CompaniasDeSeguros.findByIdCompaniaDeSeguros", query = "SELECT c FROM CompaniasDeSeguros c WHERE c.idCompaniaDeSeguros = :idCompaniaDeSeguros"),
    @NamedQuery(name = "CompaniasDeSeguros.findByCompaniaDeSeguro", query = "SELECT c FROM CompaniasDeSeguros c WHERE c.companiaDeSeguro = :companiaDeSeguro"),
    @NamedQuery(name = "CompaniasDeSeguros.findByCodigo", query = "SELECT c FROM CompaniasDeSeguros c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CompaniasDeSeguros.findByFechaCreacion", query = "SELECT c FROM CompaniasDeSeguros c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "CompaniasDeSeguros.findByUltimaEdicion", query = "SELECT c FROM CompaniasDeSeguros c WHERE c.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "CompaniasDeSeguros.findByEstado", query = "SELECT c FROM CompaniasDeSeguros c WHERE c.estado = :estado")})
public class CompaniasDeSeguros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compania_de_seguros")
    private Integer idCompaniaDeSeguros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "compania_de_seguro")
    private String companiaDeSeguro;
    @Size(max = 500)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
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

    public CompaniasDeSeguros() {
    }

    public CompaniasDeSeguros(Integer idCompaniaDeSeguros) {
        this.idCompaniaDeSeguros = idCompaniaDeSeguros;
    }

    public CompaniasDeSeguros(Integer idCompaniaDeSeguros, String companiaDeSeguro, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idCompaniaDeSeguros = idCompaniaDeSeguros;
        this.companiaDeSeguro = companiaDeSeguro;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdCompaniaDeSeguros() {
        return idCompaniaDeSeguros;
    }

    public void setIdCompaniaDeSeguros(Integer idCompaniaDeSeguros) {
        this.idCompaniaDeSeguros = idCompaniaDeSeguros;
    }

    public String getCompaniaDeSeguro() {
        return companiaDeSeguro;
    }

    public void setCompaniaDeSeguro(String companiaDeSeguro) {
        this.companiaDeSeguro = companiaDeSeguro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        hash += (idCompaniaDeSeguros != null ? idCompaniaDeSeguros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompaniasDeSeguros)) {
            return false;
        }
        CompaniasDeSeguros other = (CompaniasDeSeguros) object;
        if ((this.idCompaniaDeSeguros == null && other.idCompaniaDeSeguros != null) || (this.idCompaniaDeSeguros != null && !this.idCompaniaDeSeguros.equals(other.idCompaniaDeSeguros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admin_cloud.ejb.entidades.CompaniasDeSeguros[ idCompaniaDeSeguros=" + idCompaniaDeSeguros + " ]";
    }
    
}
