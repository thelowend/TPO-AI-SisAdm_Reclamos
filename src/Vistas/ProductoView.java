package Vistas;

/**
 * Created by eladh_000 on 15/10/2016.
 */
public class ProductoView {
    private int codigo;

    private String titulo;

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public ProductoView(){}

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ProductoView(int code, String title){
        this.codigo = code;
        this.titulo = title;
    }

    public String toString(){
        return titulo;
    }
}
