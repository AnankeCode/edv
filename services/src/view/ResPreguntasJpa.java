
package view;

import model.ResPreguntas;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ResPreguntasJpa {

    @PersistenceContext
    EntityManager em;    
    
    
    

    public void sumarVoto(Integer idOpcion) {
        Query query = em.createQuery("UPDATE ResPreguntas p SET p.resp_escogida = p.resp_escogida + 1 where p.resp_id = :idOpcion");
        query.setParameter("idOpcion", idOpcion);
        query.executeUpdate();
    }
    
    public List<ResPreguntas> obtenerOpcionesEncuesta(int id){
        List lista = null;
        Query query = em.createQuery("select p from  ResPreguntas p where p.resp_id = :id");
        query.setParameter("id", id);
        lista = query.getResultList();        
        return lista;        
    }
    
    public long obtenerCantidadVotos(Integer id){
        long cant = 0;       
        Query query = em.createQuery("select p from  ResPreguntas p where p.resp_id = :id");
        query.setParameter("id", id);
        List <Res> lista = query.getResultList();
        for(ResPreguntas po:lista){
            int votos = po.getresp_escogida();
            cant = cant + votos;
        }        
        return cant;
    }
    

    
}
