/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ed.listaEnlazada.ListaEnlazada;

/**
 *
 * @author danny
 */
public class Sucursal {

    private Integer id;
    private String nombre;
    private ListaEnlazada <Venta> ventas;

    public Sucursal(String nombre) {
        this.nombre = nombre;
    }

    public ListaEnlazada<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ListaEnlazada<Venta> ventas) {
        this.ventas = ventas;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
