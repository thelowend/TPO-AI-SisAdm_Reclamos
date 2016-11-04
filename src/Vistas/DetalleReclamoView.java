package Vistas;

import java.util.Date;

public class DetalleReclamoView {
    private Date fechaInicacion;
    private Date fechaCierre;
    private String comentarios;
    private int responsable_id;
    
    public Date getFechaInicacion() {
        return fechaInicacion;
    }
    
    public void setFechaInicacion(Date fechaInicacion) {
        this.fechaInicacion = fechaInicacion;
    }
    
    public Date getFechaCierre() {
        return fechaCierre;
    }
    
    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    public String getComentarios() {
        return comentarios;
    }
    
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getResponsableId() {
        return responsable_id;
    }
    
    public void setResponsableId(int responsable) {
        this.responsable_id = responsable;
    }

    public DetalleReclamoView(Date fechaInicacion, Date fechaCierre, String comentarios, int responsable) {
        this.fechaInicacion = fechaInicacion;
        this.fechaCierre = fechaCierre;
        this.comentarios = comentarios;
        this.responsable_id = responsable;
    }

}

