package Main;
import Model.*;
import Persistencia.AdministradorPersistenciaReclamos;
import Vistas.*;
import Mapper.Mapper;
import Persistencia.AdministradorPersistenciaUsuario;
import com.sun.scenario.effect.impl.prism.PrDrawable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Controller {
    private static Controller Sistema;

    public static Controller getInstancia() {
        if(Sistema == null){
            Sistema = new Controller();
        }
        return Sistema;
    }

    public UsuarioView ValidarIngreso(String legajo,String clave){
        Usuario usuario =  AdministradorPersistenciaUsuario.getInstancia().login(legajo,clave);
        return Mapper.getMapper().UsuarioToUsuarioView(usuario);
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

    public Factura getFactura(int numero){
        try {
            return AdministradorPersistenciaReclamos.getInstancia().getFactura(numero);
        }
        catch (Exception ex) {
            throw ex;
        }
    }

    public Producto getProducto(int codigo) {
        try {
            return AdministradorPersistenciaReclamos.getInstancia().getProducto(codigo);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void addReclamo(Reclamo reclamo){
        try {
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
