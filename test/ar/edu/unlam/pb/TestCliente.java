package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import ar.edu.unlam.pb.Auto.AutoDeportivo;

public class TestCliente {

	@Test
	public void queUnClienteNuevoNoPuedaSerVip() {
		Integer dni = 000001;
		String direccion = "CALLE FALSA 123";
		String nombreYApellido = "Juan Peres";
		Integer telefono = 1122332233;
		Cliente cliente = new Cliente(dni, direccion, nombreYApellido, telefono);
		
		Integer idReserva = 11111111;
		String modelo = "Fiesta";
		String marca =  "Ford";
		
		Auto auto = new Auto("ABS 123", marca, modelo,350.5);
		Reserva reserva1 = new Reserva(idReserva, cliente, auto, 15);
		cliente.agregarReserva(reserva1);
		Reserva reserva2 = new Reserva(idReserva, cliente, auto, 15);
		cliente.agregarReserva(reserva2);
		boolean logroSerVIP = cliente.serVip();
		assertFalse(logroSerVIP);
	}
	@Test
	public void queUnClientePuedaSerVipHaciendo3Reservas() {
		Integer dni = 000001;
		String direccion = "CALLE FALSA 123";
		String nombreYApellido = "Juan Peres";
		Integer telefono = 1122332233;
		Cliente cliente = new Cliente(dni, direccion, nombreYApellido, telefono);
		
		Integer idReserva = 11111111;
		String modelo = "Fiesta";
		String marca =  "Ford";
		Auto auto = new Auto("ABS 123", marca, modelo,350.5);
		Reserva reserva1 = new Reserva(idReserva, cliente, auto, 40);
		cliente.agregarReserva(reserva1);
		Reserva reserva2 = new Reserva(idReserva, cliente, auto, 50);
		cliente.agregarReserva(reserva2);
		Reserva reserva3 = new Reserva(idReserva, cliente , auto, 30);
		cliente.agregarReserva(reserva3);
		boolean logroSerVIP = cliente.serVip();
		assertTrue(logroSerVIP);
	}
	
	@Test
	public void queUnClientePuedaEliminarUnaReserva() {
		Integer dni = 000001;
		String direccion = "CALLE FALSA 123";
		String nombreYApellido = "Juan Peres";
		Integer telefono = 1122332233;
		Cliente cliente = new Cliente(dni, direccion, nombreYApellido, telefono);
		
		Integer idReserva = 11111111;
		String modelo = "Fiesta";
		String marca =  "Ford";
		Auto auto = new Auto("ABS 123", marca, modelo,350.5);
		Reserva reserva1 = new Reserva(idReserva, cliente, auto, 20);
		cliente.eliminarReserva(reserva1);
		Reserva reserva2 = new Reserva(idReserva, cliente, auto, 20);
		cliente.eliminarReserva(reserva2);
		assertEquals(cliente.getHistorial().size(), 0);
	}
	
	@Test
	public void queUnClientePuedaReservarUnAutoDeportivo() {
		String razonSocial = "SA";
		Integer cuit = 19919919;
		ArrayList <Alquiler> alquileres= new ArrayList<>();
		ArrayList<Auto> autosEnElGaraje = new ArrayList<>();
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
		
		//AutoDeportivo auto = new AutoDeportivo("ABS 123", marca, modelo,2010, 350.5, garaje, alquileres, precioPorDia, 500, true);
		//String patente, String marca, String modelo, int anio, double precio, Garaje garaje, 
		//ArrayList<Alquiler> alquileres, double precioPorDia, int caballosDeFuerza, boolean turbo
		//Reserva reserva1 = new Reserva(idReserva, cliente, auto, 20);
	}

}
