package Main;
import Model.*;
import Persistencia.*;
import Vistas.*;
import Mapper.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private static Controller Sistema;
    private ArrayList<Producto> productos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Factura> facturas;

    public static Controller getInstancia() {
        if (Sistema == null) {
            Sistema = new Controller();
        }
        return Sistema;
    }

    private Controller(){
        productos = AdministradorPersistenciaProductos.getInstancia().listProductos();
        facturas = new ArrayList<Factura>();
        clientes = new ArrayList<Cliente>();
    }

    private Cliente buscarCliente(int clienteId){
        Cliente c = clientes.stream().filter(cl -> cl.getClienteId() == clienteId).findFirst().orElse(null);
        if (c!=null){
            return c;
        }
        else {
            c = AdministradorPersistenciaCliente.getInstancia().getClienteById(clienteId);
            if (c!=null){
                clientes.add(c);
                return c;
            }
        }
        return null;
    }

    private Factura buscarFactura(int numero){
        Factura f = facturas.stream().filter(fc -> fc.getNumero() == numero).findFirst().get();
        if (f!=null){
            return f;
        }
        else {
            f = AdministradorPersistenciaFacturas.getInstancia().getFacturaId(numero);
            if (f!=null){
                facturas.add(f);
                return f;
            }
        }
        return null;
    }

    private Producto buscarProducto(int codigo){
        Producto p = productos.stream().filter(pr -> pr.getCodigo() == codigo).findFirst().get();
        return p;
    }

    public ArrayList<ProductoView> listProductos(){
        ArrayList<ProductoView> productoViews = new ArrayList<ProductoView>();
        productos.stream().forEach(p -> productoViews.add(Mapper.getMapper().ProductoToProductoView(p)));
        return productoViews;
    }

    public UsuarioView ValidarIngreso(String legajo, String clave) {
    	try {
    		Usuario usuario =  AdministradorPersistenciaUsuario.getInstancia().login(legajo,clave);
    		return Mapper.getMapper().UsuarioToUsuarioView(usuario);
    	} catch (Exception ex) {
            throw ex;
        }
    }

    public void addUsuario(UsuarioView usuarioView) {
        try {
            AdministradorPersistenciaUsuario.getInstancia().agregarUsuario(Mapper.getMapper().UsuarioViewToUsuario(usuarioView));

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void updateUsuario(UsuarioView usuarioView) {
        try {
            AdministradorPersistenciaUsuario.getInstancia().modificarUsuario(Mapper.getMapper().UsuarioViewToUsuario(usuarioView));

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void deleteUsuario(UsuarioView usuarioView) {
        try {
            AdministradorPersistenciaUsuario.getInstancia().borrarUsuario(Mapper.getMapper().UsuarioViewToUsuario(usuarioView));

        } catch (Exception ex) {
            throw ex;
        }
    }

    public ArrayList<UsuarioView> listUsuarios(){
        try {
            ArrayList<UsuarioView> usuariosViews = new ArrayList<UsuarioView>();
            for(Usuario usuario : AdministradorPersistenciaUsuario.getInstancia().listarUsuarios()){
                usuariosViews.add(Mapper.getMapper().UsuarioToUsuarioView(usuario));
            }
            return usuariosViews;
        }
        catch (Exception ex){
            throw ex;
        }
    }

    public ArrayList<RoleView> listRoles(){
        try {
            ArrayList<RoleView> rolesViews = new ArrayList<RoleView>();
            for(Role role : AdministradorPersistenciaUsuario.getInstancia().listarRoles()){
                rolesViews.add(Mapper.getMapper().RoleToRoleView(role));
            }
            return rolesViews;
        }
        catch (Exception ex){
            throw ex;
        }
    }

    public void addReclamo(ReclamoZonaView reclamoView){
        try {
            ReclamoZona reclamo = Mapper.getMapper().ReclamoViewToReclamo(reclamoView);
            reclamo.setCliente(buscarCliente(reclamoView.getClienteId()));
            AdministradorPersistenciaReclamos.getInstancia().agregarReclamo(reclamo,0);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void addReclamo(ReclamoCantidadsView reclamoView){
        try {
            ReclamoCantidades reclamo = Mapper.getMapper().ReclamoViewToReclamo(reclamoView);
            reclamo.setCliente(buscarCliente(reclamoView.getClienteId()));
            reclamoView.getProductos().stream().forEach(dp -> reclamo.getProductos().add(
                    new DetalleProducto(buscarProducto(dp.getProducto().getCodigo()),dp.getCantidad())));
            AdministradorPersistenciaReclamos.getInstancia().agregarReclamo(reclamo,0);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Cliente getClienteByName(String nombre){
        try {
            return AdministradorPersistenciaReclamos.getInstancia().getClienteByName(nombre);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Reclamo> listReclamos(){
        try {
            return AdministradorPersistenciaReclamos.getInstancia().listarReclamos(null);
        } catch (Exception ex) {
            throw ex;
        }
    }


}
