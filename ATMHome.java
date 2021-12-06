import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Dec 06 20:39:28 CST 2021
 */



/**
 * @author unknown
 */
public class ATMHome extends JFrame {
    public ATMHome() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        panel4 = new JPanel();
        panel3 = new JPanel();
        panel2 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel4 ========
        {
            panel4.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),
            java.awt.Color.red),panel4. getBorder()));panel4. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))
            throw new RuntimeException();}});
            panel4.setLayout(new BorderLayout());
        }
        contentPane.add(panel4, BorderLayout.EAST);

        //======== panel3 ========
        {
            panel3.setLayout(new BorderLayout());
        }
        contentPane.add(panel3, BorderLayout.WEST);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());
        }
        contentPane.add(panel2, BorderLayout.SOUTH);

        //======== panel5 ========
        {
            panel5.setLayout(new BorderLayout());
        }
        contentPane.add(panel5, BorderLayout.NORTH);

        //======== panel6 ========
        {
            panel6.setLayout(new BorderLayout());

            //---- label1 ----
            label1.setText("ATM");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel6.add(label1, BorderLayout.NORTH);
            panel6.add(textField1, BorderLayout.CENTER);
        }
        contentPane.add(panel6, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JPanel panel4;
    private JPanel panel3;
    private JPanel panel2;
    private JPanel panel5;
    private JPanel panel6;
    private JLabel label1;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
