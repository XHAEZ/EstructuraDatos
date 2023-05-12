/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modeloTabla;

import controller.util.Utilities;
import javax.swing.table.AbstractTableModel;
import model.Sucursal;

/**
 *
 * @author danny
 */
public class ModeloTablaSucursal extends AbstractTableModel{
    
    private Sucursal [] datos = new Sucursal[4];

    public Sucursal[] getDatos() {
        return datos;
    }

    public void setDatos(Sucursal[] datos) {
        this.datos = datos;
    }
    
    @Override
    public int getRowCount() {
       return datos.length;
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Sucursal s = datos[i];
        switch(i1){
            case 0: return (s != null) ? s.getNombre() : "No definido";
            case 1: return (s != null) ? Utilities.sumarVentas(s) : 0.0;
            case 2: return (s != null) ? Utilities.mediaVentas(s) : 0.0;
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Sucursal";
            case 1: return "Venta Anual";
            case 2: return "Venta Promedio";
            default: return null;
        }
    }
    
    
    
}
