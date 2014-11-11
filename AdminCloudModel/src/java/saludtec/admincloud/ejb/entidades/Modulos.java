/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saintec
 */
@Entity
@Table(name = "modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulos.findAll", query = "SELECT m FROM Modulos m"),
    @NamedQuery(name = "Modulos.findByIdModulo", query = "SELECT m FROM Modulos m WHERE m.idModulo = :idModulo"),
    @NamedQuery(name = "Modulos.findByModulo", query = "SELECT m FROM Modulos m WHERE m.modulo = :modulo"),
    @NamedQuery(name = "Modulos.findByNombre", query = "SELECT m FROM Modulos m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Modulos.findByIcono", query = "SELECT m FROM Modulos m WHERE m.icono = :icono")})
public class Modulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modulo")
    private Integer idModulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "modulo")
    private String modulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "icono")
    private String icono;
    @OneToMany(mappedBy = "idModulo", fetch = FetchType.LAZY)
    private List<ModulosClinicas> modulosClinicasList;

    public Modulos() {
    }

    public Modulos(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public Modulos(Integer idModulo, String modulo, String nombre) {
        this.idModulo = idModulo;
        this.modulo = modulo;
        this.nombre = nombre;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @XmlTransient
    public List<ModulosClinicas> getModulosClinicasList() {
        return modulosClinicasList;
    }

    public void setModulosClinicasList(List<ModulosClinicas> modulosClinicasList) {
        this.modulosClinicasList = modulosClinicasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModulo != null ? idModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulos)) {
            return false;
        }
        Modulos other = (Modulos) object;
        if ((this.idModulo == null && other.idModulo != null) || (this.idModulo != null && !this.idModulo.equals(other.idModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.Modulos[ idModulo=" + idModulo + " ]";
    }
    
}
