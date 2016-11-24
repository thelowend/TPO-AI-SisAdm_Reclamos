package Model;

public class Cliente {
	
	// ====================================
	// == Attributes
	// ====================================
	
	private int clienteId;
	private String nombre;
	private String domicilio;
	private String telefono;
	private String mail;

	// ====================================
	// == Constructor(s)
	// ====================================
	
	public Cliente(){

	}	
	
	public Cliente(int clienteId, String nombre, String domicilio, String telefono, String mail) {
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================	

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getClienteId() {
		return this.clienteId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public String getMail() {
		return this.mail;
	}

}
