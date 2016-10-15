package Persistencia;
import Model.Cliente;
import java.sql.*;
import java.util.ArrayList;

public class AdministradorPersistenciaCliente {
    private static AdministradorPersistenciaCliente pool;

    public static AdministradorPersistenciaCliente getInstancia() {
        if (pool == null)
            pool = new AdministradorPersistenciaCliente();
        return pool;
    }

    public Cliente getClienteById(int id) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        Cliente cliente = new Cliente();
        try {
            String query = "select * from Clientes where Id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                while (result.next()) {
                    cliente.setClienteId(result.getInt("Id"));
                    cliente.setNombre(result.getString("nombre"));
                    cliente.setTelefono(result.getString("telefono"));
                    cliente.setMail(result.getString("mail"));
                    cliente.setDomicilio(result.getString("domicilio"));
                }
            }
            else
                cliente = null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return cliente;
        }
    }

    public ArrayList<Cliente> listClientes() {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            String query = "select * from Clientes;";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                clientes.add(new Cliente(result.getInt("Id"), result.getString("nombre"),
                result.getString("domicilio"),result.getString("telefono"),result.getString("mail")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return clientes;
        }
    }
}
