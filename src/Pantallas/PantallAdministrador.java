/*
 * Created by JFormDesigner on Thu Sep 22 00:01:13 ART 2016
 */

package Pantallas;

import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author unknown
 */
public class PantallAdministrador extends JPanel {
    public PantallAdministrador() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - elad haim
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu2 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "default, $lcgap, default",
            "2*(default, $lgap), default"));

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Administradores");

                //---- menuItem4 ----
                menuItem4.setText("Agregar Usuarios");
                menu1.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("Modificar Usuarios");
                menu1.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("Borrar Usuarios");
                menu1.add(menuItem6);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Roles");

                //---- menuItem1 ----
                menuItem1.setText("Agregar Roles");
                menu2.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("Modificar Roles");
                menu2.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("Borrar Roles");
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);
        }
        add(menuBar1, CC.xy(1, 1));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - elad haim
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu2;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
