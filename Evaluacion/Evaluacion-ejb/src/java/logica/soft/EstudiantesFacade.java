/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.soft;

import entidades.soft.Estudiantes;
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
public class EstudiantesFacade extends AbstractFacade<Estudiantes> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiantesFacade() {
        super(Estudiantes.class);
    }

    public List<Estudiantes> listaRepresentado(int idRepresentante) {
        List<Estudiantes> listado;
        try {
            listado = em.createNamedQuery("Estudiantes.findByRepresentado")
                    .setParameter("id", idRepresentante)
                    .getResultList();
            return listado;
        } catch (Exception e) {
            return null;
        }
    }

    public Estudiantes estudiante(int idEstudiante) {
        try {
            Estudiantes estudent = (Estudiantes) em.createNamedQuery("Estudiantes.findByEstudianteEntidad")
                    .setParameter("id", idEstudiante)
                    .getSingleResult();
            return estudent;
        } catch (Exception e) {
            return null;
        }
    }
}
