package Vistas;

import Model.Reclamo;

public class ReclamoZonaView extends Reclamo {
	private String zona;

	public ReclamoZonaView(){}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getZona() {

		return zona;
	}
}
