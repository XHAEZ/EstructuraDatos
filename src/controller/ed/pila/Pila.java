/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ed.pila;

import controller.ed.cola.exception.TopeException;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;


/**
 *
 * @author cobos
 */
public class Pila <E>{
    private PilaI <E> pilaI;

    public Pila(Integer cima) {
        pilaI = new PilaI<>(cima);
    }
    
    public void push(E obj) throws TopeException{
        pilaI.push(obj);
    }
    
    public E pop() throws EmptyException, PositionException{
        return pilaI.pop();
    }
    
    public Integer getCima(){
        return pilaI.getCima();
    }
    
    public void print() throws EmptyException{
        pilaI.imprimir();
    }
}
