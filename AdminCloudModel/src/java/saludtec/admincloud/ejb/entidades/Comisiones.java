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
@Table(name = "comisiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comisiones.findAll", query = "SELECT c FROM Comisiones c"),
    @NamedQuery(name = "Comisiones.findByIdComision", query = "SELECT c FROM Comisiones c WHERE c.idComision = :idComision"),
    @NamedQuery(name = "Comisiones.findByTipoComision", query = "SELECT c FROM Comisiones c WHERE c.tipoComision = :tipoComision"),
    @NamedQuery(name = "Comisiones.findByValorComision", query = "SELECT c FROM Comisiones c WHERE c.valorComision = :valorComision"),
    @NamedQuery(name = "Comisiones.findByTotal", query = "SELECT c FROM Comisiones c WHERE c.total = :total"),
    @NamedQuery(name = "Comisiones.findByFechaCreacion", query = "SELECT c FROM Comisiones c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Comisiones.findByUltimaEdicion", query = "SELECT c FROM Comisiones c WHERE c.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "Comisiones.findByEstado", query = "SELECT c FROM Comisiones c WHERE c.estado = :estado")})
public class Comisiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_comision")
    private Integer idComision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_comision")
    private String tipoComision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_comision")
    private double valorComision;
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
    @JoinColumn(name = "id_profesional", referencedColumnName = "id_profesional")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profesionales idProfesional;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;
    @JoinColumn(name = "id_procedimiento", referencedColumnName = "id_procedimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Procedimientos idProcedimiento;

    public Comisiones() {
    }

    public Comisiones(Integer idComision) {
        this.idComision = idComision;
    }

    public Comisiones(Integer idComision, String tipoComision, double valorComision, double total, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idComision = idComision;
        this.tipoComision = tipoComision;
        this.valorComision = valorComision;
        this.total = total;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdComision() {
        return idComision;
    }

    public void setIdComision(Integer idComision) {
        this.idComision = idComision;
    }

    public String getTipoComision() {
        return tipoComision;
    }

    public void setTipoComision(String tipoComision) {
        this.tipoComision = tipoComision;
    }

    public double getValorComision() {
        return valorComision;
    }

    public void setValorComision(double valorComision) {
        this.valorComision = valorComision;
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

    public Profesionales getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Profesionales idProfesional) {
        this.idProfesional = idProfesional;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComision != null ? idComision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comisiones)) {
            return false;
        }
        Comisiones other = (Comisiones) object;
        if ((this.idComision == null && other.idComision != null) || (this.idComision != null && !this.idComision.equals(other.idComision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.Comisiones[ idComision=" + idComision + " ]";
    }
    
}
