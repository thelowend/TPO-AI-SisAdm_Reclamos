package Persistencia;

import Model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by eladh_000 on 15/10/2016.
 */
public class AdministradorPersistenciaProductos {
    
	// ====================================
	// == Attributes
	// ====================================    
    
    private static AdministradorPersistenciaProductos pool;
    
	// ====================================
	// == Constructor(s)
	// ====================================    

    private AdministradorPersistenciaProductos() {
    }
    
    public static AdministradorPersistenciaProductos getInstancia() {
        if (pool == null)
            pool = new AdministradorPersistenciaProductos();
        return pool;
    }

    // ====================================
	// == Execution
	// ====================================    
    
    public Producto getProductoById(int id) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        Producto producto = null;
        try {
            String query = "select * from Productos where codigo = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                producto = new Producto(result.getInt("codigo"),result.getString("titulo"),
                        result.getString("descripcion"),result.getFloat("precio"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return producto;
        }
    }

    public ArrayList<Producto> listProductos() {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        ArrayList<Producto> productos = new ArrayList<Producto>();
        try {
            String query = "select * from Productos";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                productos.add(new Producto(result.getInt("codigo"),result.getString("titulo"),
                        result.getString("descripcion"),result.getFloat("precio")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return productos;
        }
    }
}
