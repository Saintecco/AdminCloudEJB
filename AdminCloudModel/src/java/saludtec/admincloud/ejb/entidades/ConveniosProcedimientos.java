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
@Table(name = "convenios_procedimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConveniosProcedimientos.findAll", query = "SELECT c FROM ConveniosProcedimientos c"),
    @NamedQuery(name = "ConveniosProcedimientos.findByIdConvenioProcedimiento", query = "SELECT c FROM ConveniosProcedimientos c WHERE c.idConvenioProcedimiento = :idConvenioProcedimiento"),
    @NamedQuery(name = "ConveniosProcedimientos.findByTipoDescuento", query = "SELECT c FROM ConveniosProcedimientos c WHERE c.tipoDescuento = :tipoDescuento"),
    @NamedQuery(name = "ConveniosProcedimientos.findByValorDescuento", query = "SELECT c FROM ConveniosProcedimientos c WHERE c.valorDescuento = :valorDescuento"),
    @NamedQuery(name = "ConveniosProcedimientos.findByTotal", query = "SELECT c FROM ConveniosProcedimientos c WHERE c.total = :total"),
    @NamedQuery(name = "ConveniosProcedimientos.findByFechaCreacion", query = "SELECT c FROM ConveniosProcedimientos c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ConveniosProcedimientos.findByUltimaEdicion", query = "SELECT c FROM ConveniosProcedimientos c WHERE c.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "ConveniosProcedimientos.findByEstado", query = "SELECT c FROM ConveniosProcedimientos c WHERE c.estado = :estado")})
public class ConveniosProcedimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_convenio_procedimiento")
    private Integer idConvenioProcedimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_descuento")
    private String tipoDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_descuento")
    private double valorDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
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
    @JoinColumn(name = "id_procedimiento", referencedColumnName = "id_procedimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Procedimientos idProcedimiento;
    @JoinColumn(name = "id_convenio", referencedColumnName = "id_convenio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Convenios idConvenio;

    public ConveniosProcedimientos() {
    }

    public ConveniosProcedimientos(Integer idConvenioProcedimiento) {
        this.idConvenioProcedimiento = idConvenioProcedimiento;
    }

    public ConveniosProcedimientos(Integer idConvenioProcedimiento, String tipoDescuento, double valorDescuento, double total, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idConvenioProcedimiento = idConvenioProcedimiento;
        this.tipoDescuento = tipoDescuento;
        this.valorDescuento = valorDescuento;
        this.total = total;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdConvenioProcedimiento() {
        return idConvenioProcedimiento;
    }

    public void setIdConvenioProcedimiento(Integer idConvenioProcedimiento) {
        this.idConvenioProcedimiento = idConvenioProcedimiento;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public Procedimientos getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Procedimientos idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Convenios getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Convenios idConvenio) {
        this.idConvenio = idConvenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConvenioProcedimiento != null ? idConvenioProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConveniosProcedimientos)) {
            return false;
        }
        ConveniosProcedimientos other = (ConveniosProcedimientos) object;
        if ((this.idConvenioProcedimiento == null && other.idConvenioProcedimiento != null) || (this.idConvenioProcedimiento != null && !this.idConvenioProcedimiento.equals(other.idConvenioProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.ConveniosProcedimientos[ idConvenioProcedimiento=" + idConvenioProcedimiento + " ]";
    }
    
}
