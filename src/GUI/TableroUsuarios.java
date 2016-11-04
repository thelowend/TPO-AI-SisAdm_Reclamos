package GUI;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Main.Controller;

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
public class TableroUsuarios extends javax.swing.JFrame {
    private JTextField textContrasena;
    private JTextField textUsuario;
    private JLabel Tipo;
    private JLabel lblClave;
    private JLabel lblNomUsuario;
    private JButton jButton3;
    private JButton jButton2;
    private JButton jButton1;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TableroUsuarios inst = new TableroUsuarios();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TableroUsuarios() {
		super();
		setTitle("Administrador de Usuarios");
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Agregar");
				jButton1.setBounds(343, 106, 90, 25);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Modificar");
				jButton2.setBounds(240, 107, 90, 23);
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Baja");
				jButton3.setBounds(133, 107, 90, 23);
			}
			{
				lblNomUsuario = new JLabel();
				getContentPane().add(lblNomUsuario);
				lblNomUsuario.setText("Nombre de Usuario:");
				lblNomUsuario.setBounds(10, 11, 113, 23);
			}
			{
				lblClave = new JLabel();
				getContentPane().add(lblClave);
				lblClave.setText("Contrase\u00F1a:");
				lblClave.setBounds(10, 48, 113, 16);
			}
			{
				Tipo = new JLabel();
				getContentPane().add(Tipo);
				Tipo.setText("Rol:");
				Tipo.setBounds(10, 75, 113, 16);
			}
			{
				textUsuario = new JTextField();
				getContentPane().add(textUsuario);
				textUsuario.setBounds(133, 11, 300, 23);
			}
			{
				textContrasena = new JTextField();
				getContentPane().add(textContrasena);
				textContrasena.setBounds(133, 45, 300, 23);
			}
			
			JComboBox comboBox = new JComboBox(Controller.getInstancia().listRoles().toArray());
			comboBox.setBounds(133, 75, 300, 20);
			
			getContentPane().add(comboBox);

		/*	panel.setPreferredSize(new java.awt.Dimension(113, 346));*/

			//pack();
			this.setSize(460, 180);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
