package Model;

public class DetalleProducto {
    
	// ====================================
	// == Attributes
	// ====================================
    
    private Producto producto;
    private int cantidad;    
    
	// ====================================
	// == Constructor(s)
	// ====================================    
    
    public DetalleProducto(){

    }    

    public DetalleProducto(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    

    public Producto getProducto() {
        return this.producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

}

