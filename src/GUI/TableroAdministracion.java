package GUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.ListModel;
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
public class TableroAdministracion extends javax.swing.JFrame {
    private JPanel    panel;
    private JTextField texRol;
    private JTextField textContrasena;
    private JTextField textUsuario;
    private JLabel Tipo;
    private JLabel clave;
    private JLabel usuario;
    private JButton jButton3;
    private JButton jButton2;
    private JButton jButton1;
    private JButton JBmodif;
    private JLabel administracionReclamosZona;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TableroAdministracion inst = new TableroAdministracion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TableroAdministracion() {
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
				administracionReclamosZona = new JLabel();
				getContentPane().add(administracionReclamosZona);
				administracionReclamosZona.setText("Administracion Usuarios");
				administracionReclamosZona.setBounds(179, 12, 221, 18);
			}
			{
				JBmodif = new JButton();
				getContentPane().add(JBmodif);
				JBmodif.setText("Aplicar");
				JBmodif.setBounds(234, 311, 99, 23);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Agregar");
				jButton1.setBounds(70, 73, 96, 25);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Modificar");
				jButton2.setBounds(70, 109, 96, 23);
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Baja");
				jButton3.setBounds(70, 152, 96, 23);
			}
			{
				usuario = new JLabel();
				getContentPane().add(usuario);
				usuario.setText("Usuario");
				usuario.setBounds(202, 73, 71, 23);
			}
			{
				clave = new JLabel();
				getContentPane().add(clave);
				clave.setText("Contraseña");
				clave.setBounds(202, 112, 71, 16);
			}
			{
				Tipo = new JLabel();
				getContentPane().add(Tipo);
				Tipo.setText("Rol");
				Tipo.setBounds(202, 155, 58, 16);
			}
			{
				textUsuario = new JTextField();
				getContentPane().add(textUsuario);
				textUsuario.setBounds(302, 68, 118, 23);
			}
			{
				textContrasena = new JTextField();
				getContentPane().add(textContrasena);
				textContrasena.setBounds(302, 109, 113, 23);
			}
			{
				texRol = new JTextField();
				getContentPane().add(texRol);
				texRol.setBounds(302, 152, 118, 23);
			}

		/*	panel.setPreferredSize(new java.awt.Dimension(113, 346));*/

			//pack();
			this.setSize(578, 396);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}