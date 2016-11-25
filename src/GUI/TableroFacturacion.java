package GUI;

import Main.Controller;
import Model.EstadoReclamo;
import Vistas.DetalleProductoView;
import Vistas.DetalleReclamoView;
import Vistas.ProductoView;
import Vistas.ReclamoCantidadsView;
import Vistas.ReclamoProductoView;
import Vistas.ReclamoView;
import Vistas.RoleView;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

@SuppressWarnings({"rawtypes", "serial" })
public class TableroFacturacion extends JFrame {

	private JPanel contentPane;
	private JPanel pnlReclamo;
	private JTable tblReclamoCantidades;
	private DefaultTableModel dtm;
	private JLabel lblReclamoId;
	private JTextField txtCliente;
	private JLabel lblFechaIngresado;
	private JLabel lblFechaModificado;
	private JTextArea txtDescripcion;
	private JComboBox<String> cbEstadoReclamo;
	private JTextArea txtModificacion;
	private ArrayList<ReclamoView> reclamosView;
	private DefaultTableModel tblReclamosCantidades;
	private JButton btnActualizarReclamo;
	private ReclamoView currentRCV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroFacturacion frame = new TableroFacturacion();
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
	public TableroFacturacion() {
		setTitle("Tablero Reclamo Facturación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeReclamos = new JLabel("Lista de Reclamos:");
		lblListaDeReclamos.setBounds(10, 11, 120, 14);
		contentPane.add(lblListaDeReclamos);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 36, 414, 160);
		contentPane.add(scrollPane);

		dtm = new DefaultTableModel();
		dtm.addColumn("Cliente");
		dtm.addColumn("Descripción");
		dtm.addColumn("Estado");
		dtm.addColumn("Ingresado");
		dtm.addColumn("Actualizado");
		
		tblReclamoCantidades = new JTable(dtm);
		tblReclamoCantidades.setShowVerticalLines(false);
		tblReclamoCantidades.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblReclamoCantidades);
		tblReclamoCantidades.setModel(dtm);
		
