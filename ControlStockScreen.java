import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Thu Dec 09 22:48:52 CST 2021
 */



/**
 * @author Xudong Gao
 */
public class ControlStockScreen extends JFrame {
    private java.util.List<Stock> stocks;
    public ControlStockScreen() {
        initComponents();
        stocks = Admin.getInstance().getStockController().getStocks();
        DefaultTableModel model =  Admin.getInstance().getStockController().getView().getTableModel_4(stocks);
        table1.setModel(model);

    }

    private void closeActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void addStockActionPerformed(ActionEvent e) {
        new addStockScreen(this).setVisible(true);


    }

    private void removeStockActionPerformed(ActionEvent e) {
        int selectedRow = table1.getSelectedRow();
        if(selectedRow==-1){
            JOptionPane.showMessageDialog(null, "You have to click on one of the stocks!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }else {
            Stock stock = Admin.getInstance().getStockController().getStock(selectedRow);
            if(stock.isBought()){
                JOptionPane.showMessageDialog(null, "This stock is held by clients and cannot be deleted!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }else {
                Admin.getInstance().getStockController().deleteStock(selectedRow);
                JOptionPane.showMessageDialog(this, "Deleted successfully!",
                        "Succeed!", JOptionPane.INFORMATION_MESSAGE);
                refreshActionPerformed(e);
            }
        }

    }

    public void updatePriceActionPerformed(ActionEvent e) {
        int selectedRow = table1.getSelectedRow();
        if(selectedRow==-1){
            JOptionPane.showMessageDialog(null, "You have to click on one of the stocks!", "Error!", JOptionPane.ERROR_MESSAGE);
        }else {
            String stockName = Admin.getInstance().getStockController().getStock(selectedRow).getName();
            String newPrice = JOptionPane.showInputDialog(this, "Please set new price for " + stockName + ":");
            try {
                Admin.getInstance().getStockController().updatePrice(selectedRow, Float.parseFloat(newPrice));
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "The price must be float!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        refreshActionPerformed(e);
    }

    public void refreshActionPerformed(ActionEvent e) {
        stocks = Admin.getInstance().getStockController().getStocks();
        DefaultTableModel model =  Admin.getInstance().getStockController().getView().getTableModel_4(stocks);
        table1.setModel(model);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        addStock = new JButton();
        removeStock = new JButton();
        updatePrice = new JButton();
        close = new JButton();
        label1 = new JLabel();
        refresh = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- addStock ----
        addStock.setText("Add a new stock");
        addStock.addActionListener(e -> addStockActionPerformed(e));

        //---- removeStock ----
        removeStock.setText("Remove a stock");
        removeStock.addActionListener(e -> removeStockActionPerformed(e));

        //---- updatePrice ----
        updatePrice.setText("Update Price");
        updatePrice.addActionListener(e -> updatePriceActionPerformed(e));

        //---- close ----
        close.setText("Close");
        close.addActionListener(e -> closeActionPerformed(e));

        //---- label1 ----
        label1.setText("Stock management platform");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));

        //---- refresh ----
        refresh.setText("Refresh");
        refresh.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 10));
        refresh.addActionListener(e -> refreshActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(updatePrice, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addComponent(addStock, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                            .addGap(74, 74, 74)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(removeStock, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addComponent(close, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(refresh, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(29, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(refresh))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addStock, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addComponent(removeStock, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(updatePrice, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addComponent(close, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(34, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton addStock;
    private JButton removeStock;
    private JButton updatePrice;
    private JButton close;
    private JLabel label1;
    private JButton refresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
