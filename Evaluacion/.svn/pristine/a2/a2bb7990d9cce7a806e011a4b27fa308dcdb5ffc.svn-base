/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.eval.Matriz;
import entidades.eval.Resultado;
import entidades.eval.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import logica.eval.MatrizFacade;
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
public class ChartTcemoControler {

    @EJB
    private MatrizFacade matrizFacade;
    private LineChartModel lineChartModel;
    private List<Resultado> listadoChart;
    private Matriz matrizTotal;
    private BigDecimal total;
    private Test testActual;

    public ChartTcemoControler() {
        listadoChart = new ArrayList<>();
        testActual = new Test();
    }

    @PostConstruct
    public void init() {
        listadoChart = TestTemoControlador.getListaResultado();
        testActual = TestTemoControlador.getTestActual();
        createLineModels();
        cargaTotal();
    }

    private void cargaTotal() {
        total = listadoChart.get(0).getTotal();
        matrizTotal = matrizFacade.buscaMatrizTotal(total, testActual.getIdtest());
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
        for (Resultado r : listadoChart) {
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
        lineChartModel.getAxes().put(AxisType.X, new CategoryAxis("SubEscala"));
        Axis yAxis = lineChartModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(45);

        lineChartModel.setExtender("skinChart");

    }

    public List<Resultado> getListadoResultado() {
        return listadoChart;
    }

    public Matriz getMatrizTotal() {
        return matrizTotal;
    }

    public void setMatrizTotal(Matriz matrizTotal) {
        this.matrizTotal = matrizTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


}
