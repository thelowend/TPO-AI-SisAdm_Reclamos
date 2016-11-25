package Model;

public class Zona {

	// ====================================
	// == Attributes
	// ====================================    
    
	private int Id;
	private String zona;
	
	// ====================================
	// == Constructor(s)
	// ====================================    
    
	public Zona() {
		
    }
    
	public Zona(int id, String zona) {
		this.Id = id;
		this.zona = zona;
	}    

	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================
    
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public String getZona() {
		return this.zona;
	}
}
