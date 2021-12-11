import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Thu Dec 09 11:58:05 CST 2021
 */

/**
 * @author Xudong Gao
 */
public class AccountInfoScreen extends JFrame {
    public AccountInfoScreen() {
        initComponents();

    }

    private void buttonConfirmPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        balanceTable = new JTable();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        button1 = new JButton();

        // ======== this ========
        setTitle("Account information");
        var contentPane = getContentPane();

        // ---- label1 ----
        label1.setText("Username:");

        // ---- label2 ----
        label2.setText("Account type:");

        // ======== scrollPane1 ========
        {
            scrollPane1.setName("a");

            // ---- balanceTable ----
            balanceTable.setModel(new DefaultTableModel(
                    new Object[][] { { "USD", "0" }, { "EUR", "0" }, { "CNY", "0" }, { "JPY", "0" }, },
                    new String[] { null, null }));
            balanceTable.setToolTipText("mm");
            balanceTable.setBorder(null);
            balanceTable.setAutoCreateColumnsFromModel(false);
            scrollPane1.setViewportView(balanceTable);
        }

        // ---- label3 ----
        label3.setText("Balance:");

        // ---- label4 ----
        label4.setText("Loan:");

        // ---- label5 ----
        label5.setText("None");

        // ---- button1 ----
        button1.setText("Confirm");
        button1.addActionListener(e -> buttonConfirmPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                .createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(24, 24, 24).addGroup(contentPaneLayout.createParallelGroup().addComponent(label1)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3)
                                .addGroup(contentPaneLayout.createSequentialGroup().addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(label5))))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(98, 98, 98).addComponent(scrollPane1,
                                GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addGap(0, 170, Short.MAX_VALUE).addComponent(button1).addGap(165, 165, 165)));
        contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup().addGap(33, 33, 33).addComponent(label1)
                        .addGap(18, 18, 18).addComponent(label2).addGap(18, 18, 18).addComponent(label3).addGap(1, 1, 1)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4).addComponent(label5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(button1)
                        .addGap(36, 36, 36)));
        setSize(435, 430);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable balanceTable;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton button1;
    // JFormDesigner - End of variables declaration //GEN-END:variables
}
