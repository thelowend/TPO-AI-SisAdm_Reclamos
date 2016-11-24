package Model;

import java.util.ArrayList;

public class ReclamoCantidades extends Reclamo{

	// ====================================
	// == Attributes
	// ====================================

	private ArrayList<DetalleProducto> productos;    
    
	// ====================================
	// == Constructor(s)
	// ====================================

	public ReclamoCantidades(){
		productos = new ArrayList<DetalleProducto>();
	}
    
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    
    
	public ArrayList<DetalleProducto> getProductos() {
		return this.productos;
	}

	public void setProductos(ArrayList<DetalleProducto> productos) {
		this.productos = productos;
	}
	
}
