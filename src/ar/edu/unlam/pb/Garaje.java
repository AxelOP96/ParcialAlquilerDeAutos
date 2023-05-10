package ar.edu.unlam.pb;

import java.util.*;

public class Garaje {

	private Integer idGaraje;
	private Integer espaciosDisponibles;
	private String direccion;
	private ArrayList<Auto> autosEnElGaraje;

	public Garaje(Integer idGaraje, String direccion, Integer espaciosDisponibles) {
	    this.idGaraje = idGaraje;
	    this.direccion = direccion;
	    this.espaciosDisponibles = espaciosDisponibles;
	    this.autosEnElGaraje = new ArrayList<Auto>();
	}

	
	
	public boolean agregarAuto(Auto auto) {
		if (espaciosDisponibles > 0) {
			this.autosEnElGaraje.add(auto);
			auto.setGaraje(this); //Se agrega este auto en el garaje actual
			espaciosDisponibles--;
			return true;			//Si se agrego
		} else {
			return false;		//no se agrego
		}
	}

	public boolean estaAutoEnGaraje(Auto auto) {
		return this.autosEnElGaraje.contains(auto);
	}

	public void quitarAuto(Auto auto) {
		if (estaAutoEnGaraje(auto)) {
			this.autosEnElGaraje.remove(auto);
			this.espaciosDisponibles++;
		}
	}

	public boolean tieneEspaciosDisponibles() {
		return this.espaciosDisponibles > 0;
	}

	public Auto buscarAuto(String patente) {
		for (Auto auto : this.autosEnElGaraje) {
			if (auto.getPatente().equals(patente)) {
				return auto;
			}
		}
		return null;
	}

	public ArrayList<Auto> getAutosEnElGaraje() {
		return this.autosEnElGaraje;
	}

	public Object getDireccion() {
		 return this.direccion;
	}



	public void disminuirCantidadEspaciosDisponibles() {
		this.espaciosDisponibles--;
	}
}
