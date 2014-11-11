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
@Table(name = "pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByIdPaciente", query = "SELECT p FROM Pacientes p WHERE p.idPaciente = :idPaciente"),
    @NamedQuery(name = "Pacientes.findByNombre", query = "SELECT p FROM Pacientes p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pacientes.findByApellido", query = "SELECT p FROM Pacientes p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Pacientes.findByNumeroDeDocumento", query = "SELECT p FROM Pacientes p WHERE p.numeroDeDocumento = :numeroDeDocumento"),
    @NamedQuery(name = "Pacientes.findByFechaDeNacimiento", query = "SELECT p FROM Pacientes p WHERE p.fechaDeNacimiento = :fechaDeNacimiento"),
    @NamedQuery(name = "Pacientes.findBySexo", query = "SELECT p FROM Pacientes p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Pacientes.findByOcupacion", query = "SELECT p FROM Pacientes p WHERE p.ocupacion = :ocupacion"),
    @NamedQuery(name = "Pacientes.findByTelefono", query = "SELECT p FROM Pacientes p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Pacientes.findByCelular", query = "SELECT p FROM Pacientes p WHERE p.celular = :celular"),
    @NamedQuery(name = "Pacientes.findByEmail", query = "SELECT p FROM Pacientes p WHERE p.email = :email"),
    @NamedQuery(name = "Pacientes.findByPais", query = "SELECT p FROM Pacientes p WHERE p.pais = :pais"),
    @NamedQuery(name = "Pacientes.findByCiudad", query = "SELECT p FROM Pacientes p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Pacientes.findByNacionalidad", query = "SELECT p FROM Pacientes p WHERE p.nacionalidad = :nacionalidad"),
    @NamedQuery(name = "Pacientes.findByDireccion", query = "SELECT p FROM Pacientes p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Pacientes.findByZonaResidencial", query = "SELECT p FROM Pacientes p WHERE p.zonaResidencial = :zonaResidencial"),
    @NamedQuery(name = "Pacientes.findByCodigoPostal", query = "SELECT p FROM Pacientes p WHERE p.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Pacientes.findByNombreAcudiente", query = "SELECT p FROM Pacientes p WHERE p.nombreAcudiente = :nombreAcudiente"),
    @NamedQuery(name = "Pacientes.findByApellidoAcudiente", query = "SELECT p FROM Pacientes p WHERE p.apellidoAcudiente = :apellidoAcudiente"),
    @NamedQuery(name = "Pacientes.findByNumeroDeDocumentoAcudiente", query = "SELECT p FROM Pacientes p WHERE p.numeroDeDocumentoAcudiente = :numeroDeDocumentoAcudiente"),
    @NamedQuery(name = "Pacientes.findByTelefonoAcudiente", query = "SELECT p FROM Pacientes p WHERE p.telefonoAcudiente = :telefonoAcudiente"),
    @NamedQuery(name = "Pacientes.findByParentescoAcudiente", query = "SELECT p FROM Pacientes p WHERE p.parentescoAcudiente = :parentescoAcudiente"),
    @NamedQuery(name = "Pacientes.findByNombreEmergencia", query = "SELECT p FROM Pacientes p WHERE p.nombreEmergencia = :nombreEmergencia"),
    @NamedQuery(name = "Pacientes.findByTelefonoEmergencia", query = "SELECT p FROM Pacientes p WHERE p.telefonoEmergencia = :telefonoEmergencia"),
    @NamedQuery(name = "Pacientes.findByParentescoEmergencia", query = "SELECT p FROM Pacientes p WHERE p.parentescoEmergencia = :parentescoEmergencia"),
    @NamedQuery(name = "Pacientes.findByFoto", query = "SELECT p FROM Pacientes p WHERE p.foto = :foto"),
    @NamedQuery(name = "Pacientes.findByFechaCreacion", query = "SELECT p FROM Pacientes p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Pacientes.findByUltimaEdicion", query = "SELECT p FROM Pacientes p WHERE p.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "Pacientes.findByEstado", query = "SELECT p FROM Pacientes p WHERE p.estado = :estado")})
public class Pacientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paciente")
    private Integer idPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_de_documento")
    private String numeroDeDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha_de_nacimiento")
    private String fechaDeNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ocupacion")
    private String ocupacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "celular")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "zona_residencial")
    private String zonaResidencial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Size(max = 200)
    @Column(name = "nombre_acudiente")
    private String nombreAcudiente;
    @Size(max = 200)
    @Column(name = "apellido_acudiente")
    private String apellidoAcudiente;
    @Size(max = 100)
    @Column(name = "numero_de_documento_acudiente")
    private String numeroDeDocumentoAcudiente;
    @Size(max = 100)
    @Column(name = "telefono_acudiente")
    private String telefonoAcudiente;
    @Size(max = 100)
    @Column(name = "parentesco_acudiente")
    private String parentescoAcudiente;
    @Size(max = 500)
    @Column(name = "nombre_emergencia")
    private String nombreEmergencia;
    @Size(max = 100)
    @Column(name = "telefono_emergencia")
    private String telefonoEmergencia;
    @Size(max = 100)
    @Column(name = "parentesco_emergencia")
    private String parentescoEmergencia;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "alerta_medica")
    private String alertaMedica;
    @Size(max = 45)
    @Column(name = "foto")
    private String foto;
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
    @JoinColumn(name = "id_tipo_de_documento_acudiente", referencedColumnName = "id_tipo_de_documento")
    @ManyToOne(fetch = FetchType.LAZY)
    private TiposDeDocumentos idTipoDeDocumentoAcudiente;
    @JoinColumn(name = "id_tipo_de_vinculacion", referencedColumnName = "id_tipo_de_vinculacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TiposDeVinculacion idTipoDeVinculacion;
    @JoinColumn(name = "id_compania_de_seguro", referencedColumnName = "id_compania_de_seguro")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CompaniasDeSeguros idCompaniaDeSeguro;
    @JoinColumn(name = "id_raza", referencedColumnName = "id_raza")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Razas idRaza;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamentos idDepartamento;
    @JoinColumn(name = "id_estrato_social", referencedColumnName = "id_estrato_social")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstratosSociales idEstratoSocial;
    @JoinColumn(name = "id_estado_civil", referencedColumnName = "id_estado_civil")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadosCiviles idEstadoCivil;
    @JoinColumn(name = "id_estado_paciente", referencedColumnName = "id_estado_paciente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadosPacientes idEstadoPaciente;
    @JoinColumn(name = "id_tipo_de_documento", referencedColumnName = "id_tipo_de_documento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TiposDeDocumentos idTipoDeDocumento;
    @OneToMany(mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private List<Facturas> facturasList;

    public Pacientes() {
    }

    public Pacientes(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Pacientes(Integer idPaciente, String nombre, String apellido, String numeroDeDocumento, String fechaDeNacimiento, String sexo, String ocupacion, String telefono, String celular, String email, String pais, String ciudad, String nacionalidad, String direccion, String zonaResidencial, String codigoPostal, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeDocumento = numeroDeDocumento;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.pais = pais;
        this.ciudad = ciudad;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.zonaResidencial = zonaResidencial;
        this.codigoPostal = codigoPostal;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getZonaResidencial() {
        return zonaResidencial;
    }

    public void setZonaResidencial(String zonaResidencial) {
        this.zonaResidencial = zonaResidencial;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getApellidoAcudiente() {
        return apellidoAcudiente;
    }

    public void setApellidoAcudiente(String apellidoAcudiente) {
        this.apellidoAcudiente = apellidoAcudiente;
    }

    public String getNumeroDeDocumentoAcudiente() {
        return numeroDeDocumentoAcudiente;
    }

    public void setNumeroDeDocumentoAcudiente(String numeroDeDocumentoAcudiente) {
        this.numeroDeDocumentoAcudiente = numeroDeDocumentoAcudiente;
    }

    public String getTelefonoAcudiente() {
        return telefonoAcudiente;
    }

    public void setTelefonoAcudiente(String telefonoAcudiente) {
        this.telefonoAcudiente = telefonoAcudiente;
    }

    public String getParentescoAcudiente() {
        return parentescoAcudiente;
    }

    public void setParentescoAcudiente(String parentescoAcudiente) {
        this.parentescoAcudiente = parentescoAcudiente;
    }

    public String getNombreEmergencia() {
        return nombreEmergencia;
    }

    public void setNombreEmergencia(String nombreEmergencia) {
        this.nombreEmergencia = nombreEmergencia;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getParentescoEmergencia() {
        return parentescoEmergencia;
    }

    public void setParentescoEmergencia(String parentescoEmergencia) {
        this.parentescoEmergencia = parentescoEmergencia;
    }

    public String getAlertaMedica() {
        return alertaMedica;
    }

    public void setAlertaMedica(String alertaMedica) {
        this.alertaMedica = alertaMedica;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public TiposDeDocumentos getIdTipoDeDocumentoAcudiente() {
        return idTipoDeDocumentoAcudiente;
    }

    public void setIdTipoDeDocumentoAcudiente(TiposDeDocumentos idTipoDeDocumentoAcudiente) {
        this.idTipoDeDocumentoAcudiente = idTipoDeDocumentoAcudiente;
    }

    public TiposDeVinculacion getIdTipoDeVinculacion() {
        return idTipoDeVinculacion;
    }

    public void setIdTipoDeVinculacion(TiposDeVinculacion idTipoDeVinculacion) {
        this.idTipoDeVinculacion = idTipoDeVinculacion;
    }

    public CompaniasDeSeguros getIdCompaniaDeSeguro() {
        return idCompaniaDeSeguro;
    }

    public void setIdCompaniaDeSeguro(CompaniasDeSeguros idCompaniaDeSeguro) {
        this.idCompaniaDeSeguro = idCompaniaDeSeguro;
    }

    public Razas getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(Razas idRaza) {
        this.idRaza = idRaza;
    }

    public Departamentos getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamentos idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public EstratosSociales getIdEstratoSocial() {
        return idEstratoSocial;
    }

    public void setIdEstratoSocial(EstratosSociales idEstratoSocial) {
        this.idEstratoSocial = idEstratoSocial;
    }

    public EstadosCiviles getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(EstadosCiviles idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public EstadosPacientes getIdEstadoPaciente() {
        return idEstadoPaciente;
    }

    public void setIdEstadoPaciente(EstadosPacientes idEstadoPaciente) {
        this.idEstadoPaciente = idEstadoPaciente;
    }

    public TiposDeDocumentos getIdTipoDeDocumento() {
        return idTipoDeDocumento;
    }

    public void setIdTipoDeDocumento(TiposDeDocumentos idTipoDeDocumento) {
        this.idTipoDeDocumento = idTipoDeDocumento;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.Pacientes[ idPaciente=" + idPaciente + " ]";
    }
    
}
