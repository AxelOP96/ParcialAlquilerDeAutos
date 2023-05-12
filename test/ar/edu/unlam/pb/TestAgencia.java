package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class TestAgencia {

	@Test
	public void queSePuedaIncluirUnGarajeAUnaAgencia() {
	    String razonSocial = "SA";
	    Integer cuit = 19919919;
	    ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
	    
	    Integer id = 000001;
	    String direccion = "CALLE FALSA 123";
	    Integer espaciosDisponibles = 100;
	    
	    Agencia agencia = new Agencia(razonSocial, cuit, garajesDisponibles);
	    Garaje garaje = new Garaje(id, direccion, espaciosDisponibles, new ArrayList<Auto>());
	    agencia.agregarGaraje(garaje);
	    assertEquals(agencia.getGarajes().size(), 1);
	}

	@Test
	public void queSePuedaIncluirUnClienteAUnaAgencia() {
		String razonSocial = "SA";
		Integer cuit = 19919919;
		HashSet <Auto> autosDisponibles= new HashSet<>();
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		
		Integer dni = 000001;
		String direccion = "CALLE FALSA 123";
		String nombreYApellido = "Juan Peres";
		Integer telefono = 1122332233;
		
		Integer comparador = 1;
		
		Agencia agencia = new Agencia(razonSocial, cuit, garajesDisponibles);
		Cliente cliente = new Cliente(dni, direccion, nombreYApellido, telefono);
		agencia.agregarCliente(cliente);
		assertEquals(agencia.getClientes().size(), 1);
		
	    

	}
	
	@Test
	public void queSePuedaIncluirUnAutoDeportivoAUnaAgencia() {
		
	}
	
	
	
}
