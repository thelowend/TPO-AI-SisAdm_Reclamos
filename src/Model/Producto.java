package Model;

public class Producto {
	private int codigo;
	
	private String titulo;

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	private String descripcion;
	
	private float precio;
	public Producto(){}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Producto(int code, String title, String description, float price){
		this.codigo = code;
		this.titulo = title;
		this.descripcion = description;
		this.precio = price;
	}
}
