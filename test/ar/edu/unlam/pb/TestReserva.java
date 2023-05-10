package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.sistemaAlquilerAutos.Agencia;
import ar.edu.unlam.pb2.sistemaAlquilerAutos.Auto;
import ar.edu.unlam.pb2.sistemaAlquilerAutos.Cliente;
import ar.edu.unlam.pb2.sistemaAlquilerAutos.Garaje;
import ar.edu.unlam.pb2.sistemaAlquilerAutos.Reserva;

public class TestReserva {

	@Test
	public void queSePuedaCrearUnaReservaEnAgencia() {
		
	}

	
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
}

//queSePuedaCrearUnaReservaEnAgencia()
//queSeSepaElValorFinalDeUnAutoDe10MilPorDiaReservadoPor5Dias()
//queCuandoUnClienteHagaUnaReservaDeMasDe100MilEstePaseASerClienteVip()
//queALosCLientesVipSeLeHaganUnDescuentoDel10PorCientoEnSusReservasSiguientes()

