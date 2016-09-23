package Persistencia;

import Model.Usuario;
import Model.Role;

import java.sql.*;
import java.util.ArrayList;

public class AdministradorPersistenciaUsuario {
    private static AdministradorPersistenciaUsuario pool;

    public static AdministradorPersistenciaUsuario getInstancia() {
        if (pool == null)
            pool = new AdministradorPersistenciaUsuario();
        return pool;
    }

    public Usuario login(String legajo, String clave) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        Usuario usuario = new Usuario();
        try {
            String query = "select  u.id as user_id,* from Roles r INNER JOIN Usuarios_Roles ur on r.Id = ur.role_id Inner Join " +
                    "Usuarios u on u.Id = ur.usuario_id where legajo = ? and clave = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, legajo);
            ps.setString(2, clave);
            ResultSet result = ps.executeQuery();

            if (result.isBeforeFirst()) {
                usuario.setLegajo(legajo);
                usuario.setClave(clave);
                ArrayList<Role> roles = new ArrayList<Role>();
                while (result.next()) {
                    if (usuario.getId() == 0)
                        usuario.setId(result.getInt("user_id"));
                    roles.add(new Role(result.getInt("Id"), result.getString("nombreRole")));
                }
                usuario.setRoles(roles);
            } else
                usuario = null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return usuario;
        }
    }

    public void agregarUsuario(Usuario usuario) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
            String query = "INSERT INTO Usuarios Values (?,?)";
            String query2 = "SELECT * FROM Roles WHERE nombreRole = ?";
            String query3 = "INSERT INTO Usuarios_Roles Values (?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, usuario.getLegajo());
            ps.setString(2, usuario.getClave());
            ps.executeUpdate();
            ResultSet u = ps.getGeneratedKeys();
            u.next();
            int usuarioId = u.getInt(1);

            for (Role role : usuario.getRoles()) {
                ps = null;
                ps = con.prepareStatement(query2);
                ps.setString(1, role.getRoleName());
                ResultSet result = ps.executeQuery();
                if (result.isBeforeFirst()) {
                    result.next();
                    ps = con.prepareStatement(query3);
                    ps.setInt(1, usuarioId);
                    ps.setInt(2, result.getInt("Id"));
                    ps.execute();
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);

        }
    }


    public void modificarUsuario(Usuario usuario) {
        agregarUsuario(usuario);
        borrarUsuario(usuario);
    }

    public void borrarUsuario(Usuario usuario) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
            String query1 = "DELETE Usuarios_Roles WHERE usuario_id = ?";
            String query2 = "DELETE Usuarios WHERE Id = ?";
            PreparedStatement ps = con.prepareStatement(query1);
            ps.setInt(1, usuario.getId());
            ps.execute();
            ps = con.prepareStatement(query2);
            ps.setInt(1, usuario.getId());
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);

        }
    }


    public void agregarRole(Role role) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
            String query = "INSERT INTO Roles Values (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, role.getRoleName());
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);

        }
    }

    public void borrarRole(Role role) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
            String query = "DELETE Roles where Id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, role.getId());
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);

        }
    }

    public ArrayList<Role> listarRoles() {
        ArrayList<Role> roles = new ArrayList<Role>();
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
            String query = "SELECT * FROM Roles";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                roles.add(new Role(result.getInt("Id"),result.getString("nombreRole")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return roles;
        }
    }

    public ArrayList<Usuario> listarUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<Role> roles = new ArrayList<Role>();
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
            String query = "SELECT * FROM Usuarios";
            String query2 = "SELECT * FROM Usuarios_Roles ur INNER JOIN Roles r ON ur.role_id = r.Id  where usuario_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(result.getInt("Id"));
                usuario.setClave(result.getString("clave"));
                usuario.setLegajo(result.getString("legajo"));
                ps = null;
                ps = con.prepareStatement(query2);
                ps.setInt(1,usuario.getId());
                ResultSet result2 = ps.executeQuery();
                while (result2.next()) {
                    usuario.getRoles().add(new Role(result2.getInt("role_id"), result2.getString("nombreRole")));
                }
                usuarios.add(usuario);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return usuarios;
        }
    }
}


