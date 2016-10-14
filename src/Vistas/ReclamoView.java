package Vistas;

import Model.EstadoReclamo;

import java.util.HashMap;

public class ReclamoView {

	protected int numeroReclamo;
	protected int clienteId;
	protected String descripcion;
	protected HashMap<EstadoReclamo,DetalleReclamoView> hashReclamos;
	public ReclamoView() {

	}

	public int getNumeroReclamo() {
		return numeroReclamo;
	}

	public int getClienteId() {
		return clienteId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setNumeroReclamo(int numeroReclamo) {
		this.numeroReclamo = numeroReclamo;
	}

	public void setCliente(int clienteId) {
		this.clienteId = clienteId;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setHashReclamos(HashMap<EstadoReclamo, DetalleReclamoView> hashReclamos) {
		this.hashReclamos = hashReclamos;
	}

	public HashMap<EstadoReclamo, DetalleReclamoView> getHashReclamos() {

		return hashReclamos;
	}

}
