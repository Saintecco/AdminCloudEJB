/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.Departamentos;

/**
 *
 * @author saintec
 */
@Stateless
public class DepartamentosImpl implements DepartamentosEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public Departamentos guardar(Departamentos departamento) {
        try {
            em.persist(departamento);
            return departamento;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Departamentos editar(Departamentos departamento) {
        try {
            em.merge(departamento);
            return departamento;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idDepartamento) {
        Integer ok = 0;
        try {
            Departamentos departamentos = em.find(Departamentos.class, idDepartamento);
            if (departamentos != null) {
                em.remove(departamentos);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public Departamentos traer(Integer idDepartamento) {
        try {
            return em.find(Departamentos.class, idDepartamento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Departamentos> listar(Clinicas clinica) {
        try {
            String queryStr = "SELECT d FROM Departamentos d "
                    + "WHERE d.idClinica = :idClinica "
                    + "ORDER BY d.departamento";
            Query query = em.createQuery(queryStr);
            query.setParameter("idClinica", clinica);
            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
