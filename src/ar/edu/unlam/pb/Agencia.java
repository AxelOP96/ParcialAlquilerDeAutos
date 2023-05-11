package ar.edu.unlam.pb;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Agencia {
    private String razonSocial;
    private Integer cuit;
    private ArrayList<Garaje> garajesDisponibles;
    private HashSet<Garaje> garajes;
    private HashSet<Auto> autos ;		//Autos disponibles
	private HashSet<Cliente> clientes;
	private HashSet<Reserva> reservas;
	private Date fechaFin;
	private Date fechaInicio;


    public Agencia(String razonSocial, Integer l, ArrayList<Garaje> garajesDisponibles2) {
        this.razonSocial = razonSocial;
        this.cuit = l;
        this.garajesDisponibles = new ArrayList<>();
        this.garajes = new HashSet<>();
        this.autos = new HashSet<>();
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
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.garajes = garajesDisponibles;
		this.autos = new HashSet<Auto>();
		this.clientes = new HashSet<Cliente>();
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
		
		Reserva reserva = new Reserva(codReserva, cliente, auto, dias);
        reservas.add(reserva);
        auto.reservar();
        autos.remove(auto);
        auto.getGaraje().disminuirCantidadEspaciosDisponibles();//Hacer test de este
        return reserva;
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
		this.autos.remove(auto);
	}

	private Auto buscarAuto(String patente) {
		return null;
	}

	public boolean cambiarPrecio(String modelo, double nuevoPrecio) {
	    for (Garaje garaje : garajesDisponibles) {
	        for (Auto auto : garaje.getAutos()) {
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

	public boolean cambiarAuto(String patente, Auto autoNuevo) {
	    if (autoNuevo == null) {
	        return false;
	    }

	    // Buscar el auto a reemplazar
	    Auto auto = null;
	    Garaje garaje = null; // nueva línea agregada
	    for (Garaje g : garajes) {
	        for (Auto a : g.getAutos()) {
	            if (a.getPatente().equals(patente)) {
	                auto = a;
	                garaje = g; // asignar el garaje correspondiente
	                break;
	            }
	        }
	        if (auto != null) {
	            break;
	        }
	    }

	    // Si el auto a reemplazar no existe, retornar false
	    if (auto == null) {
	        return false;
	    }

	    // Reemplazar el auto antiguo por el nuevo en la lista de autos del garaje
	    garaje.getAutos().set(garaje.getAutos().indexOf(auto), autoNuevo);

	    // Actualizar la referencia del garaje del nuevo auto
	    autoNuevo.setGaraje(garaje);

	    return true;
	}



	public ArrayList<Auto> buscarAutoPorMarca(String marca) {
	    ArrayList<Auto> autosEncontrados = new ArrayList<Auto>();
	    for (Garaje garaje : garajes) {
	        for (Auto auto : garaje.getAutos()) {
	            if (auto.getMarca().equals(marca)) {
	                autosEncontrados.add(auto);
	            }
	        }
	    }
	    return autosEncontrados;
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

	public List<Auto> mostrarAutosDisponiblesOrdenadosPorPrecio(Date fechaInicio, Date fechaFin) {
	    return garajesDisponibles.stream()
	            .flatMap(garaje -> garaje.getAutosEnElGaraje().stream())
	            .filter(auto -> auto.estaDisponible(fechaInicio, fechaFin))
	            .sorted(Comparator.comparingDouble(Auto::getPrecio))
	            .collect(Collectors.toList());
	}

	public boolean devolverAuto(Auto auto) {
	    Alquiler alquiler = buscarAlquilerPorAuto(auto);
	    if (alquiler == null) {
	        return false;
	    }
	    alquiler.finalizar();
	    Garaje garaje = auto.getGaraje();
	    garaje.actualizarAlquiler(alquiler);
	    // Agregamos el auto a la lista de autos disponibles en el garaje
	    garaje.agregarAutoDisponible(auto);
	    return true;
	}
	public List<Auto> mostrarAutosDisponiblesOrdenadosPorPrecio() {
		return garajesDisponibles.stream()
	            .flatMap(garaje -> garaje.getAutosEnElGaraje().stream())
	            .filter(auto -> auto.estaDisponible(fechaInicio, fechaFin))
	            .sorted(Comparator.comparingDouble(Auto::getPrecio))
	            .collect(Collectors.toList());
	}}

