package Vistas;

import java.util.Date;


public class FacturaView {

    private Date fecha;
    private int numero;

    public FacturaView(){}

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public FacturaView(int numero, Date fecha) {
        this.fecha = fecha;
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNumero() {
        return numero;
    }
    
    public String toString(){
        return String.valueOf(numero);
    }
}

