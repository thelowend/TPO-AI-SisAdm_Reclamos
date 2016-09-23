package Model;


import java.util.ArrayList;

public class ReclamoFacturacion extends Reclamo{
	private ArrayList<Factura> facturas; 
	
	
	public ReclamoFacturacion(){
		facturas = new ArrayList<Factura>();
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
}
	
	
