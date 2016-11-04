package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

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
		
		JButton btnTableroDeAdministracin = new JButton("Tableros de Administraci\u00F3n de Reclamos");
		btnTableroDeAdministracin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame subVentana = new Tableros();
				subVentana.setVisible(true);
				subVentana.setLocationRelativeTo(null);
			}
		});
		btnTableroDeAdministracin.setBounds(10, 50, 414, 23);
		panel.add(btnTableroDeAdministracin);
		
		JButton btnRegistroDeReclamos = new JButton("Registro de Reclamos");
		btnRegistroDeReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame subVentana = new Reclamos();
				subVentana.setVisible(true);
				subVentana.setLocationRelativeTo(null);
			}
		});
		btnRegistroDeReclamos.setBounds(10, 84, 414, 23);
		panel.add(btnRegistroDeReclamos);
		
		JButton btnZonaDeReportes = new JButton("Zona de Reportes");
		btnZonaDeReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame subVentana = new Reportes();
				subVentana.setVisible(true);
				subVentana.setLocationRelativeTo(null);
			}
		});
		btnZonaDeReportes.setBounds(10, 118, 414, 23);
		panel.add(btnZonaDeReportes);
		
		JButton btnConfiguracion = new JButton("Configuraci\u00F3n");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame subVentana = new Configuracion();
				subVentana.setVisible(true);
				subVentana.setLocationRelativeTo(null);	
			}
		});
		btnConfiguracion.setBounds(10, 158, 190, 23);
		panel.add(btnConfiguracion);
		
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
