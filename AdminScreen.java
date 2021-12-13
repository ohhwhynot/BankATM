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
        public AdminScreen() {
                initComponents();
        }

        private void logoutActionPerformed(ActionEvent e) {
                new ATMHome().setVisible(true);
                this.dispose();
                // TODO add your code here
        }

        private void checkProfitActionPerformed(ActionEvent e) {

                // new AccountInfoScreen(account, user).setVisible(true);
                // TODO add your code here
        }

        private void checkLogsActionPerformed(ActionEvent e) {
                new LogScreen().setVisible(true);
                // TODO add your code here
        }

        private void updateStockActionPerformed(ActionEvent e) {
                new ControlStockScreen().setVisible(true);
                // TODO add your code here
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

                // ======== this ========
                setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
                var contentPane = getContentPane();

                // ---- checkProfit ----
                checkProfit.setText("Check  Bank Balance");
                checkProfit.addActionListener(e -> checkProfitActionPerformed(e));

                // ---- checkLogs ----
                checkLogs.setText("Check  Logs");
                checkLogs.addActionListener(e -> checkLogsActionPerformed(e));

                // ---- updateStock ----
                updateStock.setText("Update Stocks");
                updateStock.addActionListener(e -> updateStockActionPerformed(e));

                // ---- logout ----
                logout.setText("Logout");
                logout.addActionListener(e -> logoutActionPerformed(e));

                // ---- label1 ----
                label1.setText("Controll Platform");
                label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));

                // ---- label2 ----
                label2.setText("Username:");
                label2.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

                // ---- username ----
                username.setText("admin");
                username.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

                GroupLayout contentPaneLayout = new GroupLayout(contentPane);
                contentPane.setLayout(contentPaneLayout);
                contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addContainerGap(205, Short.MAX_VALUE).addComponent(label1)
                                                .addGap(74, 74, 74).addComponent(logout).addGap(61, 61, 61))
                                .addGroup(contentPaneLayout.createSequentialGroup().addGap(107, 107, 107).addGroup(
                                                contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                                                                .createSequentialGroup().addComponent(label2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(username))
                                                                .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addGroup(contentPaneLayout
                                                                                                .createParallelGroup()
                                                                                                .addComponent(updateStock,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                160,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(checkProfit,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                160,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(74, 74, 74)
                                                                                .addComponent(checkLogs,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                160,
                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(127, Short.MAX_VALUE)));
                contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup().addGroup(contentPaneLayout
                                .createSequentialGroup().addGap(35, 35, 35)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label1).addComponent(logout))
                                .addGap(34, 34, 34)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label2).addComponent(username))
                                .addGap(58, 58, 58)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(checkLogs, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                                .addComponent(checkProfit, GroupLayout.DEFAULT_SIZE, 50,
                                                                Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateStock, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE)));
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
        // JFormDesigner - End of variables declaration //GEN-END:variables
}
