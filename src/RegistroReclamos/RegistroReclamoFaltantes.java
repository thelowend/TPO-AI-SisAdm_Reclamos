package RegistroReclamos;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class RegistroReclamoFaltantes extends JFrame {

	private JPanel contentPane;
	private JTextField txtSolicitada;
	private JTextField txtRecibida;
	private JTable tblFaltantesReclamo;
	private JTextField txtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroReclamoFaltantes frame = new RegistroReclamoFaltantes();
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
	public RegistroReclamoFaltantes() {
		setTitle("Registro de ReclamoView de Faltantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbSeleccionarProducto = new JComboBox();
		cbSeleccionarProducto.setModel(new DefaultComboBoxModel(new String[] {"Producto1", "Producto2"}));
		cbSeleccionarProducto.setBounds(10, 107, 200, 20);
		contentPane.add(cbSeleccionarProducto);
		
		JLabel lblSeleccionarProducto = new JLabel("Seleccionar Producto:");
		lblSeleccionarProducto.setBounds(10, 87, 133, 14);
		contentPane.add(lblSeleccionarProducto);
		
		JLabel lblSolicitada = new JLabel("C. Solicitada:");
		lblSolicitada.setBounds(220, 87, 100, 14);
		contentPane.add(lblSolicitada);
		
		txtSolicitada = new JTextField();
		txtSolicitada.setColumns(10);
		txtSolicitada.setBounds(220, 107, 100, 20);
		contentPane.add(txtSolicitada);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(324, 138, 100, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblRecibida = new JLabel("C. Recibida:");
		lblRecibida.setBounds(324, 87, 100, 14);
		contentPane.add(lblRecibida);
		
		txtRecibida = new JTextField();
		txtRecibida.setColumns(10);
		txtRecibida.setBounds(324, 107, 100, 20);
		contentPane.add(txtRecibida);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuitar.setBounds(324, 309, 100, 23);
		contentPane.add(btnQuitar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 414, 126);
		contentPane.add(scrollPane);
		
		tblFaltantesReclamo = new JTable();
		tblFaltantesReclamo.setFillsViewportHeight(true);
		tblFaltantesReclamo.setShowVerticalLines(false);
		tblFaltantesReclamo.setModel(new DefaultTableModel(
			new Object[][] {
				{"Producto1", new Integer(12), new Integer(5)},
			},
			new String[] {
				"Producto", "Cantidad Solicitada", "Cantidad Recibida"
			}
		) {

			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class
			};

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tblFaltantesReclamo);
		
		JButton btnRegistrarReclamo = new JButton("Registrar ReclamoView");
		btnRegistrarReclamo.setBounds(10, 347, 414, 23);
		contentPane.add(btnRegistrarReclamo);
		
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
		scrollPane_1.setBounds(106, 28, 318, 49);
		contentPane.add(scrollPane_1);
		
		JTextPane txtDescripcionReclamo = new JTextPane();
		scrollPane_1.setViewportView(txtDescripcionReclamo);
	}

}
