package Model;

public class ReclamoProducto extends Reclamo {
    
	// ====================================
	// == Attributes
	// ====================================    
    
	private DetalleProducto detalleProducto;
    
	// ====================================
	// == Constructor(s)
	// ====================================    

	public ReclamoProducto() {

	}
    
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    
    
	public void setDetalleProducto(DetalleProducto detalleProducto) {
		this.detalleProducto = detalleProducto;
	}

	public DetalleProducto getDetalleProducto() {
		return this.detalleProducto;
	}
	
}
