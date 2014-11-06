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
@Table(name = "rel_procedimientos_convenios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelProcedimientosConvenios.findAll", query = "SELECT r FROM RelProcedimientosConvenios r"),
    @NamedQuery(name = "RelProcedimientosConvenios.findByIdRelProcedimientoConvenio", query = "SELECT r FROM RelProcedimientosConvenios r WHERE r.idRelProcedimientoConvenio = :idRelProcedimientoConvenio"),
    @NamedQuery(name = "RelProcedimientosConvenios.findByTipoDescuento", query = "SELECT r FROM RelProcedimientosConvenios r WHERE r.tipoDescuento = :tipoDescuento"),
    @NamedQuery(name = "RelProcedimientosConvenios.findByValorDescuento", query = "SELECT r FROM RelProcedimientosConvenios r WHERE r.valorDescuento = :valorDescuento"),
    @NamedQuery(name = "RelProcedimientosConvenios.findByTotal", query = "SELECT r FROM RelProcedimientosConvenios r WHERE r.total = :total"),
    @NamedQuery(name = "RelProcedimientosConvenios.findByFechaCreacion", query = "SELECT r FROM RelProcedimientosConvenios r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RelProcedimientosConvenios.findByUltimaEdicion", query = "SELECT r FROM RelProcedimientosConvenios r WHERE r.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "RelProcedimientosConvenios.findByEstado", query = "SELECT r FROM RelProcedimientosConvenios r WHERE r.estado = :estado")})
public class RelProcedimientosConvenios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rel_procedimiento_convenio")
    private Integer idRelProcedimientoConvenio;
    @Size(max = 100)
    @Column(name = "tipo_descuento")
    private String tipoDescuento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_descuento")
    private Double valorDescuento;
    @Column(name = "total")
    private Double total;
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

    public RelProcedimientosConvenios() {
    }

    public RelProcedimientosConvenios(Integer idRelProcedimientoConvenio) {
        this.idRelProcedimientoConvenio = idRelProcedimientoConvenio;
    }

    public RelProcedimientosConvenios(Integer idRelProcedimientoConvenio, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idRelProcedimientoConvenio = idRelProcedimientoConvenio;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdRelProcedimientoConvenio() {
        return idRelProcedimientoConvenio;
    }

    public void setIdRelProcedimientoConvenio(Integer idRelProcedimientoConvenio) {
        this.idRelProcedimientoConvenio = idRelProcedimientoConvenio;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
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
        hash += (idRelProcedimientoConvenio != null ? idRelProcedimientoConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelProcedimientosConvenios)) {
            return false;
        }
        RelProcedimientosConvenios other = (RelProcedimientosConvenios) object;
        if ((this.idRelProcedimientoConvenio == null && other.idRelProcedimientoConvenio != null) || (this.idRelProcedimientoConvenio != null && !this.idRelProcedimientoConvenio.equals(other.idRelProcedimientoConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.RelProcedimientosConvenios[ idRelProcedimientoConvenio=" + idRelProcedimientoConvenio + " ]";
    }
    
}
