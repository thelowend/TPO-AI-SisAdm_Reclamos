package Main;
import RegistroReclamos.RegistroReclamoCantidades;
import RegistroReclamos.RegistroReclamoZona;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.TabableView;


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
public class login extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JLabel jContrasena;
	private JLabel jLogin;
	private JButton jregistrarse;
	private JTextField jClave;
	private JTextField jtextUsuario;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				login inst = new login();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public login() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.WEST);
				FlowLayout jPanel1Layout = new FlowLayout();
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBounds(66, 91, 81, 32);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Usuario: ");
				/*	jLabel1.setPreferredSize(new java.awt.Dimension(139, 21));*/
				/*	jLabel1.setSize(200, 21);*/
					jLabel1.setBounds(600, 600, 200, 21);
					jLabel1.setPreferredSize(new java.awt.Dimension(58, 29));

				}
			}
			{
				jtextUsuario = new JTextField();
				getContentPane().add(jtextUsuario);
				jtextUsuario.setBounds(190, 100, 149, 23);
			}
			{
				jContrasena = new JLabel();
				getContentPane().add(jContrasena);
				jContrasena.setText("Clave :");
				jContrasena.setBounds(78, 156, 65, 25);
			}
			{
				jClave = new JTextField();
				getContentPane().add(jClave);
				jClave.setBounds(190, 155, 149, 23);
			}
			{
				jLogin = new JLabel();
				getContentPane().add(jLogin);
				jLogin.setText("Administracion Reclamos");
				jLogin.setBounds(190, 28, 256, 16);
			}
			{
				jregistrarse = new JButton();
				getContentPane().add(jregistrarse);
				jregistrarse.setText("Iniciar Sesion");
				jregistrarse.setBounds(183, 220, 171, 23);
				jregistrarse.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						tryLogin();
					}
				});
			}
			//pack();
			this.setSize(304, 278);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void tryLogin(){
		if (Controller.getInstancia().ValidarIngreso(jtextUsuario.getText(),jClave.getText()).getRoles()
				.stream().filter(role -> role.getRoleName().compareTo("CallCenter") == 0).count() > 0){
			RegistroReclamoZona tz = new RegistroReclamoZona();
			//tz.run();
		}
		else{

		}
	}

}
