package ar.edu.unlam.pb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agencia {
    private String razonSocial;
    private Integer cuit;
    private ArrayList<Garaje> garajesDisponibles;
    private List<Garaje> garajes;

    public Agencia(String razonSocial, Integer l, ArrayList<Garaje> garajesDisponibles2) {
        this.razonSocial = razonSocial;
        this.cuit = l;
        this.garajesDisponibles = new ArrayList<>();
        this.garajes = new ArrayList<>();
    }

    public boolean agregarGaraje(Garaje garaje) {
        if (garajeConMismaDireccion(garaje)) {
            return false;
        }
        return garajesDisponibles.add(garaje);
    }

    public boolean garajeConMismaDireccion(Garaje garaje) {
        for (Garaje g : garajesDisponibles) {
            if (g.getDireccion().equals(garaje.getDireccion())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Garaje> getGarajesDisponibles() {
        return garajesDisponibles;
    }

    public void registrarAuto(Auto auto) {
        for (Garaje garaje : garajesDisponibles) {
            if (garaje.tieneEspaciosDisponibles() && !garaje.estaAutoEnGaraje(auto)) {
                garaje.agregarAuto(auto);
                return;
            }
        }
    }

    public boolean eliminarAuto(String patente) {
        Auto auto = buscarAuto(patente);
        if (auto != null) {
            quitarAuto(auto);
            return true;
        }
        return false;
    }

	private void quitarAuto(Auto auto) {
		// TODO Auto-generated method stub
		
	}

	private Auto buscarAuto(String patente) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean cambiarPrecio(String modelo, double nuevoPrecio) {
	    for (Garaje garaje : garajesDisponibles) {
	        for (Auto auto : garaje.getAutosEnElGaraje()) {
	            if (auto.getModelo().equals(modelo)) {
	                auto.setPrecio(nuevoPrecio);
	                return true;
	            }
	        }
	    }
	    return false;
	}

	public boolean cambiarGaraje(String patente, Garaje nuevoGaraje) {
	    Auto auto = buscarAutoEnGarajes(patente);
	    if (auto != null) {
	        auto.getGaraje().quitarAuto(auto);
	        nuevoGaraje.agregarAuto(auto);
	        auto.setGaraje(nuevoGaraje);
	        return true;
	    }
	    return false;
	}
	private Auto buscarAutoEnGarajes(String patente) {
	    for (Garaje garaje : garajesDisponibles) {
	        Auto auto = garaje.buscarAuto(patente);
	        if (auto != null) {
	            return auto;
	        }
	    }
	    return null;
	}

	public boolean cambiarAuto(String string, Auto auto2) {
		
		return false;
	}

	public ArrayList<Auto> buscarAutoPorMarca(String marca) {
	    ArrayList<Auto> autosPorMarca = new ArrayList<Auto>();
	    Garaje[] garajes = new Garaje[] { /* Inicializar el array con los objetos Garaje */ };
	    for (Garaje garaje : garajes) {
	        for (Auto auto : garaje.getAutosEnElGaraje()) {
	            if (auto.getMarca().equals(marca)) {
	                autosPorMarca.add(auto);
	            }
	        }
	    }
	    return autosPorMarca;
	}

	public int cantidadDeAutosDeUnaMarca(String marca) {
	    int cantidad = 0;
	    if (garajes != null) {
	        for (Garaje garaje : garajes) {
	            if (garaje.getAutos() != null) {
	                for (Auto auto : garaje.getAutos()) {
	                    if (auto.getMarca().equals(marca)) {
	                        cantidad++;
	                    }
	                }
	            }
	        }
	    }
	    return cantidad;
	}
	private Alquiler buscarAlquilerPorAuto(Auto auto) {
	    for (Garaje garaje : garajes) {
	        for (Alquiler alquiler : garaje.getAlquileres()) {
	            if (alquiler.getAuto().equals(auto)) {
	                return alquiler;
	            }
	        }
	    }
	    return null;
	}

	public List<Auto> mostrarAutosDisponiblesOrdenadosPorPrecio() {
	    List<Auto> autosDisponibles = new ArrayList<>();
	    for (Garaje garaje : garajesDisponibles) {
	        autosDisponibles.addAll(garaje.getAutosEnElGaraje());
	    }
	    List<Auto> autosOrdenados = new ArrayList<>(autosDisponibles);
	    autosOrdenados.removeIf(auto -> !auto.estaDisponible(null,null));
	    autosOrdenados.sort(Comparator.comparingDouble(Auto::getPrecio));
	    return autosOrdenados;
	}

	public boolean devolverAuto(Auto auto) {
	    Alquiler alquiler = buscarAlquilerPorAuto(auto);
	    if (alquiler == null) {
	        return false;
	    }
	    alquiler.finalizar();
	    Garaje garaje = auto.getGaraje();
	    garaje.actualizarAlquiler(alquiler);
	    return true;
	}
}
