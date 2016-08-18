/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Resultado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import logica.eval.ResultadoFacade;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@ViewScoped
public class ChartTsapControler implements Serializable {

    @EJB
    private ResultadoFacade resultadoFacade;

    private BarChartModel barModel;
    private List<Resultado> lista;

    public ChartTsapControler() {
        lista = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        lista = SatisfaccionPadreControler.getListaResultado();
        crearChart();
    }

    private void crearChart() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = initBarModel();
        barModel.setTitle("Resultado");
        barModel.setAnimate(true);
        barModel.setSeriesColors("62656a,a5a5a5,929397");
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Area");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Porcentaje");
        yAxis.setMin(0);
        yAxis.setMax(100);

        barModel.setExtender("skinBar");
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries subClase = new BarChartSeries();
        for (Resultado rs : lista) {
            if (rs.getSubclase().getCodigo().compareTo("SCOBB") != 0) {
                subClase.set(rs.getSubclase().getCodigo(), rs.getValor());
            }

        }
        model.addSeries(subClase);
        return model;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }
}
