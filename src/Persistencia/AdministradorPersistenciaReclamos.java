package Persistencia;

import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class AdministradorPersistenciaReclamos {
    private static AdministradorPersistenciaReclamos pool;

    public static AdministradorPersistenciaReclamos getInstancia() {
        if (pool == null)
            pool = new AdministradorPersistenciaReclamos();
        return pool;
    }

    public void agregarReclamo(Reclamo reclamo,int id) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
            String query = "INSERT INTO Reclamos Values (?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            if (id != 0)
                ps.setInt(1,id);
            else
                ps.setObject(1,null);
            ps.setString(2,reclamo.getClass().getSimpleName());
            ps.setString(3,reclamo.getDescripcion());
            ps.setInt(4,reclamo.getCliente().getClienteId());
            ps.setObject(5,null);
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            if (result.next()) {
                int reclamo_id = id != 0 ? id : result.getInt(1);
                reclamo.setNumeroReclamo(reclamo_id);
                if(reclamo.getClass().getSimpleName().compareTo("ReclamoCombo") == 0){
                    for(Reclamo r : ((ReclamoCombo)reclamo).getReclamos()) {
                        agregarDetallesReclamos(reclamo);
                        agregarReclamo(r, reclamo_id);
                    }
                }
                else {
                    agregarDetallesReclamos(reclamo);
                    insertReclamoByType(con, reclamo);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
        }
    }

    private void insertReclamoByType(Connection con,Reclamo reclamo){
        try {
            String query2 = "INSERT INTO Reclamos_Productos VALUES (?,?,?)";
            String query3 = "INSERT INTO Reclamos_Facturas VALUES (?,?)";
            String query4 = "UPDATE Reclamos SET zona = ? where Id = ?";
            PreparedStatement ps;
            String reclamoName = reclamo.getClass().getSimpleName();
            switch (reclamoName) {
                case "ReclamoProducto":
                    ps = con.prepareStatement(query2);
                    ps.setInt(1, ((ReclamoProducto) reclamo).getDetalleProducto().getCantidad());
                    ps.setInt(2, reclamo.getNumeroReclamo());
                    ps.setInt(3, ((ReclamoProducto) reclamo).getDetalleProducto().getProducto().getCodigo());
                    ps.execute();
                    break;
                case "ReclamoCantidades":
                    for (DetalleProducto detalleProducto : ((ReclamoCantidades) reclamo).getProductos()) {
                        ps = con.prepareStatement(query2);
                        ps.setInt(1, detalleProducto.getCantidad());
                        ps.setInt(2, reclamo.getNumeroReclamo());
                        ps.setInt(3, detalleProducto.getProducto().getCodigo());
                        ps.execute();
                    }
                    break;
                case "ReclamoFacturacion":
                    for (Factura factura : ((ReclamoFacturacion) reclamo).getFacturas()) {
                        ps = con.prepareStatement(query3);
                        ps.setInt(1, reclamo.getNumeroReclamo());
                        ps.setInt(2, factura.getNumero());
                        ps.execute();
                    }
                    break;
                case "ReclamoZona":
                    ps = con.prepareStatement(query4);
                    ps.setString(1, ((ReclamoZona) reclamo).getZona());
                    ps.setInt(2, reclamo.getNumeroReclamo());
                    ps.execute();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //TODO
    public void cambiarEstadoReclamo(Reclamo reclamo,EstadoReclamo estado) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
                String query;
                if (reclamo.getClass().getSimpleName() == "ReclamoCombo")
                    query = "Update Reclamos Set estado = ? where combo_id = ?";
                else
                    query = "Update Reclamos Set estado = ? where Id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1,estado.ordinal());
                ps.setInt(2,reclamo.getNumeroReclamo());
                ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);

        }
    }

    public void borrarReclamo(Reclamo reclamo) {
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
            String query = "Delete Reclamos_Productos where reclamo_id = ?";
            String query2 = "Delete Reclamos_Facturas where reclamo_id = ?";
            String query3 = "Delete Reclamos where Id = ?";
            String query4 = "Delete DetalleReclamos where reclamo_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, reclamo.getNumeroReclamo());
            ps.execute();
            ps = con.prepareStatement(query2);
            ps.setInt(1, reclamo.getNumeroReclamo());
            ps.execute();
            ps = con.prepareStatement(query3);
            ps.setInt(1, reclamo.getNumeroReclamo());
            ps.execute();
            ps = con.prepareStatement(query4);
            ps.setInt(1, reclamo.getNumeroReclamo());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);

        }
    }

    public ArrayList<Reclamo> listarReclamos(String tipoDeReclamo){
        ArrayList<Reclamo> reclamos = new ArrayList<Reclamo>();
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try {
            String tipoReclamo;
            String query = "";
            PreparedStatement ps;
            ResultSet result2;
            if (tipoDeReclamo == null) {
                query = "SELECT r.Id as reclamo_id,* FROM Reclamos r INNER JOIN Clientes c on r.cliente_id = c.Id where r.combo_id IS NULL ";
                ps = con.prepareStatement(query);
            } else {
                query = "SELECT r.Id as reclamo_id,* FROM Reclamos r INNER JOIN Clientes c on r.cliente_id = c.Id  where tipoReclamo = ?" +
                "And r.combo_id IS NULL";
                ps = con.prepareStatement(query);
                ps.setString(1, tipoDeReclamo);
            }
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                reclamos.add(getReclamobyId(result.getInt("Id")));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally
        {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return reclamos;
        }
    }

    public Reclamo getReclamobyId(int reclamoId){
        Connection con = PoolConnection.getPoolConnection().getConnection();
        Reclamo r = new Reclamo();
        try {
            String tipoReclamo;
            String query = "";
            PreparedStatement ps;
            ResultSet result2;
            query = "SELECT r.Id as reclamo_id,* FROM Reclamos r INNER JOIN Clientes c on r.cliente_id = c.Id where r.Id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, reclamoId);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                tipoReclamo = result.getString("tipoReclamo");
                switch (tipoReclamo) {
                    case "ReclamoFacturacion":
                        String query2 = "SELECT * FROM Facturas f INNER JOIN Reclamos_Facturas rf on f.numero = rf.factura_id where rf.reclamo_id = ?";
                        ps = con.prepareStatement(query2);
                        ps.setInt(1, result.getInt("reclamo_id"));
                        result2 = ps.executeQuery();
                        ArrayList<Factura> facturas = new ArrayList<Factura>();
                        while (result2.next()) {
                            facturas.add(new Factura(result2.getInt("numero"), result2.getDate("fecha")));
                        }
                        ReclamoFacturacion reclamoFacturacion = new ReclamoFacturacion();
                        setCamposBasicos(result,reclamoFacturacion);
                        reclamoFacturacion.setFacturas(facturas);
                        r = reclamoFacturacion;
                        break;
                    case "ReclamoCantidades":
                    case "ReclamoProducto":
                        String query3 = "SELECT * FROM Productos p INNER JOIN Reclamos_Productos rp on p.codigo = rp.producto_id where rp.reclamo_id = ?";
                        ps = con.prepareStatement(query3);
                        ps.setInt(1, result.getInt("reclamo_id"));
                        result2 = ps.executeQuery();
                        ArrayList<DetalleProducto> detalleProductos = new ArrayList<DetalleProducto>();
                        while (result2.next()) {
                            detalleProductos.add(new DetalleProducto(new Producto(result2.getInt("codigo"), result2.getString("titulo")
                                    , result2.getString("descripcion"), result2.getFloat("precio")), result2.getInt("cantidad")));
                        }
                        if (tipoReclamo.compareTo("ReclamoCantidades") == 0) {
                            ReclamoCantidades reclamoP = new ReclamoCantidades();
                            setCamposBasicos(result,reclamoP);
                            reclamoP.setProductos(detalleProductos);
                            r = reclamoP;
                        }
                        else{
                            ReclamoProducto reclamoP = new ReclamoProducto();
                            setCamposBasicos(result,reclamoP);
                            reclamoP.setDetalleProducto(detalleProductos.get(0));
                            r = reclamoP;
                        }
                        break;
                    case "ReclamoZona":
                        ReclamoZona reclamoZona = new ReclamoZona();
                        setCamposBasicos(result,reclamoZona);
                        reclamoZona.setZona(result.getString("zona"));
                        r = reclamoZona;
                        break;
                    case "ReclamoCombo":
                        ReclamoCombo reclamoCombo = new ReclamoCombo();
                        setCamposBasicos(result,reclamoCombo);
                        String query4 = "Select * from Reclamos where combo_id = ?";
                        ps = con.prepareStatement(query4);
                        ps.setInt(1, reclamoCombo.getNumeroReclamo());
                        result2 = ps.executeQuery();
                        while(result2.next()) {
                            reclamoCombo.getReclamos().add(getReclamobyId(result2.getInt("Id")));
                        }
                        r = reclamoCombo;
                        break;
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally
        {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return r;
        }
    }


    private void setCamposBasicos(ResultSet result,Reclamo reclamo) {
        try {
            Cliente cliente = new Cliente();
            cliente.setClienteId(result.getInt("cliente_id"));
            cliente.setDomicilio(result.getString("domicilio"));
            cliente.setMail(result.getString("mail"));
            cliente.setNombre(result.getString("nombre"));
            cliente.setTelefono(result.getString("telefono"));
            reclamo.setCliente(cliente);
            reclamo.setDescripcion(result.getString("descripcion"));
            reclamo.setNumeroReclamo(result.getInt("reclamo_id"));
            setDetallesReclamos(reclamo);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void agregarDetallesReclamos(Reclamo reclamo){
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try{
            String query = "Insert Into DetalleReclamos Values (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,reclamo.getNumeroReclamo());
            for (EstadoReclamo key : reclamo.getHashReclamos().keySet()) {
                ps.setInt(2, key.ordinal());
                ps.setTimestamp(3, new java.sql.Timestamp(reclamo.getHashReclamos().get(key).getFechaInicacion().getTime()));
                if(reclamo.getHashReclamos().get(key).getFechaCierre() != null)
                    ps.setTimestamp(4, new java.sql.Timestamp(reclamo.getHashReclamos().get(key).getFechaCierre().getTime()));
                else
                    ps.setNull(4,java.sql.Types.TIMESTAMP);
                ps.setString(5,reclamo.getHashReclamos().get(key).getComentarios());
                ps.execute();
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setDetallesReclamos(Reclamo reclamo){
        Connection con = PoolConnection.getPoolConnection().getConnection();
        try{
            HashMap<EstadoReclamo,DetalleReclamo> hashMapDetalleReclamos = new HashMap<EstadoReclamo,DetalleReclamo>();
            String query = "Select * From DetalleReclamos where reclamo_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,reclamo.getNumeroReclamo());
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    hashMapDetalleReclamos.put(EstadoReclamo.values()[resultSet.getInt("estado")],
                            new DetalleReclamo(resultSet.getDate("fechaInicio"), resultSet.getDate("fechaFin"),
                                    resultSet.getString("comentrio")));
                }
                reclamo.setHashReclamos(hashMapDetalleReclamos);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public Producto getProducto(int codigo){
        Connection con = PoolConnection.getPoolConnection().getConnection();
        Producto producto = new Producto();
        try {
            String query = "SELECT * from Productos where codigo = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,codigo);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                producto.setCodigo(result.getInt("codigo"));
                producto.setDescripcion(result.getString("descripcion"));
                producto.setPrecio(result.getFloat("precio"));
                producto.setTitulo(result.getString("titulo"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            producto = null;
        } finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return producto;
        }
    }

    public Factura getFactura(int numero){
        Connection con = PoolConnection.getPoolConnection().getConnection();
        Factura factura = new Factura();
        try {
            String query = "SELECT * from Facturas where numero = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,numero);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                factura.setNumero(result.getInt("numero"));
                factura.setFecha(result.getDate("fecha"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            factura = null;
        }
        finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return factura;
        }
    }

    public Cliente getClienteByName(String nombre){
        Connection con = PoolConnection.getPoolConnection().getConnection();
        Cliente cliente = new Cliente();
        try {
            String query = "SELECT * from Clientes where nombre = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,nombre);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                cliente.setClienteId(result.getInt("Id"));
                cliente.setNombre(result.getString("nombre"));
                cliente.setDomicilio(result.getString("domicilio"));
                cliente.setMail(result.getString("mail"));
                cliente.setTelefono(result.getString("telefono"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            cliente = null;
        }
        finally {
            PoolConnection.getPoolConnection().realeaseConnection(con);
            return cliente;
        }
    }
}


