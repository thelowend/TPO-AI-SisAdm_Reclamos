package Model;

public class Role extends Entity{
	private String RoleName;

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public String getRoleName() {
		return RoleName;
	}

	public Role(int id, String roleName){
		super(id);
		this.RoleName = roleName;
	}
}
