package RegistroReclamos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class RegistroReclamoZona extends JFrame {

	private JPanel contentPane;
	private JTextField txtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroReclamoZona frame = new RegistroReclamoZona();
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
	public RegistroReclamoZona() {
		setTitle("Registro de Reclamo de Zona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarZona = new JLabel("Seleccionar Zona:");
		lblSeleccionarZona.setBounds(10, 86, 133, 14);
		contentPane.add(lblSeleccionarZona);
		
		JComboBox cbZonaReclamo = new JComboBox();
		cbZonaReclamo.setBounds(10, 106, 414, 20);
		contentPane.add(cbZonaReclamo);
		
		JButton btnRegistrarReclamo = new JButton("Registrar Reclamo");
		btnRegistrarReclamo.setBounds(10, 137, 286, 23);
		contentPane.add(btnRegistrarReclamo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 137, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 11, 46, 14);
		contentPane.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(10, 28, 86, 20);
		contentPane.add(txtCliente);
		
		JLabel lblDescripcionReclamo = new JLabel("Descripci\u00F3n Reclamo:");
		lblDescripcionReclamo.setBounds(106, 11, 170, 14);
		contentPane.add(lblDescripcionReclamo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 28, 318, 49);
		contentPane.add(scrollPane);
		
		JTextPane txtDescripcionReclamo = new JTextPane();
		scrollPane.setViewportView(txtDescripcionReclamo);
	}

}
