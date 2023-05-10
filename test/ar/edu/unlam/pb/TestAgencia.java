package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class TestAgencia {

	@Test
	public void queSePuedaIncluirUnGarajeAUnaAgencia() {
		String razonSocial = "SA";
		Integer cuit = 19919919;
		HashSet <Auto> autosDisponibles= new HashSet<>();
		HashSet <Garaje> garajesDisponibles = new HashSet<>();
		
		Integer id = 000001;
		String direccion = "CALLE FALSA 123";
		Integer espaciosDisponibles = 100;
		
		Agencia agencia = new Agencia(razonSocial, cuit, garajesDisponibles);
		Garaje garaje = new Garaje(id, direccion, espaciosDisponibles, autosDisponibles);
		agencia.agregarGaraje(garaje);
		assertNotNull(agencia.getGarajesDisponibles());
	}

}
