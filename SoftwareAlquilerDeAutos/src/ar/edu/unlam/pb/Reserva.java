package ar.edu.unlam.pb;

public class Reserva {

	private Integer idReserva;
	private String modelo;
	private String marca;
	private String nombraYApellido;

	public Reserva(Integer idReserva, String modelo, String marca, String nombreYApellido) {
		// TODO Auto-generated constructor stub
		this.idReserva = idReserva;
		this.modelo = modelo;
		this.marca = marca;
		this.nombraYApellido = nombreYApellido;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombraYApellido() {
		return nombraYApellido;
	}

	public void setNombraYApellido(String nombraYApellido) {
		this.nombraYApellido = nombraYApellido;
	}
	
	

}
