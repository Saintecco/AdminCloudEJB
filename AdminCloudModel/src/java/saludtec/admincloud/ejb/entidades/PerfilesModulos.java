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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saintec
 */
@Entity
@Table(name = "perfiles_modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilesModulos.findAll", query = "SELECT p FROM PerfilesModulos p"),
    @NamedQuery(name = "PerfilesModulos.findByIdPerfilModulo", query = "SELECT p FROM PerfilesModulos p WHERE p.idPerfilModulo = :idPerfilModulo")})
public class PerfilesModulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil_modulo")
    private Integer idPerfilModulo;

    public PerfilesModulos() {
    }

    public PerfilesModulos(Integer idPerfilModulo) {
        this.idPerfilModulo = idPerfilModulo;
    }

    public Integer getIdPerfilModulo() {
        return idPerfilModulo;
    }

    public void setIdPerfilModulo(Integer idPerfilModulo) {
        this.idPerfilModulo = idPerfilModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilModulo != null ? idPerfilModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilesModulos)) {
            return false;
        }
        PerfilesModulos other = (PerfilesModulos) object;
        if ((this.idPerfilModulo == null && other.idPerfilModulo != null) || (this.idPerfilModulo != null && !this.idPerfilModulo.equals(other.idPerfilModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.PerfilesModulos[ idPerfilModulo=" + idPerfilModulo + " ]";
    }
    
}
