package GUI;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;


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
public class TableroConsulta extends javax.swing.JFrame {
    private JButton tiempoResp;
    private JButton tratRec;
    private JButton recMes;
    private JButton rankingCli;
    @SuppressWarnings({ "rawtypes", "unused" })
	private JComboBox recCantidades;
    private JButton JBmodif;
    private JLabel administracionReclamosZona;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TableroConsulta inst = new TableroConsulta();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TableroConsulta() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				administracionReclamosZona = new JLabel();
				administracionReclamosZona.setHorizontalAlignment(SwingConstants.CENTER);
				getContentPane().add(administracionReclamosZona);
				administracionReclamosZona.setText("Generacion de Reportes");
				administracionReclamosZona.setBounds(102, 55, 195, 43);
			}
			{
				JBmodif = new JButton();
				getContentPane().add(JBmodif);
				JBmodif.setText("Archivar");
				JBmodif.setBounds(152, 231, 99, 23);
			}
			{
				rankingCli = new JButton();
				getContentPane().add(rankingCli);
				rankingCli.setText("Clientes Mayor Reclamos");
				rankingCli.setBounds(102, 95, 195, 23);
			}
			{
				recMes = new JButton();
				getContentPane().add(recMes);
				recMes.setText("Reclamos en el Mes");
				recMes.setBounds(102, 129, 195, 23);
			}
			{
				tratRec = new JButton();
				getContentPane().add(tratRec);
				tratRec.setText("Reclamos Finalizados");
				tratRec.setBounds(102, 163, 195, 23);
			}
			{
				tiempoResp = new JButton();
				getContentPane().add(tiempoResp);
				tiempoResp.setText("Resolucion Reclamo (tiempo) ");
				tiempoResp.setBounds(102, 197, 195, 23);
			}

		/*	panel.setPreferredSize(new java.awt.Dimension(113, 346));*/

			//pack();
			this.setSize(578, 396);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
