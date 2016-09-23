package Model;

public class Cliente {
	private int clienteId;
	
	private String nombre;
	
	private String domicilio;

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

		return clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}

	private String telefono;
	
	private String mail;


	public Cliente(){

	}
}
