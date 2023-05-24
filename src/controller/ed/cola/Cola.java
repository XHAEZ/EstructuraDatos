/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ed.cola;

import controller.ed.cola.exception.TopeException;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;


/**
 *
 * @author cobos
 */
public class Cola<E> {

    private ColaI<E> cola;

    public Cola(Integer tope) {
        cola = new ColaI(tope);
    }

    public void queue(E obj) throws TopeException {
        cola.queue(obj);
    }

    public E dequeue() throws EmptyException, PositionException {
        return cola.dequeue();
    }
    
    public Integer getTope(){
        return cola.getTope();
    }
    
    public void print() throws EmptyException{
        cola.imprimir();
    }
}
