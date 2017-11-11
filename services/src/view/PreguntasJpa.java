/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Preguntas;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
@LocalBean
public class PreguntasJpa {

    @PersistenceContext
    EntityManager em;
    
    
        
    
    public PreguntasJpa(){
    }
      
    
    public Preguntas buscarEncuesta(Integer id){        
        return (em.find(Preguntas.class, id));
    }    
    
    public List<Preguntas> listarEncuestas(){
        Query query = em.createQuery("select p from Preguntas p");
        List<Preguntas> lista = query.getResultList();
        return lista;
    }

}