		pnlReclamo = new JPanel();
		pnlReclamo.setBounds(10, 207, 414, 293);
		contentPane.add(pnlReclamo);
		pnlReclamo.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 39, 46, 14);
		pnlReclamo.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBounds(94, 36, 40, 20);
		pnlReclamo.add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 67, 86, 14);
		pnlReclamo.add(lblDescripcin);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 163, 59, 14);
		pnlReclamo.add(lblEstado);
		
		cbEstadoReclamo = new JComboBox<String>();
		cbEstadoReclamo.setBounds(94, 160, 310, 20);
		
		 for (EstadoReclamo d : EstadoReclamo.values()) {
		     System.out.println(d.toString());
		     cbEstadoReclamo.addItem(d.toString());
		 }
		
		pnlReclamo.add(cbEstadoReclamo);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setBackground(Color.WHITE);
		txtDescripcion.setEnabled(false);
		txtDescripcion.setEditable(false);
		txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(94, 67, 310, 60);
		txtDescripcion.setBorder(txtCliente.getBorder());
		pnlReclamo.add(txtDescripcion);
		
		JLabel lblIngresado = new JLabel("Ingresado:");
		lblIngresado.setBounds(144, 39, 60, 14);
		pnlReclamo.add(lblIngresado);
		
		lblFechaIngresado = new JLabel();
		lblFechaIngresado.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFechaIngresado.setBounds(210, 39, 60, 14);
		pnlReclamo.add(lblFechaIngresado);
		
		JLabel lblModificado = new JLabel("Modificado:");
		lblModificado.setBounds(274, 39, 70, 14);
		pnlReclamo.add(lblModificado);
		
		lblFechaModificado = new JLabel();
		lblFechaModificado.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFechaModificado.setBounds(344, 39, 60, 14);
		pnlReclamo.add(lblFechaModificado);
		
		JLabel lblAdministrar = new JLabel("Administrar:");
		lblAdministrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdministrar.setBounds(10, 138, 86, 14);
		pnlReclamo.add(lblAdministrar);
		
		JLabel lblModificacion = new JLabel("Modificaci\u00F3n:");
		lblModificacion.setBounds(10, 188, 86, 14);
		pnlReclamo.add(lblModificacion);
		
		txtModificacion = new JTextArea();
		txtModificacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtModificacion.setColumns(10);
		txtModificacion.setBorder(txtCliente.getBorder());
		txtModificacion.setBounds(94, 188, 310, 60);
		pnlReclamo.add(txtModificacion);
		
		ArrayList<RoleView> roles = Controller.getInstancia().getSesion().getRoles();
		//Si el usuario NO es de consulta, agrego el botón de Actualizar Reclamo
		if (roles.stream().filter(role -> role.getRoleName().compareTo("Consulta") != 0).count() > 0) {
			btnActualizarReclamo = new JButton("Actualizar Reclamo");
			
			btnActualizarReclamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						ReclamoCantidadsView rpv = new ReclamoCantidadsView();
						rpv.setCliente(Integer.parseInt(txtCliente.getText()));
						rpv.setDescripcion(txtDescripcion.getText());
						EstadoReclamo nuevoEstadoReclamo = EstadoReclamo.valueOf(cbEstadoReclamo.getSelectedItem().toString());
						rpv.setNumeroReclamo(Integer.parseInt(lblReclamoId.getText()));
						//HashMap<EstadoReclamo, DetalleReclamoView> oldHash = currentRCV.getHashReclamos();
						HashMap<EstadoReclamo, DetalleReclamoView> newHash = new HashMap<EstadoReclamo, DetalleReclamoView>();
						
						DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
						Date startDate = df.parse(lblFechaIngresado.getText());
						
						newHash.put(nuevoEstadoReclamo, new DetalleReclamoView(
								startDate, 
								new Date(), 
								txtModificacion.getText(),
								Controller.getInstancia().getSesion().getId()
						));
						
						rpv.setHashReclamos(newHash);
						//rpv.setProductos(currentRCV.getProductos());
						
						Controller.getInstancia().actualizarReclamo(rpv);
						
						updateVistaReclamos();
						JOptionPane.showMessageDialog(null, "¡Actualizado con éxito!");
					}
					catch (Exception ex){
						ex.printStackTrace();
					}	

				}
			});
			btnActualizarReclamo.setBounds(94, 259, 310, 23);
			pnlReclamo.add(btnActualizarReclamo);	
		}
		
		JLabel lblReclamo = new JLabel("Reclamo:");
		lblReclamo.setBounds(10, 11, 86, 14);
		pnlReclamo.add(lblReclamo);
		
		lblReclamoId = new JLabel("");
		lblReclamoId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReclamoId.setBounds(94, 12, 46, 14);
		pnlReclamo.add(lblReclamoId);
		
		tblReclamoCantidades.getSelectionModel().addListSelectionListener(new ListSelectionListener (){
	        public void valueChanged(ListSelectionEvent event) {
	        	if (tblReclamoCantidades.getSelectedRow() != -1) {
	        		showSelectedData(reclamosView.get(tblReclamoCantidades.getSelectedRow()));
	        	}
	        }
	    });

		String[] headersReclamoCantidades = {"Cliente", "Descripción", "Estado", "Ingresado", "Actualizado"};
	    tblReclamosCantidades = new DefaultTableModel(headersReclamoCantidades, 0);
	    updateVistaReclamos();

	}
	
	private void updateVistaReclamos() {

		tblReclamosCantidades.setRowCount(0);
		reclamosView = Controller.getInstancia().listReclamoView("ReclamoFacturacion");
		
		for (int i = 0; i < reclamosView.size(); i++) {
			
			int clienteId = reclamosView.get(i).getClienteId();
			String descripcion = reclamosView.get(i).getDescripcion();
			HashMap<EstadoReclamo, DetalleReclamoView> hashReclamo = reclamosView.get(i).getHashReclamos();
			
    		for(Entry<?, ?> entry: hashReclamo.entrySet()) {
    			String estadoReclamo = entry.getKey().toString();
    			DetalleReclamoView drView = (DetalleReclamoView) entry.getValue();
    			
    			Date dFechaInicio = drView.getFechaInicacion();
				Date dFechaUltima = drView.getFechaCierre();
				String fechaInicio = dFechaInicio.toString();
				String fechaUltima = "-";
				
				if (dFechaUltima != null) {
					fechaUltima = dFechaUltima.toString();
				}
				
				tblReclamosCantidades.addRow(new Object[] {clienteId, descripcion, estadoReclamo, fechaInicio, fechaUltima});
    		}
			
		}
		
		tblReclamoCantidades.setModel(tblReclamosCantidades);
		
	}
	
	private void showSelectedData(ReclamoView rv) {	
		currentRCV = rv;
		lblReclamoId.setText(Integer.toString(rv.getNumeroReclamo()));
		txtCliente.setText(Integer.toString(rv.getClienteId()));
		txtDescripcion.setText(rv.getDescripcion());
		HashMap<EstadoReclamo, DetalleReclamoView> hashReclamo = rv.getHashReclamos();
		
		for(Entry<?, ?> entry: hashReclamo.entrySet()) {
			String estadoReclamo = entry.getKey().toString();
			DetalleReclamoView drView = (DetalleReclamoView) entry.getValue();
			Date dFechaInicio = drView.getFechaInicacion();
			Date dFechaUltima = drView.getFechaCierre();
			String fechaInicio = dFechaInicio.toString();
			String fechaUltima = "-";
			
			if (dFechaUltima != null) {
				fechaUltima = dFechaUltima.toString();
			}
			
			lblFechaIngresado.setText(fechaInicio);
			lblFechaModificado.setText(fechaUltima);
			cbEstadoReclamo.setSelectedItem(estadoReclamo);
			txtModificacion.setText(drView.getComentarios());
		}
		
		
	}
}
