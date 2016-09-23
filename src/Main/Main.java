package Main;



import Pantallas.Login;
import Vistas.RoleView;
import Vistas.UsuarioView;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<RoleView> rv = new ArrayList<RoleView>();
					UsuarioView uv = new UsuarioView();
					rv.add(new RoleView("Administrador"));
					rv.add(new RoleView("Facturtacion"));
					uv.setRoles(rv);
					uv.setLegajo("213123");
					uv.setClave("blabla");
					Controller.getInstancia().addUsuario(uv);
					rv = Controller.getInstancia().listRoles();
					ArrayList<UsuarioView> uvlist = Controller.getInstancia().listUsuarios();
					System.out.print("sdfsdf");
					/*JFrame frame = new JFrame();
					frame.setBounds(100, 100, 450, 300);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setContentPane(new Login().getLoginPanel());
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
