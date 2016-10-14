package Mapper;
import Model.*;
import Persistencia.AdministradorPersistenciaCliente;
import Vistas.*;

import java.util.ArrayList;
import java.util.HashMap;

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

    public ReclamoZona ReclamoViewToReclamo(ReclamoZonaView reclamoZonaView){
        ReclamoZona reclamoZona = new ReclamoZona();
        ReclamoViewToReclamo(reclamoZona,reclamoZonaView);
        reclamoZona.setCliente(AdministradorPersistenciaCliente.getInstancia().getClienteById(reclamoZonaView.getClienteId()));
        reclamoZona.setZona(reclamoZonaView.getZona());
        return reclamoZona;
    }
    public Cliente ClienteViewToCilente(ClienteView clienteView){
        return AdministradorPersistenciaCliente.getInstancia().getClienteById(clienteView.getClienteId());
    }

    private void ReclamoViewToReclamo(Reclamo reclamo,ReclamoView reclamoView){
        HashMap<EstadoReclamo,DetalleReclamo> hashMapDetalleReclamos = new HashMap<EstadoReclamo,DetalleReclamo>();
        for (EstadoReclamo key : reclamoView.getHashReclamos().keySet()) {
            hashMapDetalleReclamos.put(key,DetalleReclamoViewToDetalle(
                    reclamoView.getHashReclamos().get(key)));
        }
        reclamo.setHashReclamos(hashMapDetalleReclamos);
        reclamo.setDescripcion(reclamoView.getDescripcion());
        reclamo.setNumeroReclamo(reclamoView.getNumeroReclamo());
    }

    private DetalleReclamo DetalleReclamoViewToDetalle(DetalleReclamoView detalleReclamoView){
        DetalleReclamo dr = new DetalleReclamo(detalleReclamoView.getFechaInicacion(),
                detalleReclamoView.getFechaCierre(),detalleReclamoView.getComentarios());
        return dr;
    }
}
