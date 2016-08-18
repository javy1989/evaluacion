/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.eval;

import entidades.eval.Resultado;
import entidades.eval.ResultadoChartTcfso;
import generica.AbstractFacade;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
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
public class ResultadoFacade extends AbstractFacade<Resultado> {

    @PersistenceContext(unitName = "Evaluacion-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultadoFacade() {
        super(Resultado.class);
    }

    public List<Resultado> listaResultado(int idTestUser) {
        List<Resultado> listado;
        try {
            listado = em.createNamedQuery("Resultado.findByTestUser")
                    .setParameter("idtestuser", idTestUser)
                    .getResultList();
            return listado;
        } catch (Exception e) {
            return null;
        }
    }
    public List<Resultado> listaResultadoClase(int idClase,int idTestUser) {
        List<Resultado> listado;
        try {
            listado = em.createNamedQuery("Resultado.findByClase")
                    .setParameter("idclase", idClase)
                    .setParameter("idtestuser",idTestUser)
                    .getResultList();
            return listado;
        } catch (Exception e) {
            return null;
        }
    }

    public List<ResultadoChartTcfso> listaResulTcfso(int idTestUser) {
        String sql = "select distinct(c.detalle),re.idclase,sum(re.sub_valor),z.categoria from resultado as re "
                + "inner join clase as c "
                + "on re.idclase=c.idclase "
                + "inner join matriz as z "
                + "on re.idmatriz=z.idmatriz "
                + "where re.idtestuser = "+" "+idTestUser+" "
                + "group by re.idclase,c.detalle,z.categoria";
        try {
            Query query = em.createNativeQuery(sql);
            List<Resultado> listaReaux = query.getResultList();
            List<ResultadoChartTcfso> listaResul = new ArrayList<>();
            Iterator it = listaReaux.iterator();
                while (it.hasNext()) {
                Object[] result = (Object[]) it.next();
                ResultadoChartTcfso aux = new ResultadoChartTcfso();
                aux.setDetalle(result[0].toString());
                aux.setIdClase((int)result[1]);
                aux.setSuma(new BigDecimal(result[2].toString()));
                aux.setCategoria(result[3].toString());
                listaResul.add(aux);
            }
            return listaResul;

        } catch (Exception e) {
            return null;
        }

    }
}
