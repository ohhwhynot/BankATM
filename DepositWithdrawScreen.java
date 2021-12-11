import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 08 17:46:10 CST 2021
 */

/**
 * @author Xudong Gao
 */
public class DepositWithdrawScreen extends JFrame {
        public DepositWithdrawScreen(boolean isDeposit, Client c) {
                initComponents();
                if (!isDeposit) {
                        this.label1.setText("Please input the amount you want to withdraw");
                }
        }

        private String getSelectedAccount(String[] options) {
                String result = (String) JOptionPane.showInputDialog(this, " ", "Please select an account to continue:",
                                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                return result;
        }

        private void accountActionPerformed(ActionEvent e) {
                new AccountInfoScreen().setVisible(true);
                // TODO add your code here
        }

        private void switchAccActionPerformed(ActionEvent e) {
                String[] options = { "Saving Account", "Checking Account", "Securities Account" };// todo
                String result = getSelectedAccount(options);

                // TODO add your code here
        }

        private void ReturnActionPerformed(ActionEvent e) {
                this.dispose();
                // TODO add your code here
        }

        private void initComponents() {
                // JFormDesigner - Component initialization - DO NOT MODIFY
                // //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Xudong Gao
                textField1 = new JTextField();
                separator1 = new JSeparator();
                label1 = new JLabel();
                comboBox1 = new JComboBox<>();
                reset = new JButton();
                confirm = new JButton();
                Return = new JButton();
                account = new JButton();
                switchAcc = new JButton();

                // ======== this ========
                var contentPane = getContentPane();

                // ---- label1 ----
                label1.setText("Please input the amount you want to deposit");

                // ---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "USD", "EUR", "CNY", "JPY" }));

                // ---- reset ----
                reset.setText("Reset");

                // ---- confirm ----
                confirm.setText("Confirm");

                // ---- Return ----
                Return.setText("Return");
                Return.addActionListener(e -> ReturnActionPerformed(e));

                // ---- account ----
                account.setText("Account Information");
                account.addActionListener(e -> accountActionPerformed(e));

                // ---- switchAcc ----
                switchAcc.setText("Switch Account");
                switchAcc.addActionListener(e -> switchAccActionPerformed(e));

                GroupLayout contentPaneLayout = new GroupLayout(contentPane);
                contentPane.setLayout(contentPaneLayout);
                contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                                .createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                                                .createSequentialGroup().addGap(136, 136, 136)
                                                .addGroup(contentPaneLayout.createParallelGroup().addGroup(
                                                                contentPaneLayout.createSequentialGroup().addComponent(
                                                                                reset, GroupLayout.PREFERRED_SIZE, 130,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(34, 34, 34)
                                                                                .addComponent(confirm,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                130,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(comboBox1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                110,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(textField1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                178,
                                                                                                GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(contentPaneLayout.createSequentialGroup().addContainerGap()
                                                                .addComponent(Return, GroupLayout.PREFERRED_SIZE, 76,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(102, 102, 102).addComponent(account)
                                                                .addGap(47, 47, 47).addComponent(switchAcc))
                                                .addGroup(contentPaneLayout.createSequentialGroup().addGap(96, 96, 96)
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                                .addComponent(separator1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                395,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(contentPaneLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(label1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                354,
                                                                                                                GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(40, Short.MAX_VALUE)));
                contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                                .createSequentialGroup().addGap(22, 22, 22)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(switchAcc, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(account, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Return, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(label1)
                                .addGap(32, 32, 32)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 47,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(reset, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(94, Short.MAX_VALUE)));
                setSize(595, 410);
                setLocationRelativeTo(getOwner());
                // JFormDesigner - End of component initialization //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        private JTextField textField1;
        private JSeparator separator1;
        private JLabel label1;
        private JComboBox<String> comboBox1;
        private JButton reset;
        private JButton confirm;
        private JButton Return;
        private JButton account;
        private JButton switchAcc;
        // JFormDesigner - End of variables declaration //GEN-END:variables
}
