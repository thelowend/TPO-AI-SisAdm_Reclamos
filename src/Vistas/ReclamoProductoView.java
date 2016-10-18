package Vistas;

public class ReclamoProductoView extends ReclamoView{
    private DetalleProductoView detalleProducto;

    public void setDetalleProducto(DetalleProductoView detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public DetalleProductoView getDetalleProducto() {

        return detalleProducto;
    }

    public ReclamoProductoView(){

    }

    public ReclamoProductoView(DetalleProductoView detalleProducto){
        this.detalleProducto = detalleProducto;
    }
}
