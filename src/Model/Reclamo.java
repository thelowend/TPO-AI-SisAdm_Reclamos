package Model;

import java.util.Date;

public class Reclamo {

	protected Date fechaCreacion;
	protected int numeroReclamo;
	protected Date fechaCierre;
	protected Cliente cliente;
	protected String descripcion;
	protected EstadoReclamo estado;

	public Reclamo(){

	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public int getNumeroReclamo() {
		return numeroReclamo;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public EstadoReclamo getEstado() {
		return estado;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setNumeroReclamo(int numeroReclamo) {
		this.numeroReclamo = numeroReclamo;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEstado(EstadoReclamo estado) {
		this.estado = estado;
	}
}
