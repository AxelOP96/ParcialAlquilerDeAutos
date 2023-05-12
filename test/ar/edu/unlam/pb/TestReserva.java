package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TestReserva {

	
	@Test
	public void queCuandoSeAlquilenDosAutosSeDisminuyaLosAutosDisponibles() {



		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);

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
	
		final Integer AUTOS_DISPONIBLES_INICIAL = ag.cantidaDeAutosDisponibles();
		
		
		Integer codReserva = 1;
		Integer diasAlquiler = 5;
		Reserva reserva1 = ag.alquilarAuto(codReserva, cliente1, auto5, diasAlquiler);
		
		final Integer AUTOS_DISPONIBLES_DESPUES_DE_LA_RESERVA = ag.cantidaDeAutosDisponibles();
		
		// Validaciones
		assertEquals((Integer)5, AUTOS_DISPONIBLES_INICIAL);
		assertEquals((Integer)4,AUTOS_DISPONIBLES_DESPUES_DE_LA_RESERVA);
	}

	@Test
	public void queSePuedaDevolverUnAutoALaAgencia() {



		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);

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
	
		final Integer AUTOS_DISPONIBLES_INICIAL = ag.cantidaDeAutosDisponibles();
		
		Integer codReserva = 1;
		Integer diasAlquiler = 5;
		Reserva reserva1 = ag.alquilarAuto(codReserva, cliente1, auto5, diasAlquiler);
		
		final Integer AUTOS_DISPONIBLES_DESPUES_DE_LA_RESERVA = ag.cantidaDeAutosDisponibles();
		
		final Boolean AUTO_DEBUELTO = ag.recibirAutoQueSeAlquilo(auto5);
		final Integer AUTOS_DISPONIBLES_DESPUES_DE_LA_DEVOLUCION = ag.cantidaDeAutosDisponibles();
		
		// Validaciones
		assertEquals((Integer)5, AUTOS_DISPONIBLES_INICIAL);
		assertEquals((Integer)4,AUTOS_DISPONIBLES_DESPUES_DE_LA_RESERVA);
		
		
		assertTrue(AUTO_DEBUELTO);
		assertEquals((Integer)5, AUTOS_DISPONIBLES_DESPUES_DE_LA_DEVOLUCION);
		assertTrue(ag.getAutos().contains(auto5));
		
	}
	
	@Test
	public void queCuandoUnClienteHagaUnaReservaDeMasDe100MilEstePaseASerClienteVip() {


		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);

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
		
		ag.agregarCliente(cliente1);
		
		final Boolean EL_CLIENTE_ES_VIP_ANTES_DE_LA_RESERVA = cliente1.getEsVip();
		
		Integer codReserva = 1;
		Integer diasAlquiler = 12;
		Reserva reserva1 = ag.alquilarAuto(codReserva, cliente1, auto5, diasAlquiler);
		final Boolean EL_CLIENTE_ES_VIP_DESPUES_DE_LA_RESERVA = cliente1.getEsVip();
		
		final Double PRECIO_TOTAL_RESERVA_ESPERADO = 10000.0*12;
		final Double PRECIO_TOTAL_RESERVA = reserva1.getPrecioTotal();
		

		// Validaciones

		assertFalse(EL_CLIENTE_ES_VIP_ANTES_DE_LA_RESERVA);
		assertEquals(PRECIO_TOTAL_RESERVA_ESPERADO, PRECIO_TOTAL_RESERVA);
		assertTrue(EL_CLIENTE_ES_VIP_DESPUES_DE_LA_RESERVA);
		
	}

	
	@Test
	public void queALosCLientesVipSeLeHaganUnDescuentoDel10PorCientoEnSusReservasSiguientes() {

		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);

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
		String apellidoNombre = "Diego Fernandez";
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
		
		ag.agregarCliente(cliente1);
		
		
		Integer codReserva = 1;
		Integer diasAlquiler = 12;
		Reserva reserva1 = ag.alquilarAuto(codReserva, cliente1, auto5, diasAlquiler);
		
		Reserva segundaReserva = ag.alquilarAuto(2, cliente1, auto3, 10);
		
		final Double PRECIO_TOTAL_RESERVA2_ESPERADO = 10000.0*10*0.9;
		final Double PRECIO_TOTAL_RESERVA2 = segundaReserva.getPrecioTotal();

		// Validaciones

		assertTrue(cliente1.getEsVip());
		assertEquals(PRECIO_TOTAL_RESERVA2_ESPERADO, PRECIO_TOTAL_RESERVA2);
		
	}
	
	@Test
	public void queNoSePuedaReservarUnAutoQueNoEsteDisponiblePorqueEstaReservado() {

		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);

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
		String apellidoNombre = "Diego Fernandez";
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
		
		ag.agregarCliente(cliente1);
		
		
		Integer codReserva = 1;
		Integer diasAlquiler = 12;
		Reserva reserva1 = ag.alquilarAuto(codReserva, cliente1, auto5, diasAlquiler);
		//Reserva del mismo auto
		Boolean EL_AUTO_ESTA_DISPONIBLE = ag.elAutoEstaDisponible(auto5);
		Reserva segundaReserva = ag.alquilarAuto(2, cliente1, auto5, 10);
		

		// Validaciones

		assertFalse(EL_AUTO_ESTA_DISPONIBLE);
		assertNotNull(segundaReserva);
		assertFalse(ag.getReservas().contains(auto5));
		
	}
	
	@Test
	public void queNoSePuedaRegistrarDosReservasConElMismoCodigoDeReserva() {

		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);

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
		String apellidoNombre = "Diego Fernandez";
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
		
		ag.agregarCliente(cliente1);
		
		
		Integer codReserva = 1;
		Integer diasAlquiler = 12;
		Reserva reserva1 = ag.alquilarAuto(codReserva, cliente1, auto5, diasAlquiler);
		//Con mismo codigo de reserva
		Reserva segundaReserva = ag.alquilarAuto(codReserva, cliente1, auto3, 10);
			
		// Validaciones
		Integer reservasEsperadas = 1;
		assertEquals(1,  ag.getReservas().size());
		
	}
	
	
	@Test
	public void queLaListaDeReservasHechasEnLaAgenciaSeHayanGuardadoDeFormaCorrecta() {

		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);

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
		Auto auto4 = new Auto("BUS 850", "Volkswagen","Gol", 8000.0);
		Auto auto5 = new Auto("CAR 970", "Volkswagen", "Amarok", 10000.0);
		
		Integer dni = 34535345; 
		String apellidoNombre = "Diego Fernandez";
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
		
		ag.agregarCliente(cliente1);
		
		ag.alquilarAuto(1, cliente1, auto1, 10);
		ag.alquilarAuto(2, cliente1, auto2, 10);
		ag.alquilarAuto(3, cliente1, auto3, 10);
		ag.alquilarAuto(4, cliente1, auto4, 10);
		HashSet<Reserva> reservasObtenidas =  ag.getReservas();
		
		HashSet<Reserva> reservasEsperadas = new HashSet<>();
		reservasEsperadas.add(new Reserva(1, cliente1, auto1, 10));
		reservasEsperadas.add(new Reserva(2, cliente1, auto2, 10));
		reservasEsperadas.add(new Reserva(3, cliente1, auto3, 10));
		reservasEsperadas.add(new Reserva(4, cliente1, auto4, 10));
		
		
		// Validaciones

		assertEquals(reservasEsperadas, reservasObtenidas);
		
	}
	
	
	@Test
	public void queSePuedaCambiarDeAutoEnUnaReserva() {


		// Preparacion de datos
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);

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
		Auto auto4 = new Auto("BUS 850", "Volkswagen","Gol", 8000.0);
		Auto auto5 = new Auto("CAR 970", "Volkswagen", "Amarok", 10000.0);
		
		Integer dni = 34535345; 
		String apellidoNombre = "Diego Fernandez";
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
		
		ag.agregarCliente(cliente1);
		
		Reserva reserva1 = ag.alquilarAuto(1, cliente1, auto1, 10);
		
		Boolean SE_CAMBIO_CORRECTAMENTE = ag.cambiarAutoDeLaReserva(reserva1, auto3);
		
		
		// Validaciones
		
		assertTrue(SE_CAMBIO_CORRECTAMENTE);
		assertEquals(auto3, reserva1.getAuto());
		
		
	}
	
	@Test
	public void queSePuedaCancelarUnaReserva() {
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);
		
		Integer idGaraje = 1;
		String direccion = "Av. Victoria 123";
		Integer espaciosDisponibles = 10;
		Garaje garaje1 = new Garaje(idGaraje, direccion, espaciosDisponibles);

		String patente = "USD 660";
		String marca = "Renauld kwid";
		String modelo = "Climber";
		Double precioPorDia = 5000.0;
		Auto auto1 = new Auto(patente, marca, modelo, precioPorDia);
		
		Integer dni = 34535345; 
		String apellidoNombre = "Diego Fernandez";
		String direccionC = "Av Libertadores 1234";
		Integer telefono = 462415441;
		Cliente cliente1 = new Cliente(dni, apellidoNombre, direccionC, telefono);
		
		Integer diasReserva = 20; 
		ag.registrarUnAuto(auto1, garaje1);
		ag.agregarCliente(cliente1);
		Reserva reserva01 = ag.alquilarAuto(dni, cliente1, auto1, diasReserva);
		
		assertNull(ag.cancelarReserva(reserva01));
	}
	
	@Test
	public void queSePuedaCambiarLaCantidadDeDiasDelAlquilerDeUnaReserva() {
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia ag = new Agencia(razonSocial, cuit, garajesDisponibles);
		
		Integer idGaraje = 1;
		String direccion = "Av. Victoria 123";
		Integer espaciosDisponibles = 10;
		Garaje garaje1 = new Garaje(idGaraje, direccion, espaciosDisponibles);

		String patente = "USD 660";
		String marca = "Renauld kwid";
		String modelo = "Climber";
		Double precioPorDia = 5000.0;
		Auto auto1 = new Auto(patente, marca, modelo, precioPorDia);
		
		Integer dni = 34535345; 
		String apellidoNombre = "Diego Fernandez";
		String direccionC = "Av Libertadores 1234";
		Integer telefono = 462415441;
		Cliente cliente1 = new Cliente(dni, apellidoNombre, direccionC, telefono);
		
		Integer diasReserva = 20; 
		ag.registrarUnAuto(auto1, garaje1);
		ag.agregarCliente(cliente1);
		Reserva reserva01 = ag.alquilarAuto(dni, cliente1, auto1, diasReserva);
		Integer diasEsperados = 15;
		reserva01.setDias(15);
		assertEquals(diasEsperados, reserva01.getDias());
	}
	@Test
	public void queSePuedaBuscarEnLaListaDeReservasLaCantidadDeAutosReservadosDeUnaMarca() {
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia agencia = new Agencia(razonSocial, cuit, garajesDisponibles);
		
		
		Integer idGaraje = 1;
		String direccion = "Av. Victoria 123";
		Integer espaciosDisponibles = 10;
		Garaje garaje1 = new Garaje(idGaraje, direccion, espaciosDisponibles);

		String patente = "USD 660";
		String marca = "Renauld kwid";
		String modelo = "Climber";
		Double precioPorDia = 5000.0;
		Auto auto1 = new Auto(patente, marca, modelo, precioPorDia);
		
		Integer dni = 34535345; 
		String apellidoNombre = "Diego Fernandez";
		String direccionC = "Av Libertadores 1234";
		Integer telefono = 462415441;
		Cliente cliente1 = new Cliente(dni, apellidoNombre, direccionC, telefono);
		
		Integer diasReserva = 20; 
		agencia.registrarUnAuto(auto1, garaje1);
		agencia.agregarCliente(cliente1);
		Reserva reserva01 = agencia.alquilarAuto(dni, cliente1, auto1, diasReserva);
		Integer marcasEsperadas= 1;
		Integer cantidadMarcasBuscadas = agencia.getCantidadMarcas("Renauld kwid");
		assertEquals(marcasEsperadas, cantidadMarcasBuscadas);
	}
	@Test
	public void queSeBusqueAlClienteQueHizoMasReservasEnLaAgencia() {
		String razonSocial = "Rodriguez y cia S.R.L";
		Integer cuit = 250686778;
		ArrayList <Garaje> garajesDisponibles = new ArrayList<>();
		Agencia agencia = new Agencia(razonSocial, cuit, garajesDisponibles);
		
		
		Integer idGaraje = 1;
		String direccion = "Av. Victoria 123";
		Integer espaciosDisponibles = 10;
		Garaje garaje1 = new Garaje(idGaraje, direccion, espaciosDisponibles);

		String patente = "USD 660";
		String marca = "Renauld kwid";
		String modelo = "Climber";
		Double precioPorDia = 5000.0;
		Auto auto1 = new Auto(patente, marca, modelo, precioPorDia);
		
		Integer dni = 34535345; 
		String apellidoNombre = "Diego Fernandez";
		String direccionC = "Av Libertadores 1234";
		Integer telefono = 462415441;
		Cliente cliente1 = new Cliente(dni, apellidoNombre, direccionC, telefono);
		
		Integer diasReserva = 20; 
		agencia.registrarUnAuto(auto1, garaje1);
		agencia.agregarCliente(cliente1);
		Reserva reserva01 = agencia.alquilarAuto(dni, cliente1, auto1, diasReserva);
		
		assertNull(agencia.buscarClienteConMasReservas());
	}
	
	
}


