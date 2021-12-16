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
    private Client client;
    private String accountType;
    private boolean isDeposit;
    private SessionHandler s;

    public DepositWithdrawScreen(boolean isDeposit, Client c, String accountType) {
        initComponents();
        this.client = c;
        this.accountType = accountType;
        this.isDeposit = isDeposit;
        this.s = SessionHandler.getInstance();
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
        if (accountType.equals("SAVING")) {
            new AccountInfoScreen(client.getSavingAccount(), client).setVisible(true);
        } else if (accountType.equals("CHECKING")) {
            new AccountInfoScreen(client.getCheckingAccount(), client).setVisible(true);
        } else {
            new AccountInfoScreen(client.getStockAccount(), client).setVisible(true);
        }

    }

    private void switchAccActionPerformed(ActionEvent e) {
        String[] options = { "Saving Account", "Checking Account", "Securities Account" };
        String result = getSelectedAccount(options);
        if (result.equals("Saving Account")) {
            this.accountType = "SAVING";
        } else if (accountType.equals("Checking Account")) {
            this.accountType = "CHECKING";
        } else {
            this.accountType = "STOCK";
        }
    }

    private void ReturnActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void resetActionPerformed(ActionEvent e) {
        textField1.setText(null);
    }

    private void confirmActionPerformed(ActionEvent e) {
        String curr = (String) comboBox1.getSelectedItem().toString();
        String number = textField1.getText();
        if (isPositiveNum(number) == true) {
            float amount = Float.parseFloat(number);
            if (amount > 0) {
                Money m = new Money(curr, amount);
                AccountManager am = client.getAccountManager();
                if (isDeposit == true) {
                    if (accountType.equals("SAVING")) {
                        am.deposit(client.getSavingAccount(), m);
                        this.s.addLog(client.getUserName() + " deposited " + m.toString() + " into SAVING");
                        JOptionPane.showMessageDialog(null, "Success! You action is completed.", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (accountType.equals("CHECKING")) {
                        am.deposit(client.getCheckingAccount(), m);
                        this.s.addLog(client.getUserName() + " deposited " + m.toString() + " into CHECKING");
                        JOptionPane.showMessageDialog(null, "Success! You action is completed.", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        am.deposit(client.getStockAccount(), m);
                        this.s.addLog(client.getUserName() + " deposited " + m.toString() + " into STOCK");
                        JOptionPane.showMessageDialog(null, "Success! You action is completed.", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                } else if (isDeposit == false) {
                    if (accountType.equals("SAVING")) {
                        if ((client.getSavingAccount().getCurrMoney(curr) + am.calculateFee(m)) >= amount) {
                            am.withdraw(client.getSavingAccount(), m);
                            this.s.addLog(client.getUserName() + " withdrawn " + m.toString() + " from SAVING");
                            JOptionPane.showMessageDialog(null, "Success! You action is completed.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Action failed! Not enough money.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else if (accountType.equals("CHECKING")) {
                        if ((client.getCheckingAccount().getCurrMoney(curr) + am.calculateFee(m)) >= amount) {
                            am.withdraw(client.getCheckingAccount(), m);
                            this.s.addLog(client.getUserName() + " withdrawn " + m.toString() + " from CHECKING");
                            JOptionPane.showMessageDialog(null, "Success! You action is completed.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Action failed! Not enough money.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        if ((client.getStockAccount().getCurrMoney(curr) + am.calculateFee(m)) >= amount) {
                            am.withdraw(client.getStockAccount(), m);
                            this.s.addLog(client.getUserName() + " withdrawn " + m.toString() + " from STOCK");
                            JOptionPane.showMessageDialog(null, "Success! You action is completed.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Action failed! Not enough money.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                this.dispose();
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
        reset.addActionListener(e -> resetActionPerformed(e));

        // ---- confirm ----
        confirm.setText("Confirm");
        confirm.addActionListener(e -> {
            confirmActionPerformed(e);
        });

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
                .addGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(136, 136, 136).addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(reset, GroupLayout.PREFERRED_SIZE, 130,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34).addComponent(confirm, GroupLayout.PREFERRED_SIZE, 130,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 110,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 178,
                                                GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup().addContainerGap()
                                .addComponent(Return, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102).addComponent(account).addGap(47, 47, 47).addComponent(switchAcc))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(96, 96, 96)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 395,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(18, 18, 18)
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 354,
                                                        GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE)));
        contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup().addGap(22, 22, 22)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(switchAcc, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(account, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Return, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(label1)
                        .addGap(32, 32, 32)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(reset, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
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
