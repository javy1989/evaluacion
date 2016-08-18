/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.eval;

import java.math.BigDecimal;

/**
 *
 * @author Multimedia
 */
public class ResultadoChartTcfso {

    private String detalle;
    private Integer idClase;
    private BigDecimal suma;
    private String categoria;

    
    public ResultadoChartTcfso() {
    }

    public ResultadoChartTcfso(String detalle, BigDecimal suma, String categoria) {
        this.detalle = detalle;
        this.suma = suma;
        this.categoria = categoria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BigDecimal getSuma() {
        return suma;
    }

    public void setSuma(BigDecimal suma) {
        this.suma = suma;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }
}
