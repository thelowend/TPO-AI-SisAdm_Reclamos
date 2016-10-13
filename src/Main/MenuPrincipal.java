package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

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
		setBounds(100, 100, 450, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a, ".concat(usuario));
		lblBienvenidoa.setBounds(10, 11, 264, 14);
		panel.add(lblBienvenidoa);
		
		JButton btnTableroDeAdministracin = new JButton("Tablero de Administraci\u00F3n de Reclamos");
		btnTableroDeAdministracin.setBounds(83, 50, 264, 23);
		panel.add(btnTableroDeAdministracin);
		
		JButton btnRegistroDeReclamos = new JButton("Registro de Reclamos");
		btnRegistroDeReclamos.setBounds(83, 84, 264, 23);
		panel.add(btnRegistroDeReclamos);
		
		JButton btnZonaDeReportes = new JButton("Zona de Reportes");
		btnZonaDeReportes.setBounds(83, 118, 264, 23);
		panel.add(btnZonaDeReportes);
	}
}
