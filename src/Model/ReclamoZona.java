package Model;

public class ReclamoZona extends Reclamo {
    
	// ====================================
	// == Attributes
	// ====================================    
	
	private int zona;
	
	// ====================================
	// == Constructor(s)
	// ====================================    
    
	public ReclamoZona() {
    }
    
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    

	public void setZona(int zona) {
		this.zona = zona;
	}

	public int getZona() {
		return this.zona;
	}
    
}
