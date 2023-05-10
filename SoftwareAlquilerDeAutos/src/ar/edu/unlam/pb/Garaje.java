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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEspaciosDisponibles() {
		return espaciosDisponibles;
	}

	public void setEspaciosDisponibles(Integer espaciosDisponibles) {
		this.espaciosDisponibles = espaciosDisponibles;
	}

}
