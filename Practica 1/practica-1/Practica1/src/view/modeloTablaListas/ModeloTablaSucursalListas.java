/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modeloTablaListas;

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

        Sucursal sucursal = null;

        try {
            sucursal = datos.get(i);
        } catch (Exception ex) {
          
        }

        switch (i1) {
            case 0:
                return (sucursal != null) ? sucursal.getNombre() : "NO DEFINIDO";
            default:
                return null;
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
