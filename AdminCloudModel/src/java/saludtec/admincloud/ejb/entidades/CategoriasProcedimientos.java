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
@Table(name = "categorias_procedimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriasProcedimientos.findAll", query = "SELECT c FROM CategoriasProcedimientos c"),
    @NamedQuery(name = "CategoriasProcedimientos.findByIdCategoriaProcedimiento", query = "SELECT c FROM CategoriasProcedimientos c WHERE c.idCategoriaProcedimiento = :idCategoriaProcedimiento"),
    @NamedQuery(name = "CategoriasProcedimientos.findByCategoriaProcedimiento", query = "SELECT c FROM CategoriasProcedimientos c WHERE c.categoriaProcedimiento = :categoriaProcedimiento"),
    @NamedQuery(name = "CategoriasProcedimientos.findByFechaCreacion", query = "SELECT c FROM CategoriasProcedimientos c WHERE c.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "CategoriasProcedimientos.findByUltimaEdicion", query = "SELECT c FROM CategoriasProcedimientos c WHERE c.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "CategoriasProcedimientos.findByEstado", query = "SELECT c FROM CategoriasProcedimientos c WHERE c.estado = :estado")})
public class CategoriasProcedimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_procedimiento")
    private Integer idCategoriaProcedimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "categoria_procedimiento")
    private String categoriaProcedimiento;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaProcedimiento", fetch = FetchType.LAZY)
    private List<Procedimientos> procedimientosList;
    @JoinColumn(name = "id_clinica", referencedColumnName = "id_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clinicas idClinica;

    public CategoriasProcedimientos() {
    }

    public CategoriasProcedimientos(Integer idCategoriaProcedimiento) {
        this.idCategoriaProcedimiento = idCategoriaProcedimiento;
    }

    public CategoriasProcedimientos(Integer idCategoriaProcedimiento, String categoriaProcedimiento, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idCategoriaProcedimiento = idCategoriaProcedimiento;
        this.categoriaProcedimiento = categoriaProcedimiento;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdCategoriaProcedimiento() {
        return idCategoriaProcedimiento;
    }

    public void setIdCategoriaProcedimiento(Integer idCategoriaProcedimiento) {
        this.idCategoriaProcedimiento = idCategoriaProcedimiento;
    }

    public String getCategoriaProcedimiento() {
        return categoriaProcedimiento;
    }

    public void setCategoriaProcedimiento(String categoriaProcedimiento) {
        this.categoriaProcedimiento = categoriaProcedimiento;
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
    public List<Procedimientos> getProcedimientosList() {
        return procedimientosList;
    }

    public void setProcedimientosList(List<Procedimientos> procedimientosList) {
        this.procedimientosList = procedimientosList;
    }

    public Clinicas getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(Clinicas idClinica) {
        this.idClinica = idClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaProcedimiento != null ? idCategoriaProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriasProcedimientos)) {
            return false;
        }
        CategoriasProcedimientos other = (CategoriasProcedimientos) object;
        if ((this.idCategoriaProcedimiento == null && other.idCategoriaProcedimiento != null) || (this.idCategoriaProcedimiento != null && !this.idCategoriaProcedimiento.equals(other.idCategoriaProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.CategoriasProcedimientos[ idCategoriaProcedimiento=" + idCategoriaProcedimiento + " ]";
    }
    
}
