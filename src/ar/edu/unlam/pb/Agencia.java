package ar.edu.unlam.pb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
//import java.util.LinkedList;
import java.util.List;

public class Agencia {
    private String razonSocial;
    private Integer cuit;
    private ArrayList<Garaje> garajesDisponibles;
    private HashSet<Garaje> garajes;
    private HashSet<Auto> autos ;		//Autos disponibles
	private HashSet<Cliente> clientes;
	private HashSet<Reserva> reservas;

    
	
	public Agencia(String razonSocial, Integer l, ArrayList<Garaje> garajesDisponibles2) {
        this.razonSocial = razonSocial;
        this.cuit = l;
        this.garajesDisponibles = new ArrayList<>();
        this.garajes = new HashSet<>();
    }
    public Agencia(String razonSocial, Integer cuit) {
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		garajes = new HashSet<>();
		autos = new HashSet<>();
		clientes = new HashSet<>();
		reservas = new HashSet<>();
	}

	public Agencia(String razonSocial, Integer cuit, HashSet<Garaje> garajesDisponibles) {
		// TODO Auto-generated constructor stub
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.garajes = garajesDisponibles;
		this.autos = autos;
		this.clientes = new HashSet();
	}

	public Agencia(String razonSocial,Integer cuit, HashSet<Garaje> garajes, HashSet<Auto> autos) {
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.garajes = garajes;
		this.autos = autos;
		clientes = new HashSet<>();
	}
    public boolean agregarGaraje1(Garaje garaje) {
        if (garajeConMismaDireccion(garaje)) {
            return false;
        }
        return garajesDisponibles.add(garaje);
    }
	
	public boolean registrarUnGaraje(Garaje garaje) {
		return this.garajes.add(garaje);
	}



	public Boolean registrarUnAuto(Auto auto1, Garaje garaje1) {
		
		if(garaje1.agregarAuto(auto1)) {
			
			auto1.setGaraje(garaje1);
			return this.autos.add(auto1);
		}
		else {
			return false;
		}
			
		
	}
	
	public Reserva alquilarAuto(Integer codReserva,Cliente cliente, Auto auto,Integer dias) {
		
		if(autos.contains(auto)) {
			Reserva reserva = new Reserva(codReserva, cliente, auto, dias);
	        reservas.add(reserva);
	        auto.reservar();
	        autos.remove(auto);
	        auto.getGaraje().disminuirCantidadEspaciosDisponibles();//Hacer test de este
	        return reserva;
		}
		else 
			return null;
		
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public Integer getCuit() {
		return cuit;
	}
	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}
	public HashSet<Garaje> getGarajes() {
		return garajes;
	}
	public void setGarajes(HashSet<Garaje> garajes) {
		this.garajes = garajes;
	}
	public HashSet<Auto> getAutos() {
		return this.autos;
	}
	public void setAutos(HashSet<Auto> autos) {
		this.autos = autos;
	}
	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public HashSet<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(HashSet<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Integer cantidaDeAutosDisponibles() {
		return this.autos.size();
	}



	public Integer cantDeGarajesDisponibles() {
		return this.garajes.size();
	}



	public Boolean elAutoEstaDisponible(Auto auto1) {
		return this.autos.contains(auto1);
	}



	public Auto buscarAutoPorPatente(String patente) {
		
		for(Auto auto: autos) {
			if(auto.getPatente().equals(patente))
				return auto;
		}
		return null;
	}



	public HashSet<Auto> buscarAutosPorMarca(String marca) {
		HashSet<Auto> autosEncontrados = new HashSet<>();
		for(Auto auto: autos) {
			if(auto.getMarca().equalsIgnoreCase(marca))
				autosEncontrados.add(auto);
		}
		return autosEncontrados;
	}
	public Boolean recibirAutoQueSeAlquilo(Auto auto5) {
		return this.autos.add(auto5);
	}
    
	public boolean agregarGaraje(Garaje garaje) {
        if (garajeConMismaDireccion(garaje)) {
            return false;
        }
        return garajes.add(garaje);
    }

    public boolean garajeConMismaDireccion(Garaje garaje) {
        for (Garaje g : garajes) {
            if (g.getDireccion().equals(garaje.getDireccion())) {
                return true;
            }
        }
        return false;
    }
	public void agregarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clientes.add(cliente);
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
		this.autos.remove(auto);
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
	
	public Boolean cambiarAuto(Reserva reserva1, Auto autoNuevo) {
		if(this.autos.add(reserva1.getAuto()) ) {
			reserva1.setAuto(autoNuevo);
			return true;
		}
			return null;
	}
}

