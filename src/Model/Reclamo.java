package Model;

import java.util.Date;
import java.util.HashMap;

public class Reclamo {
	protected int numeroReclamo;
	protected Cliente cliente;
	protected String descripcion;
 	protected HashMap<EstadoReclamo,DetalleReclamo> hashReclamos;
	public Reclamo(){
		hashReclamos = new HashMap<EstadoReclamo,DetalleReclamo>();
	}

	public int getNumeroReclamo() {
		return numeroReclamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setNumeroReclamo(int numeroReclamo) {
		this.numeroReclamo = numeroReclamo;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setHashReclamos(HashMap<EstadoReclamo, DetalleReclamo> hashReclamos) {
		this.hashReclamos = hashReclamos;
	}

	public HashMap<EstadoReclamo, DetalleReclamo> getHashReclamos() {
		return hashReclamos;
	}
}
