/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.ed.listaEnlazada;

import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;

/**
 *
 * @author danny
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size = 0;

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return cabecera == null;
    }

    public void insertar(E info) {
        NodoLista<E> nuevo = new NodoLista<>(null, info);
        if (isEmpty()) {
            this.cabecera = nuevo;
            this.size++;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            this.size++;
//            for (int i = 0; i < size()-1; i++) {
//                System.out.println(aux.getInfo());
//                aux = aux.getSig();
//            }
//            aux.setSig(nuevo);
        }
    }

    public void insertarInicio(E info) {
        if (isEmpty()) {
            insertar(info);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(null, info);
            nuevo.setSig(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

    public void insertarPosicion(E info, Integer pos) throws PositionException {
        if (isEmpty()) {
            insertar(info);
        } else if (pos >= 0 && pos < size() && pos == 0) {
            insertarInicio(info);
        } else if (pos >= 0 && pos < size()) {
            NodoLista<E> aux = cabecera;
            NodoLista<E> nuevo = new NodoLista<>(null, info);
            for (int i = 0; i < (pos - 1); i++) {
                aux = aux.getSig();
            }
            NodoLista<E> sig = aux.getSig();
            aux.setSig(nuevo);
            nuevo.setSig(sig);
            size++;
        } else {
            throw new PositionException();
        }

    }

    public E get(Integer pos) throws EmptyException, PositionException {
        if (isEmpty()) {
            throw new EmptyException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSig();
                    }
                    dato = aux.getInfo();
                }
            }else{
                throw new PositionException();
            }
            return dato;
        }
    }
     public E delete(Integer pos) throws EmptyException, PositionException {
        if (isEmpty()) {
            throw new EmptyException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                    cabecera = cabecera.getSig();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < (pos-1); i++) {
                        aux = aux.getSig();
                    }
//                    if ((pos + 1) == size) {
                        NodoLista<E> aux1 = aux.getSig();
                        dato = aux1.getInfo();
//                    }else{
//                        dato = aux.getInfo();
//
//                    }
                    NodoLista<E> proximo = aux.getSig();
                    aux.setSig(proximo.getSig());
                    size--;
                }
            }else{
                throw new PositionException();
            }
            return dato;
        }
    }
     
     public void deleteAll(){
         this.cabecera = null;
     }
    public Integer size() {
        return size;
    }

    public void imprimir() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        } else {
            NodoLista<E> aux = cabecera;
            System.out.println("-------Lista-------");
            for (int i = 0; i < size(); i++) {
                System.out.println(aux.getInfo());
                aux = aux.getSig();
            }
            System.out.println("-------Lista Fin-------");
        }
    }
    
     public int getUltimaPosicionOcupada() {
        int posicion = 0;
        if (!isEmpty()) {
            NodoLista<E> aux = cabecera;
            posicion += 1;
            while (aux.getSig() != null) {
                posicion += 1;
                aux = aux.getSig();
            }
        }   
        return posicion;
    }
}
