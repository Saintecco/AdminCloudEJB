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
@Table(name = "profesionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesionales.findAll", query = "SELECT p FROM Profesionales p"),
    @NamedQuery(name = "Profesionales.findByIdProfesional", query = "SELECT p FROM Profesionales p WHERE p.idProfesional = :idProfesional"),
    @NamedQuery(name = "Profesionales.findByNombre", query = "SELECT p FROM Profesionales p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesionales.findByApellido", query = "SELECT p FROM Profesionales p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Profesionales.findByNumeroDeDocumento", query = "SELECT p FROM Profesionales p WHERE p.numeroDeDocumento = :numeroDeDocumento"),
    @NamedQuery(name = "Profesionales.findByTelefono", query = "SELECT p FROM Profesionales p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Profesionales.findByEmail", query = "SELECT p FROM Profesionales p WHERE p.email = :email"),
    @NamedQuery(name = "Profesionales.findByUsuario", query = "SELECT p FROM Profesionales p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "Profesionales.findByFechaCreacion", query = "SELECT p FROM Profesionales p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Profesionales.findByUltimaEdicion", query = "SELECT p FROM Profesionales p WHERE p.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "Profesionales.findByEstado", query = "SELECT p FROM Profesionales p WHERE p.estado = :estado")})
public class Profesionales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profesional")
    private Integer idProfesional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "numero_de_documento")
    private String numeroDeDocumento;
    @Size(max = 100)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuario")
    private String usuario;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesional", fetch = FetchType.LAZY)
    private List<Comisiones> comisionesList;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;
    @JoinColumn(name = "id_tipo_de_documento", referencedColumnName = "id_tipo_de_documento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TiposDeDocumentos idTipoDeDocumento;

    public Profesionales() {
    }

    public Profesionales(Integer idProfesional) {
        this.idProfesional = idProfesional;
    }

    public Profesionales(Integer idProfesional, String nombre, String apellido, String numeroDeDocumento, String usuario, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idProfesional = idProfesional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeDocumento = numeroDeDocumento;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(Integer idProfesional) {
        this.idProfesional = idProfesional;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    @XmlTransient
    public List<Comisiones> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comisiones> comisionesList) {
        this.comisionesList = comisionesList;
    }

    public Clinicas getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinicas idClinica) {
        this.idClinica = idClinica;
    }

    public TiposDeDocumentos getIdTipoDeDocumento() {
        return idTipoDeDocumento;
    }

    public void setIdTipoDeDocumento(TiposDeDocumentos idTipoDeDocumento) {
        this.idTipoDeDocumento = idTipoDeDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesional != null ? idProfesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesionales)) {
            return false;
        }
        Profesionales other = (Profesionales) object;
        if ((this.idProfesional == null && other.idProfesional != null) || (this.idProfesional != null && !this.idProfesional.equals(other.idProfesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.Profesionales[ idProfesional=" + idProfesional + " ]";
    }
    
}
