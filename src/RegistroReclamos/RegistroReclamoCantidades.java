package RegistroReclamos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegistroReclamoCantidades extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroReclamoCantidades frame = new RegistroReclamoCantidades();
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
	public RegistroReclamoCantidades() {
		setTitle("Registrar Reclamo de Cantidad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox productBox = new JComboBox();
		productBox.setBounds(10, 31, 190, 20);
		contentPane.add(productBox);
		
		JLabel lblSeleccionarProducto = new JLabel("Seleccionar Producto:");
		lblSeleccionarProducto.setBounds(10, 11, 133, 14);
		contentPane.add(lblSeleccionarProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(210, 11, 66, 14);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(210, 31, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnAgregarAlReclamo = new JButton("Agregar");
		btnAgregarAlReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnAgregarAlReclamo.setBounds(306, 30, 118, 23);
		contentPane.add(btnAgregarAlReclamo);
		
		JList listProductos = new JList();
		listProductos.setBounds(10, 62, 414, 204);
		contentPane.add(listProductos);
		
		JButton btnRegistrarReclamo = new JButton("Registrar Reclamo");
		btnRegistrarReclamo.setBounds(10, 277, 286, 23);
		contentPane.add(btnRegistrarReclamo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 277, 89, 23);
		contentPane.add(btnCancelar);
	}

}
