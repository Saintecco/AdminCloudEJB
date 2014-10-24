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
import javax.persistence.Lob;
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
@Table(name = "clinicas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clinicas.findAll", query = "SELECT c FROM Clinicas c"),
    @NamedQuery(name = "Clinicas.findByIdClinica", query = "SELECT c FROM Clinicas c WHERE c.idClinica = :idClinica"),
    @NamedQuery(name = "Clinicas.findByRazonSocial", query = "SELECT c FROM Clinicas c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Clinicas.findByNit", query = "SELECT c FROM Clinicas c WHERE c.nit = :nit"),
    @NamedQuery(name = "Clinicas.findByTipoRegimen", query = "SELECT c FROM Clinicas c WHERE c.tipoRegimen = :tipoRegimen"),
    @NamedQuery(name = "Clinicas.findByDireccionPrincipal", query = "SELECT c FROM Clinicas c WHERE c.direccionPrincipal = :direccionPrincipal"),
    @NamedQuery(name = "Clinicas.findByTelefonoPrinicipal", query = "SELECT c FROM Clinicas c WHERE c.telefonoPrinicipal = :telefonoPrinicipal"),
    @NamedQuery(name = "Clinicas.findByFax", query = "SELECT c FROM Clinicas c WHERE c.fax = :fax"),
    @NamedQuery(name = "Clinicas.findByEmailPrincipal", query = "SELECT c FROM Clinicas c WHERE c.emailPrincipal = :emailPrincipal"),
    @NamedQuery(name = "Clinicas.findByActividadEconomica", query = "SELECT c FROM Clinicas c WHERE c.actividadEconomica = :actividadEconomica"),
    @NamedQuery(name = "Clinicas.findByFechaCreacion", query = "SELECT c FROM Clinicas c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Clinicas.findByUltimaEdicion", query = "SELECT c FROM Clinicas c WHERE c.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "Clinicas.findByEstado", query = "SELECT c FROM Clinicas c WHERE c.estado = :estado"),
    @NamedQuery(name = "Clinicas.findByLimiteSedes", query = "SELECT c FROM Clinicas c WHERE c.limiteSedes = :limiteSedes"),
    @NamedQuery(name = "Clinicas.findByLimiteUsuarios", query = "SELECT c FROM Clinicas c WHERE c.limiteUsuarios = :limiteUsuarios"),
    @NamedQuery(name = "Clinicas.findByFechaLimiteActivo", query = "SELECT c FROM Clinicas c WHERE c.fechaLimiteActivo = :fechaLimiteActivo")})
