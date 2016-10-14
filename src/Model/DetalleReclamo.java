package Model;

import java.util.Date;

/**
 * Created by eladh_000 on 13/10/2016.
 */
public class DetalleReclamo {
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

    public DetalleReclamo(Date fechaInicacion, Date fechaCierre, String comentarios) {
        this.fechaInicacion = fechaInicacion;
        this.fechaCierre = fechaCierre;
        this.comentarios = comentarios;
    }

    private String comentarios;
}
