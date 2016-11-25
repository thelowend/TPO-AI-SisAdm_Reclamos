package Persistencia;

import Model.Zona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by eladh_000 on 15/10/2016.
 */
public class AdministradorPersistenciaZonas {

    // ====================================
	// == Attributes
	// ====================================
    
    private static AdministradorPersistenciaZonas pool;
    
	// ====================================
	// == Constructor(s)
	// ====================================    

    private AdministradorPersistenciaZonas() {
    }
    
    public static AdministradorPersistenciaZonas getInstancia() {
        if (pool == null)
            pool = new AdministradorPersistenciaZonas();
        return pool;
    }
    
	// ====================================
	// == Execution
	// ====================================    

    public ArrayList<Zona> listZonas(int zona) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        ArrayList<Zona> zonas = new ArrayList<Zona>();
        String query;
        try {
        	PreparedStatement ps = null;
        	if (zona == -1) {
        		query = "select * from Zonas";
        		ps = con.prepareStatement(query);
        	} else {
        		query = "select * from Zonas where Id = ?";
        		ps = con.prepareStatement(query);
        		ps.setInt(1, zona);
        	}

            ResultSet result = ps.executeQuery();
            while (result.next()) {
            	zonas.add(new Zona(result.getInt(1), result.getString("zona")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return zonas;
        }
    }
}
