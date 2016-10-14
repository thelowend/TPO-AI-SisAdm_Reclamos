package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
public class RegistroReclamoFacturacion extends JFrame {

	private JPanel contentPane;
	private JTextField txtSeleccionarFecha;
	private JTable tblFacturasReclamo;
	private JTextField txtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroReclamoFacturacion frame = new RegistroReclamoFacturacion();
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
	public RegistroReclamoFacturacion() {
		setTitle("Registro de ReclamoView de Facturaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarFactura = new JLabel("Seleccionar Factura:");
		lblSeleccionarFactura.setBounds(234, 91, 133, 14);
		contentPane.add(lblSeleccionarFactura);
		
		JLabel lblFecha = new JLabel("Fecha de Facturaci\u00F3n (DD-MM-AAAA):");
		lblFecha.setBounds(10, 91, 190, 14);
		contentPane.add(lblFecha);
		
		txtSeleccionarFecha = new JTextField();
		txtSeleccionarFecha.setColumns(10);
		txtSeleccionarFecha.setBounds(10, 111, 120, 20);
		contentPane.add(txtSeleccionarFecha);
		
		JComboBox cbSeleccionarFactura = new JComboBox();
		cbSeleccionarFactura.setBounds(234, 111, 190, 20);
		contentPane.add(cbSeleccionarFactura);
		
		JLabel lblDescripcinDeInconsistencia = new JLabel("Descripci\u00F3n de Inconsistencia:");
		lblDescripcinDeInconsistencia.setBounds(10, 137, 190, 14);
		contentPane.add(lblDescripcinDeInconsistencia);
		
		JLabel lblListadoDeFacturas = new JLabel("Listado de Facturas para ReclamoView:");
		lblListadoDeFacturas.setBounds(10, 311, 190, 14);
		contentPane.add(lblListadoDeFacturas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 336, 414, 110);
		contentPane.add(scrollPane);
		
		tblFacturasReclamo = new JTable();
		tblFacturasReclamo.setFillsViewportHeight(true);
		tblFacturasReclamo.setModel(new DefaultTableModel(
			new Object[][] {
				{"12-03-2015", new Integer(4), "Cobro Incorrecto"},
				{"26-09-2016", new Integer(56), null},
			},
			new String[] {
				"Fecha", "ID Factura", "Descripcion"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tblFacturasReclamo);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(324, 277, 100, 23);
		contentPane.add(btnAgregar);
		
		JButton btnQuitarFactura = new JButton("Quitar");
		btnQuitarFactura.setBounds(324, 457, 100, 23);
		contentPane.add(btnQuitarFactura);
		
		JButton btnRegistrarReclamo = new JButton("Registrar ReclamoView");
		btnRegistrarReclamo.setBounds(10, 507, 414, 23);
		contentPane.add(btnRegistrarReclamo);
		
		JButton btnBuscar = new JButton("Buscar ->");
		btnBuscar.setBounds(135, 110, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 11, 46, 14);
		contentPane.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(10, 28, 86, 20);
		contentPane.add(txtCliente);
		
		JLabel lblDescripcionReclamo = new JLabel("Descripci\u00F3n ReclamoView:");
		lblDescripcionReclamo.setBounds(106, 11, 170, 14);
		contentPane.add(lblDescripcionReclamo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(106, 31, 318, 49);
		contentPane.add(scrollPane_1);
		
		JTextPane txtDescripcionReclamo = new JTextPane();
		scrollPane_1.setViewportView(txtDescripcionReclamo);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 162, 414, 104);
		contentPane.add(scrollPane_2);
		
		JTextPane txtDescripcionInconsistencia = new JTextPane();
		txtDescripcionInconsistencia.setText("Text");
		scrollPane_2.setViewportView(txtDescripcionInconsistencia);
	}

}
