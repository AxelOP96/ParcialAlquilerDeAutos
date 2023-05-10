package ar.edu.unlam.pb;

public class Cliente {

	private Integer dni;
	private String direccion;
	private String nombreYApellido;
	private Integer telefono;
	private boolean esVip;

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

	public boolean isEsVip() {
		return esVip;
	}

	public void setEsVip(boolean esVip) {
		this.esVip = esVip;
	}

}
