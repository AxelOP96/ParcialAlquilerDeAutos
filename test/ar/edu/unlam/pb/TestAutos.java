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
	public void queSePuedaEliminarUnAuto() {
	    Agencia agencia = new Agencia("MiAgencia", 203456789, new ArrayList<>());
	    Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	    agencia.agregarGaraje(garaje);
	    Auto auto = new Auto("ABC123", "Toyota", "Corolla", 2019, 2000.0, garaje, new ArrayList<Alquiler>(), 100.0);
	    agencia.registrarAuto(auto);
	    assertTrue(agencia.eliminarAuto("ABC123"));
	}

	@Test
	public void queSePuedaCambiarElPrecioXDiaDeUnAuto() {
		Agencia agencia = new Agencia("MiAgencia", 203456789, new ArrayList<>());
	    Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	    agencia.agregarGaraje(garaje);
	    Auto auto = new Auto("ABC123", "Toyota", "Corolla", 2019, 2000.0, garaje, new ArrayList<Alquiler>(), 200.0);
	    agencia.registrarAuto(auto);
	    assertTrue(agencia.cambiarPrecio("ABC123", 2500.0));
	}

	@Test
	public void queSePuedaCambiarDeGarajeUnAuto() {
	    Agencia agencia = new Agencia("MiAgencia", 203456789, new ArrayList<>());
	    Garaje garaje1 = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	    Garaje garaje2 = new Garaje(2, "Av. Rivadavia 123", 7, new ArrayList<>());
	    agencia.agregarGaraje(garaje1);
	    agencia.agregarGaraje(garaje2);
	    Auto auto = new Auto("ABC123", "Toyota", "Corolla", 2019, 2000.0, garaje1, new ArrayList<Alquiler>(), 150.0);
	    agencia.registrarAuto(auto);
	    assertTrue(agencia.cambiarGaraje("ABC123", garaje2));
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
	    assertTrue(agencia.cambiarAuto("ABC123", auto2));
	}

	@Test
	public void queSePuedaBuscarUnAutoPorMarca() {
	    Agencia agencia = new Agencia("MiAgencia", 203456789, new ArrayList<>());
	    Garaje garaje1 = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	    agencia.agregarGaraje(garaje1);
	    Auto auto1 = new Auto("ABC123", "Chevrolet", "Onix", 2021, 1000.0, garaje1, new ArrayList<Alquiler>(), 500.0);
	    Auto auto2 = new Auto("DEF456", "Ford", "Fiesta", 2020, 800.0, garaje1, new ArrayList<Alquiler>(), 450.0);
	    Auto auto3 = new Auto("GHI789", "Chevrolet", "Cruze", 2022, 1200.0, garaje1, new ArrayList<Alquiler>(), 550.0);
	    agencia.registrarAuto(auto1);
	    agencia.registrarAuto(auto2);
	    agencia.registrarAuto(auto3);
	    
	    ArrayList<Auto> autosEncontrados = agencia.buscarAutoPorMarca("Chevrolet");
	    assertEquals(2, autosEncontrados.size());
	    assertTrue(autosEncontrados.contains(auto1));
	    assertTrue(autosEncontrados.contains(auto3));
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
	    garaje.agregarAuto(auto1);
	    garaje.agregarAuto(auto2);
	    assertEquals(auto1, garaje.buscarAutoPorPatente("ABC123"));
	}

	@Test
	public void queSePuedanOrdenarLosAutosPorPrecio() {
	    Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5, new ArrayList<>());
	    Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2019, 2000.0, garaje, new ArrayList<Alquiler>(), 300.0);
	    Auto auto2 = new Auto("DEF456", "Chevrolet", "Cruze", 2020, 2500.0, garaje, new ArrayList<Alquiler>(), 350.0);
	    Auto auto3 = new Auto("GHI789", "Ford", "Fiesta", 2021, 1800.0, garaje, new ArrayList<Alquiler>(), 400.0);
	    garaje.agregarAuto(auto1);
	    garaje.agregarAuto(auto2);
	    garaje.agregarAuto(auto3);

	    List<Auto> autosOrdenados = garaje.ordenarAutosPorPrecio();
	    assertEquals(3, autosOrdenados.size());
	    assertEquals(auto3, autosOrdenados.get(0));
	    assertEquals(auto1, autosOrdenados.get(1));
	    assertEquals(auto2, autosOrdenados.get(2));
	}

	@Test
	public void queSePuedaMostrarLosAutosDisponiblesOrdenadosPorPrecio() {
	    Agencia agencia = new Agencia("MiAgencia", 203456789, new ArrayList<>());
	    Garaje garaje1 = new Garaje(1, "Calle Falsa 123", 10, new ArrayList<>());
	    agencia.agregarGaraje(garaje1);
	    Garaje garaje2 = new Garaje(2, "Calle Falsa 456", 10, new ArrayList<>());
	    agencia.agregarGaraje(garaje2);
	    Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2020, 2500.0, garaje1,  new ArrayList<Alquiler>(), 200.0);
	    agencia.registrarAuto(auto1);
	    Auto auto2 = new Auto("DEF456", "Honda", "Civic", 2021, 3000.0, garaje1, new ArrayList<Alquiler>(), 250.0);
	    agencia.registrarAuto(auto2);
	    Auto auto3 = new Auto("GHI789", "Toyota", "Yaris", 2019, 2000.0, garaje2,  new ArrayList<Alquiler>(), 175.0);
	    agencia.registrarAuto(auto3);
	    List<Auto> autosOrdenados = agencia.mostrarAutosDisponiblesOrdenadosPorPrecio();
	    assertEquals(3, autosOrdenados.size());
	    assertEquals(auto2, autosOrdenados.get(0));
	    assertEquals(auto3, autosOrdenados.get(1));
	    assertEquals(auto1, autosOrdenados.get(2));
	}

	@Test
	public void queSePuedaDevolverUnAuto() {
	    Agencia agencia = new Agencia("MiAgencia", 203456789, new ArrayList<>());
	    Garaje garaje1 = new Garaje(1, "Calle Falsa 123", 10, new ArrayList<>());
	    agencia.agregarGaraje(garaje1);
	    Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2020, 2500.0, garaje1, new ArrayList<Alquiler>(), 250.0);
	    agencia.registrarAuto(auto1);
	    assertTrue("Se esperaba que el método devolverAuto devolviera true", agencia.devolverAuto(auto1));
	    assertFalse("El auto devuelto no debería estar en la lista de autos disponibles en el garaje", garaje1.getAutosDisponibles(null, null).contains(auto1));
	}
	
	/*
	 * queSePuedaEliminarUnAuto()
queSePuedaCambiarDeGarajeUnAuto()
queSePuedaCambiarDeAuto()
queSePuedaBuscarUnAutoPorMarca()
queSePuedaBuscarUnAutoPorPatente()
queSePuedaDevolverUnAuto()*/
	
}