package Model;

public class Producto {
    
	// ====================================
	// == Attributes
	// ====================================    
    
	private int codigo;
	private String titulo;
	private String descripcion;
    private float precio;

	// ====================================
	// == Constructor(s)
	// ====================================	
	
    public Producto(){
    }
    
	public Producto(int code, String title, String description, float price){
		this.codigo = code;
		this.titulo = title;
		this.descripcion = description;
		this.precio = price;
	}    
	
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================    
    
	public int getCodigo() {
		return this.codigo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public float getPrecio() {
		return this.precio;
	}

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

}
