/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modeloTabla;

import controller.ed.cola.ColaI;
import javax.swing.table.AbstractTableModel;
import model.Peticion;


/**
 *
 * @author cobos
 */
public class ModeloTablaPeticiones extends AbstractTableModel {

    private ColaI<Peticion> datos = new ColaI<>(20);

    public ColaI<Peticion> getDatos() {
        return datos;
    }

    public void setDatos(ColaI<Peticion> datos) {
        this.datos = datos;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int i1) {

        Peticion p = null;
        try {
            p = datos.get(i);
        } catch (Exception e) {
        }
        switch (i1) {
            case 0:
                return (p != null ? p.getUsuario() : "NO DEFINIDO");
            case 1: 
                return (p != null) ? p.getPeticion() : "NO DEFINIDO";
            default: return null;
        }
    }

    @Override
        public String getColumnName(int column) {
        switch (column) {
                case 0:
                    return "Usuario";
                case 1:
                    return "Peticion";
                default:
                    return null;
            }
        }
    }
