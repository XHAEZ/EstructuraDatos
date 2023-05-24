/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import model.Sucursal;

/**
 *
 * @author danny
 */
public class Utilities {
    public static void imprimir(Object [] objs){
        System.out.println("Lista de "+ objs.getClass().getSimpleName());
        for (Object o : objs) {
            System.out.println(o.toString());
        }
    }
    
    public static Double sumarVentas(Sucursal s) throws EmptyException, PositionException{
       if (s.getVenta() != null) {
            Double ventas = 0.0 ;
            for (int i = 0; i < s.getVenta().getSize(); i++) {
                ventas=s.getVenta().get(i).getValor()+ventas;
            }
            return ventas;
        }
        return 0.0;
    }
    
    public static Double mediaVentas(Sucursal s) throws EmptyException, PositionException{
        Double suma = sumarVentas(s) ;
            if (suma == 0 ) {
                return suma;
            }else 
            return suma / (s.getVenta().getSize());
    }
    
    
}
