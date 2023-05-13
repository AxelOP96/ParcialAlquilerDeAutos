package ar.edu.unlam.pb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

public class Auto {

	private String patente;
	private String marca;
	private double precio;
	private Garaje garaje;
	private int anio;
	protected Double precioPorDia;
	private ArrayList<Alquiler> alquileres;
	private String modelo;
	private Boolean estaDisponible;

	public Auto(String patente, String marca, String modelo, int anio, Double precio, Garaje garaje,ArrayList<Alquiler> alquileres, Double precioPorDia) {
	    this.patente = patente;
	    this.modelo = modelo;
	    this.marca = marca;
	    this.precio = precio;
	    this.garaje = garaje;
	    this.setAnio(anio);
	    this.precioPorDia = precioPorDia;
	    this.alquileres = new ArrayList<>();
	    this.anio = anio;
	}

	public Auto() {

	}

	public Auto(String patente, String marca, String modelo, Double precioPorDia, Garaje garaje) {
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
		this.garaje = garaje;
	}
	
	public void reservar() {
        estaDisponible = false;
    }

    public void devolver() {
        estaDisponible = true;
    }

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setPrecioPorDia(Double precioPorDia) {
		this.precioPorDia = precioPorDia;
	}

	public Garaje getGaraje() {
		return garaje;
	}

	public void setGaraje(Garaje garaje) {
		this.garaje = garaje;
	}

	
	public Boolean getEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(Boolean estaDisponoble) {
		this.estaDisponible = estaDisponoble;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}
	
	public String toString() {
		
		return "Coche [patente=" + this.getPatente() + ",marca = " + this.getMarca() + ",modelo=" + this.getModelo()+"]";
	}

	public static boolean contains(Auto auto) {
	    return Auto.contains(auto);
	}

	public void setPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

	 public double getPrecio() {
	        return this.precio;
	    }
	 public boolean estaDisponible(Date fechaInicio, Date fechaFin) {
		    for (Alquiler alquiler : this.alquileres) {
		        if (fechaInicio.before(alquiler.getFechaFin()) && fechaFin.after(alquiler.getFechaInicio())) {
		            return false;
		        }
		    }
		    return true;
		}

	 public double getPrecioPorHora() {
		    // retorna el precio por hora del auto
		    return this.precioPorDia/24;
		}

		public double getPrecioPorDia() {
		    // calcula y retorna el precio por día del auto
		    return this.precioPorDia * 1;
		}

		public static boolean remove(Auto autoAnterior) {
		    if (!Auto.contains(autoAnterior)) {
		        throw new IllegalArgumentException("El auto no se encuentra en la lista de autos de la agencia.");
		    }
		    
		    return Auto.remove(autoAnterior);
		}

		public static Iterator<Auto> iterator(ArrayList<Auto> autos) {
		    if (autos != null) { // Verificar que autos no sea null
		        return autos.iterator();
		    }
		    return Collections.emptyIterator(); // Si autos es null, devolver un iterador vacío
		}

		public int getAnio() {
			return anio;
		}

		public void setAnio(int anio) {
			this.anio = anio;
		}
		
		//Herencia
		public class AutoDeportivo extends Auto {
		    private int caballosDeFuerza;
		    private boolean turbo;

		    public AutoDeportivo(String patente, String marca, String modelo, int anio, double precio, Garaje garaje, 
		    	    ArrayList<Alquiler> alquileres, double precioPorDia, int caballosDeFuerza, boolean turbo) {
		    	    super(patente, marca, modelo, anio, precio, garaje, alquileres, precioPorDia);
		    	    this.caballosDeFuerza = caballosDeFuerza;
		    	    this.turbo = turbo;
		    	    setPrecioPorDia(precioPorDia);
		    	}

		    public int getCaballosDeFuerza() {
		        return caballosDeFuerza;
		    }

		    public void setCaballosDeFuerza(int caballosDeFuerza) {
		        this.caballosDeFuerza = caballosDeFuerza;
		    }

		    public boolean isTurbo() {
		        return turbo;
		    }

		    public void setTurbo(boolean turbo) {
		        this.turbo = turbo;
		    }
		    
		    // Método para establecer el precio por día específico del auto deportivo
		    public void setPrecioPorDia(double precioPorDia) {
		        this.precioPorDia = precioPorDia;
		    }
		    
		    @Override
		    public String toString() {
		        return "AutoDeportivo{" +
		                "patente='" + getPatente() + '\'' +
		                ", marca='" + getMarca() + '\'' +
		                ", modelo='" + getModelo() + '\'' +
		                ", anio=" + getAnio() +
		                ", precio=" + getPrecio() +
		                ", caballosDeFuerza=" + caballosDeFuerza +
		                ", turbo=" + turbo +
		                '}';
		    }
		}

}