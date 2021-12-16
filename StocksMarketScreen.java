/*
 * Created by JFormDesigner on Thu Dec 09 22:13:00 CST 2021
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Xudong Gao
 */
public class StocksMarketScreen extends JFrame {
    Client client;
    private java.util.List<Stock> stocks;
    private TradeStockScreen tradeStockScreen;
    public StocksMarketScreen(TradeStockScreen tradeStockScreen,Client client) {
        this.tradeStockScreen = tradeStockScreen;
        this.client = client;
        initComponents();
        stocks = Admin.getInstance().getStockController().getStocks();
        DefaultTableModel model =  Admin.getInstance().getStockController().getView().getTableModel_4(stocks);
        table1.setModel(model);

    }

    private void closeActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void buyActionPerformed(ActionEvent e) {
        int selectedRow = table1.getSelectedRow();
        if(selectedRow==-1){
            JOptionPane.showMessageDialog(null, "You have to click on one of the stocks!", "Error!", JOptionPane.ERROR_MESSAGE);
        }else {
            Stock stock = Admin.getInstance().getStockController().getStock(selectedRow);
            String amount = JOptionPane.showInputDialog(this, "Please input the amount you want to buy for " + stock.getName() + ":");
            try {
                if(!client.getStockAccount().buyStock(Integer.parseInt(amount),stock)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance!",
                            "Error!", JOptionPane.ERROR_MESSAGE);
                }else {

                    JOptionPane.showMessageDialog(null, "Purchase succeeds!",
                            "Succeed!", JOptionPane.INFORMATION_MESSAGE);
                    SessionHandler.getInstance().addLog("Client "+ client.getUserName()+" bought "+amount+ " shares of "
                    +stock.getName()+" stocks at "+stock.getPrice()+" USD each");
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "The amount must be an integer!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }



        }
        tradeStockScreen.refresh();
        //new BuyStockScreen(client).setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        label1 = new JLabel();
        separator1 = new JSeparator();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        close = new JButton();
        buy = new JButton();

        // ======== this ========
        var contentPane = getContentPane();

        // ---- label1 ----
        label1.setText("Stock Market");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));

        // ======== scrollPane2 ========
        {

            // ---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                            { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
                    new String[] { null, null, null, null }));
            scrollPane2.setViewportView(table1);
        }

        // ---- close ----
        close.setText("Close");
        close.addActionListener(e -> closeActionPerformed(e));

        // ---- buy ----
        buy.setText("Buy");
        buy.addActionListener(e -> buyActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup().addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(215, 215, 215).addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(79, 79, 79).addComponent(scrollPane2,
                                GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(90, 90, 90).addComponent(separator1,
                                GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(128, 128, 128)
                                .addComponent(close, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)
                                .addComponent(buy, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(81, Short.MAX_VALUE)));
        contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup().addGap(31, 31, 31).addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(close, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(buy, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(41, Short.MAX_VALUE)));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JLabel label1;
    private JSeparator separator1;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JButton close;
    private JButton buy;
    // JFormDesigner - End of variables declaration //GEN-END:variables
}
