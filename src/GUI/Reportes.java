package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Main.Controller;
import Model.EstadoReclamo;
import Vistas.DetalleReclamoView;
import Vistas.ReclamoView;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Component;

public class Reportes extends JFrame {

	private JPanel contentPane;
	private JTable tblReporte;
	private ArrayList<ReclamoView> reclamosView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes frame = new Reportes();
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
	public Reportes() {
		JFrame frame = this;
		setTitle("Generador de Reportes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbReportes = new JComboBox();
		cmbReportes.setModel(new DefaultComboBoxModel(new String[] {"Clientes con m\u00E1s reclamos", "Cantidad de reclamos tratados por mes", "Ranking de tratamiento de reclamos", "Tiempo promedio de respuesta de los reclamos por responsable"}));
		cmbReportes.setBounds(10, 34, 474, 20);
		contentPane.add(cmbReportes);
		
		JLabel lblTipoDeReporte = new JLabel("Tipo de Reporte:");
		lblTipoDeReporte.setBounds(10, 11, 125, 14);
		contentPane.add(lblTipoDeReporte);
		
		JButton btnGenerar = new JButton("Generar");
		
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    switch (cmbReportes.getSelectedIndex()) {
            	case 0: 
            		//ranking de clientes con mayor reclamos
            		reclamosView = Controller.getInstancia().listReclamoView();
            		Hashtable<Integer, Integer> htMasReclamos = new Hashtable<Integer, Integer>();

            		for (int i = 0; i < reclamosView.size(); i++) {
            			int clienteId = reclamosView.get(i).getClienteId();
            			if (!htMasReclamos.containsKey(clienteId)) {
            				htMasReclamos.put(clienteId, 1);
            			} else {
            				htMasReclamos.put(clienteId,  htMasReclamos.get(clienteId) + 1);
            			} 			
            		}
            		
            		String[] headersMasReclamos = {"ID Cliente", "Cantidad de Reclamos"};
            	    DefaultTableModel tblReporteModelMasReclamos = new DefaultTableModel(headersMasReclamos, 0);
            	    
            		
            		for(Entry<?, ?> entry: htMasReclamos.entrySet()) {
            			tblReporteModelMasReclamos.addRow(new Object[] {entry.getKey(), entry.getValue()});
            		}
            		
            		tblReporte.setModel(tblReporteModelMasReclamos);
            		tblReporte.setAutoCreateRowSorter(true);
            		
            		//Ordena por mayor cantidad de reclamos
            		tblReporte.getRowSorter().toggleSortOrder(1);
            		
	        		break;
            	case 1: 
            		//cantidad de reclamos tratados por mes
            		reclamosView = Controller.getInstancia().listReclamoView();
            		Calendar cal = Calendar.getInstance();
            		String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            		
            		
            		ArrayList<ReclamoView> reclamosView = Controller.getInstancia().listReclamoView();
            		Hashtable<String, Integer> htReclamosMensales = new Hashtable<String, Integer>();

            		for (int i = 0; i < reclamosView.size(); i++) {
            			HashMap<EstadoReclamo, DetalleReclamoView> hashReclamo = reclamosView.get(i).getHashReclamos();
            			
            	        for (EstadoReclamo key : hashReclamo.keySet()) {
            	        	Date fechaCierre = hashReclamo.get(key).getFechaCierre();
            	        	
            	        	if(fechaCierre != null) {
                	        	cal.setTime(fechaCierre);
                	        	String mesReclamo = mes[cal.get(Calendar.MONTH)];
                	        	if (cal.get(Calendar.YEAR) == Year.now().getValue()) {
                        			if (!htReclamosMensales.containsKey(mesReclamo)) {
                        				htReclamosMensales.put(mesReclamo, 1);
                        			} else {
                        				htReclamosMensales.put(mesReclamo,  htReclamosMensales.get(mesReclamo) + 1);
                        			}   	        		
                	        	}
            	        	}
            	        }		
            		}
            		
            		String[] headersReclamosMensuales = {"Mes", "Cantidad de Reclamos Tratados"};
            	    DefaultTableModel tblReporteModelReclamosMensuales = new DefaultTableModel(headersReclamosMensuales, 0);
            	    
            		
            		for(Entry<?, ?> entry: htReclamosMensales.entrySet()) {
            			tblReporteModelReclamosMensuales.addRow(new Object[] {entry.getKey(), entry.getValue()});
            		}
            		
            		tblReporte.setModel(tblReporteModelReclamosMensuales);
            		
        			break;   
            	case 2: 
            		//ranking de tratamiento de reclamos

        			System.out.println("2");
        			break;
            	case 3: 
            		//tiempo promedio de respuesta de los reclamos por responsable
            		
        			System.out.println("3");
        			break;
            	default:
        			System.out.println("Def");
	        		break;    
			    }
			}
		});
		btnGenerar.setBounds(395, 65, 89, 23);
		contentPane.add(btnGenerar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnVolver.setBounds(296, 427, 89, 23);
		contentPane.add(btnVolver);
		
		JScrollPane panelReporte = new JScrollPane();
		panelReporte.setBounds(10, 93, 474, 323);
		contentPane.add(panelReporte);
		
		tblReporte = new JTable();

		tblReporte.setFillsViewportHeight(true);
		panelReporte.setViewportView(tblReporte);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tblReporte.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnImprimir.setBounds(395, 427, 89, 23);
		contentPane.add(btnImprimir);
	}
}
