package Mapper;
import Model.*;
import Vistas.*;

import java.util.ArrayList;

/**
 * Created by eladh_000 on 21/9/2016.
 */
public class Mapper {
    private static Mapper mapper;

    public static Mapper getMapper(){
        if (mapper == null){
            mapper = new Mapper();
        }
        return mapper;
    }

    public RoleView RoleToRoleView(Role role){
        RoleView roleView = new RoleView(role.getId(),role.getRoleName());
        return roleView;
    }

    public Role RoleViewToRole(RoleView roleView){
        Role role = new Role(roleView.getId(), roleView.getRoleName());
        return role;
    }

    public UsuarioView UsuarioToUsuarioView(Usuario usuario){
        UsuarioView usuarioView = new UsuarioView(usuario.getId());
        ArrayList<RoleView> rolesViews = new ArrayList<RoleView>();
        if(usuario != null) {
            if (usuario.getRoles() != null) {
                for (Role role : usuario.getRoles()) {
                    rolesViews.add(RoleToRoleView(role));
                }
                usuarioView.setRoles(rolesViews);
            }
            usuarioView.setId(usuario.getId());
            usuarioView.setClave(usuario.getClave());
            usuarioView.setLegajo(usuario.getLegajo());
        }
        return usuarioView;
    }

    public Usuario UsuarioViewToUsuario(UsuarioView usuarioView){
        Usuario usuario = new Usuario(usuarioView.getId());
        ArrayList<Role> roles = new ArrayList<Role>();
        if(usuarioView != null) {
            if (usuarioView.getRoles() != null) {
                for (RoleView roleView : usuarioView.getRoles()) {
                    roles.add(RoleViewToRole(roleView));
                }
                usuario.setRoles(roles);
            }
            usuario.setId(usuarioView.getId());
            usuario.setClave(usuarioView.getClave());
            usuario.setLegajo(usuarioView.getLegajo());
        }
        return usuario;
    }
}