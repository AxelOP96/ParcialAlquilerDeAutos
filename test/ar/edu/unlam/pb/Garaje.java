package ar.edu.unlam.pb;

import java.util.ArrayList;

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

	public void agregarAuto(Auto auto) {
		if (tieneEspaciosDisponibles()) {
			this.autosEnElGaraje.add(auto);
			this.espaciosDisponibles--;
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
}
