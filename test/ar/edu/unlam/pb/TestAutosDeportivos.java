package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ar.edu.unlam.pb.Auto.AutoDeportivo;

public class TestAutosDeportivos {
    @Test
    public void testPrecioPorDia() {
    	Auto auto = new Auto("ABC123", "Toyota", "Corolla", 2020, 10000.0, null, null, 100.0);
    	Auto.AutoDeportivo autoDeportivo = auto.new AutoDeportivo("XYZ456", "Ferrari", "Testarossa", 2022, 200000.0, null, null, 120.0, 500, true);
    	assertEquals(120, autoDeportivo.getPrecioPorDia(), 0.001);
    }
    	@Test
    	public void testToString() {
    	    Auto miAuto = new Auto();
    	    AutoDeportivo miAutoDeportivo = miAuto.new AutoDeportivo("ABC123", "Ferrari", "F430", 2010, 50000.0, new Garaje(null, null, null, null), new ArrayList<Alquiler>(), 500, 500, true);
    	    String expected = "AutoDeportivo{patente='ABC123', marca='Ferrari', modelo='F430', anio=2010, precio=50000.0, caballosDeFuerza=500, turbo=true}";
    	    String actual = miAutoDeportivo.toString();
    	    assertEquals(expected, actual);
    	}
}