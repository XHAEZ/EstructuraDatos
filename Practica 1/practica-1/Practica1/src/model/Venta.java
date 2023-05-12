/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author danny
 */
public class Venta {

    private Integer id;
    private Double valor;
    private EnumMes mes;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EnumMes getMes() {
        return mes;
    }

    public void setMes(EnumMes mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", valor=" + valor + ", mes=" + mes.toString() + '}';
    }
    
}
