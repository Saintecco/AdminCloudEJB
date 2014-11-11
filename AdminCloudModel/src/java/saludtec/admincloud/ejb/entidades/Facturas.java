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
import javax.persistence.Lob;
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
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f"),
    @NamedQuery(name = "Facturas.findByIdFactura", query = "SELECT f FROM Facturas f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Facturas.findByNumeroFactura", query = "SELECT f FROM Facturas f WHERE f.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "Facturas.findByNombrePaciente", query = "SELECT f FROM Facturas f WHERE f.nombrePaciente = :nombrePaciente"),
    @NamedQuery(name = "Facturas.findByApellidoPaciente", query = "SELECT f FROM Facturas f WHERE f.apellidoPaciente = :apellidoPaciente"),
    @NamedQuery(name = "Facturas.findByTipoDeDocumento", query = "SELECT f FROM Facturas f WHERE f.tipoDeDocumento = :tipoDeDocumento"),
    @NamedQuery(name = "Facturas.findByNumeroDeDocumento", query = "SELECT f FROM Facturas f WHERE f.numeroDeDocumento = :numeroDeDocumento"),
    @NamedQuery(name = "Facturas.findByRazonSocialClinica", query = "SELECT f FROM Facturas f WHERE f.razonSocialClinica = :razonSocialClinica"),
    @NamedQuery(name = "Facturas.findByNitClinica", query = "SELECT f FROM Facturas f WHERE f.nitClinica = :nitClinica"),
    @NamedQuery(name = "Facturas.findByTipoRegimenClinica", query = "SELECT f FROM Facturas f WHERE f.tipoRegimenClinica = :tipoRegimenClinica"),
    @NamedQuery(name = "Facturas.findByDireccionClinica", query = "SELECT f FROM Facturas f WHERE f.direccionClinica = :direccionClinica"),
    @NamedQuery(name = "Facturas.findByTelefonoClinica", query = "SELECT f FROM Facturas f WHERE f.telefonoClinica = :telefonoClinica"),
    @NamedQuery(name = "Facturas.findByFaxClinica", query = "SELECT f FROM Facturas f WHERE f.faxClinica = :faxClinica"),
    @NamedQuery(name = "Facturas.findByEmailClinica", query = "SELECT f FROM Facturas f WHERE f.emailClinica = :emailClinica"),
    @NamedQuery(name = "Facturas.findByFecha", query = "SELECT f FROM Facturas f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Facturas.findByHora", query = "SELECT f FROM Facturas f WHERE f.hora = :hora"),
    @NamedQuery(name = "Facturas.findByEstado", query = "SELECT f FROM Facturas f WHERE f.estado = :estado")})
public class Facturas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_factura")
    private String numeroFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_paciente")
    private String nombrePaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido_paciente")
    private String apellidoPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_de_documento")
    private String tipoDeDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_de_documento")
    private String numeroDeDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "razon_social_clinica")
    private String razonSocialClinica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nit_clinica")
    private String nitClinica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_regimen_clinica")
    private String tipoRegimenClinica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion_clinica")
    private String direccionClinica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "telefono_clinica")
    private String telefonoClinica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fax_clinica")
    private String faxClinica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email_clinica")
    private String emailClinica;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "otros_clinica")
    private String otrosClinica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pacientes idPaciente;
    @OneToMany(mappedBy = "idFactura", fetch = FetchType.LAZY)
    private List<DescripcionFacturas> descripcionFacturasList;

    public Facturas() {
    }

    public Facturas(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Facturas(Integer idFactura, String numeroFactura, String nombrePaciente, String apellidoPaciente, String tipoDeDocumento, String numeroDeDocumento, String razonSocialClinica, String nitClinica, String tipoRegimenClinica, String direccionClinica, String telefonoClinica, String faxClinica, String emailClinica, String otrosClinica, Date fecha, Date hora, String estado) {
        this.idFactura = idFactura;
        this.numeroFactura = numeroFactura;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.tipoDeDocumento = tipoDeDocumento;
        this.numeroDeDocumento = numeroDeDocumento;
        this.razonSocialClinica = razonSocialClinica;
        this.nitClinica = nitClinica;
        this.tipoRegimenClinica = tipoRegimenClinica;
        this.direccionClinica = direccionClinica;
        this.telefonoClinica = telefonoClinica;
        this.faxClinica = faxClinica;
        this.emailClinica = emailClinica;
        this.otrosClinica = otrosClinica;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
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

    public String getRazonSocialClinica() {
        return razonSocialClinica;
    }

    public void setRazonSocialClinica(String razonSocialClinica) {
        this.razonSocialClinica = razonSocialClinica;
    }

    public String getNitClinica() {
        return nitClinica;
    }

    public void setNitClinica(String nitClinica) {
        this.nitClinica = nitClinica;
    }

    public String getTipoRegimenClinica() {
        return tipoRegimenClinica;
    }

    public void setTipoRegimenClinica(String tipoRegimenClinica) {
        this.tipoRegimenClinica = tipoRegimenClinica;
    }

    public String getDireccionClinica() {
        return direccionClinica;
    }

    public void setDireccionClinica(String direccionClinica) {
        this.direccionClinica = direccionClinica;
    }

    public String getTelefonoClinica() {
        return telefonoClinica;
    }

    public void setTelefonoClinica(String telefonoClinica) {
        this.telefonoClinica = telefonoClinica;
    }

    public String getFaxClinica() {
        return faxClinica;
    }

    public void setFaxClinica(String faxClinica) {
        this.faxClinica = faxClinica;
    }

    public String getEmailClinica() {
        return emailClinica;
    }

    public void setEmailClinica(String emailClinica) {
        this.emailClinica = emailClinica;
    }

    public String getOtrosClinica() {
        return otrosClinica;
    }

    public void setOtrosClinica(String otrosClinica) {
        this.otrosClinica = otrosClinica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    @XmlTransient
    public List<DescripcionFacturas> getDescripcionFacturasList() {
        return descripcionFacturasList;
    }

    public void setDescripcionFacturasList(List<DescripcionFacturas> descripcionFacturasList) {
        this.descripcionFacturasList = descripcionFacturasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.Facturas[ idFactura=" + idFactura + " ]";
    }
    
}
