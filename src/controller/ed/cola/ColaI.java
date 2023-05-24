/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ed.cola;

import controller.ed.cola.exception.TopeException;
import controller.ed.listaEnlazada.ListaEnlazada;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;

/**
 *
 * @author cobos
 */
public class ColaI<E> extends ListaEnlazada<E> {

    private Integer tope;

    public ColaI(Integer tope) {
        this.tope = tope;
    }

    public Boolean isFull() {
        return (size() >= tope);
    }

    public void queue(E dato) throws TopeException {
        if (isFull()) {
            throw new TopeException("Cola sin espacio");
        } else {
            this.insertar(dato);
        }
    }

    public E dequeue() throws EmptyException, PositionException {
        E dato = null;
        if (isEmpty()) {
            throw new EmptyException("Cola vacia");
        } else {
            return this.delete(0);
        }
    }

    public E peek() throws EmptyException, PositionException {
        if (isEmpty()) {
            throw new EmptyException("Cola vacía");
        } else {
            return get(0);
        }
    }

    public Integer getTope() {
        return tope;
    }

}
