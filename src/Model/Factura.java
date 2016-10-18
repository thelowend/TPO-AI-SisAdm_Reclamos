package Model;

import java.util.Date;


public class Factura {
	
	private Date fecha;
	private int numero;
	
	public Factura(){}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Factura(int numero, Date fecha) {
		this.numero = numero;
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getNumero() {
		return numero;
	}
}
