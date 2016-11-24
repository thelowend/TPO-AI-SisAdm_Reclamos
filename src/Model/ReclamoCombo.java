package Model;

import java.util.ArrayList;

public class ReclamoCombo extends Reclamo {

	// ====================================
	// == Attributes
	// ====================================
    
    private ArrayList<Reclamo> reclamos; 

	// ====================================
	// == Constructor(s)
	// ====================================
    
	public ReclamoCombo(){
		this.reclamos = new ArrayList<Reclamo>();
	}

	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    
    
	public ArrayList<Reclamo> getReclamos() {
		return this.reclamos;
	}
    
}
