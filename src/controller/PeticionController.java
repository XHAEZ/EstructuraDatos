/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ed.cola.ColaI;
import controller.ed.cola.exception.TopeException;
import controller.ed.listaEnlazada.exception.EmptyException;
import controller.ed.listaEnlazada.exception.PositionException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import model.Peticion;

/**
 *
 * @author cobos
 */
public class PeticionController {

    public static final transient String NOMBRE_ARCHIVO = "peticiones";
    private ColaI<Peticion> peticiones;

    public PeticionController() {
        this.peticiones = new ColaI<>(20);
    }

    public ColaI<Peticion> getPeticion() {
        if (peticiones == null) {
            peticiones = new ColaI<>(20);
        }
        return peticiones;
    }

    public ColaI<Peticion> getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(ColaI<Peticion> peticiones) {
        this.peticiones = peticiones;
    }

    public void agregarPeticiones(String usuario, String peticion) throws TopeException, EmptyException {
        Peticion nuevaPeticion = new Peticion(usuario, peticion);
        peticiones.queue(nuevaPeticion);
    }

    public void borrarElementoAntiguo() throws EmptyException, PositionException, TopeException {
        LocalDateTime horaActual = LocalDateTime.now();

        while (!peticiones.isEmpty()) {
            Peticion elemento = peticiones.dequeue();
            LocalDateTime horaCreacion = elemento.getFecha().atTime(LocalTime.MIN);
            long minutosPasados = ChronoUnit.MINUTES.between(horaCreacion, horaActual);
            long minutosEnUnaHora = 60;
            if (minutosPasados >= minutosEnUnaHora) {
                continue; 
            } else {
                peticiones.queue(elemento); 
                break;
            }
        }
    }

}
