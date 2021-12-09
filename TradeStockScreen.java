import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Thu Dec 09 20:57:34 CST 2021
 */



/**
 * @author Xudong Gao
 */
public class TradeStockScreen extends JFrame {
    public TradeStockScreen() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        table2 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        username = new JLabel();
        balance = new JLabel();
        totProfit = new JLabel();

        //======== this ========
        setTitle("My stocks");
        var contentPane = getContentPane();

        //---- table1 ----
        table1.setModel(new DefaultTableModel(
            new Object[][] {
                {"", "", null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
            },
            new String[] {
                null, null, null, null, null, null, null
            }
        ));

        //---- button1 ----
        button1.setText("Buy");

        //---- button2 ----
        button2.setText("Sell");

        //---- table2 ----
        table2.setModel(new DefaultTableModel(
            new Object[][] {
                {"Name", "Code", "Cost price", "Cur price", "Number", "Postion", "Profit"},
            },
            new String[] {
                null, null, null, null, null, null, null
            }
        ));

        //---- label1 ----
        label1.setText("Username:");

        //---- label2 ----
        label2.setText("Balance:");

        //---- label3 ----
        label3.setText("Total profit:");

        //---- username ----
        username.setText("none");

        //---- balance ----
        balance.setText("0");

        //---- totProfit ----
        totProfit.setText("0");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(button1)
                    .addGap(62, 62, 62)
                    .addComponent(button2)
                    .addContainerGap(226, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(username)
                            .addGap(100, 100, 100)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(balance)
                            .addGap(61, 61, 61)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(totProfit, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(table1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(table2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGap(63, 63, 63))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2)
                        .addComponent(label3)
                        .addComponent(username)
                        .addComponent(balance)
                        .addComponent(totProfit))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                    .addComponent(table2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(table1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(74, 74, 74))
        );
        setSize(655, 435);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JTable table2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel username;
    private JLabel balance;
    private JLabel totProfit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
