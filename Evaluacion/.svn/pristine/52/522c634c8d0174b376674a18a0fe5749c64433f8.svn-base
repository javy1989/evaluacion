/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Resultado;
import entidades.eval.ResultadoChartTcfso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import logica.eval.ResultadoFacade;
import logica.eval.TestFacade;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Multimedia
 */
@ManagedBean
@ViewScoped
public class ChartTcfsoControlador implements Serializable {

    @EJB
    private ResultadoFacade resultadoFacade;

    @EJB
    private TestFacade testFacade;
    private List<ResultadoChartTcfso> lista;
    private List<Resultado> subescala;
    private List<Resultado> listaChart;
    private LineChartModel lineChartModel;

    public ChartTcfsoControlador() {
        lista = new ArrayList<>();
        subescala = new ArrayList<>();
        listaChart = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        lista = resultadoFacade.listaResulTcfso(TestCfsoControler.getTestuser().getIdtestuser());
        listaChart = resultadoFacade.listaResultado(TestCfsoControler.getTestuser().getIdtestuser());
        createLineModels();

    }

    public List<ResultadoChartTcfso> getLista() {
        return lista;
    }

    public void setLista(List<ResultadoChartTcfso> lista) {
        this.lista = lista;
    }

    public List<Resultado> subescala(int idClase) {
        subescala = resultadoFacade.listaResultadoClase(idClase,listaChart.get(0).getIdtestuser().getIdtestuser());
        return subescala;
    }

    public void setLineChartModel(LineChartModel lineChartModel) {
        this.lineChartModel = lineChartModel;
    }

    public LineChartModel getLineChartModel() {
        return lineChartModel;
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        ChartSeries series = new ChartSeries();
        for (Resultado r : listaChart) {
          series.set(r.getSubclase().getCodigo(), r.getValor());
         }
        
        model.addSeries(series);
        return model;

    }

    private void createLineModels() {
        lineChartModel = initLinearModel();
        lineChartModel.setTitle("Resultados");
        lineChartModel.setAnimate(true);
        lineChartModel.setShowPointLabels(true);
        lineChartModel.getAxes().put(AxisType.X,new CategoryAxis("SubEscala"));
        Axis yAxis = lineChartModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
        
        
        
        lineChartModel.setExtender("skinChart");

    }

}
