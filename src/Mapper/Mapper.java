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
        RoleView roleView = new RoleView(role.getId(), role.getRoleName());
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
        reclamoZona.setZona(reclamoZonaView.getZona());
        return reclamoZona;
    }

    public ReclamoCantidades ReclamoViewToReclamo(ReclamoCantidadsView reclamoCantidadesView){
        ReclamoCantidades reclamoCantidades = new ReclamoCantidades();
        ReclamoViewToReclamo(reclamoCantidades,reclamoCantidadesView);
        return reclamoCantidades;
    }

    public ReclamoFacturacion ReclamoViewToReclamo(ReclamoFacturacionView reclamoFacturacionView){
        ReclamoFacturacion reclamoFacturacion = new ReclamoFacturacion();
        ReclamoViewToReclamo(reclamoFacturacion,reclamoFacturacionView);
        reclamoFacturacionView.getFacturas().forEach(f -> reclamoFacturacion.getFacturas().add(
                new Factura(f.getNumero(),f.getFecha())));
        return reclamoFacturacion;
    }

    public ReclamoProducto ReclamoViewToReclamo(ReclamoProductoView reclamoProductoView){
        ReclamoProducto reclamoProducto = new ReclamoProducto();
        ReclamoViewToReclamo(reclamoProducto,reclamoProductoView);
        return reclamoProducto;
    }

    private void ReclamoViewToReclamo(Reclamo reclamo, ReclamoView reclamoView) {
        for (EstadoReclamo key : reclamoView.getHashReclamos().keySet()) {
        	DetalleReclamoView drv = reclamoView.getHashReclamos().get(key);
            reclamo.getHashReclamos().put(key, 
            		new DetalleReclamo(
	            		drv.getFechaInicacion(), 
	            		drv.getFechaCierre(), 
	            		drv.getComentarios(),
	                    drv.getResponsableId()
            		)
            );

        }
        reclamo.setDescripcion(reclamoView.getDescripcion());
        reclamo.setNumeroReclamo(reclamoView.getNumeroReclamo());    	
    }
    
    public ReclamoView ReclamoToReclamoView (Reclamo reclamo) {
    	ReclamoView rView = new ReclamoView();
        for (EstadoReclamo key : reclamo.getHashReclamos().keySet()) {
        	DetalleReclamo dr = reclamo.getHashReclamos().get(key);
        	rView.getHashReclamos().put(key, 
            		new DetalleReclamoView(
            				dr.getFechaInicacion(), 
            				dr.getFechaCierre(), 
            				dr.getComentarios(),
            				dr.getResponsableId()
            		)
            );
        	
        }
        
        rView.setCliente(reclamo.getCliente().getClienteId());
        rView.setDescripcion(reclamo.getDescripcion());
        rView.setNumeroReclamo(reclamo.getNumeroReclamo());
		
        return rView;
    }


    public ProductoView ProductoToProductoView(Producto producto) {
        ProductoView productoView = new ProductoView(producto.getCodigo(),producto.getTitulo());
        return productoView;
    }

}
