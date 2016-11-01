package GUI;

		import Main.Controller;
		import Model.EstadoReclamo;
		import Vistas.*;

		import java.awt.EventQueue;

		import javax.swing.*;
		import javax.swing.border.EmptyBorder;
		import java.awt.event.ActionListener;
		import java.awt.event.ActionEvent;
		import java.util.ArrayList;
		import java.util.Date;

@SuppressWarnings("serial")
public class RegistroReclamoProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtCliente;
	private JTextPane txtDescripcionReclamo;
	private JComboBox cbSeleccionarProducto;

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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


		cbSeleccionarProducto = new JComboBox();
		ArrayList<ProductoView> pv = Main.Controller.getInstancia().listProductos();
		pv.stream().forEach(p -> cbSeleccionarProducto.addItem(p));

		cbSeleccionarProducto.setBounds(10, 122, 190, 20);
		contentPane.add(cbSeleccionarProducto);

		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(210, 122, 86, 20);
		contentPane.add(txtCantidad);

		JButton btnRegistrarReclamo = new JButton("Registrar ReclamoView");
		btnRegistrarReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReclamoProductoView rpv = new ReclamoProductoView();
				rpv.setCliente(Integer.parseInt(txtCliente.getText()));
				rpv.getHashReclamos().put(EstadoReclamo.Ingresado,new DetalleReclamoView(new Date(),null,null));
				rpv.setDescripcion(txtDescripcionReclamo.getText());
				rpv.setDetalleProducto(new DetalleProductoView(
						(ProductoView)cbSeleccionarProducto.getSelectedItem(),Integer.parseInt(txtCantidad.getText())));
				Controller.getInstancia().addReclamo(rpv);
				confiramarGrabado();
			}
		});

		btnRegistrarReclamo.setBounds(10, 217, 414, 23);
		contentPane.add(btnRegistrarReclamo);

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

		txtDescripcionReclamo = new JTextPane();
		scrollPane.setViewportView(txtDescripcionReclamo);

	}

	private void confiramarGrabado(){
		JOptionPane.showMessageDialog(null, "El Reclamo se registro con exito");
		txtCantidad.setText("");
		txtCliente.setText("");
		cbSeleccionarProducto.setSelectedIndex(0);
		txtDescripcionReclamo.setText("");
	}
}
