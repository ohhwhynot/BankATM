import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Thu Dec 09 20:12:57 CST 2021
 */

/**
 * @author Xudong Gao
 */
public class ExchangeScreen extends JFrame {
        private Client client;
        private Account account;
        private Currency curr;

        public ExchangeScreen(Account a, Client c) {
                this.client = c;
                this.account = a;
                this.curr = new Currency();
                initComponents();
                label3.setText("Exchanged Amount:");
        }

        private void buttonCancelActionPerformed(ActionEvent e) {
                this.dispose();
        }

        private void buttonConfirmActionPerformed(ActionEvent e) {
                String currout = (String) comboBox1.getSelectedItem().toString();
                String currin = (String) comboBox2.getSelectedItem().toString();
                String number = scr.getText();

                if (isPositiveNum(number) == true) {
                        float amount = Float.parseFloat(number);
                        if (amount > 0) {
                                if (this.account.getCurrMoney(currout) >= amount) {
                                        account.convertTo(convertToIndex(currout), convertToIndex(currin));
                                        moneyT.setText(String.valueOf(curr.getValue(currin)));
                                        ServiceFee.setText(String.valueOf(account.getCurrMoney(currin)));
                                        JOptionPane.showMessageDialog(null, "Success! You action is completed.",
                                                        "Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                        JOptionPane.showMessageDialog(null, "Action failed! Insufficient balance.",
                                                        "Error", JOptionPane.ERROR_MESSAGE);
                                }
                        } else {
                                JOptionPane.showMessageDialog(null, "Action failed! Invalid number.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else {
                        JOptionPane.showMessageDialog(null, "Action failed! Invalid input.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                }

        }

        private void viewAccountInfoActionPerformed(ActionEvent e) {
                new AccountInfoScreen(this.account, this.client).setVisible(true);
        }

        public static boolean isPositiveNum(String str) {
                for (char c : str.toCharArray()) {
                        if (!Character.isDigit(c))
                                return false;
                }
                return true;
        }

        public int convertToIndex(String str) {
                if (str.equalsIgnoreCase("USD")) {
                        return 0;
                } else if (str.equalsIgnoreCase("EUR")) {
                        return 1;
                } else if (str.equalsIgnoreCase("CNY")) {
                        return 2;
                } else {
                        return 3;
                }
        }

        private void initComponents() {
                // JFormDesigner - Component initialization - DO NOT MODIFY
                // //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Xudong Gao
                comboBox1 = new JComboBox<>();
                scr = new JTextField();
                comboBox2 = new JComboBox<>();
                label2 = new JLabel();
                exRate = new JLabel();
                moneyT = new JLabel();
                buttonCancel = new JButton();
                buttonConfirm = new JButton();
                label3 = new JLabel();
                ServiceFee = new JLabel();
                viewAccountInfo = new JButton();
                label4 = new JLabel();
                separator1 = new JSeparator();

                //======== this ========
                var contentPane = getContentPane();

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "USD",
                    "EUR",
                    "CNY",
                    "JPY"
                }));

                //---- comboBox2 ----
                comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                    "USD",
                    "EUR",
                    "CNY",
                    "JPY"
                }));

                //---- label2 ----
                label2.setText("Currency exchange rate:");

                //---- moneyT ----
                moneyT.setText("0");

                //---- buttonCancel ----
                buttonCancel.setText("Cancel");
                buttonCancel.addActionListener(e -> buttonCancelActionPerformed(e));

                //---- buttonConfirm ----
                buttonConfirm.setText("Confirm");
                buttonConfirm.addActionListener(e -> buttonConfirmActionPerformed(e));

                //---- label3 ----
                label3.setText("Service charge:");

                //---- ServiceFee ----
                ServiceFee.setText("0");

                //---- viewAccountInfo ----
                viewAccountInfo.setText("Account Information");
                viewAccountInfo.addActionListener(e -> viewAccountInfoActionPerformed(e));

                //---- label4 ----
                label4.setText("EXCHANGE");
                label4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 26));

                GroupLayout contentPaneLayout = new GroupLayout(contentPane);
                contentPane.setLayout(contentPaneLayout);
                contentPaneLayout.setHorizontalGroup(
                    contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(moneyT, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                            .addGap(50, 50, 50))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(scr, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                            .addGap(45, 45, 45))))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(96, 96, 96)
                                            .addComponent(label4))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(39, 39, 39)
                                            .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(79, 79, 79)
                                            .addComponent(viewAccountInfo, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(61, 61, 61)
                                            .addComponent(label3)
                                            .addGap(18, 18, 18)
                                            .addComponent(ServiceFee, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(59, 59, 59)
                                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                    .addComponent(buttonCancel)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(buttonConfirm))
                                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                    .addComponent(label2)
                                                    .addGap(46, 46, 46)
                                                    .addComponent(exRate, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap(25, Short.MAX_VALUE))
                );
                contentPaneLayout.setVerticalGroup(
                    contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(label4)
                            .addGap(9, 9, 9)
                            .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(viewAccountInfo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(scr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(exRate)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(moneyT))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(ServiceFee))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonCancel)
                                .addComponent(buttonConfirm))
                            .addGap(53, 53, 53))
                );
                setSize(355, 420);
                setLocationRelativeTo(getOwner());
                // JFormDesigner - End of component initialization //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        private JComboBox<String> comboBox1;
        private JTextField scr;
        private JComboBox<String> comboBox2;
        private JLabel label2;
        private JLabel exRate;
        private JLabel moneyT;
        private JButton buttonCancel;
        private JButton buttonConfirm;
        private JLabel label3;
        private JLabel ServiceFee;
        private JButton viewAccountInfo;
        private JLabel label4;
        private JSeparator separator1;
        // JFormDesigner - End of variables declaration //GEN-END:variables
}
