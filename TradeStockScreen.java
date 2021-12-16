import java.awt.*;
import java.awt.event.*;
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
    private StockAccount stockAccount;
    private Client client;
    public TradeStockScreen(Client client) {
        initComponents();
        username.setText(client.getUserName());
        stockAccount = client.getStockAccount();
        balance.setText(Float.toString(stockAccount.getBalance()));
        this.client = client;
        DefaultTableModel model =  Admin.getInstance().getStockController().getView().getTableModel_7(client.getStockAccount());
        table1.setModel(model);
        balance.setText(Float.toString(client.getStockAccount().getBalance()));
        totProfit.setText(Float.toString(Admin.getInstance().getStockController().getView().getTotProfits(client.getStockAccount())));
    }

    public void refresh(){
        DefaultTableModel model =  Admin.getInstance().getStockController().getView().getTableModel_7(client.getStockAccount());
        table1.setModel(model);
        balance.setText(Float.toString(stockAccount.getBalance()));
        totProfit.setText(Float.toString(Admin.getInstance().getStockController().getView().getTotProfits(client.getStockAccount())));
    }

    private void buyActionPerformed(ActionEvent e) {
        new StocksMarketScreen(this,client).setVisible(true);
    }

    private void sellActionPerformed(ActionEvent e) {

        int selectedRow = table1.getSelectedRow();
        if(selectedRow==-1){
            JOptionPane.showMessageDialog(null, "You have to click on one of the stocks!", "Error!", JOptionPane.ERROR_MESSAGE);
        }else {

            HeldStock heldStock = client.getStockAccount().getHeldStock(selectedRow);
            Stock stock = heldStock.getStock();
            String amount = JOptionPane.showInputDialog(this, "Please input the amount you want to sell for " + stock.getName() + ":");
            float amountF = 0;
            try {
                amountF = Integer.parseInt(amount);
            }catch (Exception err) {
                JOptionPane.showMessageDialog(null, "The amount must be an integer!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }
            if(amountF>heldStock.getAmount()) {
                JOptionPane.showMessageDialog(null, "You don't have that many shares!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }else {
                client.getStockAccount().sellStock(Integer.parseInt(amount),stock,stock.getPrice());
                JOptionPane.showMessageDialog(null, "Sell succeeds!",
                        "Succeed!", JOptionPane.INFORMATION_MESSAGE);
                SessionHandler.getInstance().addLog("Client "+ client.getUserName()+" sold "+amount+ " shares of "
                        +stock.getName()+" stocks at "+stock.getPrice()+" USD each");
            }
        }
        this.refresh();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        buy = new JButton();
        sell = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        username = new JLabel();
        balance = new JLabel();
        totProfit = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label4 = new JLabel();

        //======== this ========
        setTitle("My stocks");
        setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        var contentPane = getContentPane();

        //---- buy ----
        buy.setText("Buy");
        buy.addActionListener(e -> buyActionPerformed(e));

        //---- sell ----
        sell.setText("Sell");
        sell.addActionListener(e -> sellActionPerformed(e));

        //---- label1 ----
        label1.setText("Username:");
        label1.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

        //---- label2 ----
        label2.setText("Balance:");
        label2.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

        //---- label3 ----
        label3.setText("Total unrealized profit:");
        label3.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

        //---- username ----
        username.setText("none");
        username.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

        //---- balance ----
        balance.setText("0");
        balance.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

        //---- totProfit ----
        totProfit.setText("0");
        totProfit.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    null, null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- label4 ----
        label4.setText("Total realized profit:  ");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(buy, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                            .addGap(135, 135, 135)
                            .addComponent(sell, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(username)
                    .addGap(93, 93, 93)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(balance, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(totProfit, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
                    .addGap(31, 31, 31))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(label4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(label3)
                        .addComponent(label1)
                        .addComponent(username)
                        .addComponent(totProfit)
                        .addComponent(balance))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buy, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(sell, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(39, Short.MAX_VALUE))
        );
        setSize(655, 435);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JButton buy;
    private JButton sell;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel username;
    private JLabel balance;
    private JLabel totProfit;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
