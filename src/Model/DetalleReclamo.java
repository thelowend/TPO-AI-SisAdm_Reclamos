package Model;

import java.util.Date;

public class DetalleReclamo {
    
	// ====================================
	// == Attributes
	// ====================================    
    
    private Date fechaInicacion;
    private Date fechaCierre;
    private String comentarios;
    private int responsableId;
    
	// ====================================
	// == Constructor(s)
	// ====================================    
    
    public DetalleReclamo(Date fechaInicacion, Date fechaCierre, String comentarios, int responsable) {
        this.fechaInicacion = fechaInicacion;
        this.fechaCierre = fechaCierre;
        this.comentarios = comentarios;
        this.responsableId = responsable;
    }
    
	// ====================================
	// == Accesors (Getters/Setters)
	// ====================================
    
    public Date getFechaInicacion() {
        return this.fechaInicacion;
    }
    
    public void setFechaInicacion(Date fechaInicacion) {
        this.fechaInicacion = fechaInicacion;
    }
    
    public Date getFechaCierre() {
        return this.fechaCierre;
    }
    
    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    public String getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getResponsableId() {
        return this.responsableId;
    }
    
    public void setResponsableId(int responsable) {
        this.responsableId = responsable;
    }
    
}
