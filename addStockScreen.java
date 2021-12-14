import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Tue Dec 14 15:22:17 CST 2021
 */



/**
 * @author Xudong Gao
 */
public class addStockScreen extends JFrame {
    ControlStockScreen parent;
    public addStockScreen(ControlStockScreen parent) {
        initComponents();
        this.parent = parent;
    }

    private void cancelActionPerformed(ActionEvent e) {
        this.dispose();
        // TODO add your code here
    }

    private void confirmActionPerformed(ActionEvent e) {
        String name = stockName.getText();
        if(Admin.getInstance().getStockController().isExisted(name)){
            JOptionPane.showMessageDialog(null, "The name have been taken!", "Error!", JOptionPane.ERROR_MESSAGE);
        }else {
            float price;
            try {
                price = Float.parseFloat(listPrice.getText());
                Admin.getInstance().getStockController().addNewStock(name, price);
                JOptionPane.showMessageDialog(null, "You've add a new stock!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                parent.refreshActionPerformed(e);
                this.dispose();
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "The price must be float!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        stockName = new JTextField();
        listPrice = new JTextField();
        cancel = new JButton();
        confirm = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Add a new stock");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));

        //---- label2 ----
        label2.setText("Stock name:");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

        //---- label3 ----
        label3.setText("Listing price:");
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));

        //---- cancel ----
        cancel.setText("Cancel");
        cancel.addActionListener(e -> cancelActionPerformed(e));

        //---- confirm ----
        confirm.setText("Confirm");
        confirm.addActionListener(e -> confirmActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                .addComponent(label3)
                                .addGap(18, 18, 18)
                                .addComponent(listPrice, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label2)
                                .addGap(18, 18, 18)
                                .addComponent(stockName, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(108, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(label1)
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(stockName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(listPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(54, Short.MAX_VALUE))
        );
        setSize(450, 365);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField stockName;
    private JTextField listPrice;
    private JButton cancel;
    private JButton confirm;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
