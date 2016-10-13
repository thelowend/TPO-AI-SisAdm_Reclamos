package Main;
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
public class TableroZona extends javax.swing.JFrame {
    private JPanel    panel;
    private JButton JBmodif;
    private JTextField jtestadorec;
    private JLabel jlestado;
    private JTextField jTextField1;
    private JLabel jtdescripcion;
    private JTextField jtdescripmodif;
    private JLabel jldescrip;
    private JLabel jlfechamodif;
    private JLabel jtzona;
    private JLabel jlzona;
    private JLabel jldescripcion;
    private JLabel textNroCliente;
    private JLabel cliente;
    private JLabel administracionReclamosZona;
    private JComboBox Zona;
    private JComboBox reclamos;
	/**
	* Auto-generated main method to display this JFrame
	*/
	//public static void main(String[] args) {
	//	SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TableroZona inst = new TableroZona();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
	//	});
	//}
	
	public TableroZona() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			panel = new JPanel();
			BorderLayout panelLayout = new BorderLayout();
			panel.setLayout(panelLayout);
			getContentPane().add(panel, BorderLayout.WEST);
			panel.setBounds(0, 0, 64, 118);
			{
				ComboBoxModel reclamosModel = 
						new DefaultComboBoxModel(
								new String[] { "seleccione fecha ","02/06/2016", "05/03/2016" });
				reclamos = new JComboBox();
				getContentPane().add(reclamos);
				reclamos.setModel(reclamosModel);
				reclamos.setBounds(20, 124, 122, 26);
				
				
				/*reclamos.setPreferredSize(new java.awt.Dimension(97, 139));*/
			}
			{
				ComboBoxModel ZonaModel = 
						new DefaultComboBoxModel(
								new String[] { "seleccione zona", "Belgrano","Palermo","tigre" });
				Zona = new JComboBox();
				getContentPane().add(Zona);
				Zona.setModel(ZonaModel);
				Zona.setBounds(20, 189, 122, 27);
			}
			{
				administracionReclamosZona = new JLabel();
				getContentPane().add(administracionReclamosZona);
				administracionReclamosZona.setText("Administracion de Reclamos Zonales");
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
				jldescripcion.setBounds(191, 86, 92, 22);
			}
			{
				jtdescripcion = new JLabel("entrega de productos compertidos");
				getContentPane().add(jtdescripcion);
				jtdescripcion.setBounds(340, 87, 204, 23);
			}
			{
				jlzona = new JLabel();
				getContentPane().add(jlzona);
				jlzona.setText("Zona ReclamoView :");
				jlzona.setBounds(191, 129, 110, 17);
			}
			{
				jtzona = new JLabel();
				getContentPane().add(jtzona);
				jtzona.setText("la zona");
				jtzona.setBounds(340, 120, 93, 20);
			}
			{
				jlfechamodif = new JLabel();
				getContentPane().add(jlfechamodif);
				jlfechamodif.setText("Fecha Modificacion :");
				jlfechamodif.setBounds(191, 165, 137, 21);
			}
			{
				jldescrip = new JLabel();
				getContentPane().add(jldescrip);
				jldescrip.setText("Descripcion Modif : ");
				jldescrip.setBounds(191, 200, 130, 20);
			}
			{
				jtdescripmodif = new JTextField();
				getContentPane().add(jtdescripmodif);
				jtdescripmodif.setBounds(339, 199, 108, 22);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(340, 164, 92, 23);
			}
			{
				jlestado = new JLabel();
				getContentPane().add(jlestado);
				jlestado.setText("Estado : ");
				jlestado.setBounds(191, 237, 93, 16);
			}
			{
				jtestadorec = new JTextField();
				getContentPane().add(jtestadorec);
				jtestadorec.setBounds(339, 236, 120, 19);
			}
			{
				JBmodif = new JButton();
				getContentPane().add(JBmodif);
				JBmodif.setText("Actualizar");
				JBmodif.setBounds(234, 311, 99, 23);
			}

		/*	panel.setPreferredSize(new java.awt.Dimension(113, 346));*/

			//pack();
			this.setSize(686, 656);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
