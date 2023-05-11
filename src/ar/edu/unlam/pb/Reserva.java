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
	

	public String toString() {
		return "["+ "Cod="+this.codReserva + "Modelo="+this.auto.getModelo()+"]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codReserva == null) ? 0 : codReserva.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (codReserva == null) {
			if (other.codReserva != null)
				return false;
		} else if (!codReserva.equals(other.codReserva))
			return false;
		return true;
	}



	
	
	
	
	
	
}
