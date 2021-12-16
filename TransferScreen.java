import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sat Dec 11 22:59:04 CST 2021
 */

/**
 * @author Xudong Gao
 */
public class TransferScreen extends JFrame {
    private Client client;
    private Account account;
    private SessionHandler s;

    public TransferScreen(Account a, Client c) {
        this.account = a;
        this.client = c;
        initComponents();
        this.s = SessionHandler.getInstance();
    }

    private void accountInfoActionPerformed(ActionEvent e) {
        new AccountInfoScreen(account, client).setVisible(true);
    }

    private void cancelActionPerformed(ActionEvent e) {
        this.dispose();

    }

    private void confirmActionPerformed(ActionEvent e) {
        String acc = (String) comboBox3.getSelectedItem().toString();
        String curr = (String) comboBox1.getSelectedItem().toString();
        String number = textField1.getText();
        if (isPositiveNum(number) == true) {
            float amount = Float.parseFloat(number);
            if (amount > 0) {
                Money m = new Money(curr, amount);
                if (acc.equals("Saving Account")) {
                    if (this.client.isAccountExist("SAVING") == true) {
                        if (account.getCurrMoney(curr) >= amount) {
                            client.getAccountManager().transferMoney(this.account, this.client.getSavingAccount(), m);
                            this.s.addLog(client.getUserName() + " transfered" + m.toString() + " from "
                                    + this.account.getAccountType() + " to SAVING");
                            JOptionPane.showMessageDialog(null, "Success! You action is completed.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Action failed! Insufficient balance.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Action failed! You don't have this type of account.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (acc.equals("Checking Account")) {
                    if (this.client.isAccountExist("CHECKING") == true) {
                        if (account.getCurrMoney(curr) >= amount) {
                            client.getAccountManager().transferMoney(this.account, this.client.getCheckingAccount(), m);
                            this.s.addLog(client.getUserName() + " transfered" + m.toString() + " from "
                                    + this.account.getAccountType() + " to CHECKING");
                            JOptionPane.showMessageDialog(null, "Success! You action is completed.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Action failed! Insufficient balance.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Action failed! You don't have this type of account.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (this.client.isAccountExist("STOCK") == true) {
                        if (this.account.getAccountType() == "SAVING") {
                            if (account.getCurrMoney(curr) >= amount && amount >= 1000
                                    && this.client.getSavingAccount().getBalance() - amount >= 2500) {
                                client.getAccountManager().transferMoney(this.account, this.client.getStockAccount(),
                                        m);
                                this.s.addLog(client.getUserName() + " transfered" + m.toString() + " from "
                                        + this.account.getAccountType() + " to STOCK");
                                JOptionPane.showMessageDialog(null, "Success! You action is completed.", "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Action failed! Insufficient balance.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Action failed! You have to transfer from Saving Account.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Action failed! You don't have this type of account.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Action failed! Invalid number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Action failed! Invalid input.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static boolean isPositiveNum(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        label1 = new JLabel();
        comboBox1 = new JComboBox<>();
        textField1 = new JTextField();
        comboBox3 = new JComboBox<>();
        cancel = new JButton();
        confirm = new JButton();
        accountInfo = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();

        // ======== this ========
        var contentPane = getContentPane();

        // ---- label1 ----
        label1.setText("Transfer");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));

        // ---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "USD", "EUR", "CNY", "JPY" }));

        // ---- comboBox3 ----
        comboBox3.setModel(
                new DefaultComboBoxModel<>(new String[] { "Saving Account", "Checking account", "Stock account" }));

        // ---- cancel ----
        cancel.setText("Cancel");
        cancel.addActionListener(e -> cancelActionPerformed(e));

        // ---- confirm ----
        confirm.setText("Confirm");
        confirm.addActionListener(e -> confirmActionPerformed(e));

        // ---- accountInfo ----
        accountInfo.setText("Account Infomation");
        accountInfo.addActionListener(e -> accountInfoActionPerformed(e));

        // ---- label2 ----
        label2.setText("From:");

        // ---- label3 ----
        label3.setText("To:");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup().addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(86, 86, 86)
                                .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(121, 121, 121)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(127, 127, 127).addComponent(
                                comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(60, 60, 60).addGroup(
                                contentPaneLayout.createParallelGroup().addComponent(label2).addComponent(label3)))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(159, 159, 159).addComponent(label1,
                                GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(145, 145, 145).addComponent(
                                accountInfo, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(102, Short.MAX_VALUE)));
        contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                .createSequentialGroup().addGap(31, 31, 31)
                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountInfo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12).addComponent(label2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14).addComponent(label3).addGap(1, 1, 1)
                .addComponent(
                        comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE)));
        setSize(475, 450);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JLabel label1;
    private JComboBox<String> comboBox1;
    private JTextField textField1;
    private JComboBox<String> comboBox3;
    private JButton cancel;
    private JButton confirm;
    private JButton accountInfo;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration //GEN-END:variables
}
