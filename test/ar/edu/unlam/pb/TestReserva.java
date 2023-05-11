package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReserva {

	@Test
	public void queSeSepaElValorFinalDeUnAutoDe10MilPorDiaReservadoPor5Dias() {

		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		Agencia ag = new Agencia(razonSocial, cuit);

		Integer idGaraje = 1;
		String direccion = "Av. Victoria 123";
		Integer espaciosDisponibles = 10;
		Garaje garaje1 = new Garaje(idGaraje, direccion, espaciosDisponibles);

		String patente = "USD 660";
		String marca = "Renauld kwid";
		String modelo = "Climber";
		Double precioPorDia = 5000.0;
		Auto auto1 = new Auto(patente, marca, modelo, precioPorDia);
		Auto auto2 = new Auto("USY 550", "Chevrolet","Camaro", 8000.0);
		Auto auto3 = new Auto("USS 770", "Chevrolet", "Equinox", 10000.0);
		Auto auto4 = new Auto("BUS 850", "Chevrolet","Camaro", 8000.0);
		Auto auto5 = new Auto("CAR 970", "Chevrolet", "Equinox", 10000.0);
		
		Integer dni = 34535345; 
		String apellidoNombre = "Elon Musk";
		String direccionC = "Av Libertadores 1234";
		Integer telefono = 462415441;
		Cliente cliente1 = new Cliente(dni, apellidoNombre, direccionC, telefono);
		
		// Acciones
		ag.registrarUnGaraje(garaje1);
		
		ag.registrarUnAuto(auto1, garaje1);
		ag.registrarUnAuto(auto2, garaje1);
		ag.registrarUnAuto(auto3, garaje1);
		ag.registrarUnAuto(auto4, garaje1);
		ag.registrarUnAuto(auto5, garaje1);
		
		
		Integer codReserva = 1;
		Integer diasAlquiler = 5;
		Reserva reserva1 = ag.alquilarAuto(codReserva, cliente1, auto5, diasAlquiler);
		
		final Double PRECIO_TOTAL_RESERVA_ESPERADO = 10000.0*5;
		final Double PRECIO_TOTAL_RESERVA = reserva1.getPrecioTotal();
		
		
		// Validaciones

		assertEquals(PRECIO_TOTAL_RESERVA_ESPERADO, PRECIO_TOTAL_RESERVA);
	}
	
	@Test
	public void queCuandoUnClienteHagaUnaReservaDeMasDe100MilEstePaseASerClienteVip() {


		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		Agencia ag = new Agencia(razonSocial, cuit);

		Integer idGaraje = 1;
		String direccion = "Av. Victoria 123";
		Integer espaciosDisponibles = 10;
		Garaje garaje1 = new Garaje(idGaraje, direccion, espaciosDisponibles);

		String patente = "USD 660";
		String marca = "Renauld kwid";
		String modelo = "Climber";
		Double precioPorDia = 5000.0;
		Auto auto1 = new Auto(patente, marca, modelo, precioPorDia);
		Auto auto2 = new Auto("USY 550", "Chevrolet","Camaro", 8000.0);
		Auto auto3 = new Auto("USS 770", "Chevrolet", "Equinox", 10000.0);
		Auto auto4 = new Auto("BUS 850", "Chevrolet","Camaro", 8000.0);
		Auto auto5 = new Auto("CAR 970", "Chevrolet", "Equinox", 10000.0);
		
		Integer dni = 34535345; 
		String apellidoNombre = "Elon Musk";
		String direccionC = "Av Libertadores 1234";
		Integer telefono = 462415441;
		Cliente cliente1 = new Cliente(dni, apellidoNombre, direccionC, telefono);
		
		// Acciones
		ag.registrarUnGaraje(garaje1);
		
		ag.registrarUnAuto(auto1, garaje1);
		ag.registrarUnAuto(auto2, garaje1);
		ag.registrarUnAuto(auto3, garaje1);
		ag.registrarUnAuto(auto4, garaje1);
		ag.registrarUnAuto(auto5, garaje1);
		
		
		Integer codReserva = 1;
		Integer diasAlquiler = 12;
		Reserva reserva1 = ag.alquilarAuto(codReserva, cliente1, auto5, diasAlquiler);
		
		final Double PRECIO_TOTAL_RESERVA_ESPERADO = 10000.0*12;
		final Double PRECIO_TOTAL_RESERVA = reserva1.getPrecioTotal();
		

		// Validaciones

		assertEquals(PRECIO_TOTAL_RESERVA_ESPERADO, PRECIO_TOTAL_RESERVA);
		assertTrue(cliente1.getEsVip());
		
	}
	
	@Test
	public void queALosCLientesVipSeLeHaganUnDescuentoDel10PorCientoEnSusReservasSiguientes() {


		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		Agencia ag = new Agencia(razonSocial, cuit);

		Integer idGaraje = 1;
		String direccion = "Av. Victoria 123";
		Integer espaciosDisponibles = 10;
		Garaje garaje1 = new Garaje(idGaraje, direccion, espaciosDisponibles);

		String patente = "USD 660";
		String marca = "Renauld kwid";
		String modelo = "Climber";
		Double precioPorDia = 5000.0;
		Auto auto1 = new Auto(patente, marca, modelo, precioPorDia);
		Auto auto2 = new Auto("USY 550", "Chevrolet","Camaro", 8000.0);
		Auto auto3 = new Auto("USS 770", "Chevrolet", "Equinox", 10000.0);
		Auto auto4 = new Auto("BUS 850", "Chevrolet","Camaro", 8000.0);
		Auto auto5 = new Auto("CAR 970", "Chevrolet", "Equinox", 10000.0);
		
		Integer dni = 34535345; 
		String apellidoNombre = "Elon Musk";
		String direccionC = "Av Libertadores 1234";
		Integer telefono = 462415441;
		Cliente cliente1 = new Cliente(dni, apellidoNombre, direccionC, telefono);
		
		// Acciones
		ag.registrarUnGaraje(garaje1);
		
		ag.registrarUnAuto(auto1, garaje1);
		ag.registrarUnAuto(auto2, garaje1);
		ag.registrarUnAuto(auto3, garaje1);
		ag.registrarUnAuto(auto4, garaje1);
		ag.registrarUnAuto(auto5, garaje1);
		
		
		Integer codReserva = 1;
		Integer diasAlquiler = 12;
		Reserva reserva1 = ag.alquilarAuto(codReserva, cliente1, auto5, diasAlquiler);
		
		Reserva segundaReserva = ag.alquilarAuto(2, cliente1, auto3, 10);
		
		final Double PRECIO_TOTAL_RESERVA_ESPERADO = 10000.0*10*0.9;
		final Double PRECIO_TOTAL_RESERVA = segundaReserva.getPrecioTotal();

		// Validaciones

		assertTrue(cliente1.getEsVip());
		assertEquals(PRECIO_TOTAL_RESERVA_ESPERADO, PRECIO_TOTAL_RESERVA);
		
	}
	
	
	
	
	
	
	
	
}

//queCuandoUnClienteHagaUnaReservaDeMasDe100MilEstePaseASerClienteVip()
//queALosCLientesVipSeLeHaganUnDescuentoDel10PorCientoEnSusReservasSiguientes()

