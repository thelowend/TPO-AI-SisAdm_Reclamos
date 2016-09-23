package Persistencia;

import Model.*;

import java.sql.*;

/**
 * Created by eladh_000 on 23/9/2016.
 */
public class AdministradorPersistenciaReclamos {
    private static AdministradorPersistenciaReclamos pool;

    public static AdministradorPersistenciaReclamos getInstancia() {
        if (pool == null)
            pool = new AdministradorPersistenciaReclamos();
        return pool;
    }

}
