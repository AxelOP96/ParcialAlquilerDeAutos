package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class TestAgencia {

	@Test
	public void queSePuedaIncluirUnGarajeAUnaAgencia() {
		String razonSocial = "SA";
		Integer cuit = 19919919;
		HashSet <Auto> autosDisponibles= new HashSet<>();
		HashSet <Garaje> garajesDisponibles = new HashSet<>();
		
		Integer id = 000001;
		String direccion = "CALLE FALSA 123";
		Integer espaciosDisponibles = 100;
		
		Agencia agencia = new Agencia(razonSocial, cuit, garajesDisponibles);
		Garaje garaje = new Garaje(id, direccion, espaciosDisponibles, autosDisponibles);
		agencia.agregarGaraje(garaje);
		assertNotNull(agencia.getGarajesDisponibles());
	}

	@Test
	public void queSePuedaIncluirUnClienteAUnaAgencia() {
		String razonSocial = "SA";
		Integer cuit = 19919919;
		HashSet <Auto> autosDisponibles= new HashSet<>();
		HashSet <Garaje> garajesDisponibles = new HashSet<>();
		
		Integer dni = 000001;
		String direccion = "CALLE FALSA 123";
		String nombreYApellido = "Juan Peres";
		Integer telefono = 1122332233;
		
		Integer comparador = 1;
		
		Agencia agencia = new Agencia(razonSocial, cuit, garajesDisponibles);
		Cliente cliente = new Cliente(dni, direccion, nombreYApellido, telefono);
		agencia.agregarCliente(cliente);
		assertEquals(agencia.getListaDeClientes().size(), 1);
	}
}
