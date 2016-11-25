package Vistas;

/**
 * Created by eladh_000 on 15/10/2016.
 */
public class DetalleProductoView {
    private ProductoView producto;
    private int cantidad;
	private int cantidad_pedida;

    public ProductoView getProducto() {

        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public int getCantidadPedida() {
    	return cantidad_pedida;
    }
    
    public DetalleProductoView(ProductoView producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cantidad_pedida = -1;
    }
    
    public DetalleProductoView(ProductoView producto, int cantidad, int pedida) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.cantidad_pedida = pedida;
    }
    
    public DetalleProductoView(){

    }
}
