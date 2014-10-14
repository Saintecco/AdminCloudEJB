/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.EstadosPacientes;

/**
 *
 * @author saintec
 */
@Stateless
public class EstadosPacientesImpl implements EstadosPacientesEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public EstadosPacientes guardar(EstadosPacientes estadoPaciente) {
        try {
            em.persist(estadoPaciente);
            return estadoPaciente;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public EstadosPacientes editar(EstadosPacientes estadoPaciente) {
        try {
            em.merge(estadoPaciente);
            return estadoPaciente;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idEstadoPaciente) {
        EstadosPacientes estadoPacientes = em.find(EstadosPacientes.class, idEstadoPaciente);
        Integer ok = 0;
        if (estadoPacientes != null) {
            try {
                em.remove(estadoPacientes);
                ok = 200;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return ok;
    }

    @Override
    public EstadosPacientes traer(Integer idEstadoPaciente) {
        try {
            return em.find(EstadosPacientes.class, idEstadoPaciente);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<EstadosPacientes> listar(Clinicas clinica) {
        String queryStr = "SELECT e FROM EstadosPacientes e "
                + "WHERE e.idClinica = :idClinica "
                + "ORDER BY e.estadoPaciente";
        Query query = em.createQuery(queryStr);
        query.setParameter("idClinica", clinica);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
