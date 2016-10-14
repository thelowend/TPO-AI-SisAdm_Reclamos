package Vistas;

import java.util.Date;

/**
 * Created by eladh_000 on 13/10/2016.
 */
public class DetalleReclamoView {
    private Date fechaInicacion;
    private Date fechaCierre;

    public void setFechaInicacion(Date fechaInicacion) {
        this.fechaInicacion = fechaInicacion;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getComentarios() {

        return comentarios;
    }

    public Date getFechaInicacion() {
        return fechaInicacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    private String comentarios;
    public DetalleReclamoView(){};
    public DetalleReclamoView(Date fechaInicacion, Date fechaCierre, String comentarios) {
        this.fechaInicacion = fechaInicacion;
        this.fechaCierre = fechaCierre;
        this.comentarios = comentarios;
    }
    public DetalleReclamoView(Date fechaInicacion, String comentarios) {
        this.fechaInicacion = fechaInicacion;
        this.comentarios = comentarios;
    }
}
