package Model;

public class Role extends Entity{
    
	// ====================================
	// == Attributes
	// ====================================    
    
	private String roleName;
    
	// ====================================
	// == Constructor(s)
	// ====================================

   	public Role(int id, String roleName){
		super(id);
		this.roleName = roleName;
	}

	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return this.roleName;
	}

}
