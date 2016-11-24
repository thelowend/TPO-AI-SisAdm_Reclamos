package Model;

import java.util.ArrayList;

public class Usuario extends Entity {
	
	// ====================================
	// == Attributes
	// ====================================
    
	private ArrayList<Role> roles;
	private String legajo;
	private String clave;
    
    // ====================================
	// == Constructor(s)
	// ====================================

	public Usuario(){
		this.roles = new ArrayList<Role>();
	}

	public Usuario(int id){
		super(id);
		this.roles = new ArrayList<Role>();
	}
    
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public ArrayList<Role> getRoles() {
		return this.roles;
	}

	public String getLegajo() {
		return this.legajo;
	}

	public String getClave() {
		return this.clave;
	}
    
}
