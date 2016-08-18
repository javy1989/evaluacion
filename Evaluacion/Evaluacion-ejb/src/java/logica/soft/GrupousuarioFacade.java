/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.soft;

import entidades.soft.Grupousuario;
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
public class GrupousuarioFacade extends AbstractFacade<Grupousuario> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupousuarioFacade() {
        super(Grupousuario.class);
    }

    public List<Grupousuario> buscaGrupoUsuario(String usuario) {
        try {
            List<Grupousuario> lista;
            lista = em.createNamedQuery("Grupousuario.findByUsuario")
                    .setParameter("usuario", usuario)
                    .getResultList();
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
