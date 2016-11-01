package Vistas;

public class RoleView extends EntityVista{
	private String RoleName;

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public String getRoleName() {

		return RoleName;
	}

	public RoleView(int id,String roleName){
		super(id);
		this.RoleName = roleName;
	}

	public RoleView(String roleName){
		super();
		this.RoleName = roleName;
	}

	public String toString(){
		return RoleName;
	}
}
