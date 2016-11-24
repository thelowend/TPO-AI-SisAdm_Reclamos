package Persistencia;

import Model.Factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by eladh_000 on 15/10/2016.
 */
public class AdministradorPersistenciaFacturas {

    // ====================================
	// == Attributes
	// ====================================
    
    private static AdministradorPersistenciaFacturas pool;
    
	// ====================================
	// == Constructor(s)
	// ====================================    

    private AdministradorPersistenciaFacturas() {
    }
    
    public static AdministradorPersistenciaFacturas getInstancia() {
        if (pool == null)
            pool = new AdministradorPersistenciaFacturas();
        return pool;
    }
    
	// ====================================
	// == Execution
	// ====================================    

    public Factura getFacturaId(int id) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        Factura factura = null;
        try {
            String query = "select * from Facturas where numero = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                factura = new Factura(result.getInt("numero"),result.getDate("fecha"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return factura;
        }
    }

    public ArrayList<Factura> listFacturas() {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        ArrayList<Factura> facturas = new ArrayList<Factura>();
        try {
            String query = "select * from Facturas";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                facturas.add(new Factura(result.getInt("numero"), result.getDate("fecha")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return facturas;
        }
    }

    public ArrayList<Factura> getFacturasByFecha(Date fecha) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        ArrayList<Factura> facturas = new ArrayList<Factura>();
        try {
            String query = "select * from Facturas where CAST(? AS DATE) = CAST(fecha AS DATE)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setTimestamp(1,new java.sql.Timestamp(fecha.getTime()));
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                facturas.add(new Factura(result.getInt("numero"), result.getDate("fecha")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return facturas;
        }
    }
}
