/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SucursalController;
import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import controller.util.Utilities;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sucursal;

/**
 *
 * @author danny
 */
public class Main {

    public static void main(String[] args) {
//        SucursalController sc = new SucursalController();
//        try {
//            sc.getSucursal().setId(1);
//            sc.getSucursal().setNombre("Alberto");
//            sc.registrar();
//            sc.guardarVentas(1, 20.00);
//            Utilities.imprimir(sc.getSucursal().getVentas());
//            sc.setSucursal(null);
//            sc.getSucursal().setId(2);
//            sc.getSucursal().setNombre("Paul");
//            sc.registrar();
//            sc.setSucursal(null);
//            sc.getSucursal().setId(3);
//            sc.getSucursal().setNombre("Marylin");
//            sc.registrar();
//            sc.setSucursal(null);
//            sc.getSucursal().setId(4);
//            sc.getSucursal().setNombre("Jose");
//            sc.registrar();
//            sc.setSucursal(null);
//            Utilities.imprimir(sc.getSucursales());
//        } catch (Exception e) {
//            System.out.println("Error " + e.getMessage());
//        }
        ListaEnlazada<Sucursal> lista = new ListaEnlazada<>();
        try {
            Sucursal s1 = new Sucursal();
            s1.setId(lista.size() + 1);
            s1.setNombre("Alyce");
            lista.insertar(s1);
            lista.imprimir();
            s1 = new Sucursal();
            s1.setId(lista.size() + 1);
            s1.setNombre("Marylin");
            lista.insertar(s1);
            lista.insertarPosicion(s1, 0);
            lista.imprimir();
//                        listda.insertarPosicion(s1, 1);
//                        lista.imprimir();   
        } catch (EmptyException ex) {
            System.out.println(ex.getMessage());
        
        } catch (PositionException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
