import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Thu Dec 09 22:43:44 CST 2021
 */

/**
 * @author Xudong Gao
 *
 */
@SuppressWarnings({"unchecked"})
public class LogScreen extends JFrame {
    public LogScreen() {
        initComponents();

        DefaultListModel model = new DefaultListModel();
        model.addAll(SessionHandler.getInstance().getLogs());
        list1.setModel(model);
    }

    private void confirmActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void clearActionPerformed(ActionEvent e) {
        SessionHandler.getInstance().clearLogs();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label1 = new JLabel();
        confirm = new JButton();
        clear = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- label1 ----
        label1.setText("Logs");
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));

        //---- confirm ----
        confirm.setText("Confirm");
        confirm.addActionListener(e -> confirmActionPerformed(e));

        //---- clear ----
        clear.setText("Clear");
        clear.addActionListener(e -> clearActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(206, 206, 206)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(72, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(105, Short.MAX_VALUE)
                    .addComponent(clear, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                    .addGap(64, 64, 64)
                    .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                    .addGap(113, 113, 113))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(clear, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirm, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        setSize(500, 430);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Xudong Gao
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label1;
    private JButton confirm;
    private JButton clear;
    // JFormDesigner - End of variables declaration //GEN-END:variables
}
