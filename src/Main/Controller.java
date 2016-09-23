package Main;
import Model.*;
import Vistas.*;
import Mapper.Mapper;
import Persistencia.AdministradorPersistenciaUsuario;

import java.util.ArrayList;
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
}
