package Vistas;

import Model.DetalleProducto;
import Model.Producto;

import java.util.ArrayList;

/**
 * Created by eladh_000 on 15/10/2016.
 */
public class ReclamoCantidadsView extends ReclamoView {
    private ArrayList<DetalleProductoView> detalleProductoViews;
    public ArrayList<DetalleProductoView> getProductos() {
        return detalleProductoViews;
    }
    public void setProductos(ArrayList<DetalleProductoView> productos) {
        this.detalleProductoViews = productos;
    }
    public ReclamoCantidadsView(){
        super();
        detalleProductoViews = new ArrayList<DetalleProductoView>();
    }
}
