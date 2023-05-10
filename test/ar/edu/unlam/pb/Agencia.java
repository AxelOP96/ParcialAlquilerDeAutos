package ar.edu.unlam.pb;

import java.util.ArrayList;

public class Agencia {
    private String nombre;
    private ArrayList<Garaje> garajes;

    public Agencia(String nombre) {
        this.nombre = nombre;
        this.garajes = new ArrayList<Garaje>();
    }

    public boolean agregarGaraje(Garaje garaje) {
        if (garajeConMismaDireccion(garaje)) {
            return false;
        }
        return garajes.add(garaje);
    }

    public boolean garajeConMismaDireccion(Garaje garaje) {
        for (Garaje g : garajes) {
            if (g.getDireccion().equals(garaje.getDireccion())) {
                return true;
            }
        }
        return false;
    }
    }