package GUI;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Configuracion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracion frame = new Configuracion();
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
	public Configuracion() {
		JFrame frame = this;
		setTitle("Configuración");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(5, 5, 450, 450);
		panel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 450, 450);
		panel1.add(tabbedPane);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(5, 450, 450, 40);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(133, 11, 172, 23);
		panel2.add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JFrame jfTableroUsuarios = new TableroUsuarios();
		
		tabbedPane.addTab("Usuarios", jfTableroUsuarios.getContentPane());
		
		this.setSize(465, 530);
	}

}
