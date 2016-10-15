package Vistas;

/**
 * Created by eladh_000 on 15/10/2016.
 */
public class DetalleProductoView {
    private ProductoView producto;
    private int cantidad;

    public ProductoView getProducto() {

        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public DetalleProductoView(ProductoView producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public DetalleProductoView(){

    }
}
