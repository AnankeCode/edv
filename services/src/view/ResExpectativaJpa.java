package view;

import model.ResExpectativa;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ResExpectativaJpa {

    @PersistenceContext
    EntityManager em;    
    
    
    

    public void sumarVoto(Integer idOpcion) {
        Query query = em.createQuery("UPDATE ResExpectativa p SET p.rese_escogida = p.rese_escogida + 1 where p.rese_id = :idOpcion");
        query.setParameter("idOpcion", idOpcion);
        query.executeUpdate();
    }
    
    public List<ResPreguntas> obtenerOpcionesEncuesta(int id){
        List lista = null;
        Query query = em.createQuery("select p from  ResExpectativa p where p.rese_id = :id");
        query.setParameter("id", id);
        lista = query.getResultList();        
        return lista;        
    }
    
    public long obtenerCantidadVotos(Integer id){
        long cant = 0;       
        Query query = em.createQuery("select p from  ResExpectativa p where p.rese_id = :id");
        query.setParameter("id", id);
        List <Res> lista = query.getResultList();
        for(ResExpectativa po:lista){
            int votos = po.getrese_escogida();
            cant = cant + votos;
        }        
        return cant;
    }
    

    
}
