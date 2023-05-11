package ar.edu.unlam.pb;

import java.sql.Date;
import java.util.*;//Aqui se incluye arrayList, hashSet, treeSet,linckedList,etc.
//import java.util.List;

public class Auto {

	private String patente;
	private String marca;
	private double precio;
	private Garaje garaje;
	private int anio;
	private Double precioPorDia;
	private ArrayList<Alquiler> alquileres;
	private String modelo;
	private Boolean estaDisponible;

	public Auto(String patente, String marca, String modelo, int anio, Double precio, Garaje garaje,ArrayList<Alquiler> alquileres) {
	    this.patente = patente;
	    this.modelo = modelo;
	    this.marca = marca;
	    this.precio = precio;
	    this.garaje = garaje;
	    this.anio = anio;
	    this.precioPorDia = precioPorDia;
	    this.alquileres = new ArrayList<>();
	}
	
	public Auto(String patente, String marca, String modelo, Double precioPorDia) {
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.precioPorDia = precioPorDia;
		this.estaDisponible = true;

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

	public boolean contains(Auto auto) {
	    return auto.contains(auto);
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
}