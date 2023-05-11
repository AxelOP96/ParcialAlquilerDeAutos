package ar.edu.unlam.pb;

import java.util.ArrayList;

public class Cliente {
	private Integer dni; 
	private String apellidoNombre;
	private String direccion;
	private Integer telefono;
	private Boolean esVip;
	private ArrayList<Reserva> historial = new ArrayList<>();
	
	public Cliente(Integer dni, String apellidoNombre, String direccion, Integer telefono) {
		this.dni = dni;
		this.apellidoNombre = apellidoNombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.esVip = false;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellidoNombre() {
		return apellidoNombre;
	}

	public void setApellidoNombre(String apellidoNombre) {
		this.apellidoNombre = apellidoNombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono =telefono ;
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
	public Boolean getEsVip() {
		return esVip;
	}

	public void setEsVip(Boolean esVip) {
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
