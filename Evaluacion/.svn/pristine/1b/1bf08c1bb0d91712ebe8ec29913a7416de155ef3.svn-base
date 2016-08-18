/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.soft;

import entidades.soft.Anioslectivos;
import generica.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Multimedia
 */
@Stateless
public class AnioslectivosFacade extends AbstractFacade<Anioslectivos> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnioslectivosFacade() {
        super(Anioslectivos.class);
    }

    public List<Anioslectivos> listaAnioLectivo(int idInstitucion) {
        try {
            List<Anioslectivos> listado = em.createNamedQuery("Anioslectivos.findByInstitucion")
                    .setParameter("id", idInstitucion).getResultList();
            return listado;
        } catch (Exception e) {
            return null;
        }
    }

    public String anioLectivo(int idAnio) {
        try {
            Anioslectivos anio = (Anioslectivos)em.createNamedQuery("Anioslectivos.findById")
                    .setParameter("id",idAnio)
                    .getSingleResult();
            return anio.getAniolectivo();
        } catch (Exception e) {
            return null;
        }
    }
}
