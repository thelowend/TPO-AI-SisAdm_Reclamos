package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

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
		setTitle("Tablero de Administración de Reclamos");
		setResizable(false);
		setBounds(100, 100, 470, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(5, 5, 454, 525);
		panel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel1.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(143, 537, 172, 23);
		contentPane.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));
		
		JButton btnCancel = new JButton("Cancelar");
		panel2.add(btnCancel, BorderLayout.CENTER);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JFrame jfTableroAdministracion = new TableroAdministracion();
		JFrame jfTableroConsulta = new TableroConsulta();
		JFrame jfTableroDistribucion = new TableroDistribucion();
		JFrame jfTableroFacturacion = new TableroFacturacion();
		JFrame jfTableroZona = new TableroZona();
		
		tabbedPane.addTab("Administración", jfTableroAdministracion.getContentPane());
		tabbedPane.addTab("Consulta", jfTableroConsulta.getContentPane());
		tabbedPane.addTab("Distribución", jfTableroDistribucion.getContentPane());
		tabbedPane.addTab("Facturación", jfTableroFacturacion.getContentPane());
		tabbedPane.addTab("Zona", jfTableroZona.getContentPane());
		
		this.setSize(450, 490);
	}

}
