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
@Table(name = "descripcion_facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionFacturas.findAll", query = "SELECT d FROM DescripcionFacturas d"),
    @NamedQuery(name = "DescripcionFacturas.findByIdDescripcionFactura", query = "SELECT d FROM DescripcionFacturas d WHERE d.idDescripcionFactura = :idDescripcionFactura"),
    @NamedQuery(name = "DescripcionFacturas.findByProcedimiento", query = "SELECT d FROM DescripcionFacturas d WHERE d.procedimiento = :procedimiento"),
    @NamedQuery(name = "DescripcionFacturas.findByCups", query = "SELECT d FROM DescripcionFacturas d WHERE d.cups = :cups"),
    @NamedQuery(name = "DescripcionFacturas.findByValorProcedimiento", query = "SELECT d FROM DescripcionFacturas d WHERE d.valorProcedimiento = :valorProcedimiento"),
    @NamedQuery(name = "DescripcionFacturas.findByCantidad", query = "SELECT d FROM DescripcionFacturas d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DescripcionFacturas.findByNombreProfesional", query = "SELECT d FROM DescripcionFacturas d WHERE d.nombreProfesional = :nombreProfesional"),
    @NamedQuery(name = "DescripcionFacturas.findByApellidoProfesional", query = "SELECT d FROM DescripcionFacturas d WHERE d.apellidoProfesional = :apellidoProfesional"),
    @NamedQuery(name = "DescripcionFacturas.findByTipoDeDocumento", query = "SELECT d FROM DescripcionFacturas d WHERE d.tipoDeDocumento = :tipoDeDocumento"),
    @NamedQuery(name = "DescripcionFacturas.findByNumeroDeDocumento", query = "SELECT d FROM DescripcionFacturas d WHERE d.numeroDeDocumento = :numeroDeDocumento"),
    @NamedQuery(name = "DescripcionFacturas.findByTipoDeComision", query = "SELECT d FROM DescripcionFacturas d WHERE d.tipoDeComision = :tipoDeComision"),
    @NamedQuery(name = "DescripcionFacturas.findByValorComision", query = "SELECT d FROM DescripcionFacturas d WHERE d.valorComision = :valorComision"),
    @NamedQuery(name = "DescripcionFacturas.findByTotalComision", query = "SELECT d FROM DescripcionFacturas d WHERE d.totalComision = :totalComision"),
    @NamedQuery(name = "DescripcionFacturas.findByValorConvenio", query = "SELECT d FROM DescripcionFacturas d WHERE d.valorConvenio = :valorConvenio"),
    @NamedQuery(name = "DescripcionFacturas.findByTotalProcedimiento", query = "SELECT d FROM DescripcionFacturas d WHERE d.totalProcedimiento = :totalProcedimiento"),
    @NamedQuery(name = "DescripcionFacturas.findByFechaCreacion", query = "SELECT d FROM DescripcionFacturas d WHERE d.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "DescripcionFacturas.findByUltimaEdicion", query = "SELECT d FROM DescripcionFacturas d WHERE d.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "DescripcionFacturas.findByEstado", query = "SELECT d FROM DescripcionFacturas d WHERE d.estado = :estado")})
