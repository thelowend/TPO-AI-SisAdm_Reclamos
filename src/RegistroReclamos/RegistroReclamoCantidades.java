package RegistroReclamos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
public class RegistroReclamoCantidades extends JFrame {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTable tblProductosReclamo;
	private JTextField txtCliente;
	
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
		
		JComboBox cbSeleccionarProducto = new JComboBox();
		cbSeleccionarProducto.setModel(new DefaultComboBoxModel(new String[] {"Producto1", "Producto2", "Producto3"}));
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
		
		JButton btnAgregarAlReclamo = new JButton("Agregar");
		btnAgregarAlReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnAgregarAlReclamo.setBounds(306, 107, 118, 23);
		contentPane.add(btnAgregarAlReclamo);
		
		JButton btnRegistrarReclamo = new JButton("Registrar ReclamoView");
		btnRegistrarReclamo.setBounds(10, 307, 414, 23);
		contentPane.add(btnRegistrarReclamo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 139, 414, 160);
		contentPane.add(scrollPane);
		
		tblProductosReclamo = new JTable();
		tblProductosReclamo.setShowVerticalLines(false);
		tblProductosReclamo.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProductosReclamo);
		tblProductosReclamo.setModel(new DefaultTableModel(
			new Object[][] {
				{"Producto1", new Integer(2)},
				{"Producto2", new Integer(5)},
			},
			new String[] {
				"Producto", "Cantidad"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
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
		
		JTextPane txtDescripcionReclamo = new JTextPane();
		scrollPane_1.setViewportView(txtDescripcionReclamo);
		
		JLabel lblDescripcinReclamo = new JLabel("Descripci\u00F3n ReclamoView:");
		lblDescripcinReclamo.setBounds(106, 11, 170, 14);
		contentPane.add(lblDescripcinReclamo);
		tblProductosReclamo.getColumnModel().getColumn(0).setResizable(false);
		tblProductosReclamo.getColumnModel().getColumn(1).setResizable(false);
	}
}
