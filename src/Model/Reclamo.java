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
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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

	public float calcularTiempoResolucion(){
		return 1;
	}

}
