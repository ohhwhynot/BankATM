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

    private String getSelectedAccount(String[] options){


        String result = (String)JOptionPane.showInputDialog(
                this,
                " ",
                "Please select an account to continue:",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );
        return result;
    }

    private void button4ActionPerformed(ActionEvent e) {
        //deposit
        String[] options = {"Python", "Java/Swing", "Ruby"};//todo
        String result = getSelectedAccount(options);

    }



    private void buttonLogoutPerformed(ActionEvent e) {
        this.dispose();
        //this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // TODO add your code here
    }

    private void buttonWithdrawPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonCreatAccountPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonCloseAccountPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonTransferPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonLoanPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonTradeStockPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void buttonSwapPerformed(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
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

        //======== this ========
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("Username:");

        //---- label6 ----
        label6.setText("Credit:");

        //---- credit ----
        credit.setText("text");

        //---- label8 ----
        label8.setText("Please choose the business you want to do:");

        //---- button2 ----
        button2.setText("Create a new account");
        button2.addActionListener(e -> buttonCreatAccountPerformed(e));

        //---- button4 ----
        button4.setText("Deposit");
        button4.addActionListener(e -> button4ActionPerformed(e));

        //---- button3 ----
        button3.setText("Close a new account");
        button3.addActionListener(e -> buttonCloseAccountPerformed(e));

        //---- button5 ----
        button5.setText("Withdraw");
        button5.addActionListener(e -> buttonWithdrawPerformed(e));

        //---- button6 ----
        button6.setText("Transfer");
        button6.addActionListener(e -> buttonTransferPerformed(e));

        //---- button7 ----
        button7.setText("Apply for loan");
        button7.addActionListener(e -> buttonLoanPerformed(e));

        //---- button8 ----
        button8.setText("Trade stocks");
        button8.addActionListener(e -> buttonTradeStockPerformed(e));

        //---- button9 ----
        button9.setText("Swap");
        button9.addActionListener(e -> buttonSwapPerformed(e));

        //---- button10 ----
        button10.setText("logout");
        button10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
        button10.addActionListener(e -> buttonLogoutPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label8)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button8, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                    .addGap(44, 44, 44)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(button9, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 66, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(realName)
                            .addGap(117, 117, 117)
                            .addComponent(label6)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(credit)
                            .addGap(58, 58, 58)
                            .addComponent(button10, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(realName)
                        .addComponent(label6)
                        .addComponent(credit)
                        .addComponent(button10, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addComponent(label8)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        setSize(490, 335);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
