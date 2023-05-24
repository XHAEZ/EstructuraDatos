/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.temporal.Temporal;

/**
 *
 * @author cobos
 */
public class Peticion {

    private String usuario;
    private String peticion;
    private LocalDate fecha;

    public Peticion(String usuario, String peticion) {
        this.usuario = usuario;
        this.peticion = peticion;
    }

    public Peticion() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getPeticion() {
        return peticion;
    }

    public void setPeticion(String peticion) {
        this.peticion = peticion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Peticion{" + "Usuario=" + usuario + ", peticion=" + peticion + '}';
    }

}
