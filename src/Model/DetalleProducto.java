package Model;

public class DetalleProducto {

    public DetalleProducto(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {

        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    private Producto producto;
    private int cantidad;

    public DetalleProducto(){

    }

}

