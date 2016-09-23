package Vistas;

import java.util.ArrayList;

public class UsuarioView extends EntityVista{
	
	private ArrayList<RoleView> roles;
	private String legajo;
	private String clave;

	public UsuarioView(){
		super();
		roles = new ArrayList<RoleView>();
	}

	public UsuarioView(int id){
		super(id);
		roles = new ArrayList<RoleView>();
	}

	public void setRoles(ArrayList<RoleView> roles) {
		this.roles = roles;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public ArrayList<RoleView> getRoles() {

		return roles;
	}

	public String getLegajo() {
		return legajo;
	}

	public String getClave() {
		return clave;
	}
}
