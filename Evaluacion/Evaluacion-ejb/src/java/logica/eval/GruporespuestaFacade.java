/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Gruporespuesta;
import entidades.eval.Respuesta;
import generica.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Multimedia
 */
@Stateless
public class GruporespuestaFacade extends AbstractFacade<Gruporespuesta> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GruporespuestaFacade() {
        super(Gruporespuesta.class);
    }

    public List<Respuesta> listaRespuesta(int idGrupoRespuesta) {
        try {
            List<Respuesta> list = em.createNamedQuery("Respuesta.findByRespuesraGrupoRespuesta")
                    .setParameter("grupo", idGrupoRespuesta).getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
