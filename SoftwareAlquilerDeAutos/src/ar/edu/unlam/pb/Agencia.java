package ar.edu.unlam.pb;

import java.util.HashSet;

public class Agencia {

	private String razonSocial;
	private Integer cuit;
	private HashSet<Garaje> garajesDisponibles;
	private HashSet<Auto> registroDeAutos;
	private HashSet<Cliente> listaDeClientes;

	public Agencia(String razonSocial, Integer cuit, HashSet<Garaje> garajesDisponibles) {
		// TODO Auto-generated constructor stub
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.garajesDisponibles = garajesDisponibles;
		this.registroDeAutos = registroDeAutos;
		this.listaDeClientes = listaDeClientes;
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

	public HashSet<Garaje> getGarajesDisponibles() {
		return garajesDisponibles;
	}

	public void setGarajesDisponibles(HashSet<Garaje> garajesDisponibles) {
		this.garajesDisponibles = garajesDisponibles;
	}

	public void agregarGaraje(Garaje garaje) {
		// TODO Auto-generated method stub
		this.garajesDisponibles.add(garaje);
	}

	public void agregarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.listaDeClientes.add(cliente);
	}

	public HashSet<Auto> getRegistroDeAutos() {
		return registroDeAutos;
	}

	public void setRegistroDeAutos(HashSet<Auto> registroDeAutos) {
		registroDeAutos = registroDeAutos;
	}

	public HashSet<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(HashSet<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}

}
