/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ed.pila;

import controller.ed.cola.exception.TopeException;
import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;


/**
 *
 * @author cobos
 */
public class PilaI<E> extends ListaEnlazada<E> {

    private Integer cima;

    public PilaI(Integer cima) {
        this.cima = cima;
    }

    public Boolean isFull() {
        return size() > cima;
    }

    public void push(E info) throws TopeException {
        if (!isFull()) {
            insertarInicio(info);
        } else {
            throw new TopeException();
        }
    }

    public E pop() throws EmptyException, PositionException {
        E dato = null;
        if (isEmpty()) {
            throw new EmptyException("Pila Vacia");
        } else {
            return this.delete(0);
        }
    }

    public Integer getCima() {
        return cima;
    }

}
