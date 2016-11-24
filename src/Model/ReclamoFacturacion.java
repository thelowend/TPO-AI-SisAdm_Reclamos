package Model;

import java.util.ArrayList;

public class ReclamoFacturacion extends Reclamo {

	// ====================================
	// == Attributes
	// ====================================
	
	private ArrayList<Factura> facturas; 
	
	// ====================================
	// == Constructor(s)
	// ====================================    
	
	public ReclamoFacturacion() {
		this.facturas = new ArrayList<Factura>();
	}
    
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    

	public ArrayList<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
    
}
