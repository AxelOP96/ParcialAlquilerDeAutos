package ar.edu.unlam.pb;


public class Reserva {
	private Integer codReserva;
	private Cliente cliente;
	private Auto auto;
	private Integer dias;
	private Double precioTotal;
	
	public Reserva(Integer codReserva, Cliente cliente, Auto auto,Integer dias) {
		this.codReserva = codReserva;
		this.cliente = cliente;
		this.auto = auto;
		this.dias = dias;
		
		if( (auto.getPrecioPorDia()*dias)  >100000.0 && cliente.getEsVip()==false) {
			cliente.setEsVip(true);
			this.precioTotal = auto.getPrecioPorDia()*dias;
		}
		else if(cliente.getEsVip()==true){
			this.precioTotal = auto.getPrecioPorDia()*dias*0.9;
		}
		else {
			this.precioTotal = auto.getPrecioPorDia()*dias;
		}
	}			
		
		

	public Integer getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(Integer codReserva) {
		this.codReserva = codReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Double getPrecioTotal() {
		return this.precioTotal;
	}

	
	
	
	
}
