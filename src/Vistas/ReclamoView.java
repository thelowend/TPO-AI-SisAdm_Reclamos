package Vistas;

import Model.EstadoReclamo;

import java.util.Date;

public class ReclamoView {

	protected Date fechaCreacion;
	protected int numeroReclamo;
	protected Date fechaCierre;
	protected int clienteId;
	protected String descripcion;
	protected EstadoReclamo estado;

	public ReclamoView(){

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

	public int getClienteId() {
		return clienteId;
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

	public void setCliente(int clienteId) {
		this.clienteId = clienteId;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEstado(EstadoReclamo estado) {
		this.estado = estado;
	}
}
