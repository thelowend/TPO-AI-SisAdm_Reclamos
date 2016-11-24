package Model;

import java.util.Date;
import java.util.HashMap;

public class Reclamo {
    
	// ====================================
	// == Attributes
	// ====================================
    
	protected int numeroReclamo;
	protected Cliente cliente;
	protected String descripcion;
 	protected HashMap<EstadoReclamo,DetalleReclamo> hashReclamos;
    
	// ====================================
	// == Constructor(s)
	// ====================================
    
	public Reclamo(){
		this.hashReclamos = new HashMap<EstadoReclamo,DetalleReclamo>();
	}
    
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    

	public int getNumeroReclamo() {
		return this.numeroReclamo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public String getDescripcion() {
		return this.descripcion;
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
		return this.hashReclamos;
	}
}
