import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Dec 07 21:04:03 CST 2021
 */

/**
 * @author Xudong Gao
 */
public class ClientHome extends JFrame {
        private Client client;

        public ClientHome(Client client) {
                initComponents();
                this.client = client;
                realName.setText(client.userName);

        }

        private String getSelectedAccount(String[] options) {
                String result = (String) JOptionPane.showInputDialog(this, " ", "Please select an account to continue:",
                                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                return result;
        }

        private void button4ActionPerformed(ActionEvent e) {
                // deposit
                String[] options = { "Saving Account", "Checking Account", "Securities Account" };// todo
                String result = getSelectedAccount(options);
                if (result.equals("Saving Account")) {
                        String type = "SAVING";
                        if (this.client.isAccountExist(type) == false) {
                                JOptionPane.showMessageDialog(null,
                                                "Deposit failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        } else if (this.client.isAccountExist(type) == true) {
                                new DepositWithdrawScreen(true, client, type).setVisible(true);
                        }
                } else if (result.equals("Checking Account")) {
                        String type = "CHECKING";
                        if (this.client.isAccountExist(type) == false) {
                                JOptionPane.showMessageDialog(null,
                                                "Deposit failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        } else if (this.client.isAccountExist(type) == true) {
                                new DepositWithdrawScreen(true, client, type).setVisible(true);
                        }
                } else {
                        String type = "STOCK";
                        if (this.client.isAccountExist(type) == false) {
                                JOptionPane.showMessageDialog(null,
                                                "Deposit failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        } else if (this.client.isAccountExist(type) == true) {
                                new DepositWithdrawScreen(true, client, type).setVisible(true);
                        }
                }

        }

        private void buttonLogoutPerformed(ActionEvent e) {
                this.dispose();
                new ATMHome().setVisible(true);
                // this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // TODO add your code here
        }

        private void buttonWithdrawPerformed(ActionEvent e) {
                String[] options = { "Saving Account", "Checking Account", "Securities Account" };
                String result = getSelectedAccount(options);
                if (result.equals("Saving Account")) {
                        String type = "SAVING";
                        if (this.client.isAccountExist(type) == false) {
                                JOptionPane.showMessageDialog(null,
                                                "Withdraw failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        } else if (this.client.isAccountExist(type) == true) {
                                new DepositWithdrawScreen(false, client, type).setVisible(true);
                        }
                } else if (result.equals("Checking Account")) {
                        String type = "CHECKING";
                        if (this.client.isAccountExist(type) == false) {
                                JOptionPane.showMessageDialog(null,
                                                "Withdraw failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        } else if (this.client.isAccountExist(type) == true) {
                                new DepositWithdrawScreen(false, client, type).setVisible(true);
                        }
                } else {
                        String type = "STOCK";
                        if (this.client.isAccountExist(type) == false) {
                                JOptionPane.showMessageDialog(null,
                                                "Withdraw failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        } else if (this.client.isAccountExist(type) == true) {
                                new DepositWithdrawScreen(false, client, type).setVisible(true);
                        }
                }
        }

        private void buttonCreatAccountPerformed(ActionEvent e) {
                String[] options = { "Saving Account", "Checking Account", "Securities Account" };
                String result = getSelectedAccount(options);
                if (result.equals("Saving Account")) {
                        String type = "SAVING";
                        if (this.client.isAccountExist(type) == false) {
                                this.client.createAccount(type);
                                JOptionPane.showMessageDialog(null, "Success! You have deposited 100 USD as required.",
                                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Creatation failed! You already have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else if (result.equals("Checking Account")) {
                        String type = "CHECKING";
                        if (this.client.isAccountExist(type) == false) {
                                this.client.createAccount(type);
                                JOptionPane.showMessageDialog(null, "Success! You have deposited 100 USD as required.",
                                                "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Creatation failed! You already have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else if (result.equals("Securities Account")) {
                        String type = "STOCK";
                        if (this.client.isAccountExist(type) == false) {
                                if (this.client.isAccountExist("SAVING") == false) {
                                        JOptionPane.showMessageDialog(null,
                                                        "Creatation failed! You need to have a saving account.",
                                                        "Error", JOptionPane.ERROR_MESSAGE);
                                } else if (this.client.isAccountExist("SAVING") == true) {
                                        if (this.client.getSavingAccount().getBalance() < 5000) {
                                                JOptionPane.showMessageDialog(null,
                                                                "Creatation failed! You need to have 5000 USD in a saving account.",
                                                                "Error", JOptionPane.ERROR_MESSAGE);
                                        } else if (this.client.getSavingAccount().getBalance() >= 500) {
                                                this.client.createAccount(type);
                                                JOptionPane.showMessageDialog(null,
                                                                "Success! You have deposited 100 USD as required.",
                                                                "Success", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                }
                        }
                }
        }

        private void buttonCloseAccountPerformed(ActionEvent e) {
                String[] options = { "Saving Account", "Checking Account", "Securities Account" };// todo
                String result = getSelectedAccount(options);
                if (result.equals("Saving Account")) {
                        String type = "SAVING";
                        if (this.client.isAccountExist(type) == true) {
                                if (this.client.getSavingAccount().getBalance() == 0) {
                                        this.client.closeAccount(type);
                                        JOptionPane.showMessageDialog(null, "Success! You have closed this account.",
                                                        "Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "Removal failed! Please clear out your balance.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Removal failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else if (result.equals("Checking Account")) {
                        String type = "CHECKING";
                        if (this.client.isAccountExist(type) == true) {
                                if (this.client.getCheckingAccount().getBalance() == 0) {
                                        this.client.closeAccount(type);
                                        JOptionPane.showMessageDialog(null, "Success! You have closed this account.",
                                                        "Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "Removal failed! Please clear out your balance.", "Error",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Removal failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else if (result.equals("Securities Account")) {
                        String type = "STOCK";
                        // TODO
                        // if (this.client.isAccountExist("STOCK") == true) {
                        // if (this.client.getStockAccount().getBalance() == 0) {
                        // this.client.closeAccount("STOCK");
                        // JOptionPane.showMessageDialog(null, "Success! You have closed this account.",
                        // "Success", JOptionPane.INFORMATION_MESSAGE);
                        // } else {
                        // JOptionPane.showMessageDialog(null,
                        // "Removal failed! Please clear out your balance.", "Error",
                        // JOptionPane.ERROR_MESSAGE);
                        // }
                        // } else {
                        // JOptionPane.showMessageDialog(null,
                        // "Removal failed! You don't have this type of account.", "Error",
                        // JOptionPane.ERROR_MESSAGE);
                        // }
                }

        }

        private void buttonTransferPerformed(ActionEvent e) {
                String[] options = { "Saving Account", "Checking Account", "Securities Account" };// todo
                String result = getSelectedAccount(options);
                if (result.equals("Saving Account")) {
                        String type = "SAVING";
                        if (this.client.isAccountExist(type) == true) {
                                new TransferScreen(this.client.getSavingAccount(), client).setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Action failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else if (result.equals("Checking Account")) {
                        String type = "CHECKING";
                        if (this.client.isAccountExist(type) == true) {
                                new TransferScreen(this.client.getCheckingAccount(), client).setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Action failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else {
                        String type = "STOCK";
                        if (this.client.isAccountExist(type) == true) {
                                new TransferScreen(this.client.getStockAccount(), client).setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Action failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                }
        }

        private void buttonLoanPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your credit score is not good enough", "Error",
                                JOptionPane.ERROR_MESSAGE);
                // TODO add your code here
        }

        private void buttonTradeStockPerformed(ActionEvent e) {
                new TradeStockScreen().setVisible(true);
                // TODO add your code here
        }

        private void buttonSwapPerformed(ActionEvent e) {
                String[] options = { "Saving Account", "Checking Account", "Securities Account" };
                String result = getSelectedAccount(options);
                if (result.equals("Saving Account")) {
                        String type = "SAVING";
                        if (this.client.isAccountExist(type) == true) {
                                new ExchangeScreen(client.getSavingAccount(), client).setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Action failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else if (result.equals("Checking Account")) {
                        String type = "CHECKING";
                        if (this.client.isAccountExist(type) == true) {
                                new ExchangeScreen(client.getCheckingAccount(), client).setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Action failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else {
                        String type = "STOCK";
                        if (this.client.isAccountExist(type) == true) {
                                new ExchangeScreen(client.getStockAccount(), client).setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Action failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                }
        }

        private void inquiryBalanceActionPerformed(ActionEvent e) {
                String[] options = { "Saving Account", "Checking Account", "Securities Account" };
                String result = getSelectedAccount(options);
                if (result.equals("Saving Account")) {
                        String type = "SAVING";
                        if (this.client.isAccountExist(type) == true) {
                                new AccountInfoScreen(client.getSavingAccount(), client).setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Action failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else if (result.equals("Checking Account")) {
                        String type = "CHECKING";
                        if (this.client.isAccountExist(type) == true) {
                                new AccountInfoScreen(client.getCheckingAccount(), client).setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Action failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                } else {
                        String type = "STOCK";
                        if (this.client.isAccountExist(type) == true) {
                                new AccountInfoScreen(client.getStockAccount(), client).setVisible(true);
                        } else {
                                JOptionPane.showMessageDialog(null,
                                                "Action failed! You don't have this type of account.", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                }
        }

        private void buttonRepayloanPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You don't have a loan to pay", "Error", JOptionPane.ERROR_MESSAGE);
                // TODO add your code here
        }

        private void initComponents() {
                // JFormDesigner - Component initialization - DO NOT MODIFY
                // //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Xudong Gao
                label5 = new JLabel();
                realName = new JLabel();
                label6 = new JLabel();
                credit = new JLabel();
                label8 = new JLabel();
                button2 = new JButton();
                button4 = new JButton();
                button3 = new JButton();
                button5 = new JButton();
                button6 = new JButton();
                button7 = new JButton();
                button8 = new JButton();
                button9 = new JButton();
                button10 = new JButton();
                inquiryBalance = new JButton();
                button11 = new JButton();

                // ======== this ========
                var contentPane = getContentPane();

                // ---- label5 ----
                label5.setText("Username:");

                // ---- label6 ----
                label6.setText("Credit:");

                // ---- credit ----
                credit.setText("text");

                // ---- label8 ----
                label8.setText("Please choose the business you want to do:");

                // ---- button2 ----
                button2.setText("Create a new account");
                button2.addActionListener(e -> buttonCreatAccountPerformed(e));

                // ---- button4 ----
                button4.setText("Deposit");
                button4.addActionListener(e -> button4ActionPerformed(e));

                // ---- button3 ----
                button3.setText("Close a new account");
                button3.addActionListener(e -> buttonCloseAccountPerformed(e));

                // ---- button5 ----
                button5.setText("Withdraw");
                button5.addActionListener(e -> buttonWithdrawPerformed(e));

                // ---- button6 ----
                button6.setText("Transfer");
                button6.addActionListener(e -> buttonTransferPerformed(e));

                // ---- button7 ----
                button7.setText("Apply for loan");
                button7.addActionListener(e -> buttonLoanPerformed(e));

                // ---- button8 ----
                button8.setText("Trade stocks");
                button8.addActionListener(e -> buttonTradeStockPerformed(e));

                // ---- button9 ----
                button9.setText("Exchange");
                button9.addActionListener(e -> buttonSwapPerformed(e));

                // ---- button10 ----
                button10.setText("logout");
                button10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                button10.addActionListener(e -> buttonLogoutPerformed(e));

                // ---- inquiryBalance ----
                inquiryBalance.setText("Check balance");
                inquiryBalance.addActionListener(e -> inquiryBalanceActionPerformed(e));

                // ---- button11 ----
                button11.setText("Repay loan");
                button11.addActionListener(e -> buttonRepayloanPerformed(e));

                GroupLayout contentPaneLayout = new GroupLayout(contentPane);
                contentPane.setLayout(contentPaneLayout);
                contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                                .createSequentialGroup().addGap(38, 38, 38)
                                .addGroup(contentPaneLayout.createParallelGroup().addGroup(
                                                GroupLayout.Alignment.TRAILING,
                                                contentPaneLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(label5)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(realName).addGap(117, 117, 117)
                                                                .addComponent(label6)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(credit).addGap(58, 58, 58)
                                                                .addComponent(button10, GroupLayout.PREFERRED_SIZE, 81,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31))
                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                                .addComponent(label8)
                                                                                .addGroup(contentPaneLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(contentPaneLayout
                                                                                                                .createParallelGroup()
                                                                                                                .addComponent(button2,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(button4,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(button6,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(button8,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(button7,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(44, 44, 44)
                                                                                                .addGroup(contentPaneLayout
                                                                                                                .createParallelGroup()
                                                                                                                .addComponent(button11,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(button5,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(button3,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(inquiryBalance,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(button9,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                170,
                                                                                                                                GroupLayout.PREFERRED_SIZE))))
                                                                .addGap(0, 66, Short.MAX_VALUE)))));
                contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                                .createSequentialGroup().addGap(9, 9, 9)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label5).addComponent(realName).addComponent(label6)
                                                .addComponent(credit).addComponent(button10, GroupLayout.PREFERRED_SIZE,
                                                                32, GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17).addComponent(label8).addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button5, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(button6, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(inquiryBalance, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(button8, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button9, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(button7, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button11, GroupLayout.PREFERRED_SIZE, 40,
                                                                GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(31, Short.MAX_VALUE)));
                setSize(490, 390);
                setLocationRelativeTo(getOwner());
                // JFormDesigner - End of component initialization //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        private JLabel label5;
        private JLabel realName;
        private JLabel label6;
        private JLabel credit;
        private JLabel label8;
        private JButton button2;
        private JButton button4;
        private JButton button3;
        private JButton button5;
        private JButton button6;
        private JButton button7;
        private JButton button8;
        private JButton button9;
        private JButton button10;
        private JButton inquiryBalance;
        private JButton button11;
        // JFormDesigner - End of variables declaration //GEN-END:variables
}