public class DescripcionFacturas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descripcion_factura")
    private Integer idDescripcionFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "procedimiento")
    private String procedimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cups")
    private String cups;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_procedimiento")
    private double valorProcedimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Size(max = 100)
    @Column(name = "nombre_profesional")
    private String nombreProfesional;
    @Size(max = 100)
    @Column(name = "apellido_profesional")
    private String apellidoProfesional;
    @Size(max = 100)
    @Column(name = "tipo_de_documento")
    private String tipoDeDocumento;
    @Size(max = 100)
    @Column(name = "numero_de_documento")
    private String numeroDeDocumento;
    @Size(max = 100)
    @Column(name = "tipo_de_comision")
    private String tipoDeComision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_comision")
    private Double valorComision;
    @Column(name = "total_comision")
    private Double totalComision;
    @Column(name = "valor_convenio")
    private Double valorConvenio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_procedimiento")
    private double totalProcedimiento;
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
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Facturas idFactura;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;
    @JoinColumn(name = "id_convenio", referencedColumnName = "id_convenio")
    @ManyToOne(fetch = FetchType.LAZY)
    private Convenios idConvenio;
    @JoinColumn(name = "id_comision", referencedColumnName = "id_comision")
    @ManyToOne(fetch = FetchType.LAZY)
    private Comisiones idComision;
    @JoinColumn(name = "id_procedimiento", referencedColumnName = "id_procedimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Procedimientos idProcedimiento;
    @JoinColumn(name = "id_profesional", referencedColumnName = "id_profesional")
    @ManyToOne(fetch = FetchType.LAZY)
    private Profesionales idProfesional;

    public DescripcionFacturas() {
    }

    public DescripcionFacturas(Integer idDescripcionFactura) {
        this.idDescripcionFactura = idDescripcionFactura;
    }

    public DescripcionFacturas(Integer idDescripcionFactura, String procedimiento, String cups, double valorProcedimiento, int cantidad, double totalProcedimiento, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idDescripcionFactura = idDescripcionFactura;
        this.procedimiento = procedimiento;
        this.cups = cups;
        this.valorProcedimiento = valorProcedimiento;
        this.cantidad = cantidad;
        this.totalProcedimiento = totalProcedimiento;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdDescripcionFactura() {
        return idDescripcionFactura;
    }

    public void setIdDescripcionFactura(Integer idDescripcionFactura) {
        this.idDescripcionFactura = idDescripcionFactura;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getCups() {
        return cups;
    }

    public void setCups(String cups) {
        this.cups = cups;
    }

    public double getValorProcedimiento() {
        return valorProcedimiento;
    }

    public void setValorProcedimiento(double valorProcedimiento) {
        this.valorProcedimiento = valorProcedimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProfesional() {
        return nombreProfesional;
    }

    public void setNombreProfesional(String nombreProfesional) {
        this.nombreProfesional = nombreProfesional;
    }

    public String getApellidoProfesional() {
        return apellidoProfesional;
    }

    public void setApellidoProfesional(String apellidoProfesional) {
        this.apellidoProfesional = apellidoProfesional;
    }

    public String getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public String getTipoDeComision() {
        return tipoDeComision;
    }

    public void setTipoDeComision(String tipoDeComision) {
        this.tipoDeComision = tipoDeComision;
    }

    public Double getValorComision() {
        return valorComision;
    }

    public void setValorComision(Double valorComision) {
        this.valorComision = valorComision;
    }

    public Double getTotalComision() {
        return totalComision;
    }

    public void setTotalComision(Double totalComision) {
        this.totalComision = totalComision;
    }

    public Double getValorConvenio() {
        return valorConvenio;
    }

    public void setValorConvenio(Double valorConvenio) {
        this.valorConvenio = valorConvenio;
    }

    public double getTotalProcedimiento() {
        return totalProcedimiento;
    }

    public void setTotalProcedimiento(double totalProcedimiento) {
        this.totalProcedimiento = totalProcedimiento;
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

    public Facturas getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Facturas idFactura) {
        this.idFactura = idFactura;
    }

    public Clinicas getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinicas idClinica) {
        this.idClinica = idClinica;
    }

    public Convenios getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Convenios idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Comisiones getIdComision() {
        return idComision;
    }

    public void setIdComision(Comisiones idComision) {
        this.idComision = idComision;
    }

    public Procedimientos getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Procedimientos idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Profesionales getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Profesionales idProfesional) {
        this.idProfesional = idProfesional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescripcionFactura != null ? idDescripcionFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionFacturas)) {
            return false;
        }
        DescripcionFacturas other = (DescripcionFacturas) object;
        if ((this.idDescripcionFactura == null && other.idDescripcionFactura != null) || (this.idDescripcionFactura != null && !this.idDescripcionFactura.equals(other.idDescripcionFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.DescripcionFacturas[ idDescripcionFactura=" + idDescripcionFactura + " ]";
    }
    
}
