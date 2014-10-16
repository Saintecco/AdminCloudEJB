package saludtec.admincloud.ejb.crud;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.TiposDeDocumentos;

@Stateless
public class TiposDocumentosImpl implements TiposDocumentosEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public TiposDeDocumentos guardar(TiposDeDocumentos tipoDocumento) {
        try {
            em.persist(tipoDocumento);
            return tipoDocumento;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public TiposDeDocumentos editar(TiposDeDocumentos tipoDocumento) {
        try {
            em.merge(tipoDocumento);
            return tipoDocumento;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idTipoDocumento) {
        Integer ok = 0;
        try {
            TiposDeDocumentos tipoDocumentos = em.find(TiposDeDocumentos.class, idTipoDocumento);
            if (tipoDocumentos != null) {
                em.remove(tipoDocumentos);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public TiposDeDocumentos traer(Integer idTipoDocumento) {
        try {
            return em.find(TiposDeDocumentos.class, idTipoDocumento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<TiposDeDocumentos> listar(Clinicas clinica) {
        try {
            String queryStr = "SELECT t FROM TiposDeDocumentos t "
                    + "WHERE t.idClinica = :idClinica "
                    + "ORDER BY t.tipoDeDocumento";
            Query query = em.createQuery(queryStr);
            query.setParameter("idClinica", clinica);
            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public String listarr() {
        return "mensaje del ejb";
    }

}
