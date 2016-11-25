package GUI;

import Main.Controller;
import Model.EstadoReclamo;
import Vistas.DetalleReclamoView;
import Vistas.ProductoView;
import Vistas.ReclamoZonaView;
import Vistas.ZonaView;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class RegistroReclamoZona extends JFrame {

	@SuppressWarnings("rawtypes")
	private JComboBox cbZonaReclamo;
	private JPanel contentPane;
	private JTextField txtCliente;
	private JTextPane txtDescripcionReclamo;

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RegistroReclamoZona() {
		setTitle("Registro de ReclamoView de Zona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarZona = new JLabel("Seleccionar Zona:");
		lblSeleccionarZona.setBounds(10, 86, 133, 14);
		contentPane.add(lblSeleccionarZona);
		
		cbZonaReclamo = new JComboBox();
		ArrayList<ZonaView> pv = Main.Controller.getInstancia().listZonas(-1);
		pv.stream().forEach(p -> cbZonaReclamo.addItem(p.getZona()));

		cbZonaReclamo.setBounds(10, 106, 414, 20);
		contentPane.add(cbZonaReclamo);

		JButton btnRegistrarReclamo = new JButton("Registrar ReclamoView");
		btnRegistrarReclamo.setBounds(10, 137, 414, 23);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 28, 318, 49);
		contentPane.add(scrollPane);
		
		txtDescripcionReclamo = new JTextPane();
		scrollPane.setViewportView(txtDescripcionReclamo);
		btnRegistrarReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReclamoZonaView rzv = new ReclamoZonaView();
				rzv.setCliente(Integer.parseInt(txtCliente.getText()));
				rzv.getHashReclamos().put(EstadoReclamo.Ingresado, 
						new DetalleReclamoView(
								new Date(),
								null,
								null, 
								-1
						)
				);
				rzv.setDescripcion(txtDescripcionReclamo.getText());
				rzv.setZona(cbZonaReclamo.getSelectedIndex() + 1);
				try {
					Controller.getInstancia().addReclamo(rzv);
					confirmarGrabado();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					ex.printStackTrace();
				}
				
				
			}
		});
	}
	private void confirmarGrabado() {
		JOptionPane.showMessageDialog(null, "El Reclamo se registro con exito");
		txtCliente.setText("");
		txtDescripcionReclamo.setText("");
		cbZonaReclamo.setSelectedIndex(0);
	}
}
