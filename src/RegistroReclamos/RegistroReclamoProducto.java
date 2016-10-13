package RegistroReclamos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class RegistroReclamoProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroReclamoProducto frame = new RegistroReclamoProducto();
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
	public RegistroReclamoProducto() {
		setTitle("Registro de ReclamoView de Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarProducto = new JLabel("Seleccionar Producto:");
		lblSeleccionarProducto.setBounds(10, 102, 133, 14);
		contentPane.add(lblSeleccionarProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(210, 102, 66, 14);
		contentPane.add(lblCantidad);
		
		JComboBox cbSeleccionarProducto = new JComboBox();
		cbSeleccionarProducto.setModel(new DefaultComboBoxModel(new String[] {"Producto1", "Producto2"}));
		cbSeleccionarProducto.setBounds(10, 122, 190, 20);
		contentPane.add(cbSeleccionarProducto);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(210, 122, 86, 20);
		contentPane.add(txtCantidad);
		
		JButton btnSolicitar = new JButton("Solicitar");
		btnSolicitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSolicitar.setBounds(306, 121, 118, 23);
		contentPane.add(btnSolicitar);
		
		JTextPane txtProductoReclamo = new JTextPane();
		txtProductoReclamo.setBounds(10, 178, 414, 20);
		contentPane.add(txtProductoReclamo);
		
		JButton btnRegistrarReclamo = new JButton("Registrar ReclamoView");
		btnRegistrarReclamo.setBounds(10, 217, 286, 23);
		contentPane.add(btnRegistrarReclamo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 217, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblProductoReclamo = new JLabel("Producto:");
		lblProductoReclamo.setBounds(10, 153, 190, 14);
		contentPane.add(lblProductoReclamo);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(11, 11, 46, 14);
		contentPane.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(11, 28, 86, 20);
		contentPane.add(txtCliente);
		
		JLabel lblDescripcionReclamo = new JLabel("Descripci\u00F3n ReclamoView:");
		lblDescripcionReclamo.setBounds(107, 11, 170, 14);
		contentPane.add(lblDescripcionReclamo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 28, 318, 49);
		contentPane.add(scrollPane);
		
		JTextPane txtDescripcionReclamo = new JTextPane();
		scrollPane.setViewportView(txtDescripcionReclamo);
	}
}
