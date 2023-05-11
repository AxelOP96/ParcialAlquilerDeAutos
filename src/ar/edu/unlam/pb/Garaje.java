package ar.edu.unlam.pb;

<<<<<<< HEAD
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
=======
import java.util.*;
>>>>>>> 09e05652f3f2ed76880de7eab9e8cbfffe35ecc8

public class Garaje {

	private Integer idGaraje;
	private Integer espaciosDisponibles;
	private String direccion;
	private ArrayList<Auto> autosEnElGaraje;
<<<<<<< HEAD
	private ArrayList<Garaje> garajes;
	private List<Alquiler> alquileres = new ArrayList<>();


	public Garaje(Integer idGaraje, String direccion, Integer espaciosDisponibles, ArrayList<Auto> autosDisponibles) {
		this.idGaraje = idGaraje;
		this.direccion = direccion;
		this.espaciosDisponibles = espaciosDisponibles;
		this.autosEnElGaraje = new ArrayList<>(autosDisponibles);
		this.garajes = new ArrayList<>();
	}

	public void agregarAuto(Auto auto) {
		if (tieneEspaciosDisponibles()) {
			this.autosEnElGaraje.add(auto);
			this.espaciosDisponibles--;
		}
	}

	public void agregarGaraje(Garaje garaje) {
		this.garajes.add(garaje);
	}

=======

	public Garaje(Integer idGaraje, String direccion, Integer espaciosDisponibles) {
	    this.idGaraje = idGaraje;
	    this.direccion = direccion;
	    this.espaciosDisponibles = espaciosDisponibles;
	    this.autosEnElGaraje = new ArrayList<Auto>();
	}

	
	
	public boolean agregarAuto(Auto auto) {
		if (espaciosDisponibles > 0) {
			this.autosEnElGaraje.add(auto);
			auto.setGaraje(this); //Se agrega este auto en el garaje actual
			espaciosDisponibles--;
			return true;			//Si se agrego
		} else {
			return false;		//no se agrego
		}
	}

>>>>>>> 09e05652f3f2ed76880de7eab9e8cbfffe35ecc8
	public boolean estaAutoEnGaraje(Auto auto) {
		return this.autosEnElGaraje.contains(auto);
	}

	public void quitarAuto(Auto auto) {
		if (estaAutoEnGaraje(auto)) {
			this.autosEnElGaraje.remove(auto);
			this.espaciosDisponibles++;
		}
	}

	public boolean tieneEspaciosDisponibles() {
		return this.espaciosDisponibles > 0;
	}

	public Auto buscarAuto(String patente) {
		for (Auto auto : this.autosEnElGaraje) {
			if (auto.getPatente().equals(patente)) {
				return auto;
			}
		}
		return null;
	}

	public ArrayList<Auto> getAutosEnElGaraje() {
		return this.autosEnElGaraje;
	}

<<<<<<< HEAD
	public String getDireccion() {
		return this.direccion;
	}

	public Garaje getGaraje(int index) {
		ArrayList<Garaje> garajes = getGarajesDisponibles();
		return garajes.get(index);
	}

	public Auto[] getAutos() {
		return this.autosEnElGaraje.toArray(new Auto[this.autosEnElGaraje.size()]);
	}

	public ArrayList<Garaje> getGarajesDisponibles() {
		ArrayList<Garaje> garajesDisponibles = new ArrayList<>();
		for (Garaje garaje : this.garajes) {
			if (garaje.tieneEspaciosDisponibles()) {
				garajesDisponibles.add(garaje);
			}
		}
		return garajesDisponibles;
	}

//////////////////////////////////////////////////////////////////////////////////////////////
	public Auto buscarAutoPorPatente(String patente) {
		ArrayList<Garaje> garajesDisponibles = this.getGarajesDisponibles();
		for (Garaje garaje : garajesDisponibles) {
			Auto auto = garaje.buscarAuto(patente);
			if (auto != null) {
				return auto;
			}
		}
		return null;
	}

	public List<Auto> ordenarAutosPorPrecio() {
		List<Auto> autosOrdenados = new ArrayList<>(this.autosEnElGaraje);
		Collections.sort(autosOrdenados, new Comparator<Auto>() {
			public int compare(Auto auto1, Auto auto2) {
				return Double.compare(auto1.getPrecio(), auto2.getPrecio());
			}
		});
		return autosOrdenados;
	}

	public List<Alquiler> getAlquileres() {
	    return this.alquileres;
	}
	public void devolverAuto(Alquiler alquiler) {
		List<Alquiler> alquileres = this.getAlquileres();
		alquileres.remove(alquiler);
	}

	public ArrayList<Auto> getAutosDisponibles(Date fechaInicio, Date fechaFin) {
		ArrayList<Auto> autosDisponibles = new ArrayList<>();
		for (Auto auto : this.autosEnElGaraje) {
			if (auto.estaDisponible(fechaInicio, fechaFin)) {
				autosDisponibles.add(auto);
			}
		}
		return autosDisponibles;
	}

	public void actualizarAlquiler(Alquiler alquiler) {
	    // Buscamos el alquiler en la lista de alquileres del garaje
	    int index = this.alquileres.indexOf(alquiler);
	    if (index != -1) { // Si el alquiler existe en la lista
	        // Actualizamos la fecha de devolución del alquiler
	        this.alquileres.get(index).setFechaDevolucion(alquiler.getFechaFin());
	    } else { // Si el alquiler no existe en la lista
	        System.out.println("El alquiler no se encuentra registrado en este garaje.");
	    }
	}

}
=======
	public Object getDireccion() {
		 return this.direccion;
	}



	public void disminuirCantidadEspaciosDisponibles() {
		this.espaciosDisponibles--;
	}
}
>>>>>>> 09e05652f3f2ed76880de7eab9e8cbfffe35ecc8
