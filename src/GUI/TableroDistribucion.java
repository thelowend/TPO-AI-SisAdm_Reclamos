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
@SuppressWarnings("serial")
public class TableroDistribucion extends javax.swing.JFrame {
    @SuppressWarnings("rawtypes")
	private JComboBox recProducto;
    @SuppressWarnings({ "unused", "rawtypes" })
	private JComboBox recCantidades;
    @SuppressWarnings("rawtypes")
	private JComboBox recFaltantes;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JButton JBmodif;
    private JTextField jtestadorec;
    private JLabel jlestado;
    private JTextField jTextField1;
    private JLabel jtdescripcion;
    private JTextField jtdescripmodif;
    private JLabel jldescrip;
    private JLabel jlfechamodif;
    private JLabel jldescripcion;
    private JLabel textNroCliente;
    private JLabel cliente;
    private JLabel administracionReclamosZona;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TableroDistribucion inst = new TableroDistribucion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TableroDistribucion() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				administracionReclamosZona = new JLabel();
				getContentPane().add(administracionReclamosZona);
				administracionReclamosZona.setText("Administracion Distribucion");
				administracionReclamosZona.setBounds(179, 12, 221, 18);
			}
			{
				cliente = new JLabel();
				getContentPane().add(cliente);
				cliente.setText("nroCliente :");
				cliente.setBounds(191, 50, 113, 24);
			}
			{
				textNroCliente = new JLabel("123");
				getContentPane().add(textNroCliente);
				textNroCliente.setBounds(340, 52, 99, 24);
			}
			{
				jldescripcion = new JLabel();
				getContentPane().add(jldescripcion);
				jldescripcion.setText("Descripcion : ");
				jldescripcion.setBounds(191, 80, 92, 19);
			}
			{
				jtdescripcion = new JLabel("entrega de productos compertidos");
				getContentPane().add(jtdescripcion);
				jtdescripcion.setBounds(340, 78, 202, 25);
			}
			{
				jlfechamodif = new JLabel();
				getContentPane().add(jlfechamodif);
				jlfechamodif.setText("Fecha Modificacion :");
				jlfechamodif.setBounds(191, 164, 133, 26);
			}
			{
				jldescrip = new JLabel();
				getContentPane().add(jldescrip);
				jldescrip.setText("Descripcion Modif : ");
				jldescrip.setBounds(194, 203, 127, 17);
			}
			{
				jtdescripmodif = new JTextField();
				getContentPane().add(jtdescripmodif);
				jtdescripmodif.setBounds(342, 201, 117, 18);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(342, 167, 94, 24);
			}
			{
				jlestado = new JLabel();
				getContentPane().add(jlestado);
				jlestado.setText("Estado : ");
				jlestado.setBounds(194, 232, 93, 16);
			}
			{
				jtestadorec = new JTextField();
				getContentPane().add(jtestadorec);
				jtestadorec.setBounds(342, 231, 123, 17);
			}
			{
				JBmodif = new JButton();
				getContentPane().add(JBmodif);
				JBmodif.setText("Actualizar");
				JBmodif.setBounds(234, 311, 99, 23);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Codigo ");
				jLabel1.setBounds(191, 111, 92, 19);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("cantidad");
				jLabel2.setBounds(191, 142, 137, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("codigo de producto");
				jLabel3.setBounds(340, 112, 152, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("cantidad del producto");
				jLabel4.setBounds(340, 142, 207, 16);
			}
			{
				ComboBoxModel recFaltantesModel = 
						new DefaultComboBoxModel(
								new String[] { "De faltantes", "De cant","De producto"});
				recFaltantes = new JComboBox();
				getContentPane().add(recFaltantes);
				recFaltantes.setModel(recFaltantesModel);
				recFaltantes.setBounds(61, 99, 111, 29);
			}
			
			{
				ComboBoxModel recProductoModel = 
						new DefaultComboBoxModel(
								new String[] { "prod1", "prod2" });
				recProducto = new JComboBox();
				getContentPane().add(recProducto);
				recProducto.setModel(recProductoModel);
				recProducto.setBounds(61, 158, 112, 24);
			}

		/*	panel.setPreferredSize(new java.awt.Dimension(113, 346));*/

			//pack();
			this.setSize(567, 381);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}