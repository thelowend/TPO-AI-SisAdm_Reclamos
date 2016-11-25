package Vistas;

public class ZonaView {

	// ====================================
	// == Attributes
	// ====================================    
    
	private int Id;
	private String zona;
	
	// ====================================
	// == Constructor(s)
	// ====================================    
    
	public ZonaView() {
		
    }
    
	public ZonaView(int id, String zona) {
		this.Id = id;
		this.zona = zona;
	}    

	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================
	
	public String getZona() {
		return this.zona;
	}
}
