/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.exception.SpaceException;
import model.EnumMes;
import model.Sucursal;
import model.Venta;

/**
 *
 * @author danny
 */
public class SucursalController {

    private ListaEnlazada<Sucursal> sucursal = new ListaEnlazada<>();
    private Sucursal sucursales;
    private Venta venta;

    public SucursalController() {
    }

    public ListaEnlazada<Sucursal> getSucursal() {
        sucursal.setSize(20);
        return sucursal;
    }

    public Boolean setSucursal(Sucursal sucursales) throws PositionException{
        if (sucursal.getSize() == sucursal.getUltimaPosicionOcupada()) {
            return false;
        }
        this.sucursal.insertarPosicion(sucursales, sucursal.getUltimaPosicionOcupada());
        return true;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public int getSize(){
        return sucursal.getSize();
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws SpaceException {
        if (this.sucursal != null) {
            if (posVenta <= this.sucursales.getVentas().getSize()-1) {
               
            } else {
                throw new SpaceException();
            }
        } else {
            throw new NullPointerException("Debe seleccionar una sucursal");
        }
        return true;
    }

}
