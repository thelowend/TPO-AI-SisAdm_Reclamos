package Model;

public class DetalleProducto {
    
	// ====================================
	// == Attributes
	// ====================================
    
	private Producto producto;
	private int cantidad;
	private int cantidad_pedida;
    
	// ====================================
	// == Constructor(s)
	// ====================================    
    
    public DetalleProducto(){

    }    

    public DetalleProducto(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cantidad_pedida = -1;
    }
    
    public DetalleProducto(Producto producto, int cantidad, int pedida) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cantidad_pedida = pedida;
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
    public int getCantidadPedida() {
        return this.cantidad_pedida;
    }

}
