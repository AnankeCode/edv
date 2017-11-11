
package view;

import model.Expectativa;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
@LocalBean
public class ExpectativaJpa {

    @PersistenceContext
    EntityManager em;
    
   
        
    
    public ExpectativaJpa(){
    }
      
    
    public Expectativa buscarEncuesta(Integer id){        
        return (em.find(Expectativa.class, id));
    }    
    
    public List<Expectativa> listarEncuestas(){
        Query query = em.createQuery("select p from expectativa p");
        List<Expectativa> lista = query.getResultList();
        return lista;
    }

}
