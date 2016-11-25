package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Controller;
import Vistas.RoleView;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	JButton btnTableroDeAdministracin;
	JButton btnRegistroDeReclamos;
	JButton btnZonaDeReportes;
	JButton btnConfiguracion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal(String usuario) {
		setResizable(false);
		setTitle("Sistema de Administraci\u00F3n de Reclamos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JFrame frame = this;
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a, ".concat(usuario));
		lblBienvenidoa.setBounds(10, 11, 264, 14);
		panel.add(lblBienvenidoa);
		
		btnTableroDeAdministracin = new JButton("Tableros de Administraci\u00F3n de Reclamos");
		btnTableroDeAdministracin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame subVentana = new Tableros();
				subVentana.setVisible(true);
				subVentana.setLocationRelativeTo(null);
			}
		});
		btnTableroDeAdministracin.setBounds(10, 50, 414, 23);
		
		JButton btnRegistroDeReclamos = new JButton("Registro de Reclamos");
		btnRegistroDeReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame subVentana = new Reclamos();
				subVentana.setVisible(true);
				subVentana.setLocationRelativeTo(null);
			}
		});
		btnRegistroDeReclamos.setBounds(10, 84, 414, 23);
		
		btnZonaDeReportes = new JButton("Zona de Reportes");
		btnZonaDeReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame subVentana = new Reportes();
				subVentana.setVisible(true);
				subVentana.setLocationRelativeTo(null);
			}
		});
		btnZonaDeReportes.setBounds(10, 118, 414, 23);
		
		btnConfiguracion = new JButton("Configuraci\u00F3n");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame subVentana = new Configuracion();
				subVentana.setVisible(true);
				subVentana.setLocationRelativeTo(null);	
			}
		});
		btnConfiguracion.setBounds(10, 158, 190, 23);
		

		
		ArrayList<RoleView> roles = Controller.getInstancia().getSesion().getRoles();
		
		if (roles.stream().filter(role -> role.getRoleName().compareTo("Administrador") == 0).count() > 0) {
			panel.add(btnConfiguracion);
		}
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("Facturacion") == 0).count() > 0) {
			panel.add(btnTableroDeAdministracin);
		}
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("Distribucion") == 0).count() > 0) {
			panel.add(btnTableroDeAdministracin);
		}
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("Entrega") == 0).count() > 0) {
			panel.add(btnTableroDeAdministracin);
		}
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("CallCenter") == 0).count() > 0) {
			panel.add(btnRegistroDeReclamos);
		}
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("Consulta") == 0).count() > 0) {
			panel.add(btnTableroDeAdministracin);
			panel.add(btnZonaDeReportes);
		}
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnSalir.setBounds(234, 158, 190, 23);
		panel.add(btnSalir);
	}
}
