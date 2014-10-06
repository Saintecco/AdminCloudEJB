/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saintec
 */
@Entity
@Table(name = "claves")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Claves.findAll", query = "SELECT c FROM Claves c"),
    @NamedQuery(name = "Claves.findByIdClave", query = "SELECT c FROM Claves c WHERE c.idClave = :idClave"),
    @NamedQuery(name = "Claves.findByClaveCorreccion", query = "SELECT c FROM Claves c WHERE c.claveCorreccion = :claveCorreccion"),
    @NamedQuery(name = "Claves.findByClaveArqueoDeCaja", query = "SELECT c FROM Claves c WHERE c.claveArqueoDeCaja = :claveArqueoDeCaja"),
    @NamedQuery(name = "Claves.findByClavescol", query = "SELECT c FROM Claves c WHERE c.clavescol = :clavescol")})
public class Claves implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clave")
    private Integer idClave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "clave_correccion")
    private String claveCorreccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "clave_arqueo_de_caja")
    private String claveArqueoDeCaja;
    @Size(max = 45)
    @Column(name = "clavescol")
    private String clavescol;

    public Claves() {
    }

    public Claves(Integer idClave) {
        this.idClave = idClave;
    }

    public Claves(Integer idClave, String claveCorreccion, String claveArqueoDeCaja) {
        this.idClave = idClave;
        this.claveCorreccion = claveCorreccion;
        this.claveArqueoDeCaja = claveArqueoDeCaja;
    }

    public Integer getIdClave() {
        return idClave;
    }

    public void setIdClave(Integer idClave) {
        this.idClave = idClave;
    }

    public String getClaveCorreccion() {
        return claveCorreccion;
    }

    public void setClaveCorreccion(String claveCorreccion) {
        this.claveCorreccion = claveCorreccion;
    }

    public String getClaveArqueoDeCaja() {
        return claveArqueoDeCaja;
    }

    public void setClaveArqueoDeCaja(String claveArqueoDeCaja) {
        this.claveArqueoDeCaja = claveArqueoDeCaja;
    }

    public String getClavescol() {
        return clavescol;
    }

    public void setClavescol(String clavescol) {
        this.clavescol = clavescol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClave != null ? idClave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Claves)) {
            return false;
        }
        Claves other = (Claves) object;
        if ((this.idClave == null && other.idClave != null) || (this.idClave != null && !this.idClave.equals(other.idClave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admin_cloud.ejb.entidades.Claves[ idClave=" + idClave + " ]";
    }
    
}
