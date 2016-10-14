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
public class TableroZona extends javax.swing.JFrame {
    private JButton JBmodif;
    private JTextField textEstado;
    private JLabel lblEstado;
    private JTextField textFecha;
    private JLabel textDescripcion;
    private JTextField textDescripModif;
    private JLabel lblDescModif;
    private JLabel lblFechaModif;
    private JLabel textZona;
    private JLabel lblZonaReclamoView;
    private JLabel lblDescripcion;
    private JLabel textNroCliente;
    private JLabel lblNroCliente;
    @SuppressWarnings("rawtypes")
	private JComboBox cboZona;
    @SuppressWarnings("rawtypes")
	private JComboBox cboFecha;
    @SuppressWarnings("rawtypes")
	private JComboBox cboCliente;
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
		setTitle("Tablero de Reclamos por Zona");
		initGUI();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				cboFecha = new JComboBox();
				cboFecha.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cboFecha.getSelectedIndex() > 0) {
							cboZona.setEnabled(true);
							textFecha.setText(cboFecha.getSelectedItem().toString());
						}
					}
				});
				getContentPane().add(cboFecha);
				cboFecha.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Fecha> ", "02/06/2016", "05/03/2016"}));
				cboFecha.setBounds(20, 30, 240, 20);
			}
			{
				cboZona = new JComboBox();
				cboZona.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cboZona.getSelectedIndex() > 0) {
							cboCliente.setEnabled(true);
							textZona.setText(cboZona.getSelectedItem().toString());
						}
					}
				});
				cboZona.setEnabled(false);
				getContentPane().add(cboZona);
				cboZona.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione zona>", "Belgrano", "Palermo", "Tigre"}));
				cboZona.setBounds(20, 80, 240, 20);
			}
			{
				JBmodif = new JButton();
				getContentPane().add(JBmodif);
				JBmodif.setText("Actualizar");
				JBmodif.setBounds(20, 363, 398, 23);
			}
			
			JLabel label = new JLabel("Seleccionar Zona:");
			label.setBounds(20, 60, 133, 14);
			getContentPane().add(label);
			
			JLabel lblFecha = new JLabel("Seleccionar Fecha:");
			lblFecha.setBounds(20, 11, 122, 14);
			getContentPane().add(lblFecha);
			
			JLabel lblCliente = new JLabel("Cliente:");
			lblCliente.setBounds(270, 11, 46, 14);
			getContentPane().add(lblCliente);
			
			cboCliente = new JComboBox();
			cboCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textNroCliente.setText(cboCliente.getSelectedItem().toString());
				}
			});
			
			cboCliente.setEnabled(false);
			cboCliente.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione Cliente>", "2", "4", "17"}));
			cboCliente.setBounds(270, 30, 148, 20);
			getContentPane().add(cboCliente);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 112, 434, 240);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				lblNroCliente = new JLabel();
				lblNroCliente.setBounds(20, 10, 130, 20);
				panel.add(lblNroCliente);
				lblNroCliente.setText("N\u00FAmero Cliente:");
			}
			{
				lblDescripcion = new JLabel();
				lblDescripcion.setBounds(20, 48, 130, 20);
				panel.add(lblDescripcion);
				lblDescripcion.setText("Descripci\u00F3n : ");
			}
			{
				lblZonaReclamoView = new JLabel();
				lblZonaReclamoView.setBounds(20, 86, 130, 20);
				panel.add(lblZonaReclamoView);
				lblZonaReclamoView.setText("Zona ReclamoView :");
			}
			{
				lblFechaModif = new JLabel();
				lblFechaModif.setBounds(20, 124, 130, 20);
				panel.add(lblFechaModif);
				lblFechaModif.setText("Fecha Modificaci\u00F3n :");
			}
			{
				lblDescModif = new JLabel();
				lblDescModif.setBounds(20, 162, 130, 20);
				panel.add(lblDescModif);
				lblDescModif.setText("Descripci\u00F3n Modificaci\u00F3n : ");
			}
			{
				lblEstado = new JLabel();
				lblEstado.setBounds(20, 200, 130, 20);
				panel.add(lblEstado);
				lblEstado.setText("Estado : ");
			}
			{
				textNroCliente = new JLabel("<nroCliente>");
				textNroCliente.setBounds(156, 10, 240, 20);
				panel.add(textNroCliente);
			}
			{
				textDescripcion = new JLabel("<Descripci\u00F3n>");
				textDescripcion.setBounds(156, 48, 240, 20);
				panel.add(textDescripcion);
			}
			{
				textZona = new JLabel();
				textZona.setBounds(156, 86, 240, 20);
				panel.add(textZona);
				textZona.setText("<Zona>");
			}
			{
				textFecha = new JTextField();
				textFecha.setBounds(156, 124, 240, 20);
				panel.add(textFecha);
			}
			{
				textDescripModif = new JTextField();
				textDescripModif.setBounds(155, 162, 241, 20);
				panel.add(textDescripModif);
			}
			{
				textEstado = new JTextField();
				textEstado.setBounds(155, 200, 241, 20);
				panel.add(textEstado);
			}

			//pack();
			this.setSize(450, 440);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
