package GUI;

import Main.Controller;
import Model.EstadoReclamo;
import Vistas.DetalleProductoView;
import Vistas.DetalleReclamoView;
import Vistas.ProductoView;
import Vistas.ReclamoCantidadsView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
public class RegistroReclamoCantidades extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTable tblProductosReclamo;
	private JTextField txtCliente;
	private JTextPane txtDescripcionReclamo;
	private JComboBox cbSeleccionarProducto;
	private DefaultTableModel dtm;
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroReclamoCantidades frame = new RegistroReclamoCantidades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	//	});
//	}

	/**
	 * Create the frame.
	 */
	public RegistroReclamoCantidades() {
		setTitle("Registro de ReclamoView de Cantidades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cbSeleccionarProducto = new JComboBox();
		ArrayList<ProductoView> pv = Main.Controller.getInstancia().listProductos();
		pv.stream().forEach(p -> cbSeleccionarProducto.addItem(p));

		cbSeleccionarProducto.setBounds(10, 108, 190, 20);
		contentPane.add(cbSeleccionarProducto);
		
		JLabel lblSeleccionarProducto = new JLabel("Seleccionar Producto:");
		lblSeleccionarProducto.setBounds(10, 88, 133, 14);
		contentPane.add(lblSeleccionarProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(210, 88, 66, 14);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(210, 108, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 139, 414, 160);
		contentPane.add(scrollPane);

		dtm = new DefaultTableModel();
		dtm.addColumn("ProductoId");
		dtm.addColumn("Producto");
		dtm.addColumn("Cantidad");
		tblProductosReclamo = new JTable(dtm);
		tblProductosReclamo.setShowVerticalLines(false);
		tblProductosReclamo.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProductosReclamo);
		tblProductosReclamo.setModel(dtm);
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 11, 46, 14);
		contentPane.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(10, 28, 86, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(106, 28, 318, 49);
		contentPane.add(scrollPane_1);
		
		txtDescripcionReclamo = new JTextPane();
		scrollPane_1.setViewportView(txtDescripcionReclamo);
		
		JLabel lblDescripcinReclamo = new JLabel("Descripci\u00F3n ReclamoView:");
		lblDescripcinReclamo.setBounds(106, 11, 170, 14);
		contentPane.add(lblDescripcinReclamo);
		tblProductosReclamo.getColumnModel().getColumn(0).setResizable(false);
		tblProductosReclamo.getColumnModel().getColumn(1).setResizable(false);
		tblProductosReclamo.getColumnModel().getColumn(2).setResizable(false);
		JButton btnAgregarAlReclamo = new JButton("Agregar");
		btnAgregarAlReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductoView pv = (ProductoView)cbSeleccionarProducto.getSelectedItem();
				dtm.addRow(new Object[]{pv.getCodigo(),pv,Integer.parseInt(txtCantidad.getText())});
				txtCantidad.setText("");
				cbSeleccionarProducto.setSelectedIndex(0);
			}
		});

		btnAgregarAlReclamo.setBounds(306, 107, 118, 23);
		contentPane.add(btnAgregarAlReclamo);

		JButton btnRegistrarReclamo = new JButton("Registrar ReclamoView");
		btnRegistrarReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReclamoCantidadsView rcv = new ReclamoCantidadsView();
				rcv.setCliente(Integer.parseInt(txtCliente.getText()));
				rcv.getHashReclamos().put(EstadoReclamo.Ingresado, 
						new DetalleReclamoView(
							new Date(), 
							null, 
							null,
							-1
						)
				);
				rcv.setDescripcion(txtDescripcionReclamo.getText());
				for (int i = 0 ; i < dtm.getRowCount() ; i++)
						rcv.getProductos().add(new DetalleProductoView((ProductoView)dtm.getValueAt(i,1),
								Integer.parseInt(dtm.getValueAt(i,2).toString())));
				Controller.getInstancia().addReclamo(rcv);
				confirmarGrabado();
			}
		});

		btnRegistrarReclamo.setBounds(10, 307, 414, 23);
		contentPane.add(btnRegistrarReclamo);
	}
	private void confirmarGrabado(){
		JOptionPane.showMessageDialog(null, "El Reclamo se registro con exito");
		txtCantidad.setText("");
		txtCliente.setText("");
		cbSeleccionarProducto.setSelectedIndex(0);
		txtDescripcionReclamo.setText("");
		dtm.setRowCount(0);
	}
}
