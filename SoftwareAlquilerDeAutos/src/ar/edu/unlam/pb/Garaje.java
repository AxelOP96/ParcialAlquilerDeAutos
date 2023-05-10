package ar.edu.unlam.pb;

import java.util.HashSet;

public class Garaje {

	private Integer id;
	private String direccion;
	private Integer espaciosDisponibles;

	public Garaje(Integer id, String direccion, Integer espaciosDisponibles, HashSet<Auto> autosDisponibles) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.direccion = direccion;
		this.espaciosDisponibles = espaciosDisponibles;
	}

}
