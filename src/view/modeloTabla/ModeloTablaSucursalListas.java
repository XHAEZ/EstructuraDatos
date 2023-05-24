/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modeloTabla;

import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.util.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import model.Sucursal;

/**
 *
 * @author danny
 */
public class ModeloTablaSucursalListas extends AbstractTableModel {

    private ListaEnlazada<Sucursal> datos = new ListaEnlazada<>();

    public ListaEnlazada<Sucursal> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Sucursal> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int i, int i1) {

        Sucursal s = null;
        try {
            s = datos.get(i);
        } catch (Exception e) {
        }
        switch(i1) {
            case 0: return (s != null ? s.getNombre(): "NO DEFINIDO");
            case 1: {
                try {
                    return(s != null) ? Utilities.sumarVentas(s): 0.0;
                } catch (Exception ex) {
                    
                }
            }

            case 2: {
            try {
                return (s != null) ? Utilities.mediaVentas(s) : 0.0;
            } catch (EmptyException ex) {
                Logger.getLogger(ModeloTablaSucursalListas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PositionException ex) {
                Logger.getLogger(ModeloTablaSucursalListas.class.getName()).log(Level.SEVERE, null, ex);
            }
            }

   
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Sucursal";
            case 1:
                return "Venta Anual";
            case 2:
                return "Venta Promedio";
            default:
                return null;
        }
    }

}
