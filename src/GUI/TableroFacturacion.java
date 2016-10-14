package GUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class TableroFacturacion extends javax.swing.JFrame {
    private JComboBox cboFactura;
    private JButton JBmodif;
    private JLabel label;
    private JLabel label_1;
    private JComboBox cboFecha;
    private JComboBox cboCliente;
    private JLabel lblSeleccionarFactura;
    private JPanel panel;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel lblFechaDeFactura;
    private JLabel label_5;
    private JLabel label_6;
    private JLabel label_7;
    private JLabel textCliente;
    private JLabel label_9;
    private JLabel textFechaFactura;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel lblDescripcinDeFacturacin;
    private JLabel label_11;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TableroFacturacion inst = new TableroFacturacion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TableroFacturacion() {
		super();
		setTitle("Tablero de Reclamos de Facturaci\u00F3n");
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				JBmodif = new JButton();
				getContentPane().add(JBmodif);
				JBmodif.setText("Actualizar");
				JBmodif.setBounds(20, 383, 398, 23);
			}
			{
				cboFactura = new JComboBox();
				cboFactura.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				cboFactura.setEnabled(false);
				getContentPane().add(cboFactura);
				cboFactura.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar Detalle de Factura>", "Factura 1"}));
				cboFactura.setBounds(20, 80, 240, 20);
			}
			{
				label = new JLabel("Seleccionar Fecha:");
				label.setBounds(20, 11, 122, 14);
				getContentPane().add(label);
			}
			{
				label_1 = new JLabel("Cliente:");
				label_1.setBounds(270, 11, 46, 14);
				getContentPane().add(label_1);
			}
			{
				cboFecha = new JComboBox();
				cboFecha.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cboFecha.getSelectedIndex() > 0) {
							cboCliente.setEnabled(true);
							textFechaFactura.setText(cboFecha.getSelectedItem().toString());
						}
					}
				});
				cboFecha.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Fecha> ", "02/06/2016", "05/03/2016"}));
				cboFecha.setBounds(20, 30, 240, 20);
				getContentPane().add(cboFecha);
			}
			{
				cboCliente = new JComboBox();
				cboCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cboCliente.getSelectedIndex() > 0) {
							cboFactura.setEnabled(true);
							textCliente.setText(cboCliente.getSelectedItem().toString());
						}
					}
				});
				cboCliente.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Cliente>", "2", "4", "17"}));
				cboCliente.setEnabled(false);
				cboCliente.setBounds(270, 30, 148, 20);
				getContentPane().add(cboCliente);
			}
			{
				lblSeleccionarFactura = new JLabel("Seleccionar Detalle de Factura:");
				lblSeleccionarFactura.setBounds(20, 60, 161, 14);
				getContentPane().add(lblSeleccionarFactura);
			}
			{
				panel = new JPanel();
				panel.setLayout(null);
				panel.setBackground(Color.WHITE);
				panel.setBounds(0, 112, 434, 260);
				getContentPane().add(panel);
				{
					label_2 = new JLabel();
					label_2.setText("N\u00FAmero Cliente:");
					label_2.setBounds(20, 15, 130, 20);
					panel.add(label_2);
				}
				{
					label_3 = new JLabel();
					label_3.setText("Descripci\u00F3n : ");
					label_3.setBounds(20, 50, 130, 20);
					panel.add(label_3);
				}
				{
					lblFechaDeFactura = new JLabel();
					lblFechaDeFactura.setText("Fecha de Factura:");
					lblFechaDeFactura.setBounds(20, 85, 130, 20);
					panel.add(lblFechaDeFactura);
				}
				{
					label_5 = new JLabel();
					label_5.setText("Fecha Modificaci\u00F3n :");
					label_5.setBounds(20, 155, 130, 20);
					panel.add(label_5);
				}
				{
					label_6 = new JLabel();
					label_6.setText("Descripci\u00F3n Modificaci\u00F3n : ");
					label_6.setBounds(20, 190, 130, 20);
					panel.add(label_6);
				}
				{
					label_7 = new JLabel();
					label_7.setText("Estado : ");
					label_7.setBounds(20, 225, 130, 20);
					panel.add(label_7);
				}
				{
					textCliente = new JLabel("<nroCliente>");
					textCliente.setBounds(156, 15, 240, 20);
					panel.add(textCliente);
				}
				{
					label_9 = new JLabel("<Descripci\u00F3n>");
					label_9.setBounds(156, 50, 240, 20);
					panel.add(label_9);
				}
				{
					textFechaFactura = new JLabel();
					textFechaFactura.setText("<Fecha de Factura>");
					textFechaFactura.setBounds(156, 85, 240, 20);
					panel.add(textFechaFactura);
				}
				{
					textField = new JTextField();
					textField.setBounds(156, 155, 240, 20);
					panel.add(textField);
				}
				{
					textField_1 = new JTextField();
					textField_1.setBounds(155, 190, 241, 20);
					panel.add(textField_1);
				}
				{
					textField_2 = new JTextField();
					textField_2.setBounds(155, 225, 241, 20);
					panel.add(textField_2);
				}
				{
					lblDescripcinDeFacturacin = new JLabel();
					lblDescripcinDeFacturacin.setText("Descripci\u00F3n de Facturaci\u00F3n:");
					lblDescripcinDeFacturacin.setBounds(20, 120, 130, 20);
					panel.add(lblDescripcinDeFacturacin);
				}
				{
					label_11 = new JLabel("<Descripci\u00F3n de reclamo de factura>");
					label_11.setBounds(156, 120, 240, 20);
					panel.add(label_11);
				}
			}

		/*	panel.setPreferredSize(new java.awt.Dimension(113, 346));*/

			//pack();
			this.setSize(450, 460);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
