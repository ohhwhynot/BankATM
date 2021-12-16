import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Thu Dec 09 22:31:34 CST 2021
 */

/**
 * @author Xudong Gao
 */
public class AdminScreen extends JFrame {
        private Admin admin;

        public AdminScreen() {
                this.admin = Admin.getInstance();
                initComponents();
        }


        private void logoutActionPerformed(ActionEvent e) {

                UserManager um = admin.getUserManager();
                um.storeUsers();
                BackupController.storeTime();
                BackupController.storeStockMarket(Admin.getInstance().getStockController().getMarket());
                SessionHandler.getInstance().writeLogs();
                this.dispose();

                new ATMHome().setVisible(true);
        }

        private void checkProfitActionPerformed(ActionEvent e) {
                UserManager um = admin.getUserManager();
                float balance = um.getTotalBalance();
                JOptionPane.showMessageDialog(null, "Total Balance: " + balance, "Balance", JOptionPane.INFORMATION_MESSAGE);
                SessionHandler.getInstance().addLog("Admin " + admin.getUserName() + " checked balanced");
        }

        private void checkLogsActionPerformed(ActionEvent e) {
                new LogScreen().setVisible(true);

        }

        private void updateStockActionPerformed(ActionEvent e) {
                new ControlStockScreen().setVisible(true);

        }


        private void buttonTimeActionPerformed(ActionEvent e) {
                new TimeScreen().setVisible(true);
        }

        private void thisWindowClosing(WindowEvent e) {
                UserManager um = admin.getUserManager();
                um.storeUsers();
                BackupController.storeTime();
                BackupController.storeStockMarket(Admin.getInstance().getStockController().getMarket());
                SessionHandler.getInstance().writeLogs();
                System.exit(0);
        }

        private void initComponents() {
                // JFormDesigner - Component initialization - DO NOT MODIFY
                // //GEN-BEGIN:initComponents
                // Generated using JFormDesigner Evaluation license - Xudong Gao
                checkProfit = new JButton();
                checkLogs = new JButton();
                updateStock = new JButton();
                logout = new JButton();
                label1 = new JLabel();
                label2 = new JLabel();
                username = new JLabel();
                buttonTime = new JButton();

                //======== this ========
                setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
                addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        thisWindowClosing(e);
                    }
                });
                var contentPane = getContentPane();

                //---- checkProfit ----
                checkProfit.setText("Check  Bank Balance");
                checkProfit.addActionListener(e -> checkProfitActionPerformed(e));

                //---- checkLogs ----
                checkLogs.setText("Check  Logs");
                checkLogs.addActionListener(e -> checkLogsActionPerformed(e));

                //---- updateStock ----
                updateStock.setText("Update Stocks");
                updateStock.addActionListener(e -> updateStockActionPerformed(e));

                //---- logout ----
                logout.setText("Logout");
                logout.addActionListener(e -> logoutActionPerformed(e));

                //---- label1 ----
                label1.setText("Controll Platform");
                label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));

                //---- label2 ----
                label2.setText("Username:");
                label2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

                //---- username ----
                username.setText("admin");
                username.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

                //---- buttonTime ----
                buttonTime.setText("Check Time");
                buttonTime.addActionListener(e -> buttonTimeActionPerformed(e));

                GroupLayout contentPaneLayout = new GroupLayout(contentPane);
                contentPane.setLayout(contentPaneLayout);
                contentPaneLayout.setHorizontalGroup(
                    contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap(205, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(74, 74, 74)
                            .addComponent(logout)
                            .addGap(61, 61, 61))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(username))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(updateStock, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkProfit, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                    .addGap(74, 74, 74)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(checkLogs, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                        .addComponent(buttonTime, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
                            .addContainerGap(127, Short.MAX_VALUE))
                );
                contentPaneLayout.setVerticalGroup(
                    contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(logout))
                            .addGap(34, 34, 34)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(username))
                            .addGap(58, 58, 58)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(checkLogs, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(checkProfit, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(buttonTime, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addComponent(updateStock, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                            .addContainerGap(33, Short.MAX_VALUE))
                );
                setSize(630, 365);
                setLocationRelativeTo(getOwner());
                // JFormDesigner - End of component initialization //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        private JButton checkProfit;
        private JButton checkLogs;
        private JButton updateStock;
        private JButton logout;
        private JLabel label1;
        private JLabel label2;
        private JLabel username;
        private JButton buttonTime;
        // JFormDesigner - End of variables declaration //GEN-END:variables
}
