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
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

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
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbReportes = new JComboBox();
		cmbReportes.setModel(new DefaultComboBoxModel(new String[] {"Clientes con m\u00E1s reclamos", "Cantidad de reclamos tratados por mes", "Ranking de tratamiento de reclamos", "Tiempo promedio de respuesta de los reclamos por responsable"}));
		cmbReportes.setBounds(10, 34, 414, 20);
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
            		reclamosView = Controller.getInstancia().listReclamoView(null);
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
            		
            		//Ordena por mayor cantidad de reclamos (Hay que llamarlo 2 veces si o si)
            		tblReporte.getRowSorter().toggleSortOrder(0);
            		tblReporte.getRowSorter().toggleSortOrder(0);
            		
	        		break;
            	case 1: 
            		//cantidad de reclamos tratados por mes
            		reclamosView = Controller.getInstancia().listReclamoView(null);
            		Calendar cal = Calendar.getInstance();
            		String[] mes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            		
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
    				//"Reclamos Finalizados"
            		reclamosView = Controller.getInstancia().listReclamoView(null);
            		String[] finalizados = {"ID Responsable", "Cantidad de Reclamos Tratados"};
            		
            		Hashtable<Integer, Integer> htReclamosFinalizados = new Hashtable<Integer, Integer>();

            		for (int i = 0; i < reclamosView.size(); i++) {
            			HashMap<EstadoReclamo, DetalleReclamoView> hashReclamo = reclamosView.get(i).getHashReclamos();
            			
            	        for (EstadoReclamo key : hashReclamo.keySet()) {
            	        	
            	        	if (key == EstadoReclamo.Cerrado || key == EstadoReclamo.Solucionado) {
                    			int responsableID = hashReclamo.get(key).getResponsableId();
                    			if (!htReclamosFinalizados.containsKey(responsableID)) {
                    				htReclamosFinalizados.put(responsableID, 1);
                    			} else {
                    				htReclamosFinalizados.put(responsableID,  htReclamosFinalizados.get(responsableID) + 1);
                    			}
            	        	}
            	        	
            	        }		
            		}
            		
            	    DefaultTableModel tblReporteFinalizadosModel = new DefaultTableModel(finalizados, 0);     	    
            		
            		for(Entry<?, ?> entry: htReclamosFinalizados.entrySet()) {
            			tblReporteFinalizadosModel.addRow(new Object[] {entry.getKey(), entry.getValue()});
            		}
            		
            		tblReporte.setModel(tblReporteFinalizadosModel);
            		tblReporte.setAutoCreateRowSorter(true);
            		
            		//Ordena por mayor cantidad de reclamos tratados (Hay que llamarlo 2 veces si o si)
            		tblReporte.getRowSorter().toggleSortOrder(1);
            		tblReporte.getRowSorter().toggleSortOrder(1);
        			break;
            	case 3: 
            		//tiempo promedio de respuesta de los reclamos por responsable
            		//"Resolucion Reclamo (tiempo)"
            		
            		reclamosView = Controller.getInstancia().listReclamoView(null);
            		String[] atendidos = {"ID Responsable", "Tiempo promedio (Horas)"};
            		
            		Hashtable<Integer, Long> htTiempoMedio = new Hashtable<Integer, Long>();

            		for (int i = 0; i < reclamosView.size(); i++) {
            			HashMap<EstadoReclamo, DetalleReclamoView> hashReclamo = reclamosView.get(i).getHashReclamos();
            			
            	        for (EstadoReclamo key : hashReclamo.keySet()) {
            	        	
            	        	int responsableID = hashReclamo.get(key).getResponsableId();
            	        	Date fechaInicio = hashReclamo.get(key).getFechaInicacion();
            	        	Date fechaActualizado = hashReclamo.get(key).getFechaCierre();
            	        	
            	        	if (fechaActualizado != null) {
            	        	    long diffInMillies = fechaActualizado.getTime() - fechaInicio.getTime();
            	        	    long diff =TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            	        	    
                    			if (!htTiempoMedio.containsKey(responsableID)) {
                    				htTiempoMedio.put(responsableID, diff);
                    			} else {
                    				//voy haciendo sumatoria del promedio
                    				long newDiff = (htTiempoMedio.get(responsableID) + diff) / 2;
                    				htTiempoMedio.put(responsableID, newDiff);
                    			}
            	        	    
            	        	}
            	        	
            	        }		
            		}
            		
            	    DefaultTableModel tblReporteAtendidosModel = new DefaultTableModel(atendidos, 0);     	    
            		
            		for(Entry<?, ?> entry: htTiempoMedio.entrySet()) {
            			tblReporteAtendidosModel.addRow(new Object[] {entry.getKey(), entry.getValue()});
            		}
            		
            		tblReporte.setModel(tblReporteAtendidosModel);
            		tblReporte.setAutoCreateRowSorter(true);
            		
            		//Ordena por menor tiempo promedio cantidad (si lo llamo 1 vez, es descendente)
            		tblReporte.getRowSorter().toggleSortOrder(1);
            		
        			break;
            	default:
        			System.out.println("Def");
	        		break;    
			    }
			}
		});
		btnGenerar.setBounds(335, 59, 89, 23);
		contentPane.add(btnGenerar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnVolver.setBounds(236, 382, 89, 23);
		contentPane.add(btnVolver);
		
		JScrollPane panelReporte = new JScrollPane();
		panelReporte.setBounds(10, 93, 414, 278);
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
		btnImprimir.setBounds(335, 382, 89, 23);
		contentPane.add(btnImprimir);
	}
}
