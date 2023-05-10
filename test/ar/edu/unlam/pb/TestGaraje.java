package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestGaraje {

	 private Garaje garaje;

	    @Before
	    public void setUp() {
	        garaje = new Garaje(1, "Calle Falsa 123", 5);
	    }
	@Test
    public void queSePuedaRegitrarUnGaraje() {
        Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5);
        assertNotNull(garaje);
    }

    @Test
    public void queNoSePuedaRegistrarDosGarajesConLaMismaDireccion() {
        Garaje garaje1 = new Garaje(1, "Av. Siempreviva 742", 5);
        Garaje garaje2 = new Garaje(2, "Av. Siempreviva 742", 7);
        Agencia agencia = new Agencia("MiAgencia");
        agencia.agregarGaraje(garaje1);
        assertFalse(agencia.agregarGaraje(garaje2));
    }

	@Test
    public void queSePuedaAgregarYQuitarUnAuto() {
        Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5);
        Auto auto = new Auto("AAA123", "Fiat", "Uno", 1500.0, garaje);
        garaje.agregarAuto(auto);
        assertTrue(garaje.estaAutoEnGaraje(auto));
        garaje.quitarAuto(auto);
        assertFalse(garaje.estaAutoEnGaraje(auto));
    }

    @Test
    public void queSePuedaBuscarUnAutoPorPatente() {
        Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5);
        Auto auto1 = new Auto("AAA123", "Fiat", "Uno", 1500.0, garaje);
        Auto auto2 = new Auto("BBB456", "Renault", "Kwid", 2000.0, garaje);
        garaje.agregarAuto(auto1);
        garaje.agregarAuto(auto2);
        Auto autoEncontrado = garaje.buscarAuto("BBB456");
        assertEquals(auto2, autoEncontrado);
    }

    @Test
    public void queElGarajeTengaEspaciosDisponibles() {
        Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 5);
        Auto auto1 = new Auto("AAA123", "Fiat", "Uno", 1500.0, garaje);
        garaje.agregarAuto(auto1);
        assertTrue(garaje.tieneEspaciosDisponibles());
    }

    @Test
    public void queElGarajeNoTengaEspaciosDisponibles() {
        Garaje garaje = new Garaje(1, "Av. Siempreviva 742", 1);
        Auto auto1 = new Auto("AAA123", "Fiat", "Uno", 1500.0, garaje);
        Auto auto2 = new Auto("BBB456", "Renault", "Kwid", 2000.0, garaje);
        garaje.agregarAuto(auto1);
        garaje.agregarAuto(auto2);
       assertFalse(garaje.tieneEspaciosDisponibles());
    }

    @Test
    public void testAgregarAuto() {
        Garaje garaje = new Garaje(1, "Calle 123", 5);
        Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2000.0, garaje);
        Auto auto2 = new Auto("DEF456", "Ford", "Focus", 1500.0, garaje);
        garaje.agregarAuto(auto1);
        garaje.agregarAuto(auto2);
        assertEquals(2, garaje.getAutosEnElGaraje().size());
    }
    
    @Test
    public void testQuitarAuto() {
        Garaje garaje = new Garaje(1, "Calle 123", 5);
        Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2000.0, garaje);
        Auto auto2 = new Auto("DEF456", "Ford", "Focus", 1500.0, garaje);
        garaje.agregarAuto(auto1);
        garaje.agregarAuto(auto2);
        garaje.quitarAuto(auto1);
        assertEquals(1, garaje.getAutosEnElGaraje().size());
    }
    
    @Test
    public void testBuscarAuto() {
        Garaje garaje = new Garaje(1, "Calle 123", 5);
        Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2000.0, garaje);
        Auto auto2 = new Auto("DEF456", "Ford", "Focus", 1500.0, garaje);
        garaje.agregarAuto(auto1);
        garaje.agregarAuto(auto2);
        Auto autoBuscado = garaje.buscarAuto("ABC123");
        assertEquals(auto1, autoBuscado);
    }
    
    @Test
    public void testTieneEspaciosDisponibles() {
        Garaje garaje1 = new Garaje(1, "Calle 123", 2);
        assertTrue(garaje1.tieneEspaciosDisponibles());
        
        Garaje garaje2 = new Garaje(2, "Avenida 456", 0);
        assertFalse(garaje2.tieneEspaciosDisponibles());
    }
    
    @Test
    public void testEstaAutoEnGaraje() {
        Garaje garaje = new Garaje(1, "Calle 123", 5);
        Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2000.0, garaje);
        Auto auto2 = new Auto("DEF456", "Ford", "Focus", 1500.0, garaje);
        garaje.agregarAuto(auto1);
        assertTrue(garaje.estaAutoEnGaraje(auto1));
        assertFalse(garaje.estaAutoEnGaraje(auto2));
    }
}

