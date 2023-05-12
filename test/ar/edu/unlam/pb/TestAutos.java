package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestAutos {

	@Test
	public void queNoSePuedaAgregarAutosConLaMismaPatente() {
	   Agencia agencia = new Agencia("MiAgencia", 203456789, new ArrayList<>());
	    Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	   agencia.agregarGaraje(garaje);
	    Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2019, 2000.0, garaje, new ArrayList<Alquiler>(), 150.0);
	    Auto auto2 = new Auto("ABC123", "Chevrolet", "Cruze", 2020, 2500.0, garaje, new ArrayList<Alquiler>(), 250.0);
	   agencia.registrarAuto(auto1);
	   assertFalse(agencia.agregarGaraje(garaje));
	}

	@Test
	public void queSePuedaCambiarDeAuto() {
	    
		Agencia agencia = new Agencia("MiAgencia", 203456789, new ArrayList<>());
	    Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	    agencia.agregarGaraje(garaje);
	    Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2019, 2000.0, garaje, new ArrayList<Alquiler>(), 350.0);
	    Auto auto2 = new Auto("DEF456", "Chevrolet", "Cruze", 2020, 2500.0, garaje, new ArrayList<Alquiler>(), 450.0);
	    agencia.registrarAuto(auto1);
	    agencia.registrarAuto(auto2);
	    assertFalse(agencia.cambiarAuto("ABC123", auto2));
	}

	
	@Test
	public void queSePuedaMostrarLaCantidadDeAutosDeUnaMarcaDeAuto() {
	    Agencia agencia = new Agencia("MiAgencia", 203456789, new ArrayList<>());
	    Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	    Auto auto1 = new Auto("ABC123", "Ford", "Focus", 2015, 500.0, garaje, new ArrayList<Alquiler>(), 150.0);
	    Auto auto2 = new Auto("DEF456", "Ford", "Fiesta", 2016, 600.0, garaje, new ArrayList<Alquiler>(), 200.0);
	    Auto auto3 = new Auto("GHI789", "Chevrolet", "Corsa", 2017, 700.0, garaje, new ArrayList<Alquiler>(), 250.0);
	    agencia.agregarGaraje(garaje);
	    garaje.agregarAuto(auto1);
	    garaje.agregarAuto(auto2);
	    garaje.agregarAuto(auto3);
	    assertEquals(2, agencia.cantidadDeAutosDeUnaMarca("Ford"));
	}

	@Test
	public void queSePuedaRegistrarAutosEnUnGaraje() {
	    Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	    Auto auto1 = new Auto("ABC123", "Ford", "Focus", 2015, 500.0, garaje, new ArrayList<Alquiler>(), 100.0);
	    Auto auto2 = new Auto("DEF456", "Ford", "Fiesta", 2016, 600.0, garaje,  new ArrayList<Alquiler>(), 150.0);
	    garaje.agregarAuto(auto1);
	    garaje.agregarAuto(auto2);
	    assertEquals(2, garaje.getAutosEnElGaraje().size());
	}

	@Test
	public void queSePuedaBuscarUnAutoPorPatente() {
	    Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	    Auto auto1 = new Auto("ABC123", "Ford", "Focus", 2015, 500.0, garaje, new ArrayList<Alquiler>(), 100.0);
	    Auto auto2 = new Auto("DEF456", "Ford", "Fiesta", 2016, 600.0, garaje, new ArrayList<Alquiler>(), 150.0);
	    Boolean exitoso = garaje.agregarAuto(auto1);
	    assertTrue(exitoso);
	    assertTrue(garaje.getAutosEnElGaraje().contains(auto1));
	    Auto buscado = garaje.buscarAuto("ABC123");
	    garaje.agregarAuto(auto2);
	    assertEquals(auto1, buscado);
	}
	@Test
	public void queSePuedaDevolverUnAuto() {
		ArrayList<Garaje> garajesDisponibles = new ArrayList<>();
		ArrayList<Auto> autosEnElGaraje = new ArrayList<>();
	    Agencia agencia = new Agencia("MiAgencia", 203456789, garajesDisponibles);
	    Garaje garaje1 = new Garaje(1, "Calle Falsa 123", 10, autosEnElGaraje );
	    agencia.agregarGaraje(garaje1);
	    Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2020, 2500.0, garaje1, new ArrayList<Alquiler>(), 250.0);
	    agencia.registrarAuto(auto1);
	    assertFalse("Se esperaba que el método devolverAuto devolviera true", agencia.devolverAuto(auto1));
	    assertFalse("El auto devuelto no debería estar en la lista de autos disponibles en el garaje", garaje1.getAutosDisponibles(null, null).contains(auto1));
	}
	
}