package Model;

import java.util.ArrayList;

public class ReclamoCantidades extends Reclamo{
	public ArrayList<DetalleProducto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<DetalleProducto> productos) {
		this.productos = productos;
	}

	private ArrayList<DetalleProducto> productos;
	
	public ReclamoCantidades(){}
}
