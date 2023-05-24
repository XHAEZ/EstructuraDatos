/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.exception.SpaceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EnumMes;
import model.Sucursal;
import model.Venta;

/**
 *
 * @author danny
 */
public class SucursalController {

    public static final transient String NOMBRE_ARCHIVO = "sucursales";
    private ListaEnlazada<Sucursal> sucursales;
    private ListaEnlazada<Venta> ventas;
    private Venta venta;
    private Sucursal sucursal;

    public SucursalController() {
        sucursales = new ListaEnlazada<>();
        ventas = new ListaEnlazada<>();
    }

    public ListaEnlazada<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ListaEnlazada<Sucursal> sucursale) {
        this.sucursales = sucursale;
    }

    public ListaEnlazada<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ListaEnlazada<Venta> ventas) {
        if (ventas == null) {
            ventas = new ListaEnlazada<>();
        }
        this.ventas = ventas;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Sucursal getSucursal() {
        if (sucursal == null) {
            sucursal = new Sucursal();
        }
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public boolean registrar() throws SpaceException {
        sucursal.setVenta(new ListaEnlazada<>());
        for (EnumMes mes : EnumMes.values()) {
            Venta venta = new Venta();
            venta.setId(mes.ordinal() + 1);
            venta.setMes(mes);
            venta.setValor(0.0);
            sucursal.getVenta().insertar(venta);
        }
        sucursales.insertar(sucursal);
        try {
            sucursales.imprimir();
        } catch (EmptyException ex) {
            Logger.getLogger(SucursalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws SpaceException, EmptyException, PositionException {

        if (this.sucursal != null) {
            if (posVenta <= this.sucursal.getVenta().getSize() - 1) {
                sucursal.getVenta().get(posVenta).setValor(valor);
            } else {
                throw new SpaceException();
            }

        } else {
            throw new NullPointerException("Se debe elegir una sucursal");
        }
        return true;

    }
    
    public int obtenerSucursalMayorVentas() throws EmptyException, PositionException {
        int mayorSucursal = -1;
        double mayorVenta = 0.0;

        for (int i = 0; i < sucursales.getSize(); i++) {
            double totalVentasSucursal = 0.0;
            for (int j = 0; j < sucursales.get(i).getVenta().getSize(); j++) {
                totalVentasSucursal += sucursales.get(i).getVenta().get(j).getValor();
            }

            if (totalVentasSucursal > mayorVenta) {
                mayorVenta = totalVentasSucursal;
                mayorSucursal = i;
            }
        }

        if (mayorSucursal == -1) {
            throw new EmptyException("No se encontraron sucursales registradas.");
        }

        return mayorSucursal;
    }

    public EnumMes obtenerMesMenoresVentas() throws EmptyException, PositionException {
        double[] totalVentasPorMes = new double[EnumMes.values().length];

        for (int i = 0; i < totalVentasPorMes.length; i++) {
            totalVentasPorMes[i] = 0.0;
        }

        for (int i = 0; i < sucursales.getSize(); i++) {
            for (int j = 0; j < sucursales.get(i).getVenta().getSize(); j++) {
                EnumMes mes = sucursales.get(i).getVenta().get(j).getMes();
                double valorVenta = sucursales.get(i).getVenta().get(j).getValor();
                totalVentasPorMes[mes.ordinal()] += valorVenta;
            }
        }

        EnumMes mesMenoresVentas = null;
        double menorVenta = Double.MAX_VALUE;

        for (EnumMes mes : EnumMes.values()) {
            double totalVentasMes = totalVentasPorMes[mes.ordinal()];
            if (totalVentasMes < menorVenta) {
                menorVenta = totalVentasMes;
                mesMenoresVentas = mes;
            }
        }

        if (mesMenoresVentas == null) {
            throw new EmptyException("No se encontraron ventas registradas.");
        }

        return mesMenoresVentas;
    }
}
