import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Thu Dec 09 22:43:44 CST 2021
 */

/**
 * @author Xudong Gao
 */
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY
        // //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Xudong Gao
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label1 = new JLabel();
        confirm = new JButton();

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
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(195, 195, 195)
                            .addComponent(confirm)))
                    .addContainerGap(72, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(confirm)
                    .addContainerGap(35, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration //GEN-END:variables
}
