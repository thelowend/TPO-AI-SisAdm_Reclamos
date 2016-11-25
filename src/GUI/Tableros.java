package GUI;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import Main.Controller;
import Vistas.RoleView;

@SuppressWarnings("serial")
public class Tableros extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tableros frame = new Tableros();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	public Tableros() {
		JFrame frame = this;
		setTitle("Tablero de Administración");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(5, 5, 450, 550);
		panel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 450, 550);
		panel1.add(tabbedPane);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(5, 570, 450, 40);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(133, 11, 172, 23);
		panel2.add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		ArrayList<RoleView> roles = Controller.getInstancia().getSesion().getRoles();
		
		if (roles.stream().filter(role -> role.getRoleName().compareTo("Administrador") == 0).count() > 0) {
			frame.dispose();
		}
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("Facturacion") == 0).count() > 0) {
			JFrame jfTableroFacturacion = new TableroFacturacion();
			tabbedPane.addTab("Facturación", jfTableroFacturacion.getContentPane());
		}
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("Distribucion") == 0).count() > 0) {
			JFrame jfTableroCantidades = new TableroCantidades();
			JFrame jfTableroFaltantes = new TableroFaltantes();
			JFrame jfTableroProductos = new TableroProductos();
			JFrame jfTableroZona = new TableroZona();
			tabbedPane.addTab("Cantidades", jfTableroCantidades.getContentPane());
			tabbedPane.addTab("Faltantes", jfTableroFaltantes.getContentPane());
			tabbedPane.addTab("Productos", jfTableroProductos.getContentPane());
			tabbedPane.addTab("Zona", jfTableroZona.getContentPane());
		}
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("Entrega") == 0).count() > 0) {
			JFrame jfTableroZona = new TableroZona();
			tabbedPane.addTab("Zona", jfTableroZona.getContentPane());
		}
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("CallCenter") == 0).count() > 0) {
			frame.dispose();
		} 
		else if (roles.stream().filter(role -> role.getRoleName().compareTo("Consulta") == 0).count() > 0) {
			JFrame jfTableroCantidades = new TableroCantidades();
			JFrame jfTableroFacturacion = new TableroFacturacion();
			JFrame jfTableroFaltantes = new TableroFaltantes();
			JFrame jfTableroProductos = new TableroProductos();
			JFrame jfTableroZona = new TableroZona();
			tabbedPane.addTab("Cantidades", jfTableroCantidades.getContentPane());
			tabbedPane.addTab("Facturación", jfTableroFacturacion.getContentPane());
			tabbedPane.addTab("Faltantes", jfTableroFaltantes.getContentPane());
			tabbedPane.addTab("Productos", jfTableroProductos.getContentPane());
			tabbedPane.addTab("Zona", jfTableroZona.getContentPane());
		} 
		else {
			frame.dispose();
		}

		
		this.setSize(465, 650);
	}

}
