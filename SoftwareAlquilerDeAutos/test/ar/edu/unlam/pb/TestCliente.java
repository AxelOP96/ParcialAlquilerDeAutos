package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCliente {

	@Test
	public void queUnClientePuedaSerVip() {
		Integer dni = 000001;
		String direccion = "CALLE FALSA 123";
		String nombreYApellido = "Juan Peres";
		Integer telefono = 1122332233;
		Cliente cliente = new Cliente(dni, direccion, nombreYApellido, telefono);
		
		
		//Reserva reserva1 = new Reserva();
		//Reserva reserva2 = new Reserva();
		//cliente.
		//assertTrue();
	}

}
