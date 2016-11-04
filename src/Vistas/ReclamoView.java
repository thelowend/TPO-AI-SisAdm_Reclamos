package Vistas;

import Model.Cliente;
import Model.DetalleReclamo;
import Model.EstadoReclamo;

import java.util.HashMap;

public class ReclamoView {

	protected int numeroReclamo;
	protected int clienteId;
	protected String descripcion;
	protected HashMap<EstadoReclamo,DetalleReclamoView> hashReclamos;

	public ReclamoView() {
		hashReclamos = new HashMap<EstadoReclamo,DetalleReclamoView>();
	}
	
	public ReclamoView(int nReclamo, Cliente cliente, String desc, HashMap<EstadoReclamo, DetalleReclamoView> hashMap) {
		this.numeroReclamo = nReclamo;
		this.clienteId = cliente.getClienteId();
		this.descripcion = desc;
		this.hashReclamos = hashMap;
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
