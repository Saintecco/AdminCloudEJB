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
@Table(name = "procedimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimientos.findAll", query = "SELECT p FROM Procedimientos p"),
    @NamedQuery(name = "Procedimientos.findByIdProcedimiento", query = "SELECT p FROM Procedimientos p WHERE p.idProcedimiento = :idProcedimiento"),
    @NamedQuery(name = "Procedimientos.findByProcedimiento", query = "SELECT p FROM Procedimientos p WHERE p.procedimiento = :procedimiento"),
    @NamedQuery(name = "Procedimientos.findByRango", query = "SELECT p FROM Procedimientos p WHERE p.rango = :rango"),
    @NamedQuery(name = "Procedimientos.findByAmbitoRealizacion", query = "SELECT p FROM Procedimientos p WHERE p.ambitoRealizacion = :ambitoRealizacion"),
    @NamedQuery(name = "Procedimientos.findByFinalidadProcedimiento", query = "SELECT p FROM Procedimientos p WHERE p.finalidadProcedimiento = :finalidadProcedimiento"),
    @NamedQuery(name = "Procedimientos.findByActoQuirurgico", query = "SELECT p FROM Procedimientos p WHERE p.actoQuirurgico = :actoQuirurgico"),
    @NamedQuery(name = "Procedimientos.findByCups", query = "SELECT p FROM Procedimientos p WHERE p.cups = :cups"),
    @NamedQuery(name = "Procedimientos.findByValor", query = "SELECT p FROM Procedimientos p WHERE p.valor = :valor"),
    @NamedQuery(name = "Procedimientos.findByFechaCreacion", query = "SELECT p FROM Procedimientos p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Procedimientos.findByUltimaEdicion", query = "SELECT p FROM Procedimientos p WHERE p.ultimaEdicion = :ultimaEdicion"),
    @NamedQuery(name = "Procedimientos.findByEstado", query = "SELECT p FROM Procedimientos p WHERE p.estado = :estado")})
public class Procedimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procedimiento")
    private Integer idProcedimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "procedimiento")
    private String procedimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rango")
    private int rango;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ambito_realizacion")
    private int ambitoRealizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finalidad_procedimiento")
    private int finalidadProcedimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acto_quirurgico")
    private int actoQuirurgico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "cups")
    private String cups;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
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
    @JoinColumn(name = "id_categoria_procedimiento", referencedColumnName = "id_categoria_procedimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriasProcedimientos idCategoriaProcedimiento;

    public Procedimientos() {
    }

    public Procedimientos(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Procedimientos(Integer idProcedimiento, String procedimiento, int rango, int ambitoRealizacion, int finalidadProcedimiento, int actoQuirurgico, String cups, double valor, Date fechaCreacion, Date ultimaEdicion, String estado) {
        this.idProcedimiento = idProcedimiento;
        this.procedimiento = procedimiento;
        this.rango = rango;
        this.ambitoRealizacion = ambitoRealizacion;
        this.finalidadProcedimiento = finalidadProcedimiento;
        this.actoQuirurgico = actoQuirurgico;
        this.cups = cups;
        this.valor = valor;
        this.fechaCreacion = fechaCreacion;
        this.ultimaEdicion = ultimaEdicion;
        this.estado = estado;
    }

    public Integer getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public int getAmbitoRealizacion() {
        return ambitoRealizacion;
    }

    public void setAmbitoRealizacion(int ambitoRealizacion) {
        this.ambitoRealizacion = ambitoRealizacion;
    }

    public int getFinalidadProcedimiento() {
        return finalidadProcedimiento;
    }

    public void setFinalidadProcedimiento(int finalidadProcedimiento) {
        this.finalidadProcedimiento = finalidadProcedimiento;
    }

    public int getActoQuirurgico() {
        return actoQuirurgico;
    }

    public void setActoQuirurgico(int actoQuirurgico) {
        this.actoQuirurgico = actoQuirurgico;
    }

    public String getCups() {
        return cups;
    }

    public void setCups(String cups) {
        this.cups = cups;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public CategoriasProcedimientos getIdCategoriaProcedimiento() {
        return idCategoriaProcedimiento;
    }

    public void setIdCategoriaProcedimiento(CategoriasProcedimientos idCategoriaProcedimiento) {
        this.idCategoriaProcedimiento = idCategoriaProcedimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedimiento != null ? idProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimientos)) {
            return false;
        }
        Procedimientos other = (Procedimientos) object;
        if ((this.idProcedimiento == null && other.idProcedimiento != null) || (this.idProcedimiento != null && !this.idProcedimiento.equals(other.idProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "saludtec.admincloud.ejb.entidades.Procedimientos[ idProcedimiento=" + idProcedimiento + " ]";
    }
    
}
