package Model;

import java.util.Date;

public class Factura {

	// ====================================
	// == Attributes
	// ====================================    
    
	private Date fecha;
	private int numero;
	
	// ====================================
	// == Constructor(s)
	// ====================================    
    
	public Factura(){
    }
    
	public Factura(int numero, Date fecha) {
		this.numero = numero;
		this.fecha = fecha;
	}    

	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================
    
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public int getNumero() {
		return this.numero;
	}
}
