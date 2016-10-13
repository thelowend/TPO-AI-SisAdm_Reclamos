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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;


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
	private JPanel panel;
	private JTextField txtUsuario;
	private JPasswordField pswClave;

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
		setTitle("Sistema de Administraci\u00F3n de Reclamos");
		{
			panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblSistemaDeAdministracin = new JLabel();
			lblSistemaDeAdministracin.setVerticalAlignment(SwingConstants.TOP);
			lblSistemaDeAdministracin.setText("Administraci\u00F3n de Reclamos");
			lblSistemaDeAdministracin.setHorizontalAlignment(SwingConstants.CENTER);
			lblSistemaDeAdministracin.setFont(new Font("Verdana", Font.BOLD, 20));
			lblSistemaDeAdministracin.setBounds(0, 22, 504, 23);
			panel.add(lblSistemaDeAdministracin);
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(178, 94, 172, 25);
			panel.add(txtUsuario);
			
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setLabelFor(txtUsuario);
			lblUsuario.setBounds(117, 94, 62, 25);
			panel.add(lblUsuario);
			
			JLabel lblClave = new JLabel();
			lblClave.setText("Clave :");
			lblClave.setBounds(117, 137, 62, 25);
			panel.add(lblClave);
			
			JButton btnLogIn = new JButton();
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tryLogin();
				}
			});
			btnLogIn.setText("Iniciar Sesion");
			btnLogIn.setBounds(178, 179, 172, 25);
			panel.add(btnLogIn);
			
			pswClave = new JPasswordField();
			lblClave.setLabelFor(pswClave);
			pswClave.setBounds(178, 137, 172, 25);
			panel.add(pswClave);
			
			JLabel lblalpha = new JLabel("(Alpha 0.1)");
			lblalpha.setHorizontalAlignment(SwingConstants.RIGHT);
			lblalpha.setBounds(316, 48, 94, 14);
			panel.add(lblalpha);
			
			//Login con tecla ENTER
			panel.getRootPane().setDefaultButton(btnLogIn);
		}
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			//pack();
			this.setSize(520, 270);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void tryLogin() {
		if (Controller.getInstancia().ValidarIngreso(txtUsuario.getText(), new String(pswClave.getPassword())).getRoles()
				.stream().filter(role -> role.getRoleName().compareTo("CallCenter") == 0).count() > 0){
			RegistroReclamoZona tz = new RegistroReclamoZona();
			//tz.run();
		}
		else{

		}
	}
}
