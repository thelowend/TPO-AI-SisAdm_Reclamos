package Model;

public class ReclamoProducto extends Reclamo {
	private DetalleProducto detalleProducto;

	public void setDetalleProducto(DetalleProducto detalleProducto) {
		this.detalleProducto = detalleProducto;
	}

	public DetalleProducto getDetalleProducto() {

		return detalleProducto;
	}

	public ReclamoProducto(){

	}
	
}
	
	
