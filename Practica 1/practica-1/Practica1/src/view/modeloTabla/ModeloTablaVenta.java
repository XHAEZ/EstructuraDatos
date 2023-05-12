/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modeloTabla;

import controller.util.Utilities;
import javax.swing.table.AbstractTableModel;
import model.Venta;

/**
 *
 * @author danny
 */
public class ModeloTablaVenta extends AbstractTableModel{
    
    private Venta [] datos = new Venta[12];

    public Venta[] getDatos() {
        return datos;
    }

    public void setDatos(Venta[] datos) {
        this.datos = datos;
    }
    
    @Override
    public int getRowCount() {
       return datos.length;
    }

    @Override
    public int getColumnCount() {
       return 2;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Venta s = datos[i];
        switch(i1){
            case 0: return (s != null) ? s.getMes().toString(): "No definido";
            case 1: return (s != null) ? s.getValor() : 0.0;
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Mes";
            case 1: return "Valor";
            default: return null;
        }
    }
    
}
