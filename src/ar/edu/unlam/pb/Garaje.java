package ar.edu.unlam.pb;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.*;


public class Garaje {

	private Integer idGaraje;
	private String direccion;
	private Integer espaciosDisponibles;
	private ArrayList<Auto> autosEnElGaraje = new ArrayList<>();
	private ArrayList<Auto> autosDisponibles = new ArrayList<>();
	private ArrayList<Garaje> garajes = new ArrayList<>();
	private ArrayList<Alquiler> alquileres = new ArrayList<>();
	private List<Auto> autos;


	public Garaje(Integer idGaraje, String direccion, Integer espaciosDisponibles,ArrayList<Auto> autosEnElGaraje) {
	    this.setIdGaraje(idGaraje);
	    this.direccion = direccion;
	    this.espaciosDisponibles = espaciosDisponibles;
	    this.autosEnElGaraje = new ArrayList<Auto>(autosEnElGaraje);
	    this.autosDisponibles = new ArrayList<>(autosDisponibles);
	    this.autos = new ArrayList<Auto>();
	    
	    
	}

	public void agregarGaraje(Garaje garaje) {
		this.garajes.add(garaje);
	}

	public Garaje(Integer idGaraje, String direccion, Integer espaciosDisponibles) {
	    this.setIdGaraje(idGaraje);
	    this.direccion = direccion;
	    this.espaciosDisponibles = espaciosDisponibles;
	    this.autosEnElGaraje = new ArrayList<Auto>();
	}

	//public Garaje(Integer id, String direccion, Integer espaciosDisponibles, HashSet<Auto> autosDisponibles) {
	//	this.setIdGaraje(id);
//		this.direccion = direccion;
	//	this.espaciosDisponibles = espaciosDisponibles;
	//}
 
	
	public boolean agregarAuto(Auto auto) {
	    if (espaciosDisponibles > 0) {
	        this.autosEnElGaraje.add(auto);
	        auto.setGaraje(this); //Se agrega este auto en el garaje actual
	        this.autosDisponibles.remove(auto); //Eliminamos el auto de la lista de autos disponibles
	        espaciosDisponibles--;
	        return true;			//Si se agrego
	    } else {
	        return false;		//no se agrego
	    }
	}
	public boolean estaAutoEnGaraje(Auto auto) {
		return this.autosEnElGaraje.contains(auto);
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
	public String getDireccion() {
		return this.direccion;
	}

	public Garaje getGaraje(int index) {
		ArrayList<Garaje> garajes = getGarajesDisponibles();
		return garajes.get(index);
	}

	public List<Auto> getAutos() {
	    return Collections.unmodifiableList(this.autosEnElGaraje);
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
	public void disminuirCantidadEspaciosDisponibles() {
		this.espaciosDisponibles--;
	}

	 public void agregarAutoDisponible(Auto auto) {
	        this.autosDisponibles.add(auto);
	    }

	 public boolean quitarAuto(Auto autoAnterior) {
		    if (autosEnElGaraje != null) {
		        Iterator<Auto> iterador = autosEnElGaraje.iterator();
		        while (iterador.hasNext()) {
		            Auto autoActual = iterador.next();
		            if (autoActual.equals(autoAnterior)) {
		                iterador.remove();
		                espaciosDisponibles++;
		                autosDisponibles.add(autoActual);
		                autoActual.setGaraje(null); // Actualizar la referencia al garaje
		                return true; // Devolver true si se ha quitado el auto con éxito
		            }
		        }
		    }
		    return false;
		}
	public Integer getIdGaraje() {
		return idGaraje;
	}

	public void setIdGaraje(Integer idGaraje) {
		this.idGaraje = idGaraje;
	}

	public ArrayList<Auto> getAutosEnElGaraje() {
	    return this.autosEnElGaraje;
	}



}

