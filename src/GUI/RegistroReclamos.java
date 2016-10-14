package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class RegistroReclamos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroReclamos frame = new RegistroReclamos();
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
	public RegistroReclamos() {
		JFrame frame = this;
		setTitle("Registro de Reclamos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		
		
		JFrame jfCantidades = new RegistroReclamoCantidades();
		JFrame jfFacturacion = new RegistroReclamoFacturacion();
		JFrame jfFaltantes = new RegistroReclamoFaltantes();
		JFrame jfProducto = new RegistroReclamoProducto();
		JFrame jfZona = new RegistroReclamoZona();
		
		tabbedPane.addTab("Cantidades", jfCantidades.getContentPane());
		tabbedPane.addTab("Facturacion", jfFacturacion.getContentPane());
		tabbedPane.addTab("Faltantes", jfFaltantes.getContentPane());
		tabbedPane.addTab("Producto", jfProducto.getContentPane());
		tabbedPane.addTab("Zona", jfZona.getContentPane());
		
	}

}
