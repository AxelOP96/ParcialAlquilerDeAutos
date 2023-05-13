package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import ar.edu.unlam.pb.Auto.AutoDeportivo;

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
	public void queNoSePuedaIncluirUnClienteSinDatosAUnaAgencia() {
		String razonSocial = "SA";
		Integer cuit = 19919919;
		HashSet <Auto> autosDisponibles= new HashSet<>();
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		
		Agencia agencia = new Agencia(razonSocial, cuit, garajesDisponibles);
		Cliente cliente = null;
		agencia.agregarCliente(cliente);
		assertEquals(agencia.getClientes().size(), 0);
		
	    

	}
	
	@Test
	public void queSePuedaIncluirUnAutoDeportivoAUnaAgencia() {
		String razonSocial = "SA";
		Integer cuit = 19919919;
		ArrayList <Alquiler> alquileres= new ArrayList<>();
		ArrayList<Auto> autosEnElGaraje = new ArrayList<>();
		ArrayList<Garaje> garajesDisponibles = new ArrayList<>();
		Garaje garaje = new Garaje(1, "Calle 123", 5, autosEnElGaraje );
		
		Integer dni = 000001;
		String direccion = "CALLE FALSA 123";
		String nombreYApellido = "Juan Peres";
		Integer telefono = 1122332233;
		Cliente cliente = new Cliente(dni, direccion, nombreYApellido, telefono);
		
		Integer idReserva = 11111111;
		String modelo = "Fiesta";
		String marca =  "Ford";
		Double precioPorDia = 500.5;
		Integer dias = 20;
		Auto auto = new Auto("ABS 123", marca, modelo,350.5, garaje); 
		AutoDeportivo deportivo = auto.new AutoDeportivo("ABC 123", marca, modelo, 2023, 600.5, garaje, alquileres, precioPorDia, 800, false);
		
		Agencia agencia = new Agencia(razonSocial, cuit, garajesDisponibles);
		agencia.registrarUnAuto(deportivo, garaje);
		assertNotNull(agencia.buscarAutoPorPatente("ABC 123"));
	}
	
	
	
}