public class Clinicas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clinica")
    private Integer idClinica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "razon_social")
    private String razonSocial;
    @Size(max = 250)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "tipo_regimen")
    private String tipoRegimen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direccion_principal")
    private String direccionPrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "telefono_prinicipal")
    private String telefonoPrinicipal;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "fax")
    private String fax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "email_principal")
    private String emailPrincipal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "actividad_economica")
    private String actividadEconomica;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "otros")
    private String otros;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "logo")
    private String logo;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "limite_sedes")
    private int limiteSedes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "limite_usuarios")
    private int limiteUsuarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_limite_activo")
    @Temporal(TemporalType.DATE)
    private Date fechaLimiteActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<TiposDeVinculacion> tiposDeVinculacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<Procedimientos> procedimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<EstratosSociales> estratosSocialesList;
    @OneToMany(mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<ClavesArqueoDeCaja> clavesArqueoDeCajaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<CompaniasDeSeguros> companiasDeSegurosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<TiposDeMonedas> tiposDeMonedasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<Convenios> conveniosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<ConsecutivosRecibos> consecutivosRecibosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<ConsecutivosFacturacion> consecutivosFacturacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<ModulosClinicas> modulosClinicasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<CategoriasProcedimientos> categoriasProcedimientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<Departamentos> departamentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<ComoSupo> comoSupoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<TiposDeDocumentos> tiposDeDocumentosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<EstadosPacientes> estadosPacientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClinica", fetch = FetchType.LAZY)
    private List<ClavesCorreccionFactura> clavesCorreccionFacturaList;

    public Clinicas() {
    }

    public Clinicas(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public Clinicas(Integer idClinica, String razonSocial, String tipoRegimen, String direccionPrincipal, String telefonoPrinicipal, String emailPrincipal, String actividadEconomica, Date fechaCreacion, Date ultimaEdicion, String estado, int limiteSedes, int limiteUsuarios, Date fechaLimiteActivo) {
        this.idClinica = idClinica;
        this.razonSocial = razonSocial;
        this.tipoRegimen = tipoRegimen;
        this.direccionPrincipal = direccionPrincipal;
        this.telefonoPrinicipal = telefonoPrinicipal;
        this.emailPrincipal = emailPrincipal;
        this.actividadEconomica = actividadEconomica;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
        this.limiteSedes = limiteSedes;
        this.limiteUsuarios = limiteUsuarios;
        this.fechaLimiteActivo = fechaLimiteActivo;
    }

    public Integer getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Integer idClinica) {
        this.idClinica = idClinica;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTipoRegimen() {
        return tipoRegimen;
    }

    public void setTipoRegimen(String tipoRegimen) {
        this.tipoRegimen = tipoRegimen;
    }

    public String getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(String direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public String getTelefonoPrinicipal() {
        return telefonoPrinicipal;
    }

    public void setTelefonoPrinicipal(String telefonoPrinicipal) {
        this.telefonoPrinicipal = telefonoPrinicipal;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public int getLimiteSedes() {
        return limiteSedes;
    }

    public void setLimiteSedes(int limiteSedes) {
        this.limiteSedes = limiteSedes;
    }

    public int getLimiteUsuarios() {
        return limiteUsuarios;
    }

    public void setLimiteUsuarios(int limiteUsuarios) {
        this.limiteUsuarios = limiteUsuarios;
    }

    public Date getFechaLimiteActivo() {
        return fechaLimiteActivo;
    }

    public void setFechaLimiteActivo(Date fechaLimiteActivo) {
        this.fechaLimiteActivo = fechaLimiteActivo;
    }

    @XmlTransient
    public List<TiposDeVinculacion> getTiposDeVinculacionList() {
        return tiposDeVinculacionList;
    }

    public void setTiposDeVinculacionList(List<TiposDeVinculacion> tiposDeVinculacionList) {
        this.tiposDeVinculacionList = tiposDeVinculacionList;
    }

    @XmlTransient
    public List<Procedimientos> getProcedimientosList() {
        return procedimientosList;
    }

    public void setProcedimientosList(List<Procedimientos> procedimientosList) {
        this.procedimientosList = procedimientosList;
    }

    @XmlTransient
    public List<EstratosSociales> getEstratosSocialesList() {
        return estratosSocialesList;
    }

    public void setEstratosSocialesList(List<EstratosSociales> estratosSocialesList) {
        this.estratosSocialesList = estratosSocialesList;
    }

    @XmlTransient
    public List<ClavesArqueoDeCaja> getClavesArqueoDeCajaList() {
        return clavesArqueoDeCajaList;
    }

    public void setClavesArqueoDeCajaList(List<ClavesArqueoDeCaja> clavesArqueoDeCajaList) {
        this.clavesArqueoDeCajaList = clavesArqueoDeCajaList;
    }

    @XmlTransient
    public List<CompaniasDeSeguros> getCompaniasDeSegurosList() {
        return companiasDeSegurosList;
    }

    public void setCompaniasDeSegurosList(List<CompaniasDeSeguros> companiasDeSegurosList) {
        this.companiasDeSegurosList = companiasDeSegurosList;
    }

    @XmlTransient
    public List<TiposDeMonedas> getTiposDeMonedasList() {
        return tiposDeMonedasList;
    }

    public void setTiposDeMonedasList(List<TiposDeMonedas> tiposDeMonedasList) {
        this.tiposDeMonedasList = tiposDeMonedasList;
    }

    @XmlTransient
    public List<Convenios> getConveniosList() {
        return conveniosList;
    }

    public void setConveniosList(List<Convenios> conveniosList) {
        this.conveniosList = conveniosList;
    }

    @XmlTransient
    public List<ConsecutivosRecibos> getConsecutivosRecibosList() {
        return consecutivosRecibosList;
    }

    public void setConsecutivosRecibosList(List<ConsecutivosRecibos> consecutivosRecibosList) {
        this.consecutivosRecibosList = consecutivosRecibosList;
    }

    @XmlTransient
    public List<ConsecutivosFacturacion> getConsecutivosFacturacionList() {
        return consecutivosFacturacionList;
    }

    public void setConsecutivosFacturacionList(List<ConsecutivosFacturacion> consecutivosFacturacionList) {
        this.consecutivosFacturacionList = consecutivosFacturacionList;
    }

    @XmlTransient
    public List<ModulosClinicas> getModulosClinicasList() {
        return modulosClinicasList;
    }

    public void setModulosClinicasList(List<ModulosClinicas> modulosClinicasList) {
        this.modulosClinicasList = modulosClinicasList;
    }

    @XmlTransient
    public List<CategoriasProcedimientos> getCategoriasProcedimientosList() {
        return categoriasProcedimientosList;
    }

    public void setCategoriasProcedimientosList(List<CategoriasProcedimientos> categoriasProcedimientosList) {
        this.categoriasProcedimientosList = categoriasProcedimientosList;
    }

    @XmlTransient
    public List<Departamentos> getDepartamentosList() {
        return departamentosList;
    }

    public void setDepartamentosList(List<Departamentos> departamentosList) {
        this.departamentosList = departamentosList;
    }

    @XmlTransient
    public List<ComoSupo> getComoSupoList() {
        return comoSupoList;
    }

    public void setComoSupoList(List<ComoSupo> comoSupoList) {
        this.comoSupoList = comoSupoList;
    }

    @XmlTransient
    public List<TiposDeDocumentos> getTiposDeDocumentosList() {
        return tiposDeDocumentosList;
    }

    public void setTiposDeDocumentosList(List<TiposDeDocumentos> tiposDeDocumentosList) {
        this.tiposDeDocumentosList = tiposDeDocumentosList;
    }

    @XmlTransient
    public List<EstadosPacientes> getEstadosPacientesList() {
        return estadosPacientesList;
    }

    public void setEstadosPacientesList(List<EstadosPacientes> estadosPacientesList) {
        this.estadosPacientesList = estadosPacientesList;
    }

    @XmlTransient
    public List<ClavesCorreccionFactura> getClavesCorreccionFacturaList() {
        return clavesCorreccionFacturaList;
    }

    public void setClavesCorreccionFacturaList(List<ClavesCorreccionFactura> clavesCorreccionFacturaList) {
        this.clavesCorreccionFacturaList = clavesCorreccionFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClinica != null ? idClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clinicas)) {
            return false;
        }
        Clinicas other = (Clinicas) object;
        if ((this.idClinica == null && other.idClinica != null) || (this.idClinica != null && !this.idClinica.equals(other.idClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.Clinicas[ idClinica=" + idClinica + " ]";
    }
    
}
