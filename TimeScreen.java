import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Thu Dec 16 16:53:14 CST 2021
 */

/**
 * @author Xudong Gao
 */
public class TimeScreen extends JFrame {
    public TimeScreen() {
        initComponents();
        time.setText(TimeController.getCurDate().toString());
    }

    private void confirmActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void refreshActionPerformed(ActionEvent e) {

        time.setText(TimeController.getCurDate().toString());

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        time = new JLabel();
        confirm = new JButton();
        refresh = new JButton();

        // ======== this ========
        var contentPane = getContentPane();

        // ---- time ----
        time.setText("2020 09 2 11:22");
        time.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));

        // ---- confirm ----
        confirm.setText("Confirm");
        confirm.addActionListener(e -> confirmActionPerformed(e));

        // ---- refresh ----
        refresh.setText("Refesh");
        refresh.addActionListener(e -> refreshActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup().addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(96, 96, 96).addComponent(time))
                        .addGroup(contentPaneLayout.createSequentialGroup().addGap(59, 59, 59)
                                .addComponent(refresh, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(73, Short.MAX_VALUE)));
        contentPaneLayout.setVerticalGroup(contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup().addGap(84, 84, 84)
                        .addComponent(time).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(refresh, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)));
        setSize(400, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JLabel time;
    private JButton confirm;
    private JButton refresh;
    // JFormDesigner - End of variables declaration //GEN-END:variables
}
