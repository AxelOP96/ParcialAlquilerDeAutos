package ar.edu.unlam.pb;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Auto {

	private String patente;
	private String modelo;
	private String marca;
	private double precio;
	private Garaje garaje;
	private int anio;
	private Integer precioPorDia;
	private ArrayList<Alquiler> alquileres;

	public Auto(String patente, String marca, String modelo, int anio, double precio, Garaje garaje, Integer precioPorDia,ArrayList<Alquiler> alquileres) {
	    this.patente = patente;
	    this.modelo = modelo;
	    this.marca = marca;
	    this.precio = precio;
	    this.garaje = garaje;
	    this.anio = anio;
	    this.precioPorDia = precioPorDia;
	    this.alquileres = new ArrayList<Alquiler>();

	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Auto [patente=" + patente + ", modelo=" + modelo + ", marca=" + marca + "]";
	}

	public boolean contains(Auto auto) {
	    return auto.contains(auto);
	}

	public void setPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

	public Garaje getGaraje() {
        return garaje;
    }
	
	public void setGaraje(Garaje garaje) {
	        this.garaje = garaje;
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
		    return this.precioPorDia;
		}

		public double getPrecioPorDia() {
		    // calcula y retorna el precio por día del auto
		    return this.precioPorDia * 1;
		}
}