package ar.edu.unlam.pb;

import java.util.ArrayList;

public class Cliente {

	private Integer dni;
	private String direccion;
	private String nombreYApellido;
	private Integer telefono;
	private boolean esVip;
	private ArrayList<Reserva> historial = new ArrayList<>();

	

	public Cliente(Integer dni, String direccion, String nombreYApellido, Integer telefono) {
		// TODO Auto-generated constructor stub
		this.dni = dni;
		this.direccion = direccion;
		this.nombreYApellido = nombreYApellido;
		this.telefono = telefono;
		this.esVip = false;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	public ArrayList<Reserva> getHistorial() {
		return historial;
	}

	public void agregarReserva(Reserva reserva) {
		this.historial.add(reserva);
	}
	
	public void eliminarReserva(Reserva reserva) {
		this.historial.remove(reserva);
	}
	
	public void setHistorial(ArrayList<Reserva> historial) {
		this.historial = historial;
	}
	public boolean isEsVip() {
		return esVip;
	}

	public void setEsVip(boolean esVip) {
		this.esVip = esVip;
	}

	public boolean serVip() {
		// TODO Auto-generated method stub
		boolean vip = false;
		if(historial.size()>2) {
			vip = true;
		}
		return vip;
	}

}
