import java.awt.*;
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        checkProfit = new JButton();
        checkLogs = new JButton();
        updateStock = new JButton();
        checkLogs3 = new JButton();
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        username = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //---- checkProfit ----
        checkProfit.setText("Check  Bank Balance");

        //---- checkLogs ----
        checkLogs.setText("Check  Logs");

        //---- updateStock ----
        updateStock.setText("Update Stocks");

        //---- button1 ----
        button1.setText("Logout");

        //---- label1 ----
        label1.setText("Controll Platform");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));

        //---- label2 ----
        label2.setText("Username:");

        //---- username ----
        username.setText("none");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(205, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addGap(74, 74, 74)
                    .addComponent(button1)
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
                                .addComponent(checkProfit, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addComponent(updateStock, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                            .addGap(74, 74, 74)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(checkLogs3, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkLogs, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(127, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(button1))
                    .addGap(9, 9, 9)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(username))
                    .addGap(70, 70, 70)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(checkProfit)
                        .addComponent(checkLogs))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(updateStock)
                        .addComponent(checkLogs3))
                    .addContainerGap(52, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JButton checkProfit;
    private JButton checkLogs;
    private JButton updateStock;
    private JButton checkLogs3;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JLabel username;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
