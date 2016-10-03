package Main;



import Model.*;
import Persistencia.AdministradorPersistenciaReclamos;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Producto p = Controller.getInstancia().getProducto(1);
					Factura f = Controller.getInstancia().getFactura(1);
					ReclamoCantidades rc = new ReclamoCantidades();
					ArrayList<DetalleProducto> dp = new ArrayList<DetalleProducto>();
					dp.add(new DetalleProducto(p,10));
					rc.setProductos(dp);
					rc.setDescripcion("asdfasdfasf");
					rc.setEstado(EstadoReclamo.Cerrado);
					rc.setFechaCreacion(new Date());
					rc.setCliente(Controller.getInstancia().getClienteByName("elad"));
					Controller.getInstancia().addReclamo(rc);
					ReclamoFacturacion rf = new ReclamoFacturacion();
					ArrayList<Factura> facturas = new ArrayList<Factura>();
					rf.setDescripcion("asdfasdfasf");
					rf.setEstado(EstadoReclamo.Cerrado);
					rf.setFechaCreacion(new Date());
					rf.setCliente(Controller.getInstancia().getClienteByName("elad"));
					facturas.add(AdministradorPersistenciaReclamos.getInstancia().getFactura(1));
					rf.setFacturas(facturas);
					Controller.getInstancia().addReclamo(rf);
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 450, 300);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setContentPane(new Login().getLoginPanel());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
