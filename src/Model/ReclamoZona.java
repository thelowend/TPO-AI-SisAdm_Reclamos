package Model;

public class ReclamoZona extends Reclamo {
    
	// ====================================
	// == Attributes
	// ====================================    
	
	private String zona;
	
	// ====================================
	// == Constructor(s)
	// ====================================    
    
	public ReclamoZona() {
    }
    
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getZona() {
		return this.zona;
	}
    
}
